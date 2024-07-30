# Stage 1: Build the Spring Boot application
FROM openjdk:17-jdk-slim AS build

# Install Maven
RUN apt-get update && apt-get install -y wget tar
RUN wget -qO- https://archive.apache.org/dist/maven/maven-3/3.8.7/binaries/apache-maven-3.8.7-bin.tar.gz | tar xz -C /opt
RUN ln -s /opt/apache-maven-3.8.7/bin/mvn /usr/bin/mvn

# Set the working directory
WORKDIR /app

# Copy Maven project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/superhero-0.0.1-SNAPSHOT.jar ./superhero-app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "superhero-app.jar"]
