# AvancaIF API (Java)

AvancaIF é uma API baseada em Spring Boot. Este projeto utiliza tecnologias modernas de Java e frameworks para oferecer uma solução backend robusta e escalável.

---

## 🚀 Começando

### Pré-requisitos
Para executar este projeto, certifique-se de ter instalado:
- **Java 17** ou superior
- **Maven 3.8+**
- **PostgreSQL** (ou outro banco de dados de sua preferência)

### Executando a Aplicação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-repositorio/avancaif-api-java.git
   cd avancaif-api-java
   ```

2. **Compile o projeto**:
   ```bash
   mvn package
   ```

3. **Execute a aplicação**:
 - Usando o JAR gerado:
   ```bash
   java -jar ./target/avancaif-0.0.1-SNAPSHOT.jar
   ```
 - Ou diretamente com o Maven:
   ```bash
   mvn spring-boot:run
   ```

4. **Acesse a API**:
   A aplicação estará disponível em `http://localhost:8080`.

---

## 🛠️ Tecnologias Utilizadas

### Tecnologias Principais
- **Java 17**: Linguagem de programação utilizada no backend.
- **Spring Boot**: Framework para construção da API com recursos como injeção de dependência, suporte a REST, entre outros.
- **Maven**: Ferramenta de automação de build e gerenciamento de dependências.

### Dependências (do `pom.xml`)
- **Spring Boot Starter Web**: Para construção de APIs RESTful.
- **Spring Boot Starter Data JPA**: Para interação com o banco de dados usando JPA/Hibernate.
- **PostgreSQL Driver**: Para conexão com o banco de dados PostgreSQL.
- **Spring Boot Starter Test**: Para testes unitários e de integração.
- **Lombok**: Para reduzir código boilerplate (ex.: getters, setters, construtores).
- **Spring Boot DevTools**: Para hot-reloading durante o desenvolvimento.

---

## 📂 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── br/com/cpsoftware/avancaif/
│   │       ├── AvancaIfApplication.java  # Ponto de entrada principal da aplicação
│   │       ├── domain/                   # Entidades do domínio
│   │       └── app/                      # Modelos e serviços da aplicação
│   └── resources/
│       ├── application.yml               # Configuração da aplicação
│       └── static/                       # Recursos estáticos (se houver)
├── test/                                 # Testes unitários e de integração
```

---

## 🗄️ Configuração do Banco de Dados

### Executando o Banco de Dados
A aplicação utiliza **PostgreSQL** como banco de dados padrão. Atualize o arquivo `application.yml` com as credenciais do seu banco de dados:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/avancaif
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

### Executando o Banco de Dados com Docker
Caso deseje executar o PostgreSQL via do Docker, utilize o seguinte comando:

```bash
docker-compose up -d --build
```

---

## 🧪 Testes

Execute os testes utilizando o Maven:
```bash
mvn test
```

---

## 📖 Documentação

- **Documentação do Spring Boot**: [https://spring.io/projects/spring-boot](https://spring.io/projects/spring-boot)
- **Documentação do Maven**: [https://maven.apache.org/](https://maven.apache.org/)
- **Documentação do PostgreSQL**: [https://www.postgresql.org/docs/](https://www.postgresql.org/docs/)
