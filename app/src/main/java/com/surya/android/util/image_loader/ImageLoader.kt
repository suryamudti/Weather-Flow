package com.surya.android.util.image_loader

import android.widget.ImageView

interface ImageLoader {

  fun load(imageResource: String, target: ImageView)
}
