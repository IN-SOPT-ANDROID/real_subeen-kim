package org.sopt.sample.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.transform.RoundedCornersTransformation
import org.sopt.sample.R
import coil.load

@BindingAdapter("android:src")
fun ImageView.loadCircleImage(imageUrl: String?) {
    load(imageUrl) {
        placeholder(R.drawable.ic_heart)
            .transformations(RoundedCornersTransformation(50f))
            .crossfade(true)
    }
}