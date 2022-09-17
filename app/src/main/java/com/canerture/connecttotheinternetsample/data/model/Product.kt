package com.canerture.connecttotheinternetsample.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val description: String?,
    val id: String?,
    val image: String?,
    val price: Double?,
    val title: String?
): Parcelable