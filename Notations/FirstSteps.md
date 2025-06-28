# Comparação: Application.kt e Routing.kt no Ktor vs Node.js com Express

## Application.kt (Ktor)
**Equivale a:**
- `app.js` ou `index.js` no Node.js com Express, onde criamos a instância do servidor e configuramos middleware.
- Arquivo principal do projeto, ponto de entrada como se fosse o index.js.
- Configura o servidor (porta, host).
- Instala plugins (JSON, CORS, logging).
- Registra rotas, chamando funções ou arquivos externos.


## Routing.kt (Ktor)
**Equivale a:**
- Arquivos de rotas em Node.js, como `routes.js` ou pastas `routes/`, onde definimos as rotas com `app.get()`, `app.post()`, etc.
- Arquivo dedicado a definir rotas e endpoints.
- Contém definições de `GET`, `POST`, `PUT`, etc.
- Importado e chamado dentro do `Application.kt`.


## Por que separar?
- Organização do código para facilitar manutenção.
- Mantém o ponto de entrada limpo.
- Facilita escalabilidade conforme o projeto cresce.
