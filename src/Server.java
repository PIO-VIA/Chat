import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Serveur en attente de connexion...");
            Socket socket = serverSocket.accept();
            System.out.println("Client connecté : " + socket.getInetAddress());

            // Streams pour communication
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());

            // Threads pour l'envoi et la réception
            Thread sendThread = new Thread(() -> {
                try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
                    while (true) {
                        System.out.print("Message à envoyer : ");
                        String message = consoleReader.readLine();
                        output.writeUTF(message); // Envoi du message
                        output.flush();

                        if (message.equalsIgnoreCase("file")) {
                            System.out.print("Entrez le chemin du fichier : ");
                            String filePath = consoleReader.readLine();
                            sendFile(filePath, output);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Thread receiveThread = new Thread(() -> {
                try {
                    while (true) {
                        String message = input.readUTF(); // Lecture du message
                        System.out.println("Client : " + message);

                        if (message.equalsIgnoreCase("file")) {
                            receiveFile("recu_du_client", input);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            sendThread.start();
            receiveThread.start();

            sendThread.join();
            receiveThread.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(String filePath, DataOutputStream output) throws IOException {
        File file = new File(filePath);
        if (file.exists()) {
            output.writeLong(file.length());
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Fichier envoyé avec succès !");
        } else {
            System.out.println("Fichier introuvable !");
        }
    }

    private static void receiveFile(String savePath, DataInputStream input) throws IOException {
        long fileSize = input.readLong();
        try (FileOutputStream fos = new FileOutputStream(savePath)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            long totalBytesRead = 0;
            while (totalBytesRead < fileSize && (bytesRead = input.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
                totalBytesRead += bytesRead;
            }
            System.out.println("Fichier reçu avec succès !");
        }
    }
}
