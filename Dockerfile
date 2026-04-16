FROM maven:3.9.6-eclipse-temurin-21-alpine AS build

COPY  target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
