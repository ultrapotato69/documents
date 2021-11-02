# Приложение для храниения документов
### База данных
* Postgres
* Требуется создать базу с именем documents на стандартном 5432 порту, юзер - postgres, пароль - 123 

### Серверная часть 
* Spring Boot + Spring Data Jpa + миграции бд Flyway
* Способ передачи информации - json по http, http порт - 8080
* Примеры и описание http зарпросов  в файле src/main/resources/restTestDocument.http

### Клиентская часть 
* Вебклиент на чистом javascript 
* Исходники клиента - src/main/resources/static


