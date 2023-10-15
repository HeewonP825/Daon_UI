package com.daon.daon_ui.ui.join

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentJoin1Binding
import com.daon.daon_ui.databinding.FragmentJoin2Binding

class JoinFragment2 : Fragment() {
    private var _binding: FragmentJoin2Binding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJoin2Binding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val barColor = ContextCompat.getColor(requireContext(), R.color.toolbar_sub_color)

        with(requireActivity().window) {
            statusBarColor = barColor
        }

        val windowInsetsController = ViewCompat.getWindowInsetsController(requireActivity().window.decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true

        val myEditText: EditText = binding.editText11
        val myButton: Button = binding.submitBtn

        myEditText.addTextChangedListener(object : TextWatcher {
            @SuppressLint("ResourceAsColor")
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // 텍스트 변경 전에 실행되는 코드
                myButton.setBackgroundColor(R.color.tabbar_title)
            }

            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // 텍스트가 변경될 때 실행되는 코드
                val text = s.toString()

                // 원하는 조건에 따라 버튼 색상 변경
                if (text.isNullOrEmpty()) {
                    myButton.setBackgroundColor(R.color.tabbar_title) // 버튼을 비활성 상태로 설정
                } else {
                    myButton.setBackgroundColor(R.color.mainColor) // 버튼을 활성 상태로 설정
                    myButton.isClickable // 버튼 활성화
                }
            }

            override fun afterTextChanged(s: Editable?) {
                // 텍스트 변경 후에 실행되는 코드
            }
        })

        binding.submitBtn.setOnClickListener {

            val dialogView = LayoutInflater.from(context).inflate(R.layout.join_phone_num_alert, null)

            val builder = AlertDialog.Builder(context)
            builder.setView(dialogView)

            val alertDialog = builder.create()
            alertDialog.show()

            val customButton = dialogView.findViewById<Button>(R.id.close_btn)
            customButton.setOnClickListener {
                alertDialog.dismiss() // 다이얼로그를 닫습니다.

                binding.submitBtn.visibility = View.GONE
                binding.nextBtn.visibility = View.VISIBLE

                val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_new_meeting_checkcircle_filled)
                if (drawable != null) {
                    drawable.setBounds(0, 0, drawable.intrinsicWidth, drawable.intrinsicHeight)
                } // 조절 가능한 범위
                binding.editText11.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null)
                binding.sendAgain.visibility = View.VISIBLE

                val mainActivity = requireActivity() as MainActivity
                mainActivity.hideBottomNavigation()
                mainActivity.hideToolbar()
            }

        }

        val root: View = binding.root

        return root

    }

}