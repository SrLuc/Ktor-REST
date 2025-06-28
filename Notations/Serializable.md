# 📚 Kotlin Ktor — @Serializable, listas e boas práticas

## 🚀 O que é @Serializable?

- É uma **annotation** (tipo um decorator) do `kotlinx.serialization`.
- Indica que o compilador deve gerar o código necessário pra:
    - Converter objetos dessa classe em JSON
    - E JSON em objetos dessa classe

✅ Assim o `call.receive<User>()` e o `call.respond(user)` funcionam sem erro.

#### “Essa classe pode ser convertida automaticamente pra JSON (ou de JSON pra objeto) usando o serializer do Kotlin.”

---

## 📝 Exemplo de uso

```kotlin
import kotlinx.serialization.Serializable

@Serializable
data class User(val name: String, val age: Int)
