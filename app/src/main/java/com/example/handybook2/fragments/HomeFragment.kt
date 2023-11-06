package com.example.handybook2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handybook2.R
import com.example.handybook2.adapters.BookAdapter
import com.example.handybook2.adapters.GenreAdapter
import com.example.handybook2.books.BookApi
import com.example.handybook2.databinding.FragmentHomeBinding
import com.example.handybook2.model.Book
import com.example.handybook2.model.Genre
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()

        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }




        var booksJson = shared.getString("books", null)
        books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)

        setGenresUi()
        setMainDefaultRvUI()



        changeSavedBooksVisibility()
        changeWishBooksVisibility()


        binding.filter.setOnClickListener{
            findNavController().navigate(R.id.filterFragment)
        }




        return binding.root
    }

    private fun getGenres(): ArrayList<Genre> {
        var genres = ArrayList<Genre>()
        genres.add(Genre("Comedy", R.drawable.comedy))
        genres.add(Genre("Action", R.drawable.action12))
        genres.add(Genre("Adventure", R.drawable.adventure))
        genres.add(Genre("Drama", R.drawable.drama))
        return genres
    }

    private fun setGenresUi() {
        binding.genreRecycler.adapter =
            GenreAdapter(getGenres())
        binding.genreRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }

    private fun setMainDefaultRvUI() {
        binding.mainRecycler.adapter =
            BookAdapter(books, R.layout.book_item, requireContext())
        binding.mainRecycler.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
    }



    private fun changeSavedBooksVisibility() {
        if ((books.filter { it.isSaved } as ArrayList<Book>).isEmpty()) {
            binding.box1.visibility = View.VISIBLE
            binding.savedRecycler.visibility = View.GONE
        } else {
            binding.box1.visibility = View.GONE
            binding.savedRecycler.visibility = View.VISIBLE
        }
    }

    fun changeWishBooksVisibility() {
        if ((books.filter { it.isWish } as ArrayList<Book>).isEmpty()) {
            binding.box2.visibility = View.VISIBLE
            binding.wishlistRecycler.visibility = View.GONE
        } else {
            binding.box2.visibility = View.GONE
            binding.wishlistRecycler.visibility = View.VISIBLE
        }
    }
}