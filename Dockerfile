FROM openjdk:17-jdk
VOLUME /tmp
COPY target/restdocker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]