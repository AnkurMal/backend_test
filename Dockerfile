FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .

RUN chmod +x ./mvnw

RUN ./mvnw dependency:go-offline -B

COPY src ./src

RUN ./mvnw package -DskipTests

EXPOSE 8080

# Run the Spring Boot JAR
CMD ["java", "-jar", "target/backend_test-0.0.1-SNAPSHOT.jar"]
