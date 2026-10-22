# Базовый образ с Java 17: проект собран под Java 17 (java.version=17 в pom.xml, Spring Boot 3.3.4).
# Образ openjdk:8-jdk-alpine из задания здесь не подойдёт: Java 8 не запустит классы, собранные под Java 17.
FROM eclipse-temurin:17-jre-alpine


EXPOSE 8080


ADD target/authsvc-1.0.0.jar authsvc.jar


CMD ["java", "-jar", "authsvc.jar"]
