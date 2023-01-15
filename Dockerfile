FROM openjdk:12
VOLUME /tmp
EXPOSE 8081
ADD ./target/Numerico-0.0.1-SNAPSHOT.jar numerico-service.jar
ENTRYPOINT ["java","-jar","/numerico-service.jar"]
