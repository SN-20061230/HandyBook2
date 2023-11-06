package com.example.handybook2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.handybook2.R
import com.example.handybook2.model.Book
import com.example.handybook2.model.Review
import com.google.android.material.imageview.ShapeableImageView

class ReviewAdapter(
    var books: ArrayList<Book>,
    var itemLayout: Int = R.layout.book_item2,
    var context: Context,

    ) : RecyclerView.Adapter<ReviewAdapter.MyHolder>() {
    class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var image = itemView.findViewById<ImageView>(R.id.imagelar)
        var comment = itemView.findViewById<TextView>(R.id.bookName)
        var oclock = itemView.findViewById<TextView>(R.id.bookPrice)
        var time = itemView.findViewById<TextView>(R.id.bookRating)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(parent.context).inflate(itemLayout, parent, false))
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var book = books[position]

        holder.image.setImageResource(book.img)
        holder.comment.text = book.description
        holder.oclock.text = book.price
        holder.time.text = book.genreName

        val anim = AnimationUtils.loadAnimation(context, R.anim.item_anim)
        holder.itemView.startAnimation(anim)


    }
}