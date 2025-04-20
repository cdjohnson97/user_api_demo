# -------- Build Stage --------
FROM maven:3.8.6-eclipse-temurin-17-alpine AS build

WORKDIR /app

# Copie uniquement les fichiers nécessaires pour éviter les rebuild inutiles
COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN chmod +x mvnw
RUN ./mvnw dependency:go-offline

# Ensuite on copie le reste du code source
COPY src ./src

# Compile l'application sans exécuter les tests
RUN ./mvnw clean package -DskipTests


# -------- Run Stage --------
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copie l'application depuis l'étape de build
COPY --from=build /app/target/user_api_demo-0.0.1-SNAPSHOT.jar app.jar

# Crée un utilisateur non-root
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Expose le port de l'application
EXPOSE 8080

# Permet de passer des options JVM au besoin
ENV JAVA_OPTS=""

# Commande d'exécution
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=docker -jar app.jar"]
