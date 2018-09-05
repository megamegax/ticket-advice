package client

import retrofit2.Call
import retrofit2.http.GET

interface JiraClient {
    @GET("rest/api/2/search")
    fun fetchTickets(jql: String): Call<Any>
}