FROM openjdk:8-jdk-alpine
EXPOSE 8081
ADD /build/libs/accounts-0.1.0.jar accounts.jar
ENTRYPOINT ["java", "-jar", "accounts.jar"]