package com.daon.daon_ui.ui.home

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.databinding.FragmentHomeBinding
import com.daon.daon_ui.databinding.ItemMeetingBinding
import com.daon.daon_ui.ui.allMeeting.AllMeetingFragmentDirections
import com.daon.daon_ui.ui.allMeeting.MeetingDetailFragment

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

        val navController = findNavController()

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // RecyclerView 초기화
        meetingAdapter = MeetingAdapter(getSampleMeetings()) { selectedMeeting ->
            // 클릭 시 동작할 내용을 여기에 구현
            val bundle = Bundle()
            bundle.putSerializable("selectedMeeting", selectedMeeting)
            val meetingDetailFragment = MeetingDetailFragment()
            meetingDetailFragment.arguments = bundle
            navController.navigate(HomeFragmentDirections.actionHomeFragmentToMeetingDetailFragment())

            val toolbar = (requireActivity() as MainActivity).binding.toolbar
            toolbar.visibility = View.GONE

            val bottomMenu = (requireActivity() as MainActivity).binding.navView
            bottomMenu.visibility = View.GONE
        }

        binding.homeMeetingRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = meetingAdapter
        }

        // Spinner 1 설정
        val spinner1 = binding.sortCondition1Spinner
        val sortCondition1Options = arrayOf("전체", "Option 2", "Option 3")
        val spinnerAdapter1 = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, sortCondition1Options)
        spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner1.adapter = spinnerAdapter1

        // Spinner 2 설정
        val spinner2 = binding.sortCondition2Spinner
        val sortCondition2Options = arrayOf("날짜순", "Option B", "Option C")
        val spinnerAdapter2 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, sortCondition2Options)
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


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // 샘플 데이터 리스트 생성
    private fun getSampleMeetings(): List<Meeting> {

        val resourceId1 = resources.getIdentifier("meeting_sample1", "drawable", requireContext().packageName)
        val resourceId2 = resources.getIdentifier("meeting_sample2", "drawable", requireContext().packageName)
        val resourceId3 = resources.getIdentifier("meeting_sample3", "drawable", requireContext().packageName)

        return listOf(
            Meeting(resourceId1, "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\n에 초대합니다. 사랑 가득한 선율을 마음껏\n느낄...",
                "10", "32,000", "16,000"),
            Meeting(resourceId2, "대구 수성", "2023-06-07", "10:30",
                "시각·발달·청각·지체", "여가유형", "양욱진 첼로 리사이클링 공연", "양욱진 첼로리스트의 리사이클링 공연을 함\n께 관람해요. 잔잔한 선율과 굵은 소리로 아\n름...",
                "9", "28,600", "14,200"),
            Meeting(resourceId3, "대구 수성", "2023-06-07", "10:30",
                "시각", "음악", "생명 사랑 음악회", "시각장애인 5인조 밴드의 악보 없는 음악회\n에 초대합니다. 사랑 가득한 선율을 마음껏\n느낄...",
                "10", "32,000", "16,000")
            // 추가적인 항목들을 원하는 만큼 추가
        )
    }

}