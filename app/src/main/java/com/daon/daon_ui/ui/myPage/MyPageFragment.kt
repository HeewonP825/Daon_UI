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
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentHomeBinding
import com.daon.daon_ui.databinding.FragmentMyPageBinding
import com.google.android.material.tabs.TabLayout

class MyPageFragment : Fragment() {

    private var _binding: FragmentMyPageBinding? = null

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
        tab1.customView = createTabView("내 피드")
        tabLayout.addTab(tab1)

        val tab2 = tabLayout.newTab()
        tab2.customView = createTabView("내 모임")
        tabLayout.addTab(tab2)

        val tab3 = tabLayout.newTab()
        tab3.customView = createTabView("내 후기")
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
                textView?.typeface = Typeface.DEFAULT // 선택된 탭의 폰트를 굵게 변경
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
                // 선택된 탭을 다시 선택했을 때의 동작
            }
        })

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
}