FROM openjdk:8-jdk-alpine

WORKDIR .

ENV PORT=8000
ENV DB_PASSWORD=postgres
ENV DB_HOST=ai-db
ENV DB_USER_NAME=postgres
ENV WORKDIR=/home/bsmch

COPY ./*.jar app.jar

EXPOSE ${PORT}

ENTRYPOINT ["java","-jar","app.jar"]

