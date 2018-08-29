package client

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.experimental.async

class ClientService(private val baseUrl: String) : Client {
    private val client: HttpClient = HttpClient()

    override fun fetchSprints(): Any {
        return async { client.get<String>("$baseUrl/query") }
    }

    override suspend fun pullTicketsFromSprint(sprintName: String): List<Any> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}