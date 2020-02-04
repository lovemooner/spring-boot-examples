FROM java:8
VOLUME /tmp
COPY ./target/spring-boot-hello-world.jar my.jar
RUN bash -c "touch /my.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","my.jar"]
