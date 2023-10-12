FROM openjdk:11
ADD target/userserviceapp.jar userserviceapp.jar
ENTRYPOINT [ "java", "-jar", "/userserviceapp.jar" ]