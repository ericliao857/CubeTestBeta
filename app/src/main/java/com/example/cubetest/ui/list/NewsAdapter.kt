package com.example.cubetest.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cubetest.databinding.ItemNewsBinding
import com.example.cubetest.vo.news.News
import kotlin.math.min

/**
 * - 首頁顯示三筆
 */
class NewsAdapter(
    val news: List<News>,
    val showItems: Int = news.size,
    val onItemClick: (news: News) -> Unit
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
        holder.itemView.setOnClickListener {
            onItemClick(news[position])
        }
    }

    companion object {
        // 首頁最多三筆
        const val HOME_COUNT = 3
    }
}