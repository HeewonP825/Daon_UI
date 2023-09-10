package com.daon.daon_ui.ui.myPage

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentHomeBinding
import com.daon.daon_ui.databinding.FragmentMyPageBinding
import com.daon.daon_ui.ui.home.Meeting
import com.daon.daon_ui.ui.home.MeetingAdapter
import com.daon.daon_ui.ui.home.MypgMeeting
import com.daon.daon_ui.ui.home.MypgMeetingAdapter
import com.google.android.material.tabs.TabLayout

class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null

    private lateinit var mypgMeeetingAdapter: MypgMeetingAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(MyPageViewModel::class.java)

        _binding = FragmentMyPageBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textMyPage
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val tabLayout = root.findViewById<TabLayout>(R.id.tabLayout)

        val tab1 = tabLayout.newTab()
        tab1.customView = createTabView("    내 피드   ")
        tabLayout.addTab(tab1)

        val tab2 = tabLayout.newTab()
        tab2.customView = createTabView("    내 모임   ")
        tabLayout.addTab(tab2)

        val tab3 = tabLayout.newTab()
        tab3.customView = createTabView("    내 후기   ")
        tabLayout.addTab(tab3)

        tabLayout.selectTab(tab1)

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val customView = tab.customView
                val textView = customView?.findViewById<TextView>(R.id.tabText)

                textView?.setTextColor(ContextCompat.getColor(requireActivity(), R.color.mainColor))
                textView?.typeface = Typeface.DEFAULT_BOLD // 선택된 탭의 폰트를 굵게 변경
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val customView = tab.customView
                val textView = customView?.findViewById<TextView>(R.id.tabText)

                textView?.setTextColor(ContextCompat.getColor(requireActivity(), R.color.tabbar_title))
                textView?.typeface = Typeface.DEFAULT // 선택된 탭의 폰트를 원래대로 변경
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // 선택된 탭을 다시 선택했을 때의 동작
            }
        })
//
//        val tabLayout1 = root.findViewById<TabLayout>(R.id.tabLayout1)
//
//        val taba = tabLayout.newTab()
//        taba.customView = createTabView("    내 피드   ")
//        tabLayout1.addTab(taba)
//
//        val tabb = tabLayout.newTab()
//        tabb.customView = createTabView("    내 모임   ")
//        tabLayout1.addTab(tabb)
//
//        tabLayout1.selectTab(taba)

        // RecyclerView 초기화
        mypgMeeetingAdapter = MypgMeetingAdapter(getSampleMeetings()) // 여러 항목을 가진 데이터 리스트 전달
        binding.mypgMeetingRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = mypgMeeetingAdapter
        }

        return root
    }

    @SuppressLint("MissingInflatedId")
    private fun createTabView(text: String): View {
        val tabView = layoutInflater.inflate(R.layout.custom_tab_layout_mypg, null)

        val textView = tabView.findViewById<TextView>(R.id.tabText)

        textView.text = text

        return tabView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSampleMeetings(): List<MypgMeeting> {

        val resourceId1 = resources.getIdentifier("meeting_sample1", "drawable", requireContext().packageName)
        val resourceId2 = resources.getIdentifier("meeting_sample2", "drawable", requireContext().packageName)
        val resourceId3 = resources.getIdentifier("meeting_sample3", "drawable", requireContext().packageName)

        return listOf(
            MypgMeeting(resourceId1, "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\\n에 초대합니다. 사랑 가득한 선율을 마음껏\\n 느낄...",
                "10", "32,000", "16,000", "2023년 6월 8일", "예정"),
            MypgMeeting(resourceId2, "대구 수성", "2023-06-07", "10:30",
                "시각·발달·청각·지체", "여가유형", "양욱진 첼로 리사이클링 공연", "양욱진 첼로리스트의 리사이클링 공연을 함\\n께 관람해요. 잔잔한 선율과 굵은 소리로 아\\n름...",
                "9", "28,600", "14,200", "2023년 6월 8일", "평점 3.0 (5건)"),
            MypgMeeting(resourceId3, "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\\n에 초대합니다. 사랑 가득한 선율을 마음껏\\n 느낄...",
                "10", "32,000", "16,000", "2023년 6월 8일", "예정")
            // 추가적인 항목들을 원하는 만큼 추가
        )
    }
}