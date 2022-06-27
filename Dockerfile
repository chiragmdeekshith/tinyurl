FROM openjdk:17
ARG ARG_DB_USERNAME=default_db_username
ARG ARG_DB_PASSWORD=default_db_password
ENV DB_USERNAME=$ARG_DB_USERNAME
ENV DB_PASSWORD=$ARG_DB_PASSWORD
EXPOSE 8080
ADD build/libs/tinyurl.jar tinyurl.jar
ENTRYPOINT ["java","-jar","/tinyurl.jar"]