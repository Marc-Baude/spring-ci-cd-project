#
# Build stage
#
FROM maven:3.8.2-jdk-11-openj9 AS MAVEN_TOOL_CHAIN
COPY pom.xml /tmp/
COPY src /tmp/src/
WORKDIR /tmp/
RUN mvn clean package
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/api-0.0.1-SNAPSHOT.jar"]

#
# TODO: Copy *.Jar into seperate Env., to save overhead from maven image!
#


