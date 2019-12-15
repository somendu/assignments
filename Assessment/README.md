# Application Aggregation

> Aggregation

## Build Setup and Run Application

``` bash
# Install Gradle

https://gradle.org/install/

# Install Lombok

https://projectlombok.org/

# Docker Image check out and run

docker pull xyzassessment/backend-services

docker run --rm -it -p 8081:8080 -v /app xyzassessment/backend-services

# Gradle Build for aggregation application

gradle --console=plain build copyJar

--consolde=plain is just to see the lines while building
build is to build
copyJar is a task added to copy the jar into a folder rather than going to bin

# Running Application single start point

java -jar jar/Assessment.jar

# Check Swagger-UI for execution

http://localhost:8080/swagger-ui.html

```

