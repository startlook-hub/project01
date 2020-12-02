FROM openjdk:8-jdk-alpine
RUN mkdir -p /apps
COPY ./target/project01-01.jar /apps/app.jar
WORKDIR /apps
ENTRYPOINT ["java","-jar","app.jar"]
