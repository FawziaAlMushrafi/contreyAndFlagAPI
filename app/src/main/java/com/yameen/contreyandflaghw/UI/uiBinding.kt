package com.yameen.contreyandflaghw.UI

import android.media.Image
import android.net.Uri
import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.load
import coil.request.ImageRequest
import com.yameen.contreyandflaghw.R
import com.yameen.contreyandflaghw.internet.DataItem
import com.yameen.contreyandflaghw.overview.CountryAdaper


@BindingAdapter("imageUrl")
fun ImageView.findUrl(imgUrl: String?) {
    imgUrl?.let {
        var imgUri = imgUrl.toUri().buildUpon().scheme("http").build()
        this.load(imgUri) {
            placeholder(R.drawable.loading_animation)
            error(R.drawable.ic_baseline_broken_image_24)
        }
    }
}

@BindingAdapter("listData")
fun RecyclerView.bindRecycleView(data: List<DataItem>?) {
    if (this.adapter == null) {
        this.adapter = CountryAdaper()
    }
    val adapter = this.adapter as CountryAdaper
    adapter.submitList(data)
}

@BindingAdapter("imageUri")
fun ImageView.findUrl2(imgUrl: String?) {
    val imageLoader = ImageLoader.Builder(this.context)
        .componentRegistry { add(SvgDecoder(context)) }
        .build()

    val request = ImageRequest.Builder(this.context)
        .crossfade(true)
        .crossfade(500)
        .data(imgUrl)
        .target(this)
        .placeholder(R.drawable.loading_animation)
        .error(R.drawable.ic_baseline_broken_image_24)
        .build()

    imageLoader.enqueue(request)
}
