package id.alifyasa.pbiproject.newsapi

data class NewsAPIResponse(val articles: List<Article>)
data class Article(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String
)
