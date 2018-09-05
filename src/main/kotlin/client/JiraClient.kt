package client

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface JiraClient {

    @GET("rest/api/2/search")
    fun fetchTickets(@Query("jql") jql: String): Call<Any>
}