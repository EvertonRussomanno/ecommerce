# ecommerce - Sistemas de vendas criado no curso de JAVA -Udemy

## Tecnologias
### JAVA
### Spring Boot
### Spring Data JPA
### Spring Security
### H2 Database
### Postman

## Este sistema conta com login de usuários, cadastro de produtos, listagem paginada de produtos cadastrados, alteração de produtos, categorias e níves de usuários.

# Endpoints

#### Login: {{host}}/oauth2/token

## Products:
#### findAll: {{host}}/products
#### findById: {{host}}/products/{id}
#### insert: {{host}}/products
````
{
    "name": "The Lord of the Rings",
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "price": 100.5,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg",
    "categories":[
        {
            "id": 2
        },
        {
            "id": 3
        }
    ]
}
````
#### update: {{host}}/products/{id}
````
{
    "name": "Computer",
    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    "price": 1250.5,
    "imgUrl": "https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/2-big.jpg",
    "categories":[
        {
            "id": 1
        },
        {
            "id": 3
        }
    ]
}
````
#### delete: {{host}}/products/{id}

## Orders:

#### findById: {{host}}/orders/{id}

# Em construção...
