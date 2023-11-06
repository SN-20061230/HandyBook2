package com.example.handybook2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.handybook2.R
import com.example.handybook2.databinding.FragmentAccountBinding
import com.example.handybook2.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding= FragmentSettingsBinding.inflate(inflater, container, false)


        binding.orqaga.setOnClickListener{
            findNavController().navigate(R.id.accountFragment)
        }
        return binding.root
    }


}