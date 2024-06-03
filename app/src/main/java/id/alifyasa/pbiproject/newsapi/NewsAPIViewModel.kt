package id.alifyasa.pbiproject.newsapi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsAPIViewModel : ViewModel() {
    private val _articles = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> = _articles

    init {
        fetchTopHeadlines()
    }

    private fun fetchTopHeadlines() {
        NewsAPIClient.instance.fetchTopHeadlines().enqueue(object : Callback<NewsAPIResponse> {
            override fun onResponse(
                call: Call<NewsAPIResponse>,
                response: Response<NewsAPIResponse>
            ) {
                if (response.isSuccessful) {
                    _articles.value = response.body()?.articles
                } else {
                    // Handle error
                }
            }

            override fun onFailure(call: Call<NewsAPIResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }
}