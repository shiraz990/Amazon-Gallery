package com.shiraz.amazonawslisting.base

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.shiraz.amazonawslisting.R


class FragmentBindingAdapters constructor(private val fragment: Fragment) {
    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {

        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        Glide.with(fragment).setDefaultRequestOptions(requestOptions).load(url)
            .into(imageView)
    }

    @BindingAdapter(value = ["imageUrl", "defaultImage"], requireAll = false)
    fun bindImage(imageView: ImageView, url: String?, defaultImage: Drawable? = null) {

        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        if (defaultImage != null)
            requestOptions.placeholder(defaultImage)
        Glide.with(fragment).setDefaultRequestOptions(requestOptions).load(url)
            .placeholder(R.drawable.progress_animation)
            .into(imageView)
    }

    @BindingAdapter("imageResource")
    fun bindImageResource(imageView: ImageView, resourceId: Int?) {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .priority(Priority.HIGH)
        imageView.setImageResource(resourceId!!)
    }


}