FROM eclipse-temurin:21

LABEL mantainer="jrubenrm@icloud.com"

WORKDIR /app
COPY target/happydog-api-1.0.0.jar /app/happydog-api.jar

ENTRYPOINT ["java", "-jar", "happydog-api.jar"]
