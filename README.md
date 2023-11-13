### Running the project
By default, tomcat will run on port 8080. if you have a different port please add
```
server.port=<your port>
```
to the application.properties file

#### Endpoints
Get All Items  http://localhost:8080/api/cart  | HTTP Method= "GET"   `GET`

Get Item By Id  http://localhost:8080/api/cart/<id>  | HTTP Method= `GET`

Create Item   http://localhost:8080/api/cart/  | HTTP Method= `POST`

```
{
    "name":"sugar",
    "price":"320.00"
}
```

Update Item By Id  http://localhost:8080/api/cart/<id>  | HTTP Method= `POST`

DELETE Item By Id  http://localhost:8080/api/cart/<id>  | HTTP Method= `DEELETE`

