package com.example.handybook2.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.handybook2.R
import com.example.handybook2.adapters.ReviewAdapter
import com.example.handybook2.books.BookApi
import com.example.handybook2.databinding.FragmentMaqolalarBinding
import com.example.handybook2.databinding.FragmentSavedBinding
import com.example.handybook2.model.Book
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class SavedFragment : Fragment(){

    lateinit var binding: FragmentSavedBinding
    lateinit var books: ArrayList<Book>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSavedBinding.inflate(inflater, container, false)

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
        binding.barchasiRV.adapter =
            ReviewAdapter(books, R.layout.book_item2, requireContext())
        binding.barchasiRV.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }




}