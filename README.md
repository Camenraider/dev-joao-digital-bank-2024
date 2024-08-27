# dev-joao-digital-bank-2024
Criando uma api RESTfull com Spring Boot

## Diagrama de classes

``` mermaid
classDiagram
    class User {
        +String name
        +Account account
        +Feature[] features
        +Card card
        +News[] news
    }

    class Account {
        +String number
        +String agency
        +float balance
        +float limit
    }

    class Feature {
        +String icon
        +String description
    }

    class Card {
        +String number
        +float limit
    }

    class News {
        +String icon
        +String description
    }

    User "1" *-- "1" Account
    User "1" *-- "N" Feature
    User "1" *-- "1" Card
    User "1" *-- "N" News 
```
## Acessar banco de testes
http://localhost:8080/h2-console

## Acessar Swagger
http://localhost:8080/swagger-ui/index.html