# 📅 Agendador de Tarefas

> Sistema de gerenciamento e agendamento de tarefas desenvolvido com Spring Boot e MongoDB

[![Java](https://img.shields.io/badge/Java-21-orange.svg)](https://openjdk.java.net/projects/jdk/21/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.4.3-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![MongoDB](https://img.shields.io/badge/MongoDB-Database-green.svg)](https://www.mongodb.com/)
[![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-blue.svg)](https://gradle.org/)
[![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions-blue.svg)](https://github.com/features/actions)

## 📋 Sobre o Projeto

O **Agendador de Tarefas** é uma API REST robusta desenvolvida em Java com Spring Boot, projetada para gerenciar e agendar tarefas de forma eficiente. O sistema oferece funcionalidades completas de CRUD, autenticação JWT, notificações e integração com serviços externos.

### 🎯 Principais Funcionalidades

- ✅ **Gerenciamento Completo de Tarefas** - Criar, listar, atualizar e excluir tarefas
- 🔐 **Autenticação e Autorização** - Sistema de segurança com JWT
- 📅 **Agendamento Inteligente** - Definir datas e horários para execução
- 🔔 **Sistema de Notificações** - Controle de status de notificação (PENDENTE, NOTIFICADO, CANCELADO)
- 🔍 **Busca Avançada** - Filtrar tarefas por período e usuário
- 🌐 **Integração Externa** - Comunicação com serviços de usuário via OpenFeign
- 📊 **Persistência NoSQL** - Armazenamento eficiente com MongoDB

## 🏗️ Arquitetura

O projeto segue uma arquitetura em camadas bem definida:


## 🛠️ Tecnologias Utilizadas

### Core
- **Java 21** - Linguagem de programação
- **Spring Boot 3.4.3** - Framework principal
- **Spring Security** - Autenticação e autorização
- **Spring Data MongoDB** - Persistência de dados
- **Spring Cloud OpenFeign** - Cliente HTTP declarativo

### Ferramentas e Bibliotecas
- **MongoDB** - Banco de dados NoSQL
- **JWT (JSON Web Tokens)** - Autenticação stateless
- **MapStruct** - Mapeamento de objetos
- **Lombok** - Redução de boilerplate
- **Gradle** - Gerenciamento de dependências e build
- **JUnit 5** - Testes unitários

### DevOps
- **GitHub Actions** - CI/CD
- **Docker** (configuração disponível)

## 🚀 Como Executar

### Pré-requisitos

- Java 21 ou superior
- MongoDB em execução
- Gradle (ou usar o wrapper incluído)

### Instalação

1. **Clone o repositório**
   ```bash
   git clone https://github.com/JeanHeberth/agendador-tarefas.git
   cd agendador-tarefas
   ```

2. **Configure o MongoDB**
   ```bash
   # Certifique-se de que o MongoDB está rodando na porta padrão (27017)
   mongod
   ```

3. **Execute a aplicação**
   ```bash
   # Usando Gradle Wrapper (recomendado)
   ./gradlew bootRun
   
   # Ou usando Gradle instalado
   gradle bootRun
   ```

4. **Acesse a API**
   ```
   http://localhost:8080
   ```

### Build para Produção

```bash
# Gerar JAR executável
./gradlew build

# Executar JAR
java -jar build/libs/agendador-tarefas-0.0.1-SNAPSHOT.jar
```

## 📡 Endpoints da API

### Tarefas

| Método | Endpoint | Descrição | Autenticação |
|--------|----------|-----------|-------------|
| `POST` | `/tarefas` | Criar nova tarefa | ✅ JWT |
| `GET` | `/tarefas` | Listar tarefas do usuário | ✅ JWT |
| `GET` | `/tarefas/eventos` | Buscar tarefas por período | ❌ |
| `PUT` | `/tarefas?id={id}` | Atualizar tarefa | ❌ |
| `PATCH` | `/tarefas?status={status}&id={id}` | Alterar status de notificação | ❌ |
| `DELETE` | `/tarefas?id={id}` | Excluir tarefa | ❌ |

### Exemplo de Payload

```json
{
  "nomeTarefa": "Reunião de equipe",
  "descricao": "Discussão sobre o projeto Q1",
  "dataEvento": "25-12-2024 14:30:00",
  "emailUsuario": "usuario@email.com"
}
```

## 🔧 Configuração

### Variáveis de Ambiente

```properties
# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/agendador_tarefas

# JWT
jwt.secret=sua_chave_secreta_aqui
jwt.expiration=86400000

# Logging
logging.level.com.br.agendadortarefas=DEBUG
```

## 🧪 Testes

```bash
# Executar todos os testes
./gradlew test

# Executar testes com relatório
./gradlew test jacocoTestReport

# Ver relatório de cobertura
open build/reports/jacoco/test/html/index.html
```

## 📈 CI/CD

O projeto utiliza GitHub Actions para integração contínua:

- ✅ Build automático em PRs
- ✅ Testes automatizados
- ✅ Cache de dependências Gradle
- ✅ Suporte ao Java 21

## 🤝 Contribuição

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/AmazingFeature`)
3. Commit suas mudanças (`git commit -m 'Add some AmazingFeature'`)
4. Push para a branch (`git push origin feature/AmazingFeature`)
5. Abra um Pull Request

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo `LICENSE` para mais detalhes.

## 👥 Autores

- **Projeto desenvolvido por Jean Heberth** - ***Com o curso da javanauta***

## 📞 Suporte

Para suporte e dúvidas:
- 📧 Email: [jeanheberth19@gmail.com]
- 🔗 LinkedIn: [Jean Heberth](https://www.linkedin.com/in/jean-heberth-souza-vieira-725166150/)
- 🔗 GitHub: [JeanHeberth](https://github.com/JeanHeberth)


---

⭐ **Se este projeto foi útil para você, considere dar uma estrela!**