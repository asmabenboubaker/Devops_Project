
FROM openjdk:8
Expose 8089
COPY target/docker-sts.jar docker-sts.jar
ENTRYPOINT ["java", "-jar", "docker-sts.jar"]
