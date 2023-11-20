# Discount Base Electricity bill calculator.

### About
This Spring boot API will calculate the electricity bill using units. every customer has a type. if the customer type is `silver`, it will give a `5%` discount and if the customer type 
is `gold` it will give a `10%` discount to the customer's bill. inputs are `customer id`, `name`, and `unit` for calculation. According to the formula, first 30 units, unit price =8 and 30 to 60 unit price =12, and 60 to 90 unit price =12, and above 90 unit price =20. the output will show the customer ID, unit, amount, discount, and
final bill

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
