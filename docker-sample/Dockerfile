FROM java:8
VOLUME /tmp
COPY ./target/docker-sample-1.0-SNAPSHOT.jar docker-sample.jar
RUN bash -c "touch /docker-sample.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","docker-sample.jar"]
