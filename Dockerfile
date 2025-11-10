FROM ubuntu:latest
LABEL authors="asana"

ENTRYPOINT ["top", "-b"]


FROM openjdk:17-jdk-slim

WORKDIR /app

COPY target/clinicApp.jar app.jar

ENTRYPOINT ["java", "-jar","app.jar"]