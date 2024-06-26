package com.example.cubetest.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cubetest.databinding.ItemAttractionBinding
import com.example.cubetest.vo.attraction.Attraction

/**
 * 旅遊景點列表
 */
class AttractionAdapter(
    private val attractions: List<Attraction>,
    private val onItemClick: (attraction: Attraction) -> Unit
) : RecyclerView.Adapter<AttractionAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding: ItemAttractionBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(attraction: Attraction, onItemClick: (attraction: Attraction) -> Unit) {
            if (!attraction.images.isNullOrEmpty()) {
                Glide.with(binding.root).load(attraction.images.first().src)
                    .into(binding.ivAttraction)
            }
            binding.tvTitle.text = attraction.name
            binding.tvContent.text = attraction.introduction
            itemView.setOnClickListener {
                onItemClick(attraction)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemAttractionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = attractions.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(attraction = attractions[position], onItemClick = onItemClick)
    }
}