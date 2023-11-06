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
                "J.K. Rowling",
                250,
                "\n" + "Throughout the series, Harry is described as having his father's perpetually untidy black hair",
                4.9,
                "9.8 mb",
                "$17.99",
                R.drawable.harry,
                "Fantastic"
            )
        )

        books.add(
            Book(
                "How to win friends and influence people",
                "Dale Carnegie",
                237,
                "\n" + ", his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                4.3,
                "7.9 mb",
                "$28.50",
                R.drawable.win_people,
                "Literature"
            )
        )

        books.add(
            Book(
                "Atomic Habits",
                "James Clear",
                200,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus ",
                4.3,
                "16.9 mb",
                "$18.50",
                R.drawable.atomic_habits,
                "Motivation"
            )
        )

        books.add(
            Book(
                "Ikki eshik orasi",
                "O'tkir Hoshimov",
                235,
                "\n" + " elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.1,
                "15.6 mb",
                "$20.50",
                R.drawable.ikkieshikorasi,
                "Romance"
            )
        )

        books.add(
            Book(
                "Stive Jobs",
                "Steve Jobs ",
                245,
                "\n" + " risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.5,
                "16.9 mb",
                "$18.50",
                R.drawable.steve,
                "Action"
            )
        )

        books.add(
            Book(
                "Odam bo'lish qiyin",
                "O'lmas Umarbekov",
                245,
                "\n" + "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi feugiat ac felis eget condimentum. Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.6,
                "15.6 mb",
                "$21.50",
                R.drawable.odam,
                "Motivation"
            )
        )



        books.add(
            Book(
                "Sariq devni minib",
                "Xudoyberdi To'xtaboyev",
                245,
                "\n" + ". Nunc fermentum velit et risus accumsan, at elementum metus luctus. Aliquam a nunc non leo placerat cursus. Sed et turpis sit amet libero volutpat luctus.",
                4.9,
                "25.6 mb",
                "$22.50",
                R.drawable.sariq,
                "Thiller"
            )
        )

        val booksJson = gson.toJson(books)
        shared.edit().putString("books", booksJson).apply()
    }
}