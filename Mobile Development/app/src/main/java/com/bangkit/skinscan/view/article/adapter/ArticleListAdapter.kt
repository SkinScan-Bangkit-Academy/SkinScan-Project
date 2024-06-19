package com.bangkit.skinscan.view.article.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bangkit.skinscan.data.remote.response.Article
import com.bangkit.skinscan.databinding.ActivityDetailArticleBinding
import com.bumptech.glide.Glide

class ArticleListAdapter : PagingDataAdapter<Article, ArticleListAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(private val binding: ActivityDetailArticleBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Article){
            Glide.with(binding.imgView.context)
                .load(data.image)
                .into(binding.imgView)
            binding.title.text = data.title
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = getItem(position)
        if (data != null){
            holder.bind(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ActivityDetailArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
                return oldItem.title == newItem.title
            }
        }
    }
}