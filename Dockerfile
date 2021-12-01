FROM openjdk:11-jdk
FROM maven:3.8.4-jdk-11

# image layer
WORKDIR /app
ADD pom.xml /app
RUN mvn verify clean --fail-never

# Image layer: with the application
COPY . /app
RUN mvn -v
RUN mvn clean install -DskipTests
EXPOSE 8080
ADD ./target/openshift-example-0.0.1-SNAPSHOT.jar /developments/
ENTRYPOINT ["java","-jar","/developments/openshift-example-0.0.1-SNAPSHOT.jar"]
