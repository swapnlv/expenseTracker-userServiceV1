# Use an official OpenJDK runtime as a parent image
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the application's JAR file into the container
COPY target/UserServiceV1-0.0.1-SNAPSHOT.jar userservice.jar

# Expose the service port
EXPOSE 8070

# Run the JAR file
ENTRYPOINT ["java", "-jar", "userservice.jar"]
