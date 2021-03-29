package app.devpedrocarvalho.coroutinesflowwithretrofit.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiService {

    private fun initRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://evilinsult.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    var service: InsultsApi = initRetrofit().create(InsultsApi::class.java)
}