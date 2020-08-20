package ru.mirkhusainov.newsfeed.utils.extensions

import android.widget.ImageView
import com.squareup.picasso.Picasso
import ru.mirkhusainov.newsfeed.R

fun ImageView.loadFromUrl(url: String) {
    Picasso.get()
        .load(url)
        .placeholder(R.drawable.ic_placeholder)
        .into(this)
}