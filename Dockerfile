FROM openjdk:8-jdk-alpine
MAINTAINER Murat Öztürk <muratozturk1987@gmail.com>

# Add the service itself
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} muratovic-springaop-demo.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/muratovic-springaop-demo.jar"]
