package com.danamon.test.ui.home.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.danamon.core.extension.loadImage
import com.danamon.domain.model.HomeData
import com.danamon.test.databinding.ItemHomeBinding

class HomeAdapter() : ListAdapter<HomeData, HomeAdapter.ViewHolder>(HomeDiffCallBack) {
    object HomeDiffCallBack : DiffUtil.ItemCallback<HomeData>() {
        override fun areItemsTheSame(oldItem: HomeData, newItem: HomeData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: HomeData, newItem: HomeData): Boolean =
            oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.ViewHolder {
        return ViewHolder(
            ItemHomeBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeAdapter.ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class ViewHolder(val binding: ItemHomeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: HomeData) {
            binding.apply {
                titleTv.text = data.title
                imageIv.loadImage(data.thumbnailUrl)
            }
        }
    }
}
