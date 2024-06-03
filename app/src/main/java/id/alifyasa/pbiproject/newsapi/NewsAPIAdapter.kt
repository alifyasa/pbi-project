package id.alifyasa.pbiproject.newsapi

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import id.alifyasa.pbiproject.databinding.ArticleItemBinding


class NewsAPIAdapter(private val articles: List<Article>) :
    RecyclerView.Adapter<NewsAPIAdapter.ArticleViewHolder>() {

    class ArticleViewHolder(private val binding: ArticleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {

            Glide
                .with(binding.imageView.context)
                .load(article.urlToImage)
                .placeholder(android.R.drawable.progress_indeterminate_horizontal)
                .into(binding.imageView)

            binding.titleTextView.text = article.title
            binding.descriptionTextView.text = article.description
            binding.imageView.contentDescription = article.title
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