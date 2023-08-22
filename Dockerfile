FROM eclipse-temurin:17-jdk
COPY target/*.jar app.jar

ENV DB_USERNAME "postgres"
ENV DB_PASSWORD "jose"
ENV DB_URL "jdbc:postgresql://localhost:5432/ArquiDogs"
ENV PORT 8080

ENTRYPOINT ["java","-jar","/app.jar"]