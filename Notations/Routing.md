# configureRouting() no Ktor: Guia prático

## O que é?

- Função de extensão do `Application`
- Define rotas HTTP do servidor dentro do bloco `routing {}`

## Principais funções dentro do routing

- `get("/caminho") { ... }` — responde a GET
- `post("/caminho") { ... }` — responde a POST
- `put("/caminho") { ... }` — responde a PUT
- `delete("/caminho") { ... }` — responde a DELETE
- `patch("/caminho") { ... }` — responde a PATCH

## Objeto `call`

- Representa a requisição e resposta
- `call.request` — dados da requisição
- `call.respond()` — envia resposta (texto, JSON, status)

## Exemplo prático

```kotlin
fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("API funcionando")
        }
        post("/echo") {
            val texto = call.receiveText()
            call.respondText("Você enviou: $texto")
        }
    }
}
