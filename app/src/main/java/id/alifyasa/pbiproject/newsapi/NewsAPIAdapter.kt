package id.alifyasa.pbiproject.newsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.alifyasa.pbiproject.databinding.ArticleItemBinding

class NewsAPIAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<NewsAPIAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            binding.titleTextView.text = article.title
            binding.descriptionTextView.text = article.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ArticleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        holder.bind(articles[position])
    }

    override fun getItemCount() = articles.size
}