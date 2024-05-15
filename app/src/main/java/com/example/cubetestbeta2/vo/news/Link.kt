package com.example.cubetestbeta2.vo.news


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("src")
    val src: String,
    @SerializedName("subject")
    val subject: String
)