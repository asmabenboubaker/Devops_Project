FROM openjdk:11
EXPOSE 8089
ADD target/DevOps_Project-2.1.jar devops_project-2.1.jar
ENTRYPOINT ["java","-jar","/devops_project-2.1.jar"]
