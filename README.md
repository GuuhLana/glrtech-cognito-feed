# 🧠 CognitoFeed

No mundo atual, somos inundados por informações. Mas… quem realmente está prestando atenção no que está sendo dito?
O **CognitoFeed** nasce como uma resposta a essa era de ruído, oferecendo uma solução inteligente e distribuída capaz de **ler**, **entender** e **sintetizar** sentimentos humanos e ideias complexas.
Mais do que um projeto, é um passo em direção à compreensão automatizada da linguagem natural com precisão, velocidade e empatia artificial.

---

O **CognitoFeed** é um sistema distribuído que analisa textos/redações, gerando um **resumo automático** e identificando o **sentimento predominante**. O projeto combina as tecnologias Java + Spring Boot (backend e persistência) e Python + FastAPI (inteligência artificial).

---

## 🚀 Visão Geral

Este projeto é dividido em dois microsserviços:

- `cognito-backend` (Java/Spring): responsável por armazenar, gerenciar e requisitar análises de textos.
- `cognitofeed-nlp-service` (Python/FastAPI): realiza o processamento de linguagem natural (summarization + sentiment analysis) com modelos pré-treinados da HuggingFace.

---

## 🛠️ Tecnologias Utilizadas


### Java Backend
- Spring Boot
- Spring Web
- Spring Data MongoDB
- RestTemplate (consumo de API Python)
- MongoDB

### Python NLP
- FastAPI
- HuggingFace Transformers
- PyTorch
- `pierreguillou/t5-base-pt-summarizer` (summarization)
- `distilbert-base-uncased-finetuned-sst-2-english` (sentiment)

Além disso, o projeto utiliza **Docker** para conteinerizar o MongoDB, facilitando o setup local e garantindo isolamento do banco de dados durante o desenvolvimento.

---

## 📁 Estrutura do Projeto
cognito-feed/
- cognito-backend/ # Microsserviço Java Spring Boot
- cognito-backend/db # Arquivo de import (MongoDB) com alguns textos ja criados.
- cognitofeed-nlp-service/ # Microsserviço Python FastAPI
- GLRTech-CognitoFeed.postman_collection/ # Coleção de Endpoints expostos pelos microsserviços