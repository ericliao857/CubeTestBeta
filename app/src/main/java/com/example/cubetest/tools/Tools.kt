package com.example.cubetest.tools

import android.text.Html
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.style.URLSpan
import android.widget.TextView
import java.util.regex.Pattern

object Tools {
    /*-------------------- HTML TEXT --------------------*/

    /**
     * String 轉成 Html 文字
     * @return
     */
    fun String.toHtmlText(): Spanned? {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    }

    /**
     * 處理Html文字 (連結)
     */
    @JvmStatic
    fun TextView.fromHtml(source: String?) {
        val regex = "(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]"
        val spanned = Html.fromHtml(source, Html.FROM_HTML_MODE_LEGACY)
        // Url 連結
        val spannableString = SpannableString(spanned)
        val urlMatcher = Pattern.compile(regex).matcher(spanned)
        while (urlMatcher.find()) {
            val url = urlMatcher.group()
            val start = urlMatcher.start()
            val end = urlMatcher.end()
            spannableString.setSpan(URLSpan(url), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
        this.text = spannableString

    }
}