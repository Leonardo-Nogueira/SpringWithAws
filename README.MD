# Restaurant Marketplace
## AnotaAi Backend Challenge

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MongoDB](https://img.shields.io/badge/MongoDB-%234ea94b.svg?style=for-the-badge&logo=mongodb&logoColor=white)
![AWS](https://img.shields.io/badge/AWS-%23FF9900.svg?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Docker](https://img.shields.io/badge/docker-257bd6?style=for-the-badge&logo=docker&logoColor=white)
![DockerCompose](https://img.shields.io/badge/Docker-Compose-blue?style=for-the-badge&logo=docker&logoColor=white)


Este projeto foi criado utilizando **Java, Java Spring, AWS SQS, SNS, Lambda, S3 Mongo DB and docker compose.**


## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)

## Installation

1. Clone o repositorio:

```bash
git clone git@github.com:Leonardo-Nogueira/SpringWithSQSLambdaSNSS3.git
```

2. Instale as dependencias com Maven

3. Crie uma configuração com variáveis ​​de ambiente de tempo de execução com suas credenciais da AWS usadas em `application.properties`

```yaml
aws.region=us-east-1
aws.accessKeyId=${AWS_KEY_ID}
aws.secretKey=${AWS_SECRET}
aws.sns.topic.catalog.arn=${AWS_SNS_TOPIC}
```

**Variaveis de ambiente de execução**

```yaml
AWS_KEY_ID=VALUE;AWS_SECRET=VALUE2;AWS_SNS_TOPIC=VALUE3
```

**Você pode subir toda a aplicacao pelo docker-compose.yaml ou subir via IDE**

1. Rode no terminal:
```bash
docker compose up -d
```

## Usage

1. Inicie o aplicativo com Maven
2. A API estará acessível em http://localhost:8080

## API Endpoints
A API fornece os seguintes endpoints:

**API PRODUTO**
```markdown
POST /api/product - Cria um novo produto
GET /api/product - Consulta todos os produtos
PUT /api/product/{id} - Altera um produto
DELETE /api/product/{id} - Deleta um produto
```

**BODY**
```json
{
  "title": "Produto para postar no tópico",
  "description": "Chuveiro",
  "ownerId": "123",
  "categoryId": "659d558b0304df732ddd4587",
  "price": 123.45
}
```

**API CATEGORIA**
```markdown
POST /api/category - Cria nova categoria
GET /api/category - Consulta todas categorias
PUT /api/category/{id} - Altera uma categoria
DELETE /api/category/{id} - Deleta uma categoria
```

**BODY**
```json
{
  "id": "393948882828",
  "title": "Teste",
  "description": "",
  "ownerId": "4444444"
}
```