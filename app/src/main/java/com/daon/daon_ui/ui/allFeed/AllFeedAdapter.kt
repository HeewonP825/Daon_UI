package com.daon.daon_ui.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daon.daon_ui.R
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.databinding.ItemFeedBinding
import com.daon.daon_ui.databinding.ItemMeetingBinding
import com.daon.daon_ui.ui.allFeed.AllFeed

class AllFeedAdapter(private val allFeeds: List<AllFeed>) : RecyclerView.Adapter<AllFeedAdapter.AllFeedViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllFeedViewHolder {
        val binding = ItemFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AllFeedViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: AllFeedViewHolder, position: Int) {
        val allfeed = allFeeds[position]
        holder.bind(allfeed)
    }

    override fun getItemCount(): Int = allFeeds.size

    inner class AllFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemFeedBinding = ItemFeedBinding.bind(itemView)

        fun bind(allfeed: AllFeed) {
            binding.allfeedProfileImg.setImageResource(allfeed.allfeedProfileImg) // 이미지 동적으로 설정
            binding.allfeedNickname.text = allfeed.allfeedNickmane
            binding.allfeedIntroduce.text = allfeed.allfeedIntroduce
            binding.allfeedLike.setImageResource(allfeed.allfeedLike)
            binding.allfeedMore.setImageResource(allfeed.allfeedMore)
            binding.allfeedImg.setImageResource(allfeed.allfeedImg)
            binding.allfeedContext.text = allfeed.allfeedContext
            binding.allfeedTag.text = allfeed.allfeedTag

        }
    }
}