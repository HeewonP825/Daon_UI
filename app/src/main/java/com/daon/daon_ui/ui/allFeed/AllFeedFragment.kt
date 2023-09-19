package com.daon.daon_ui.ui.allFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentAllFeedBinding
import com.daon.daon_ui.ui.home.AllFeedAdapter
import com.daon.daon_ui.ui.home.Meeting
import com.daon.daon_ui.ui.home.MeetingAdapter

class AllFeedFragment : Fragment() {

    private var _binding: FragmentAllFeedBinding? = null

    private lateinit var allfeedAdapter: AllFeedAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(AllFeedViewModel::class.java)

        _binding = FragmentAllFeedBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textAllFeed
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        // RecyclerView 초기화
        allfeedAdapter = AllFeedAdapter(getSampleMeetings()) // 여러 항목을 가진 데이터 리스트 전달
        binding.allfeedRv.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = allfeedAdapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // 샘플 데이터 리스트 생성
    private fun getSampleMeetings(): List<AllFeed> {

        val profileImg = resources.getIdentifier("feed_profile_Img", "drawable", requireContext().packageName)
        val feedImg1 = resources.getIdentifier("allfeed_img1", "drawable", requireContext().packageName)
        val feedImg2 = resources.getIdentifier("allfeed_img2", "drawable", requireContext().packageName)
        val likeButton = resources.getIdentifier("ic_allfeed_like_btn", "drawable", requireContext().packageName)
        val moreButton = resources.getIdentifier("ic_allfeed_more", "drawable", requireContext().packageName)

        return listOf(
//            AllFeed(profileImg, "해맑은 유미", "한줄소개글 표시..", likeButton, moreButton, feedImgetc,
//                "Feugiat in feugiat mauris malesuada quis est\n sodales adipiscing.\n" +
//                        "Tellus tincidunt Odio ultrices\n nibh sed accumsan. In donec felis sagittis tempus.\n" +
//                        "Elit, enim, et arcu at ultrices cursus arcu dictum\n purus...", "@양욱진 첼로 리사이클링 공연"),

            AllFeed("해맑은 유미", "한줄소개글 표시..", false, feedImg1,
                "Feugiat in feugiat mauris malesuada quis est\n sodales adipiscing.\n" +
                        "Tellus tincidunt Odio ultrices\n nibh sed accumsan. In donec felis sagittis tempus.\n" +
                        "Elit, enim, et arcu at ultrices cursus arcu dictum\n purus...", "@양욱진 첼로 리사이클링 공연"),

            AllFeed("강산들", "한줄소개글 표시..", true, feedImg1,
                "Feugiat in feugiat mauris malesuada quis est\n sodales adipiscing.\n" +
                        "Tellus tincidunt Odio ultrices\n nibh sed accumsan. In donec felis sagittis tempus.\n" +
                        "Elit, enim, et arcu at ultrices cursus arcu dictum\n purus...", "@발달장애인 체육대회"),

            AllFeed("해맑은 유미", "한줄소개글 표시..", false, feedImg2,
                "Feugiat in feugiat mauris malesuada quis est\n sodales adipiscing.\n" +
                        "Tellus tincidunt Odio ultrices\n nibh sed accumsan. In donec felis sagittis tempus.\n" +
                        "Elit, enim, et arcu at ultrices cursus arcu dictum\n purus...", "@마음으로 그리는 그림 교실"),

            // 추가적인 항목들을 원하는 만큼 추가
        )
    }

}