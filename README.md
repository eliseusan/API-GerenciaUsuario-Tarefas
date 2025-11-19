# 🧠 Desafio Técnico - Desenvolvedor Java Spring Boot (Júnior / Pleno)

## 🚀 Objetivo
Desenvolver uma **API RESTful** para gerenciamento de **Usuários e Tarefas**, aplicando boas práticas de desenvolvimento, testes automatizados e arquitetura limpa.

---

## 🧩 Tecnologias Recomendadas

- **Java 11**
- **Spring Boot 3+**
- **Spring Data JPA / Hibernate**
- **PostgreSQL**
- **Docker / Docker Compose**
- **JUnit 5 / Mockito**
- **GitHub Actions**
- **Clean Code / SOLID**
- (Opcional) **Swagger / OpenAPI**

---

## ⚙️ Funcionalidades Esperadas

### 👤 Usuários
- `POST /v1/usuario` → Criação de usuário
- `GET /v1/usuario` → Listagem de usuários
- `GET /v1/usuario/{idUsuario}` → Buscar por ID
- `PATCH /v1/usuario/{idUsuario}` → Atualizar usuário
- `DELETE /v1/usuario/{idUsuario}` → Remover usuário

### ✅ Tarefas
- `POST /v1/tarefa/{idUsuario}` → Criar tarefa vinculada a um usuário
- `GET /v1/tarefa` → Listar todas as tarefas
- `GET /v1/tarefa/usuario/{idUsuario}` → Listar tarefas por usuário
- `GET /v1/tarefa/{idTarefa}` → Buscar tarefa por ID
- `PATCH /v1/tarefa/{idTarefa}` → Atualizar status da tarefa
- `PATCH /v1/tarefa/{idTarefa}/altera` → Alterar título e descrição da tarefa
- `DELETE /v1/tarefa/{idTarefa}` → Deletar tarefa

---

## 📋 Regras de Negócio
- Um usuário pode ter várias tarefas.
- Tarefas devem estar sempre vinculadas a um usuário existente.
- Não permitir nomes de usuário duplicados.
- Status da tarefa deve seguir o enum fixo: `PENDENTE`, `EM_ANDAMENTO`, `CONCLUIDA`.

---

## 🧠 Boas Práticas Esperadas
- Uso de DTOs para entrada e saída de dados.
- Camadas bem definidas: **Controller**, **Service**, **Repository**.
- Validação de dados com **Bean Validation** (`@NotNull`, `@Email`, etc.).
- Tratamento global de exceções com `@ControllerAdvice`.
- Testes unitários cobrindo Services e Controllers.
- Aplicação de **Clean Code** e princípios **SOLID**.
- Containerização com **Docker**.

---

## 🧱 Diferenciais
- Documentação com Swagger/OpenAPI.
- Logs estruturados 
- Testes de integração com Mockito simulando dependências.

---

## 🧪 Testes Automatizados
Os testes devem garantir o correto funcionamento das regras de negócio e cobrir:
- Camada de **Service** (JUnit + Mockito)
- Camada de **Controller** (MockMvc)
