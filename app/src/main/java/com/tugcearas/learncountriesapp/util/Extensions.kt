package com.tugcearas.learncountriesapp.util

import android.content.Context
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.tugcearas.learncountriesapp.R

fun ImageView.downloadImage(url:String?, progressBarDrawable: CircularProgressDrawable){

    val options = RequestOptions()
        .placeholder(progressBarDrawable)
        .error(R.drawable.warning)

    Glide.with(context)
        .setDefaultRequestOptions(options)
        .load(url)
        .into(this)
}

fun placeholderProgressBar(context:Context): CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
        start()
    }
}

// pass this function to country item xml
@BindingAdapter("android:downloadImage")
fun downloadImageToList(view:ImageView, url:String?){
    view.downloadImage(url, placeholderProgressBar(view.context))
}