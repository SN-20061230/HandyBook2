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
import com.example.handybook2.adapters.ReviewAdapter
import com.example.handybook2.books.BookApi
import com.example.handybook2.books.ReviewApi
import com.example.handybook2.databinding.FragmentBarchasiBinding
import com.example.handybook2.databinding.FragmentHomeBinding
import com.example.handybook2.databinding.FragmentMaqolalarBinding
import com.example.handybook2.model.Book
import com.example.handybook2.model.Genre
import com.example.handybook2.model.Review
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class MaqolalarFragment : Fragment() {

    lateinit var binding: FragmentMaqolalarBinding
    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMaqolalarBinding.inflate(inflater, container, false)

        val shared = requireContext().getSharedPreferences("shared", Context.MODE_PRIVATE)
        val gson = Gson()

        if (shared.getString("books", null) == null) {
            BookApi(requireContext()).saveAllBooksToShared()
        }




        var booksJson = shared.getString("books", null)
        books = gson.fromJson(booksJson, object : TypeToken<ArrayList<Book>>() {}.type)


        setMainDefaultRvUI()




//        binding.filter.setOnClickListener{
//            findNavController().navigate(R.id.filterFragment)
//        }




        return binding.root
    }





    private fun setMainDefaultRvUI() {
        binding.maqolalar.adapter =
            ReviewAdapter(books, R.layout.book_item2, requireContext())
        binding.maqolalar.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }



}