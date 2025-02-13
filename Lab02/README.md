
# Lab 2 - Java at the Server-Side and Application Containers

## Introduction to the Lab

This lab focuses on deploying a Java web application into an application container using servlets and Spring Boot. The lab is structured into three main sections:
1. Server-side programming with servlets.
2. Application servers using Tomcat.
3. Web development with Spring Boot.

## 2.1 Server-Side Programming with Servlets

**Overview**: Java Servlets are integral to the web specifications within the Java Enterprise ecosystem. They are Java classes that operate on the server side, managing incoming client requests and generating appropriate responses.

**Deployment**: For servlets to function, they must be deployed within a servlet container, such as Apache Tomcat.

**HttpServlet**: This is a widely used extension of the Servlet interface that simplifies the creation of HTTP-specific functionality.

### Key Terminal Commands

- `mvn clean package`: Build and package the Maven project into a deployable artifact.
- `java -jar target/webapp1-0.0.1-SNAPSHOT.jar`: Execute a Spring Boot web application from a JAR file.
- `./mvnw spring-boot:run`: Start a Spring Boot application using the Maven wrapper.
- `docker-compose up`: Launch Docker containers as specified in the `docker-compose.yml` file.
- `docker-compose down`: Stop and remove any Docker containers defined in the `docker-compose.ym`` file.

## 2.2 Server-Side Programming and Application Servers (Tomcat)

**Application Servers**: Dedicated application servers, such as Apache Tomcat, are commonly used to run web applications and artifacts.

**Docker Integration**: Running Tomcat in Docker containers streamlines the deployment process and enhances management capabilities.

**Portability**: Docker provides a consistent runtime environment, allowing applications to be deployed more easily across various systems.

### Key Terminal Commands

- `docker-compose up`: Launch Docker containers as specified in the `docker-compose.yml` file.
- `docker-compose down`: Stop and remove any Docker containers defined in the `docker-compose.ym`` file.

## 2.3 Introduction to Web Development with Spring Boot

**Spring Boot Framework**: Built on top of the Spring Framework, Spring Boot accelerates application development by providing sensible defaults and reducing the need for extensive configuration.

**Spring Initializr**: This tool simplifies the setup of Spring Boot applications, allowing for rapid development.

**Convention Over Configuration**: Spring Boot follows this principle, minimizing the amount of configuration required by leveraging defaults.

### Key Terminal Commands

- `mvn clean package`: Build and package the Maven project into a deployable artifact.
- `java -jar target/webapp1-0.0.1-SNAPSHOT.jar`: Execute a Spring Boot web application from a JAR file.
- `./mvnw spring-boot:run`: Start a Spring Boot application using the Maven wrapper.

## 2.4 Wrapping-Up & Integrating Concepts

**Jakarta EE**: This framework supports the development of robust and complex applications suitable for various enterprise scenarios.

**Web Profiles**: Application servers offer web profiles that provide a lightweight environment tailored for deploying APIs and web applications.

**Creating REST APIs**: Developing a RESTful API involves defining endpoints that return JSON responses based on specified parameters and requirements.


### Additional Resources
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Jakarta EE Documentation](https://jakarta.ee/specifications/)
- [Docker Documentation](https://docs.docker.com/)




