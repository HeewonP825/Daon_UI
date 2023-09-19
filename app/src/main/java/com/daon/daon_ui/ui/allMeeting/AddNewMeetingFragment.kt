package com.daon.daon_ui.ui.allMeeting

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
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

        binding.toolbarBackbtn.setOnClickListener {
            navController.navigateUp()

        }

        val root: View = binding.root

        return root
    }

}