package com.example.cubetest.data

import android.content.Context
import android.content.SharedPreferences

class SharedPreferences(context: Context){
    private val pref: SharedPreferences? = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)

    fun saveLanguage(name: String){
        pref?.let {
            pref.edit().putString(LANGUAGE, name).apply()
        }
    }

    fun getLanguage() : String? {
        return pref?.getString(LANGUAGE, "zh-tw")
    }

    companion object {
        const val PREF_NAME = "storage"
        const val LANGUAGE = "Language"
    }
}