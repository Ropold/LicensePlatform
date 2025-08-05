FROM --platform=linux/amd64 openjdk:21
LABEL authors="ropold"
EXPOSE 8080
COPY backend/target/licenseplatform.jar licenseplatform.jar
ENTRYPOINT ["java", "-jar", "licenseplatform.jar"]