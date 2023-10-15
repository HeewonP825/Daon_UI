package com.daon.daon_ui.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.daon.daon_ui.MainActivity
import com.daon.daon_ui.R
import com.daon.daon_ui.databinding.FragmentLoginBinding
import com.daon.daon_ui.databinding.FragmentLostPassWordBinding

class LostPassWordFragment : Fragment() {
    private var _binding: FragmentLostPassWordBinding? = null

    private lateinit var navController: NavController

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLostPassWordBinding.inflate(inflater, container, false)

        // navController 초기화
        navController = findNavController()

        val mainActivity = requireActivity() as MainActivity
        mainActivity.hideBottomNavigation()
        mainActivity.hideToolbar()

        binding.submitBtn.setOnClickListener {
            navController.navigate(R.id.action_LostPassWordFragment_to_HomeFragment)

            val mainActivity = requireActivity() as MainActivity
            mainActivity.showBottomNavigation()
            mainActivity.showToolbar()
        }


        val root: View = binding.root

        return root

    }

}