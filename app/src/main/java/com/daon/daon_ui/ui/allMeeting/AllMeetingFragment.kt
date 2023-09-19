package com.daon.daon_ui.ui.allMeeting

import android.annotation.SuppressLint
import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentAllMeetingBinding
import com.daon.daon_ui.ui.home.HomeFragmentDirections
import com.daon.daon_ui.ui.home.Meeting
import com.daon.daon_ui.ui.home.MeetingAdapter
import com.google.android.material.tabs.TabLayout

class AllMeetingFragment : Fragment() {

    private var _binding: FragmentAllMeetingBinding? = null

    private lateinit var meetingAdapter: MeetingAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(AllMeetingViewModel::class.java)

        _binding = FragmentAllMeetingBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textAllMeeting
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // Spinner 1 설정
        val spinner1 = binding.sortCondition1Spinner
        val sortCondition1Options = arrayOf("전체", "Option 2", "Option 3")
        val spinnerAdapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sortCondition1Options)
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = spinnerAdapter1

        // Spinner 2 설정
        val spinner2 = binding.sortCondition2Spinner
        val sortCondition2Options = arrayOf("날짜순", "Option B", "Option C")
        val spinnerAdapter2 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sortCondition2Options)
        spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner2.adapter = spinnerAdapter2

        // Spinner 아이템 선택 리스너
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = sortCondition1Options[position]
                // 선택된 옵션에 따른 동작 수행
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 때의 동작
            }
        }

        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedOption = sortCondition2Options[position]
                // 선택된 옵션에 따른 동작 수행
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // 아무것도 선택되지 않았을 때의 동작
            }
        }

        val navController = findNavController()

        // RecyclerView 초기화
        meetingAdapter = MeetingAdapter(getSampleMeetings()) { selectedMeeting ->
            // 클릭 시 동작할 내용을 여기에 구현
            val bundle = Bundle()
            bundle.putSerializable("selectedMeeting", selectedMeeting)
            val meetingDetailFragment = MeetingDetailFragment()
            meetingDetailFragment.arguments = bundle
            navController.navigate(AllMeetingFragmentDirections.actionAllMeetingFragmentToMeetingDetailFragment())

            val toolbar = (requireActivity() as MainActivity).binding.toolbar
            toolbar.visibility = View.GONE

            val bottomMenu = (requireActivity() as MainActivity).binding.navView
            bottomMenu.visibility = View.GONE
        }

        binding.allMeetingRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = meetingAdapter
        }

        val tabLayout = root.findViewById<TabLayout>(R.id.tabLayout)

        val tab1 = tabLayout.newTab()
        tab1.customView = createTabView("내주변 (48)", R.drawable.ic_all_meeting_location)
        tabLayout.addTab(tab1)

        val tab2 = tabLayout.newTab()
        tab2.customView = createTabView("전국 (32)", R.drawable.ic_all_meeting_location)
        tabLayout.addTab(tab2)

        val tab3 = tabLayout.newTab()
        tab3.customView = createTabView("서울 (13)", R.drawable.ic_all_meeting_location)
        tabLayout.addTab(tab3)

        val tab4 = tabLayout.newTab()
        tab4.customView = createTabView("경기 (9)", R.drawable.ic_all_meeting_location)
        tabLayout.addTab(tab4)

        val tab5 = tabLayout.newTab()
        tab5.customView = createTabView("충청 (4)", R.drawable.ic_all_meeting_location)
        tabLayout.addTab(tab5)

        tabLayout.selectTab(tab1)

        // 아이콘을 숨길 나머지 탭에 대한 로직 추가
        for (i in 1 until tabLayout.tabCount) {
            val tab = tabLayout.getTabAt(i)
            val customView = tab?.customView
            val iconView = customView?.findViewById<ImageView>(R.id.tabIcon)

            iconView?.visibility = View.GONE
        }

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                val customView = tab.customView
                val textView = customView?.findViewById<TextView>(R.id.tabText)
                val iconView = customView?.findViewById<ImageView>(R.id.tabIcon)

                textView?.setTextColor(ContextCompat.getColor(requireActivity(), R.color.mainColor))
                textView?.typeface = Typeface.DEFAULT_BOLD // 선택된 탭의 폰트를 굵게 변경
                iconView?.visibility = View.VISIBLE
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
                val customView = tab.customView
                val iconView = customView?.findViewById<ImageView>(R.id.tabIcon)
                val textView = customView?.findViewById<TextView>(R.id.tabText)

                textView?.setTextColor(ContextCompat.getColor(requireActivity(), R.color.tabbar_title))
                textView?.typeface = Typeface.DEFAULT // 선택된 탭의 폰트를 굵게 변경
                iconView?.visibility = View.GONE
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // 선택된 탭을 다시 선택했을 때의 동작
            }
        })

        return root
    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        val button = view.findViewById<Button>(R.id.dynamic_button)
//
//        button.setOnClickListener {
//            // 새로운 프래그먼트로 이동
//            findNavController().navigate(R.id.action_AllMeetingFragment_to_AddAllMeetingFragment)
//        }
//    }

    @SuppressLint("MissingInflatedId")
    private fun createTabView(text: String, iconResId: Int): View {
        val tabView = layoutInflater.inflate(R.layout.custom_tab_layout_allmeeting, null)

        val textView = tabView.findViewById<TextView>(R.id.tabText)
        val iconView = tabView.findViewById<ImageView>(R.id.tabIcon)

        textView.text = text
        iconView.setImageResource(iconResId)
        iconView.visibility = View.GONE // 처음에는 아이콘을 숨김

        return tabView
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getSampleMeetings(): List<Meeting> {

        val resourceId1 = resources.getIdentifier("all_meeting_img2", "drawable", requireContext().packageName)
        val resourceId2 = resources.getIdentifier("all_meeting_img1", "drawable", requireContext().packageName)
        val resourceId3 = resources.getIdentifier("all_meeting_img3", "drawable", requireContext().packageName)

        return listOf(
            Meeting(resourceId1, "대구 수성", "2023-06-07", "10:30",
                "청각", "미술", "청각 장애인을 위한 웹툰 초급반", "청각장애인을 위해 준비된 웹툰 클래스에 초\n대합니다. 기본 구도를 익히면 웹툰도 어렵\n지...",
                "5", "28,600", "14,200"),
            Meeting(resourceId2, "대구 수성", "2023-06-07", "10:30",
                "전체", "요리", "내 손으로 만드는 빵, 아름드리 베이킹", "다양한 빵들을 직접 만들고 먹을 수 있는 베\n이킹 클래스에 초대합니다. 갓 구운 맛있\n는...",
                "5", "28,600", "14,200"),
            Meeting(resourceId3, "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\n에 초대합니다. 사랑 가득한 선율을 마음껏\n 느낄...",
                "10", "32,000", "16,000")
            // 추가적인 항목들을 원하는 만큼 추가
        )
    }
}