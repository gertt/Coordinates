PROJECT TITLE
Coordinates

DESCRIPTION
Coordinates is a simple Spring Boot Application, created to manage a location depending by their coordinates.
It gives the possibility to create new location with specific fields and then to search for a location
depending from their values.
There are created several requests handler methods, each one returing the object or a list of objects
This repository contains the core framework of the Coordinates content management system.

Rest API services are built using Spring Boot:
1- Post Api for creating new Location
2- Get Api to search for a Location



TO ACCESS THE PROJECT
server port: 8081
Use the link below for accessing this project:
localhost:8081/task

FEATURES
Two main functions of the project:

1- Creating a POST controller to manage the API for saving an new object in database.
Description:
Url to access this endpoint is :
POST- localhost:8081/task/new-coordinates
The method accepts as parameter an object (@RequestBody) specifying the values and returns the object saved in database.

Service request is:
{
    "name": "test4",
    "lat": 19.74,
    "lng": 67.864,
    "type": "normal"
}

Service Response is:

{
    "data": {
        "id": 30,
        "name": "test4",
        "lat": 19.74,
        "lng": 67.864,
        "type": "normal"
    },
    "response": "OK",
    "exeption": null
}

2- Creating a GET controller to manage the API for searching for an object in database .
Description:
Url to access this endpoint is: 
GET - http://localhost:8081/task/get-coordinates

CASES TO CHECK FOR THIS API:
A json in request having two points (lat1,lng1) and (lat2,lng2) , the type and the limit.
Supposing that to find all points withing rectangle we need all coordinates valorized , so we can not have null or empty any coordinate.
1- if one of the coordinates comes null, all the coordinates are setted null and the search will be made by type.
2- if type comes empty , it is setted null and the search will be made by coordinates 
3- query is ordered by type 
4- limit is managed by pagination , putting as size and depending by value of paramater will be showed the results.
 

This method accepts as parameter a json and returns a json as well.

Service request is:

{
    "latFirstPoint": 11.1,
    "lngFirstPoint": 11.2,
    "latSecondPoint": 100.0,
    "lngSecondPoint": 100.0,
    "type": "",
    "limit": null
}

Service response is:

{
    "data": {
        "content": [
            {
                "id": 2,
                "name": "test2",
                "lat": 15.74,
                "lng": 60.864,
                "type": "premium"
            }
        ],
        "pageable": {
            "sort": {
                "sorted": false,
                "unsorted": true,
                "empty": true
            },
            "pageNumber": 0,
            "pageSize": 1,
            "offset": 0,
            "paged": true,
            "unpaged": false
        },
        "last": false,
        "totalPages": 28,
        "totalElements": 28,
        "numberOfElements": 1,
        "first": true,
        "size": 1,
        "number": 0,
        "sort": {
            "sorted": false,
            "unsorted": true,
            "empty": true
        },
        "empty": false
    },
    "response": "OK",
    "exeption": null
}

-Is released logging configuration to allow putting logs in project for describing the flow of service.
Is added a xml file for logs and are putted dependecies in pom.xmls


DATABASE

In database is created the table Coordinates that contains these columns:
name as varchar
lat as decimal
lng as decimal
type as varchar

we can save new row in database by calling post api and search for a row in database by calling get service.

INSTALATION OF PROJECT 



CREATION OF PROJECT
Java 1.8 
MYSql 
Maven
Hibernate
