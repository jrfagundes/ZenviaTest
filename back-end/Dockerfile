FROM openjdk:18-jdk-alpine3.15

ADD . /app
WORKDIR /app

RUN ./mvnw install

EXPOSE 8080

CMD java -jar target/ZenviaTest-0.0.1-SNAPSHOT.jar