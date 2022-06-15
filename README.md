## Implementação
Aplicação que exponhe uma api web que verifica se uma senha é válida.

O projeto está dividido em dois pacotes:

[core]() responsável pelas classes de negócios, a regra da aplicação. Nesse pacote, irá conter as classes responsáveis 
por realizar a validação da senha.

[infrastructure]() responsável pelas de configuração da aplicação e formas de comunicação.

### Motivo
Estruturei o projeto dessa forma, pois acredito ser uma maneira que bem as responsabilidades de cada pacote, bem como
uma forma de ter um melhor entendimento para quem irá realizar o code review, além disso, é uma modelo que poderá ser
reaproveitado caso existam outros casos de usos para serem implementados. 

### Premissa
* Optei por colocar um limitador de caracteres (máximo 20) para a senha.

## Demonstração

**Como o serviço deve funcionar?**

Recebe uma string e verifica se a mesma é valida segundo tais critérios:
* Nove ou mais caracteres
* Ao menos 1 dígito
* Ao menos 1 letra minúscula
* Ao menos 1 letra maiúscula
* Ao menos 1 caractere especial
* Considere como especial os seguintes caracteres: !@#$%^&*()-+
* Não possuir caracteres repetidos dentro do conjunto`

Exemplo:

> IsValid("") // false  
IsValid("aa") // false  
IsValid("ab") // false  
IsValid("AAAbbbCc") // false  
IsValid("AbTp9!foo") // false  
IsValid("AbTp9!foA") // false
IsValid("AbTp9 fok") // false
IsValid("AbTp9!fok") // true

## Deploy

Compilar o projeto, baixar as dependências e rodar os testes: 
    
    > mvn clean install

Para executar a aplicação:

    > mvn spring-boot:run

### Docker
Se desejar usar o docker, é necessário usar dois comandos: 

build:

    > docker build . -t iti-itau

run:

    > docker run -it -p 8080:8080 iti-itau
### curl
> curl --location --request GET 'http://localhost:8080/v1/validate/password?password=AbTp9!fokA'

## Tecnologia
**Back-end:** Kotlin
