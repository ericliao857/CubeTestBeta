package com.example.cubetestbeta2.vo

import com.google.gson.annotations.SerializedName

/**
 * API 外層的包裝
 */
data class ApiBean<T>(
    @SerializedName("total")
    val total: Int,
    @SerializedName("data")
    val data: T
)