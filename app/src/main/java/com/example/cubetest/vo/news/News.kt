package com.example.cubetest.vo.news


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class News(
    @SerializedName("description")
    val description: String,
    @SerializedName("files")
    val files: List<File>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("posted")
    val posted: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String
): Parcelable