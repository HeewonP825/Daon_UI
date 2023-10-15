package com.daon.daon_ui.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentAddNewMeetingBinding
import com.daon.daon_ui.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val barColor = ContextCompat.getColor(requireContext(), R.color.white)

        with(requireActivity().window) {
            statusBarColor = barColor
        }

        val windowInsetsController = ViewCompat.getWindowInsetsController(requireActivity().window.decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true

        val mainActivity = requireActivity() as MainActivity
        mainActivity.hideBottomNavigation()
        mainActivity.hideToolbar()

        binding.loginBtn.setOnClickListener {
            navController.navigate(R.id.action_LoginFragment_to_HomeFragment)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.showBottomNavigation()
            mainActivity.showToolbar()
        }

        binding.lostPassword.setOnClickListener {
            navController.navigate(R.id.action_LoginFragment_to_LostPassWordFragment)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.hideBottomNavigation()
            mainActivity.hideToolbar()
        }

        binding.joinBtn.setOnClickListener {
            navController.navigate(R.id.action_LoginFragment_to_JoinFragment1)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.hideBottomNavigation()
            mainActivity.hideToolbar()
        }

        val root: View = binding.root

        return root

    }

}