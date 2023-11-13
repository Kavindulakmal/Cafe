### Running the project
##Invoice

By default, tomcat will run on port 8080. if you have a different port please add
```
server.port=<your port>
```
to the `application.properties` or `application.yml` file   

#### Endpoints
Get Invoice PDF  http://localhost:8080/invoce/<invoiceid>/pdf  | HTTP Method= "GET"   `GET`

Get Balance  http://localhost:8080/invoce/<invoiceid>/pdf  | HTTP Method= `GET`

Create Invoice   http://localhost:8080/invoice  | HTTP Method= `POST`

Add Payment   http://localhost:8080/invoce/<invoiceid>/balance | HTTP Method= `POST`


# Contributing
Pull requests are welcomed. For major changes, please open an issue first to discuss what you would like to change. Thanks!

Happy Coding!!!

## Copyright
© KAVINDU™


