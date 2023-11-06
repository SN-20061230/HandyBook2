package com.example.handybook2.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.handybook2.R
import com.example.handybook2.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentMainBinding.inflate(inflater, container, false)
        val navigationView = binding.navView
        loadFragment(HomeFragment())

        var navHeader = navigationView.getHeaderView(0)
        navHeader.findViewById<TextView>(R.id.personNamen).text = "Sardor"



        binding.bottomMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.wishlist -> {
                    loadFragment(WishlistFragment())
                    true
                }
                R.id.purchased -> {
                    loadFragment(SavedFragment())
                    true
                }
                R.id.account -> {
                    loadFragment(AccountFragment())
                    true
                }
                else -> {
                    false
                }
            }
        }


        return binding.root
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = requireActivity().supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.commit()
    }
}