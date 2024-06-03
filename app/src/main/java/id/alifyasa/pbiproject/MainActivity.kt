package id.alifyasa.pbiproject

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.alifyasa.pbiproject.newsapi.NewsAPIAdapter
import id.alifyasa.pbiproject.newsapi.NewsAPIViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: NewsAPIViewModel
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerView = findViewById(R.id.newsRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this)[NewsAPIViewModel::class.java]

        viewModel.articles.observe(this) { articles ->
            recyclerView.adapter = NewsAPIAdapter(articles)
        }

        viewModel.fetchTopHeadlines()
    }
}