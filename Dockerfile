FROM ubuntu:18.04

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean

WORKDIR /app

COPY /build/libs/blackfriday.jar /app/

CMD ["java", "-jar", "/app/blackfriday.jar"]