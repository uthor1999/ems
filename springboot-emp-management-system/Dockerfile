FROM eclipse-temurin:21-jre-alpine
 
# Set the working directory in the container
WORKDIR /app
 
# Copy the packaged Spring Boot application JAR file into the container
COPY target/springboot-emp-management-system-0.0.1-SNAPSHOT.jar .
 
# Specify the command to run your Spring Boot application
CMD ["java", "-jar", "springboot-emp-management-system-0.0.1-SNAPSHOT.jar"]