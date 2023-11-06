package com.example.handybook2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.handybook2.R
import com.example.handybook2.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentWelcomeBinding.inflate(inflater, container, false)

        binding.alreadyBtn.setOnClickListener({
            findNavController().navigate(R.id.action_welcomeFragment_to_signInFragment)
        })

        binding.getStartedBtn.setOnClickListener({
            findNavController().navigate(R.id.action_welcomeFragment_to_signUpFragment)
        })
        return binding.root   }


}