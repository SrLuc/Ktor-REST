# 🚀 Conexão do Ktor com PostgreSQL usando Exposed

```kotlin
package com.example.database
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabaseConection() {
    try {
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/ktor_db",
            driver = "org.postgresql.Driver",
            user = "xxxxx",
            password = "yyyyy"
        )
        println("✅ Banco PostgreSQL conectado com sucesso!")
    } catch (e: Exception) {
        println("🚨 Falha ao conectar no banco: ${e.message}")
    }
}

```

### 📝 Explicando o código
📦 package com.example.database
Organiza a estrutura do projeto, dizendo que esse arquivo faz parte do pacote com.example.database.

**fun Application.configureDatabaseConection()**
É uma função de extensão do Application (Ktor), que você chama no module do seu projeto para inicializar a conexão com o banco assim que o servidor sobe.

### 🔗 Database.connect(...)
Usa o Exposed pra conectar no banco PostgreSQL, passando:

url: o endereço JDBC do banco rodando local (localhost:5432) no banco ktor_db.

driver: o driver JDBC do PostgreSQL.

user e password: credenciais para autenticar no banco.

### 💡 Boas práticas
✅ Usar try/catch evita que o servidor caia por falha na conexão.
✅ Deixa claro no console o status do banco.

