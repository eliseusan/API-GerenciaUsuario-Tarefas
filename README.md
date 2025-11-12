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
- `POST /usuarios` → Criação de usuário
- `GET /usuarios` → Listagem de usuários
- `GET /usuarios/{id}` → Buscar por ID
- `PUT /usuarios/{id}` → Atualizar usuário
- `DELETE /usuarios/{id}` → Remover usuário

### ✅ Tarefas
- `POST /tarefas` → Criar tarefa vinculada a um usuário
- `GET /tarefas` → Listar todas as tarefas
- `GET /tarefas/usuario/{idUsuario}` → Listar tarefas por usuário
- `PATCH /tarefas/{id}/status` → Atualizar status da tarefa

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


