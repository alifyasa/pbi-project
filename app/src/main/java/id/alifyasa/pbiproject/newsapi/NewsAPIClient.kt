package id.alifyasa.pbiproject.newsapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NewsAPIClient {
    private const val BASE_URL = "https://newsapi.org/"

    val instance: NewsAPIService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(NewsAPIService::class.java)
    }
}