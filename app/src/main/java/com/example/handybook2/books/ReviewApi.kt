package com.example.handybook2.books

import android.content.Context
import com.example.handybook2.R
import com.example.handybook2.model.Book
import com.example.handybook2.model.Review
import com.google.gson.Gson

class ReviewApi(context: Context) {
    companion object {
        private var instance: ReviewApi? = null
        fun newInstance(context: Context): ReviewApi {
            if (instance == null) {
                instance = ReviewApi(context)
            }
            return instance!!
        }
    }

    private val shared = context.getSharedPreferences("shared", Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveAllBooksToShared() {
        var Review = ArrayList<Review>()

        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

            )
        )

        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )
        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )
        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )
        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )
        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )
        Review.add(
            Review(
                R.id.action,
                "Throughout the series, Harry is described as having his father's perpetually untidy black hair, his mother's bright green eyes, and a lightning bolt-shaped scar on his forehead. He is further described as \"small and skinny for his age\" with \"a thin face\" and \"knobbly knees\", and he wears Windsor glasses.",
                "20:50",
                "19.11.2023",

                )
        )

        val reviewJson = gson.toJson(Review)
        shared.edit().putString("books2",reviewJson).apply()
    }
}