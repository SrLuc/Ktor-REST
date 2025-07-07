# Comparação Ktor + Exposed + PostgreSQL VS Express + Mongoose + MongoDB

Se você vem do mundo JavaScript com Node, Express e MongoDB, aqui vai uma comparação pra você sacar rapidão como o Ktor e Exposed funcionam.

---

## 🚀 O que é Exposed?

- Exposed é o **ORM/Query DSL** para Kotlin que conecta com bancos SQL, tipo PostgreSQL.
- Ele é equivalente ao **Mongoose** no mundo MongoDB.
- Com ele você define tabelas, colunas e faz consultas de forma tipo- segura, no Kotlin.

Exemplo de tabela em Exposed:

```kotlin
object Users : Table() {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
}
```

Equivalente a um schema Mongoose:
```js
    const UserSchema = new mongoose.Schema({
    id: Number,
    name: String
})
```

## Resumo
Exposed = ORM SQL no Kotlin (tipo Mongoose para MongoDB).

Application = app Express no Kotlin.

Sua função configureDatabaseConection() é o equivalente ao mongoose.connect(), mas pro PostgreSQL

## Tabelinha da comparação

| Ação           | Express (Node.js)                                | Ktor (Kotlin)                                    |
|----------------|-------------------------------------------------|-------------------------------------------------|
| Criar app      | `const app = express()`                          | `fun Application.module() { ... }`               |
| Rota GET       | `app.get("/", (req, res) => res.send("Hi"))`    | `get("/") { call.respondText("Hi") }`            |
| Rota POST      | `app.post("/users", (req, res) => { ... })`     | `post("/users") { val user = call.receive<User>() ... }` |
| Receber JSON   | `app.use(express.json())`                        | `install(ContentNegotiation) { json() }`          |
| Responder JSON | `res.json({ msg: "ok" })`                        | `call.respond(mapOf("msg" to "ok"))`               |
| Parâmetro URL  | `app.get("/users/:id", (req, res) => { ... })`  | `get("/users/{id}") { val id = call.parameters["id"] }` |
| Status HTTP    | `res.status(201).json(data)`                     | `call.respond(HttpStatusCode.Created, data)`      |
