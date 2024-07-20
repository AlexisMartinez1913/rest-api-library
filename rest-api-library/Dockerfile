FROM openjdk:22-jdk-slim
ARG JAR_FILE=target/rest-api-library-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app_library.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "app_library.jar"]
