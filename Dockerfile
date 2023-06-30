FROM openjdk:11
ADD /target/practic-0.0.1-SNAPSHOT.jar backend-practic.jar
ENTRYPOINT [ "java", "-jar", "backend-practic.jar"]