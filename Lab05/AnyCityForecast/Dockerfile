FROM ubuntu:latest
LABEL authors="hugao"
# Use a imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo JAR construído para o diretório de trabalho
COPY target/AnyCityForecast-1.0-SNAPSHOT.jar app.jar

# Execute o aplicativo Java, especificando a classe principal
ENTRYPOINT ["java", "-cp", "app.jar", "AnyCityForecast.AnyCityForecast"]


