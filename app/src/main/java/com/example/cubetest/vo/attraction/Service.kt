package com.example.cubetest.vo.attraction


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Service(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
): Parcelable