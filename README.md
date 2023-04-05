# abctech-api

Projeto utilizando Spring Boot

### Container Docker para serviço de banco de dados MySQL

docker run --name mysql-dev -p 3306:3306 -e MYSQL_ROOT_PASSWORD=Fiap1234 -d mysql:8.0

### Executar o projeto com variáveis de sistema com a conexão de banco de dados

./mvnw spring-boot:run -Dspring-boot.run.jvmArguments="-DDB_HOSTNAME=localhost -DDB_PORT=3306 -DDB_NAME=abc_tech -DDB_USERNAME=root -DDB_PASSWORD=Fiap1234"
