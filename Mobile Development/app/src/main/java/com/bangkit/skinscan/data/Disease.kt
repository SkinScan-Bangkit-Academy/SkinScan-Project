package com.bangkit.skinscan.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Disease(
    @StringRes var name: Int = 0,
    @DrawableRes var img: Int = 0,
    @StringRes var about: Int = 0
): Parcelable
