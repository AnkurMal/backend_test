# Use a lightweight OpenJDK image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy Maven/Gradle wrapper and build files
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Download dependencies (Maven only)
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY src ./src

# Package the app
RUN ./mvnw package -DskipTests

# Expose the port your Spring Boot app uses
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/backend_test-0.0.1-SNAPSHOT.jar"]
