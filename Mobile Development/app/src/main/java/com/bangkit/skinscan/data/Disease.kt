package com.bangkit.skinscan.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Disease(
    var name: String = "",
    var img: Int = 0,
    var about: String = ""
): Parcelable
