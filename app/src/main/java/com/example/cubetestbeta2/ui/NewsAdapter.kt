package com.example.cubetestbeta2.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cubetestbeta2.databinding.ItemNewsBinding
import com.example.cubetestbeta2.vo.news.News
import kotlin.math.min

/**
 * - 首頁顯示三筆
 */
class NewsAdapter(
    val news: List<News>,
    val showItems: Int = news.size
) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(news: News) {
            binding.tvTitle.text = news.title
            binding.tvContent.text = news.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = min(showItems, news.size)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news = news[position])
    }
    companion object {
        // 首頁最多三筆
        const val HOME_COUNT = 3
    }
}