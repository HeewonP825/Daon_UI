package com.daon.daon_ui.ui.allMeeting

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentAddNewMeetingBinding
import com.daon.daon_ui.databinding.FragmentAllMeetingBinding
import com.daon.daon_ui.ui.home.MeetingAdapter

class AddNewMeetingFragment : Fragment() {

    private var _binding: FragmentAddNewMeetingBinding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddNewMeetingBinding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val textView1: TextView = binding.addMeetingName
        val editText1: EditText = binding.editText
        applyScaleAnimation(textView1, editText1)

        val textView2: TextView = binding.addMeetingCategory
        val editText2: EditText = binding.editText2
        applyScaleAnimation(textView2, editText2)

        val textView3: TextView = binding.addMeetingPhoto
        val editText3: EditText = binding.editText3
        applyScaleAnimation(textView3, editText3)

        val textView4: TextView = binding.addMeetingCordinator
        val editText4: EditText = binding.editText4
        applyScaleAnimation(textView4, editText4)

        val textView5: TextView = binding.addMeetingLimit
        val editText5: EditText = binding.editText5
        applyScaleAnimation(textView5, editText5)

        val textView6: TextView = binding.addMeetingAddress
        val editText6: EditText = binding.editText6
        applyScaleAnimation(textView6, editText6)

        val textView7: TextView = binding.addMeetingDate
        val editText7: EditText = binding.editText7
        applyScaleAnimation(textView7, editText7)

        val textView8: TextView = binding.addMeetingLocationName
        val editText8: EditText = binding.editText8
        applyScaleAnimation(textView8, editText8)

        val textView9: TextView = binding.addMeetingCost
        val editText9: EditText = binding.editText9
        applyScaleAnimation(textView9, editText9)

        val textView10: TextView = binding.addMeetingHelp
        val editText10: EditText = binding.editText10
        applyScaleAnimation(textView10, editText10)

        binding.toolbarBackbtn.setOnClickListener {
            navController.navigateUp()

            val toolbar = (requireActivity() as MainActivity).binding.toolbar
            toolbar.visibility = View.VISIBLE

            val bottomMenu = (requireActivity() as MainActivity).binding.navView
            bottomMenu.visibility = View.VISIBLE

        }

        binding.submitBtn.setOnClickListener {
            showSuccessDialog()
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

    private fun showSuccessDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("새 모임 등록 성공")  // 제목 설정
        builder.setMessage("작성하신 새 모임 등록이 성공적으로 완\n료되었습니다.")  // 메시지 설정

        builder.setPositiveButton("닫기") { dialog: DialogInterface, which: Int ->
            // "닫기" 버튼 클릭 시 실행할 동작을 여기에 추가
            dialog.dismiss()  // 다이얼로그 닫기
            navController.navigateUp()

            val mainActivity = requireActivity() as MainActivity
            mainActivity.showBottomNavigation()
            mainActivity.showToolbar()
        }

        val dialog = builder.create()
        dialog.show()

    }

}