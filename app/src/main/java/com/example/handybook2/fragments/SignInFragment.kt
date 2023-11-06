package com.example.handybook2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.handybook2.R
import com.example.handybook2.databinding.FragmentSignInBinding


class SignInFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentSignInBinding.inflate(inflater, container, false)


        binding.signInBtn.setOnClickListener({
            findNavController().navigate(R.id.action_signInFragment_to_mainFragment)
        })

        return binding.root
    }


}