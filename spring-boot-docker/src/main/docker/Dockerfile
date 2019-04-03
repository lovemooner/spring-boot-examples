# 1、第一行必须指定 基础镜像信息
FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-boot-docker-1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]