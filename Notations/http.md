# 🚀 Funcionamento das requisições da API Users - Ktor

---

## GET /

- Retorna uma mensagem simples para mostrar que a API tá online.
- Resposta: `200 OK` com texto `"Hello World!"`.

---

## GET /users

- Retorna a lista de usuários cadastrados (em memória).
- Resposta: `200 OK` com JSON contendo a lista de usuários.

---

## POST /users

- Recebe no corpo um JSON com `name` e `age`.
- Cria um novo usuário com ID gerado automaticamente (`users.size + 1`).
- Adiciona o usuário na lista.
- Resposta: `201 Created` com JSON do usuário criado.

---

## PUT /users/{id}

- Pega o parâmetro `id` da URL com `call.parameters["id"]`.
- Usa `toIntOrNull()` pra tentar transformar o `id` em inteiro; se não rolar, `id` vira `null`.
- Procura na lista `users` o índice do usuário com esse `id` usando `indexOfFirst`.
- Cria um novo objeto `User` com o mesmo `id` e os dados atualizados.
- Atualiza a lista na posição encontrada com esse novo usuário.
- Responde com `200 OK` e o usuário atualizado.

---

## DELETE /users/{id}

- Pega o parâmetro `id` da URL e tenta converter para inteiro, igual no PUT.
- Procura o índice do usuário na lista pelo `id`.
- Se achou, remove o usuário da lista com `removeAt(index)`.
- Responde com `204 No Content` (sem corpo, indicando que removeu com sucesso).

**Detalhes técnicos:**

```kotlin
val body = call.receive<User>()  // Recebe JSON e converte para User
val user = User(users.size + 1, body.name, body.age)  // Cria User com ID automático
