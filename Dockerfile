FROM maven:3.9.9-ecplise-temurin-21 as maven-build
WORKDIR /app
COPY . .

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=maven-build /target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]