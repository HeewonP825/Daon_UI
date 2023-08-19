package com.daon.daon_ui.ui.allMeeting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.daon.daon_ui.databinding.FragmentAllMeetingBinding

class AllMeetingFragment : Fragment() {

    private var _binding: FragmentAllMeetingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(AllMeetingViewModel::class.java)

        _binding = FragmentAllMeetingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAllMeeting
        dashboardViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}