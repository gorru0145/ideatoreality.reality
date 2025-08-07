# Step 2: Run the application
FROM eclipse-temurin:24

# Set working directory
WORKDIR /app

# Copy the built jar from the previous stage
COPY target/ideatoreality.reality-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]