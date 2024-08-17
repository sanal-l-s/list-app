package com.example.listapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.listapp.databinding.ItemImageBinding

class ImageViewPagerAdapter(private val imageUrlList: List<Int>) :
    RecyclerView.Adapter<ImageViewPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun getItemCount(): Int = imageUrlList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding = ItemImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.imageView.setImageResource(imageUrlList[position])
    }

}