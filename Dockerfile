FROM openjdk:17-jdk-alpine
WORKDIR usr/app/
COPY ./build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]