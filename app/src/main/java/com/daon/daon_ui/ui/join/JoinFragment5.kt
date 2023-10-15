package com.daon.daon_ui.ui.join

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
import com.daon.daon_ui.databinding.FragmentJoin3Binding
import com.daon.daon_ui.databinding.FragmentJoin5Binding

class JoinFragment5 : Fragment() {
    private var _binding: FragmentJoin5Binding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJoin5Binding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val mainActivity = requireActivity() as MainActivity
        mainActivity.hideBottomNavigation()
        mainActivity.hideToolbar()

        val barColor = ContextCompat.getColor(requireContext(), R.color.toolbar_sub_color)

        with(requireActivity().window) {
            statusBarColor = barColor
        }

        val windowInsetsController = ViewCompat.getWindowInsetsController(requireActivity().window.decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true

        binding.nextBtn.setOnClickListener {
            navController.navigate(R.id.action_JoinFragment5_to_JoinFragment6)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.hideBottomNavigation()
            mainActivity.hideToolbar()
        }

        binding.skipBtn.setOnClickListener {
            navController.navigate(R.id.action_JoinFragment5_to_HomeFragment)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.showBottomNavigation()
            mainActivity.showToolbar()

            val barColor = ContextCompat.getColor(requireContext(), R.color.white)

            with(requireActivity().window) {
                statusBarColor = barColor
            }

            val windowInsetsController = ViewCompat.getWindowInsetsController(requireActivity().window.decorView)
            windowInsetsController?.isAppearanceLightStatusBars = true
        }

        val root: View = binding.root

        return root

    }

}