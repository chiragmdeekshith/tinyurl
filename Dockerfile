FROM openjdk:17
EXPOSE 8080
ADD build/libs/tinyurl.jar tinyurl.jar
ENTRYPOINT ["java","-jar","/tinyurl.jar"]