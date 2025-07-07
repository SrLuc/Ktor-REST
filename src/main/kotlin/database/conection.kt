package com.example.database
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabaseConection() {
   try {
        Database.connect(
            url = "jdbc:postgresql://localhost:5432/ktor_db",
            driver = "org.postgresql.Driver",
            user = "naur",
            password = "root"
        )
        println("✅ Banco PostgreSQL conectado com sucesso!")
    }catch (e:Exception){
       println("🚨 Falha ao conectar no banco: ${e.message}")

   }
}