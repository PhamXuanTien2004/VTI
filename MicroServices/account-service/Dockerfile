FROM openjdk:17-jdk

LABEL authors="Pxtien"

WORKDIR /app

COPY target/account-service-0.0.1-SNAPSHOT.jar account-service.jar

ENTRYPOINT ["java", "-jar", "account-service.jar"]

EXPOSE 8080