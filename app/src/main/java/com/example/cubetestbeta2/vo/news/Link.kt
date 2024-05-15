package com.example.cubetestbeta2.vo.news


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Link(
    @SerializedName("src")
    val src: String,
    @SerializedName("subject")
    val subject: String
): Parcelable