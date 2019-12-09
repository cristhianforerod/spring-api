# Spring Rest Api


## Run Application

#### 1. Up Database service
run command: `docker-compose up -d`

#### 2. Install maven dependencies
run command: `mvn install`

#### 3. Run Spring Boot App with Maven
run command: `mvn spring-boot:run`

### Base URL
[http://localhost:8080/products](http://localhost:8080/products)

### Endpoints
- [http://localhost:8080/products](http://localhost:8080/products) => GET /products
- [http://localhost:8080/products](http://localhost:8080/products) => POST /products
- [http://localhost:8080/products/id](http://localhost:8080/products/0) => GET /products/:id
- [http://localhost:8080/products/id](http://localhost:8080/products/0) => DELETE /products/:id
- [http://localhost:8080/products/id](http://localhost:8080/products/0) => PUT /products/:id

### Services Documentation
[http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)