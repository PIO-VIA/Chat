# Projet Java : Application de Chat avec Support d'Images

## Description

Ce projet est une application Java permettant de discuter en temps réel avec d'autres utilisateurs et d'envoyer des photos. Il est conçu pour fournir une expérience fluide et interactive de communication simultanée, en intégrant une interface utilisateur simple et des fonctionnalités robustes de transfert de fichiers.

---

## Fonctionnalités principales

- **Chat en temps réel** : Envoi et réception de messages instantanés entre utilisateurs.
- **Transfert de photos** : Partage d'images avec d'autres utilisateurs.
- **Support multi-utilisateurs** : Gestion des sessions de plusieurs utilisateurs connectés simultanément.
- **Interface utilisateur** : Design intuitif pour une navigation facile.
- **Notifications** : Alertes pour les nouveaux messages ou fichiers reçus.

---

## Prérequis

Avant de lancer l'application, assurez-vous que les éléments suivants sont installés sur votre machine :

- **Java JDK 11 ou supérieur**
- **Maven** (pour la gestion des dépendances)
- **Serveur réseau** (par exemple, un serveur socket si le projet est basé sur des sockets)

---

## Installation

1. **Clonez le dépôt** :

   ```bash
   git clone https://github.com/votre-utilisateur/chat-app-java.git
   cd chat-app-java
   ```

2. **Compilez le projet avec Maven** :

   ```bash
   mvn clean install
   ```

3. **Exécutez le serveur** :

   ```bash
   java -jar target/server.jar
   ```

4. **Exécutez le client** :

   ```bash
   java -jar target/client.jar
   ```

---

## Utilisation

1. Lancez le serveur sur une machine hôte.
2. Connectez plusieurs clients en lançant l'application client.
3. Commencez à discuter en envoyant des messages ou des images !

---

## Architecture du projet

- **Serveur** :

    - Gère les connexions des clients.
    - Relaye les messages et les images entre utilisateurs.

- **Client** :

    - Fournit une interface utilisateur pour discuter et envoyer des fichiers.
    - Connecte au serveur via des sockets.

- **Protocole** :

    - Utilise des sockets TCP/IP pour la communication.
    - Les messages et fichiers sont sérialisés avant d'être envoyés.

---

## Technologies utilisées

- **Java** : Langage principal pour la logique et la gestion réseau.
- **Swing/JavaFX** : Pour l'interface utilisateur.
- **Sockets TCP/IP** : Pour la communication réseau.
- **Maven** : Pour la gestion des dépendances.

---

## Améliorations futures

- Intégration du chiffrement (par exemple, SSL/TLS) pour sécuriser les messages.
- Ajout de fonctionnalités de groupe (chat de groupe).
- Support pour l'envoi de vidéos et d'autres formats de fichiers.
- Intégration avec une base de données pour stocker les messages.
- Notifications push pour les messages.

---

## Auteur

Projet développé par **[PIO-VIA(moi)]** dans le cadre d'un apprentissage avancé en Java.

---


