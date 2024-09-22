#java 17
FROM openjdk:17
COPY ./target/crudapp-0.0.1-SNAPSHOT.jar crudapp-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "crudapp-0.0.1-SNAPSHOT.jar"]