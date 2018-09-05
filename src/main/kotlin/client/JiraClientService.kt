package client

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async
import retrofit2.Response
import retrofit2.Retrofit



class JiraClientService(private val baseUrl: String) {
    val service : JiraClient
    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .build()

        service = retrofit.create(JiraClient::class.java)
    }

    fun fetchTickets(jql: String): Response<Any>? {
        return  service.fetchTickets(jql).execute()
    }
}
