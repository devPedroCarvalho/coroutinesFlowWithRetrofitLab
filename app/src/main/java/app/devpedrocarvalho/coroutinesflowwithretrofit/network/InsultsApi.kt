package app.devpedrocarvalho.coroutinesflowwithretrofit.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface InsultsApi {

    @GET("generate_insult.php")
    suspend fun getInsult(
        @Query("lang") lang: String = "en",
        @Query("type") type: String = "json"
    ): Response<InsultResponse>

}