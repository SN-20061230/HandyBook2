package com.example.handybook2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handybook2.R
import com.example.handybook2.adapters.BookAdapter
import com.example.handybook2.adapters.GenreAdapter
import com.example.handybook2.books.BookApi
import com.example.handybook2.databinding.FragmentAccountBinding
import com.example.handybook2.databinding.FragmentHomeBinding
import com.example.handybook2.model.Book
import com.example.handybook2.model.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class AccountFragment : Fragment() {
    lateinit var binding: FragmentAccountBinding
    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)

        val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()

        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }




        var booksJson = shared.getString("books", null)
        books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)


        setMainDefaultRvUI()



        binding.textView25.setOnClickListener{
            findNavController().navigate(R.id.barchasiFragment)
        }


        binding.imageView3.setOnClickListener{
            findNavController().navigate(R.id.settingsFragment)
        }

        binding.imageView2.setOnClickListener{
            findNavController().navigate(R.id.mainFragment)
        }




        return binding.root
    }





    private fun setMainDefaultRvUI() {
        binding.accountRecycler.adapter =
            BookAdapter(books, R.layout.book_item3, requireContext())
        binding.accountRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }




}

