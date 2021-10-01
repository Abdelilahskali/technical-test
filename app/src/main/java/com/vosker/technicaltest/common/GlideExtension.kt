package com.vosker.technicaltest.common

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.vosker.technicaltest.R

fun ImageView.loadImage(url: String){

    val requestOption = RequestOptions()
        .placeholder(R.drawable.placeholder).centerCrop()

    Glide.with(this).load(url)
        .transition(DrawableTransitionOptions.withCrossFade())
        .apply(requestOption)
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .skipMemoryCache(true)
        .into(this)
}