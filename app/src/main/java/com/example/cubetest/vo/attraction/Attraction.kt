package com.example.cubetest.vo.attraction


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attraction(
    @SerializedName("address")
    val address: String,
    @SerializedName("category")
    val category: List<Category>,
    @SerializedName("distric")
    val distric: String,
    @SerializedName("elong")
    val elong: Double,
    @SerializedName("email")
    val email: String,
    @SerializedName("facebook")
    val facebook: String,
    @SerializedName("fax")
    val fax: String,
    @SerializedName("friendly")
    val friendly: List<Friendly>,
    @SerializedName("id")
    val id: Int,
    @SerializedName("images")
    val images: List<Image>?,
    @SerializedName("introduction")
    val introduction: String,
    @SerializedName("links")
    val links: List<Link>,
    @SerializedName("modified")
    val modified: String,
    @SerializedName("months")
    val months: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nlat")
    val nlat: Double,
    @SerializedName("official_site")
    val officialSite: String,
    @SerializedName("open_status")
    val openStatus: Int,
    @SerializedName("open_time")
    val openTime: String,
    @SerializedName("remind")
    val remind: String,
    @SerializedName("service")
    val service: List<Service>,
    @SerializedName("staytime")
    val staytime: String,
    @SerializedName("target")
    val target: List<Target>,
    @SerializedName("tel")
    val tel: String,
    @SerializedName("ticket")
    val ticket: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("zipcode")
    val zipcode: String
): Parcelable