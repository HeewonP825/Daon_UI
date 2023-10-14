package com.daon.daon_ui.ui.myPage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentEditMyPageBinding

class EditMyPageFragment : Fragment() {

    private var _binding: FragmentEditMyPageBinding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditMyPageBinding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        binding.toolbarBackbtn.setOnClickListener {
            navController.navigateUp()

            val toolbar = (requireActivity() as MainActivity).binding.toolbar
            toolbar.visibility = View.VISIBLE

            val bottomMenu = (requireActivity() as MainActivity).binding.navView
            bottomMenu.visibility = View.VISIBLE

        }

        val root: View = binding.root

        return root
    }

}