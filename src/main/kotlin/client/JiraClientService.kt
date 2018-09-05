package client

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class JiraClientService(baseUrl: String, private val responseListener: (Any?) -> Unit) {
    val service: JiraClient

    init {
        val client = OkHttpClient.Builder()
                .addInterceptor(BasicAuthInterceptor("", ""))
                .build()
        val gson = Gson()
        val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        service = retrofit.create(JiraClient::class.java)
    }

    fun fetchTickets(jql: String) {
        val call = service.fetchTickets(jql)
        println(call.request())
        call.enqueue(object : Callback<Any> {
            override fun onFailure(call: Call<Any>, t: Throwable) {
                println("error: ${t.localizedMessage}")
            }

            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                println("success: ${response.message()}")
                if (response.isSuccessful) {
                    responseListener(response.body())
                } else {
                    responseListener(response.errorBody().string())
                }
            }
        })
    }
}
