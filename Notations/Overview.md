**Ktor** é um framework assíncrono e leve para construir aplicações web e APIs em Kotlin. Criado pela JetBrains, ele permite desenvolver tanto o backend (servidor) quanto o client (HTTP client), com foco em performance, modularidade e facilidade de uso com corrotinas.

- **Servidor**: Criação de APIs REST, WebSockets, autenticação, roteamento, etc.
- **Cliente**: Fazer requisições HTTP com suporte a JSON, autenticação, cookies, etc.
- **Totalmente Kotlin**: Usa corrotinas e DSLs para ser idiomático e fluido.

Ideal pra quem quer construir apps modernos com stack 100% Kotlin.

## Há dependencias que são comuns a depender do projeto

✅ **Essenciais para API REST (quase sempre)**

| Dependência                            | Serve pra quê                                 | Obrigatória?                        |
|----------------------------------------|-----------------------------------------------|-------------------------------------|
| `ktor-server-core`                     | Coração do Ktor                                | ✅ SIM                              |
| `ktor-server-netty`                    | Engine HTTP (o "servidor" de verdade)          | ✅ SIM                              |
| `ktor-serialization-kotlinx-json`     | Serializar/deserializar JSON                   | ✅ SIM (se for fazer API REST)      |
| `ktor-server-content-negotiation`     | Dizer que tu quer mandar/receber JSON          | ✅ SIM (junto com a de cima)        |


🔁 **Comuns (mas opcionais)**

| Dependência                  | Serve pra quê                                         | Usa se…                                           |
|------------------------------|-------------------------------------------------------|--------------------------------------------------|
| `ktor-server-call-logging`   | Logar as requisições no terminal                     | Quer ver as requisições no console               |
| `ktor-server-cors`           | Liberar chamadas de outras origens (tipo frontend React) | Vai consumir a API de outro domínio             |
| `ktor-server-auth`           | Login, auth, JWT, etc                                | Vai proteger endpoints                           |
| `ktor-server-status-pages`   | Customizar mensagens de erro                         | Quer tratar 404, 500 e exceptions bonitinho      |


🚀 **Avançadas / Extras**

| Dependência                       | Serve pra quê                              | Usa se…                                  |
|-----------------------------------|--------------------------------------------|------------------------------------------|
| `ktor-server-websockets`          | WebSocket em tempo real                    | Vai fazer chat, push, etc                |
| `ktor-server-html-builder`        | Renderizar HTML com Kotlin DSL             | Vai servir páginas HTML direto           |
| `ktor-server-openapi` ou `ktor-server-swagger` | Documentação automática          | Quer Swagger UI                          |