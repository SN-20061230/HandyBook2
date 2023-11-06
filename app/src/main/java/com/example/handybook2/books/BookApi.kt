package com.example.handybook2.books

import android.content.Context
import com.example.handybook2.R
import com.example.handybook2.model.Book
import com.google.gson.Gson

class BookApi(context: Context) {
    companion object {
        private var instance: BookApi? = null
        fun newInstance(context: Context): BookApi {
            if (instance == null) {
                instance = BookApi(context)
            }
            return instance!!
        }
    }

    private val shared = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveAllBooksToShared() {
        var books = ArrayList<Book>()

        books.add(
            Book(
                "Harry Potter",
                "Uolter Ayzekson",
                850,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.7,
                "9.6 mb",
                "$17.99",
                R.drawable.doxology,
                "Thriller",
                null
            )
        )

        books.add(
            Book(
                "The Final Revival of Opal & Nev",
                "Yapon zobiti",
                237,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.9,
                "7.9 mb",
                "$28.50",
                R.drawable.opal,
                "Romance",
                null
            )
        )

        books.add(
            Book(
                "An Equal Music",
                "Vikram Seth",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.9,
                "6.9 mb",
                "$8.50",
                R.drawable.music,
                "Thriller",
                null
            )
        )

        books.add(
            Book(
                "Harry Potter",
                "Sidney Halston",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.1,
                "5.6 mb",
                "$10.50",
                R.drawable.valentines,
                "Romance",
                null
            )
        )

        books.add(
            Book(
                "Ibtido",
                "Den Braun ",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.2,
                "6.9 mb",
                "$8.50",
                R.drawable.action1,
                "Action",
                null
            )
        )

        books.add(
            Book(
                "Javdarzordagi xaloskor",
                "Jerom Selinjer",
                235,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.3,
                "5.6 mb",
                "$11.50",
                R.drawable.img_3,
                "Romance",
                null
            )
        )

        val booksJson = gson.toJson(books)
        shared.edit().putString("books", booksJson).apply()
    }
}