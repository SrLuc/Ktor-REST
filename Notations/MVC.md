# 🚀 Model

## 📂 Onde fica
`src/main/kotlin/com/example/models/Track.kt`

---

## 🔍 O que é
É a **camada mais baixa do teu MVC**, que define a **estrutura do dado**.

A anotação @Serializable vem do kotlinx.serialization e permite converter esse objeto para JSON  E ler JSON para virar esse objeto

No caso:
```kotlin
@Serializable
data class Track(
    var id: Int,
    val name: String,
    val bpm: Int
)
```

# 🚀 Controller

## 📂 Onde fica
`src/main/kotlin/com/example/controllers/TrackController.kt`

---

## 🧩 O que é
É o **nível médio da arquitetura MVC**:
- Controla a **lógica de negócios**.
- Sabe como lidar com o dado, mas **não sabe nada de HTTP** (não chama `call.respond` por exemplo).
- Se comunica só com o Model (`Track`) e com a camada mais alta (as rotas).

---

## 🛠 Como funciona
### 🔥 É um `object`
- No Kotlin, `object` cria um singleton automaticamente.
- Útil pra esse projeto simples, pois não precisa instanciar com `TrackController()`.
- Garante que a lista `tracks` é **única na aplicação inteira**.

---

## 🧬 O que faz
### ✅ getAll()
Retorna a lista completa:
```kotlin
fun getAll(): List<Track> = tracks
```

# 🚀 Routing

## 📂 Onde fica
`src/main/kotlin/com/example/routes/TrackRoutes.kt`

---

## 🔥 O que é
É o **nível mais alto do teu MVC**, onde:
- Recebe requisições HTTP (GET, POST, PUT, DELETE).
- Lê parâmetros, corpo da requisição.
- Decide qual status HTTP devolver.
- Chama o `TrackController` pra aplicar a lógica.

---

