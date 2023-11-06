package com.example.handybook2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handybook2.R
import com.example.handybook2.adapters.BookAdapter
import com.example.handybook2.adapters.GenreAdapter
import com.example.handybook2.books.BookApi
import com.example.handybook2.databinding.FragmentHomeBinding
import com.example.handybook2.databinding.FragmentSearchBinding
import com.example.handybook2.model.Book
import com.example.handybook2.model.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SearchFragment : Fragment() {
    lateinit var binding: FragmentSearchBinding
    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)

        val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()

        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }




        var booksJson = shared.getString("books", null)
        books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)


        setMainDefaultRvUI()


        binding.accountImage.setOnClickListener{
            findNavController().navigate(R.id.accountFragment)
        }




        return binding.root
    }

    private fun getGenres(): ArrayList<Genre> {
        var genres = ArrayList<Genre>()
        genres.add(Genre("Comedy", R.drawable.comedy))
        genres.add(Genre("Action", R.drawable.action12))
        genres.add(Genre("Adventure", R.drawable.adventure))
        genres.add(Genre("Drama", R.drawable.drama2))
        return genres
    }



    private fun setMainDefaultRvUI() {
        binding.qidiruvlar.adapter =
            BookAdapter(books, R.layout.book_item, requireContext())
        binding.qidiruvlar.layoutManager =
            GridLayoutManager(context, 2)
    }





}