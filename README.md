# TinyUrl Backend APIs
This Spring boot project contains the code for implementing the backend for a URL shortener application.

### Database
This application uses H2 in-memory database, so each time the server restarts, all stored data is lost.
The credentials for the in-memory database can be found/modified in the application.yaml file stored [here](src/main/resources/application.yaml). 

### Setup

1. Clone the repo
2. In the folder's root directory, run the following command to clean the folder.
    >gradle clean

3. Build the project to generate a boot jar file.
   >gradle bootJar

4. Execute the JAR file present in build/libs folder.
   > java -jar tinyurl-0.0.1-SNAPSHOT.jar

   The application should be running on the port 8080 by default. Can be changed in the [application.yaml](src/main/resources/application.yaml) file if needed.

### REST endpoints

There are two endpoints in this application. They are used for the following creating the new short URL and the other to access the same.

##### Endpoint 1:
Pass the long URL to generate the short URL.
Example below.

Input
```
POST - http://localhost:8080/_/create
Request body -
{
    "originalUrl": "https://google.com/"
}
```
Output
```
Status - 200 OK
Response body -
{
    "originalUrl": "https://google.com/",
    "shortUrl": "pSZDa7"
}
```

##### Endpoint 2:
Pass the short URL to get redirected to the long URL.
Example below.

Input
```
GET - http://localhost:8080/pSZDa7
```
Output

1. If present
```
Status - 302 FOUND
Headers.Location - https://google.com/
Response body -
{}
```
2. If not present
```
Status - 204 NO_CONTENT
Response body -
{}
```