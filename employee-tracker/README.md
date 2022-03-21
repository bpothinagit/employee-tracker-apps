# employee-tracker
This is a Spring Boot App to manage employee vacation status using REST endpoints.

## What you'll need to run and test this app
<ul>
<li>JDK 1.11 or above</li>
<li>Maven 3 or above</li>
</ul>

## Details about the REST end point
1. <b>GET Endpoint:</b> /employee/getAll
2. <b>POST Endpoint:</b> /employee/work/{id}
3. <b>POST Endpoint:</b> /take-vacation/{id}

## Steps to run and test 'employee-tracker' Spring Boot App
1. Clone this Github Repository https://github.com/bpothinagit/employee-tracker-apps.git <br/>
2. Navigate to the cloned project: <i>cd employee-tracker</i><br/>
3. Default port for Spring Boot App is 8080. </br>
   If you wish to run this on the port of your choice, mention the <i>server.port</i> property in application.properties file and accordingly use the new port in the URLs and Swagger URLs.
4. Do a Maven build and run the Spring Boot App: <i>mvn spring-boot:run</i>
