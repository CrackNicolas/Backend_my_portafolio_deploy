FROM amazoncorretto:11-alpine-jdk
MAINTAINER MGB
COPY target/demo-0.0.1-SNAPSHOT.jar mgb-app.jar
ENTRYPOINT ["java","-jar","/mgb-app.jar"]