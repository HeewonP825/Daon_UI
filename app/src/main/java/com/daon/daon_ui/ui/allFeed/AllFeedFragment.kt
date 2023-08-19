package com.daon.daon_ui.ui.allFeed

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.daon.daon_ui.databinding.FragmentAllFeedBinding

class AllFeedFragment : Fragment() {

    private var _binding: FragmentAllFeedBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(AllFeedViewModel::class.java)

        _binding = FragmentAllFeedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAllFeed
        notificationsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}