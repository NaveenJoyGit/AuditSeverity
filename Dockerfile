FROM openjdk:11
VOLUME /tmp 
EXPOSE 8300
COPY target/auditseverity-0.0.1-SNAPSHOT.jar app.jar 
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"] 