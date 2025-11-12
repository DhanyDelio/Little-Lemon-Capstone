package com.example.littlelemon.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.statement.bodyAsText
import io.ktor.serialization.kotlinx.json.*

@Serializable
data class MenuItem(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val image: String,
    val category: String

)

@Serializable
data class MenuResponse(
    val menu: List<MenuItem>
)

object Network {
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true })
        }
    }
    var cachedMenu: List<MenuItem> = emptyList()

    suspend fun fetchMenu(): MenuResponse {
        val url = "https://raw.githubusercontent.com/Meta-Mobile-Developer-PC/Working-With-Data-API/main/menu.json"
        val jsonString = client.get(url).bodyAsText()
        val response = Json.decodeFromString<MenuResponse>(jsonString)
        cachedMenu = response.menu
        return response
    }

}





