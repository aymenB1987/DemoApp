package com.example.demoapp.ui.users.widget

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso



/**
 * Paginationlistner
 * Aymen Bouali
 * Coyote
 * @date 24/09/2020
 */

// =============================================================================================
// DataBindingHelper
// =============================================================================================
@BindingAdapter("profileImage")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .resize(180, 180)
        .centerCrop()
        .into(view)
}