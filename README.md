# distributionapp

Rest application with two related entities


#### Technologies used
- SpringBoot
- PostgreSql database
- Apache maven - build
- Spring Data
- Jupiter - test engine
- Mock MVC - mock responses for tests
---
#### Get app
~~~
git clone https://github.com/Nikita-ctr/distributionapp.git
~~~

#### Build app
~~~
mvn clean install -DskipTests
~~~

#### Test app

For launching, use:(Test can be run without installed postgres)
~~~
mvn clean test
~~~

#### Build app
~~~
mvn clean install -DskipTests
~~~

---
#### Use
Application available at  (localhost:8080)

 Use postman to test functionality:

- Show all
~~~
METHOD:GET
http://localhost:8080/projects
~~~
 - Show specific
 ~~~
 METHOD:GET
 http://localhost:8080/projects/{id}
~~~
- Create new
~~~
METHOD:POST
http://localhost:8080/projects
Body:{ "id": 1,  "name": "Test"}
~~~
- Update 
~~~
 METHOD:PUT
 http://localhost:8080/projects
 Body:{ "id": 2,  "name": "Test2"}
~~~
- Delete
~~~
 METHOD:DELETE
 http://localhost:8080/projects{id}
~~~

CRUD operations with the developer are no different, except for creating

- Create
~~~
METHOD:POST
http://localhost:8080/developers/{projectId}
BODY:{  
        "first_name": "Name",
        "last_name": "Surname",
        "dateOfBirth": "2020-01-09T21:00:00.000+00:00",
        "projectHours": 30
     }
~~~