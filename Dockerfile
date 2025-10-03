# Use a lightweight OpenJDK 21 image
FROM eclipse-temurin:21-jdk-alpine

# Set working directory
WORKDIR /app

# Copy Maven wrapper and project files
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

# Make mvnw executable
RUN chmod +x ./mvnw

# Download dependencies (offline mode)
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the Spring Boot app (skip tests for faster build)
RUN ./mvnw package -DskipTests

# Expose the port your Spring Boot app uses
EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/backend_test-0.0.1-SNAPSHOT.jar"]
