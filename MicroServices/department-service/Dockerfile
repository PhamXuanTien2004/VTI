FROM openjdk:17-jdk

LABEL authors="Pxtien"

WORKDIR /app

COPY target/department_service-0.0.1-SNAPSHOT.jar department-service.jar

ENTRYPOINT ["java", "-jar", "department-service.jar"]

EXPOSE 8080