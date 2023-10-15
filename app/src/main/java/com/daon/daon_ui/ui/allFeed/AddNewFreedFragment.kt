package com.daon.daon_ui.ui.allFeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentAddNewFreedBinding
import com.daon.daon_ui.databinding.FragmentEditMyPageBinding

class AddNewFreedFragment : Fragment() {

    private var _binding: FragmentAddNewFreedBinding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewFreedBinding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val textView1: TextView = binding.addFeedName
        val editText1: EditText = binding.editText
        applyScaleAnimation(textView1, editText1)

        val textView2: TextView = binding.addFeedContain
        val editText2: EditText = binding.editText2
        applyScaleAnimation(textView2, editText2)

        val textView3: TextView = binding.addFeedPhoto
        val editText3: EditText = binding.editText3
        applyScaleAnimation(textView3, editText3)

        binding.toolbarBackbtn.setOnClickListener {
            navController.navigateUp()

            val toolbar = (requireActivity() as MainActivity).binding.toolbar
            toolbar.visibility = View.VISIBLE

            val bottomMenu = (requireActivity() as MainActivity).binding.navView
            bottomMenu.visibility = View.VISIBLE

        }

        binding.submitBtn.setOnClickListener {
            navController.navigateUp()

            val mainActivity = requireActivity() as MainActivity
            mainActivity.showBottomNavigation()
            mainActivity.showToolbar()
        }

        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun applyScaleAnimation(view: View, targetView: View) {
        view.setOnClickListener {
            val scaleAnimation = ScaleAnimation(
                1.0f, 0.9f, // X 축 크기 (시작, 끝)
                1.0f, 0.9f, // Y 축 크기 (시작, 끝)
                Animation.RELATIVE_TO_SELF, 0.5f, // 중심점 X
                Animation.RELATIVE_TO_SELF, 0.5f  // 중심점 Y
            )

            scaleAnimation.duration = 200 // 애니메이션 지속 시간 (밀리초)
            scaleAnimation.fillAfter = true // 애니메이션이 끝난 후 원래 크기로 돌아가지 않도록 설정

            // 애니메이션 시작
            view.startAnimation(scaleAnimation)
            targetView.visibility = View.VISIBLE
        }
    }

}