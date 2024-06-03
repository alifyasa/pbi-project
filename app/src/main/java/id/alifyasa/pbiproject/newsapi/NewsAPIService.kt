package id.alifyasa.pbiproject.newsapi

import retrofit2.Call
import retrofit2.http.GET

interface NewsAPIService {
    @GET("v2/top-headlines?country=id&apiKey=d57e09942a3e4c9eb3ce0da6c88b0523")
    fun fetchTopHeadlines(): Call<NewsAPIResponse>
}