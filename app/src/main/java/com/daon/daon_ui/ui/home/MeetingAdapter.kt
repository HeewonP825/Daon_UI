package com.daon.daon_ui.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.daon.daon_ui.R
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.databinding.ItemMeetingBinding

class MeetingAdapter(private val meetings: List<Meeting>) : RecyclerView.Adapter<MeetingAdapter.MeetingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeetingViewHolder {
        val binding = ItemMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MeetingViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MeetingViewHolder, position: Int) {
        val meeting = meetings[position]
        holder.bind(meeting)
    }

    override fun getItemCount(): Int = meetings.size

    inner class MeetingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemMeetingBinding = ItemMeetingBinding.bind(itemView)

        fun bind(meeting: Meeting) {
            binding.meetingThumbnail.setImageResource(R.drawable.meeting_sample1)
            binding.meetingLocation.text = meeting.meetingLocation
            binding.meetingDate.text = meeting.meetingDate
            binding.meetingTime.text = meeting.meetingTime
            binding.meetingTag1.text = meeting.meetingTag1
            binding.meetingTag2.text = meeting.meetingTag2
            binding.meetingTitle.text = meeting.meetingTitle
            binding.meetingDetail.text = meeting.meetingExplain
            binding.meetingMember.text = meeting.meetingMember
            binding.meetingOriginalPrice.text = meeting.meetingOriginalPrice
            binding.meetingPrice.text = meeting.meetingPrice
        }
    }
}