# ForumHub API

![Java](https://img.shields.io/badge/Java-17+-red)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue)
![JWT](https://img.shields.io/badge/Auth-JWT-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

## 📌 Descrição do Projeto

O **ForumHub** é uma **API REST** desenvolvida em **Java com Spring Boot** para gerenciamento de tópicos de um fórum.

A aplicação permite que usuários autenticados realizem operações completas de **CRUD (Create, Read, Update e Delete)** em tópicos do fórum.

A autenticação da API é realizada utilizando **JSON Web Token (JWT)** com **Spring Security**, garantindo que apenas usuários autenticados possam acessar determinados endpoints.

Este projeto foi desenvolvido com foco em:

* Arquitetura REST
* Boas práticas com **Spring Boot**
* Segurança com **Spring Security + JWT**
* Persistência de dados com **PostgreSQL**
* Estrutura organizada em camadas (**Controller, Service, Repository, DTO**)

---

# 🧱 Tecnologias Utilizadas

| Tecnologia      | Descrição                              |
| --------------- | -------------------------------------- |
| Java 17+        | Linguagem principal                    |
| Spring Boot     | Framework principal da aplicação       |
| Spring Web      | Criação da API REST                    |
| Spring Data JPA | Persistência de dados                  |
| Spring Security | Controle de autenticação e autorização |
| JWT             | Autenticação baseada em token          |
| PostgreSQL      | Banco de dados relacional              |
| Maven           | Gerenciador de dependências            |
| Hibernate       | ORM utilizado pelo JPA                 |

---

# 📂 Estrutura do Projeto

```
forumhub
│
├── controller
│   └── TopicoController.java
│
├── service
│   └── TopicoService.java
│
├── repository
│   └── TopicoRepository.java
│
├── model
│   └── Topico.java
│
├── dto
│   ├── DadosCadastroTopico.java
│   ├── DadosAtualizacaoTopico.java
│   └── DadosDetalhamentoTopico.java
│
├── security
│   ├── SecurityConfigurations.java
│   ├── TokenService.java
│   └── AutenticacaoController.java
│
└── ForumHubApplication.java
```

---

# ⚙️ Como Configurar o Projeto

## 1️⃣ Pré-requisitos

Antes de iniciar, certifique-se de ter instalado:

* **Java 17 ou superior**
* **Maven**
* **PostgreSQL**
* **Git**

Verifique as versões instaladas:

```bash
java -version
mvn -version
psql --version
```

---

# 🗄️ Configuração do Banco de Dados

Crie um banco de dados no PostgreSQL:

```sql
CREATE DATABASE forumhub;
```

Configure o arquivo:

```
src/main/resources/application.properties
```

Exemplo:

```properties
spring.datasource.url=jdbc:postgresql://localhost/forumhub
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

api.security.token.secret=12345678
```

---

# ▶️ Como Executar o Projeto

Clone o repositório:

```bash
git clone https://github.com/seu-usuario/forumhub.git
```

Entre na pasta:

```bash
cd forumhub
```

Execute a aplicação:

```bash
mvn spring-boot:run
```

A API estará disponível em:

```
http://localhost:8080
```

---

# 🔐 Autenticação

A API utiliza **JWT (JSON Web Token)** para autenticação.

Fluxo de autenticação:

1. Usuário envia **login e senha**
2. API gera um **token JWT**
3. Cliente envia o token no header das próximas requisições

Header necessário:

```
Authorization: Bearer SEU_TOKEN_AQUI
```

---

# 📡 Endpoints da API

## 🔑 Autenticação

### Login

```
POST /login
```

### Exemplo de requisição

```json
{
  "login": "usuario",
  "senha": "123456"
}
```

### Resposta

```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

---

# 🧵 Tópicos do Fórum

## Criar tópico

```
POST /topicos
```

### JSON

```json
{
  "titulo": "Erro ao subir aplicação Spring Boot",
  "mensagem": "Minha aplicação não inicia após atualizar dependências.",
  "autor": "Lucas",
  "curso": "Spring Boot"
}
```

---

## Listar tópicos

```
GET /topicos
```

### Resposta

```json
[
  {
    "id": 1,
    "titulo": "Erro no Spring",
    "mensagem": "Aplicação não sobe",
    "autor": "Lucas",
    "curso": "Spring Boot",
    "dataCriacao": "2026-03-10"
  }
]
```

---

## Detalhar tópico

```
GET /topicos/{id}
```

Exemplo:

```
GET /topicos/1
```

---

## Atualizar tópico

```
PUT /topicos/{id}
```

### JSON

```json
{
  "titulo": "Erro ao iniciar aplicação",
  "mensagem": "Descobri que o problema era na configuração do banco."
}
```

---

## Deletar tópico

```
DELETE /topicos/{id}
```

Exemplo:

```
DELETE /topicos/1
```

---

# 🧪 Testando a API

Ferramentas recomendadas:

* **Postman**
* **Insomnia**
* **curl**
* **Thunder Client (VSCode)**

Exemplo com **curl**:

```bash
curl -X GET http://localhost:8080/topicos \
-H "Authorization: Bearer SEU_TOKEN"
```

---

# 🔒 Boas Práticas Implementadas

* Arquitetura em camadas
* Uso de DTOs
* Validação de dados
* Autenticação com JWT
* Segurança com Spring Security
* Separação de responsabilidades
* Uso de boas práticas REST

---

# 🚀 Possíveis Melhorias Futuras

* Sistema de respostas aos tópicos
* Sistema de votos (upvote/downvote)
* Paginação de tópicos
* Documentação da API com **Swagger/OpenAPI**
* Testes automatizados (**JUnit + Mockito**)
* Deploy em **Docker**

---

# 👨‍💻 Autor

Projeto desenvolvido para fins de estudo com **Java + Spring Boot**.

---

# 📜 Licença

Este projeto está sob a licença **MIT**.

Sinta-se livre para estudar, modificar e utilizar o código.
