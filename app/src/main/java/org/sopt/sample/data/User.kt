package org.sopt.sample.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String = "",
    val password: String = "",
    val mbti: String = ""
) : Parcelable