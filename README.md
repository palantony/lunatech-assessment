# Airport Service Application

## Data Model
Used mysql as DB, and you may find db script under \db\lunatechdb.sql  ,build the db from sql

## Software / APIs
Used spring-boot, bootstrap , Junit to implement the application.

## Deployment Diagram

<img width="379" alt="airport deployment diagram" src="https://user-images.githubusercontent.com/1983768/41763495-b0ce71c4-75fe-11e8-9ade-6c257e403470.PNG">

## Services
This application is build to meet the following usecases </br>
1) List all airports for given country </br>
2) Countries having highest number of airports </br>
3) Countries having lowest number of airports </br>
4) Country and its Runway type Report </br>

## How to run
You can run the application from Maven, from Docker or as Java standalone executable. To build the application you will need Maven and Java8. After few seconds the application should be availabe, for example http://localhost:8080/health returns the health status.</br>

### Maven
Form the repository base folder run: </br>
* mvn clean install </br>
* mvn spring-boot:run </br>

### Docker
Docker should be installed in your computer.</br>

sh build-docker.sh</br>
sudo docker run --net=host -e JAVA_OPTS="-Xmx1g -Xms1g" java-api-guidelines</br>

Testing
