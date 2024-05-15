package com.example.cubetestbeta2.vo.attraction


import com.google.gson.annotations.SerializedName

data class Friendly(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)