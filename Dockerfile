# Build stage with Maven + Temurin JDK
FROM maven:3.9-eclipse-temurin-24 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline

COPY src ./src
RUN mvn clean package -DskipTests

# Runtime stage with smaller JDK (Amazon Corretto)
FROM eclipse-temurin:24
WORKDIR /app
COPY --from=build /app/target/ideatoreality.reality-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/ideatoreality.reality-0.0.1-SNAPSHOT.jar"]
