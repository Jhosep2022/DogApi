
#FROM eclipse-temurin:17-jdk
#COPY target/*.jar app.jar
#
#ENV DB_USERNAME "postgres"
#ENV DB_PASSWORD "jose"
#ENV DB_URL "jdbc:postgresql://localhost:5432/arquidogs"
#ENV PORT 8080
#
#ENTRYPOINT ["java","-jar","/app.jar"]

FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /workspace/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw install -DskipTests
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM eclipse-temurin:17-jdk

VOLUME /tmp
ARG DEPENDENCY=/workspace/app/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENV PORT = "PORT"
ENV DB_URL = "DB_URL"
ENV DB_USERNAME = "DB_USERNAME"
ENV DB_PASSWORD = "DB_PASSWORD"
ENV ISSUER_URI = "ISSUER_URI"
ENV RESOURCE_ID = "RESOURCE_ID"

ENTRYPOINT ["java","-cp","app:app/lib/*","com.example.demo.DemoApplication"]