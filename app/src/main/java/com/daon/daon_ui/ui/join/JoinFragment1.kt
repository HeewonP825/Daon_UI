package com.daon.daon_ui.ui.join

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentJoin1Binding
import com.daon.daon_ui.databinding.FragmentLostPassWordBinding

class JoinFragment1 : Fragment() {
    private var _binding: FragmentJoin1Binding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentJoin1Binding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val barColor = ContextCompat.getColor(requireContext(), R.color.toolbar_sub_color)

        with(requireActivity().window) {
            statusBarColor = barColor
        }

        val windowInsetsController = ViewCompat.getWindowInsetsController(requireActivity().window.decorView)
        windowInsetsController?.isAppearanceLightStatusBars = true

        val root: View = binding.root

        return root

    }

}