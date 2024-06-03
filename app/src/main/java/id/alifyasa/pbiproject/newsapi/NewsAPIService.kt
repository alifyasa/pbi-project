package id.alifyasa.pbiproject.newsapi

import retrofit2.Call
import retrofit2.http.GET

interface NewsAPIService {
    @GET("v2/top-headlines?country=us&apiKey=YOUR_API_KEY")
    fun fetchTopHeadlines(): Call<NewsAPIResponse>
}