FROM java:8
VOLUME /tmp
COPY target/my-1.0-SNAPSHOT.jar my.jar
RUN bash -c "touch /my.jar"
EXPOSE 8080
ENTRYPOINT ["java","-jar","my.jar"]