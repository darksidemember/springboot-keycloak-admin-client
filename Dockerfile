FROM openjdk:17-jdk-alpine
COPY target/springboot-keycloak-admin-client-0.0.1-SNAPSHOT.jar springboot-keycloak-admin-client-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/springboot-keycloak-admin-client-0.0.1-SNAPSHOT.jar"]