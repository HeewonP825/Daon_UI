package com.daon.daon_ui.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.databinding.ItemMeetingBinding
import com.daon.daon_ui.databinding.ItemMypageMeetingBinding

class MypgMeetingAdapter(private val meetings: List<MypgMeeting>) : RecyclerView.Adapter<MypgMeetingAdapter.MypgMeetingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MypgMeetingViewHolder {
        val binding = ItemMypageMeetingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MypgMeetingViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MypgMeetingViewHolder, position: Int) {
        val mypgMeeting = meetings[position]
        holder.bind(mypgMeeting)
    }

    override fun getItemCount(): Int = meetings.size

    inner class MypgMeetingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding: ItemMeetingBinding = ItemMeetingBinding.bind(itemView)

        fun bind(meeting: MypgMeeting) {
            binding.meetingThumbnail.setImageResource(meeting.meetingImg) // 이미지 동적으로 설정
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