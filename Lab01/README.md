
# Java Development Setup Guide

## Java Installation

Ensure you have Java installed in your environment, preferably OpenJDK 17 LTS. Verify the installation:
```bash
$ javac -version
```

## Maven Installation

1. Install Maven and set the `JAVA_HOME` environment variable to the JDK installation root.
2. Verify the Maven installation:
```bash
$ mvn --version
```

## Git Installation and Configuration

### Git Installation
Make sure Git is installed. Verify Git installation:
```bash
$ git --version
```

### Configure Git
If `git config --list` doesn't show your name and email, configure Git with:
```bash
$ git config --global user.name "Your Name"
$ git config --global user.email "you@example.com"
```

### SSH Key Configuration
Configure Git to use an SSH key for authentication to access Git repositories.

## Build Management with Maven

### Getting Started with Maven

Maven is a common build tool for coordinating tasks in a Java project. It streamlines tasks like dependency management, compilation, packaging, and documentation updates.

### Setting Up Maven

Maven can be utilized through the command line (CLI) for managing the build cycle. Initial setup involves installing Maven and ensuring OpenJDK is installed.

### Maven in 5 Minutes Hands-On

Use the following command to create a Maven project:
```bash
mvn archetype:generate -DgroupId=com.mycompany.app -DartifactId=my-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

Popular IDEs like IntelliJ IDEA or VS Code can be used to import Maven projects.

## Creating a Weather Forecast Project

### Creating a Maven Project

Create a new Maven project named **MyWeatherRadar** for a standard Java application. Define project properties like `groupId`, `artifactId`, and `version`.

### Understanding `POM.xml` and Folder Structure

Examine the contents of the `POM.xml` file and the generated folder structure.

### Modifying Project Properties

Update properties in the `POM.xml` file to define the development team, character encoding, and Java version.

### Declaring Project Dependencies

Use Maven to declare dependencies on external artifacts like Retrofit and Gson. Understand how dependencies form a graph of project dependencies.

### Compile and Run the Project

```bash
$ mvn package  # Get dependencies, compile the project, and create the jar
$ mvn exec:java -Dexec.mainClass="weather.WeatherStarter"  # Adapt to match your package structure and class name
```

## Source Code Management with Git

### Introduction to Git

### Adding a Project to Git Versioning

```bash
$ cd project_folder  # Move to the root of the working folder to be imported
$ git init  # Initialize a local git repo in this folder
$ git remote add origin <REMOTE_URL>  # Must adapt the URL for your repo
$ git add .  # Mark all existing changes in this root to be committed
$ git commit -m "Initial project setup for exercise 1_3"  # Create the commit snapshot locally
$ git push -u origin main  # Upload the local commit to the shared repo
```

### Adding MyWeatherRadar Project to Git

Add the **MyWeatherRadar** project to Git versioning. Create a `.gitignore` file to exclude files/folders of local interest. Import the project into Git version control and synchronize with the remote repository (e.g., GitHub).

### Simple Collaboration with Git

Commit Messages and Project History:
- Emphasize the importance of relevant commit messages for a clean and useful project history.
- Use `git log` to review the repository history and ensure meaningful commit messages.

```bash
$ git log --reverse --oneline
```

## Introduction to Docker

### Docker Setup

1. Install Docker Desktop to get started with Docker.

### Docker Management

1. Install Portainer CE server app for web-based Docker container management.
2. Access Portainer via http://localhost:9000 and set up an administration password.
