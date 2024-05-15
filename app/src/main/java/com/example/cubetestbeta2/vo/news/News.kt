package com.example.cubetestbeta2.vo.news


import com.google.gson.annotations.SerializedName

data class News(
    @SerializedName("begin")
    val begin: Any,
    @SerializedName("description")
    val description: String,
    @SerializedName("end")
    val end: Any,
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
)