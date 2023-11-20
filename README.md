# Discount Base Electricity bill calculator.

### Running the project
By default, tomcat will run on port 8080. if you have a different port please add
```
server.port=<your port>
```
to the application.properties file

Endpoints

To Insert Data
http://localhost:8080/api/billing/calculate <br>

Go to Postman and change the method to `POST` change body->row and change the type to `JSON` and type like this

```
{
    "name":"Kavindu",
    "type":"silver",
    "units":70
}
```



### Contributing
Pull requests are welcomed. For major changes, please open an issue first to discuss what you would like to change. Thanks!

Happy Coding!!!

### Copyright
© KAVINDU™ | 2023
