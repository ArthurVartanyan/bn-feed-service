FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/*.jar bn-feed-service.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bn-feed-service.jar"]