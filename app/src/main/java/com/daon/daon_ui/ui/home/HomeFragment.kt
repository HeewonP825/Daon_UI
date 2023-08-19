package com.daon.daon_ui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var meetingAdapter: MeetingAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // RecyclerView 초기화
        meetingAdapter = MeetingAdapter(getSampleMeetings()) // 여러 항목을 가진 데이터 리스트 전달
        binding.homeMeetingRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = meetingAdapter
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // 샘플 데이터 리스트 생성
    private fun getSampleMeetings(): List<Meeting> {
        return listOf(
            Meeting("R.drawable.meeting_sample1", "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\\n에 초대합니다. 사랑 가득한 선율을 마음껏\\n 느낄...",
                "10", "32,000", "16,000"),
            Meeting("R.drawable.meeting_sample1", "대구 수성", "2023-06-07", "10:30",
                "시각·발달·청각·지체", "여가유형", "양욱진 첼로 리사이클링 공연", "양욱진 첼로리스트의 리사이클링 공연을 함\\n께 관람해요. 잔잔한 선율과 굵은 소리로 아\\n름...",
                "9", "28,600", "14,200"),
            Meeting("R.drawable.meeting_sample3", "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\\n에 초대합니다. 사랑 가득한 선율을 마음껏\\n 느낄...",
                "10", "32,000", "16,000")
            // 추가적인 항목들을 원하는 만큼 추가
        )
    }
}