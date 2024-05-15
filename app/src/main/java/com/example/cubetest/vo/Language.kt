package com.example.cubetest.vo

/**
 * zh-tw -正體中文
 * zh-cn -簡體中文
 * en -英文
 * ja -日文
 * ko -韓文
 * es -西班牙文
 * id -印尼文
 * th -泰文
 * vi -越南文
 */
enum class Language(
    val languageCode: String,
    val languageName: String
) {
    ZH_TW("zh-tw", "正體中文"),
    ZH_CN("zh-cn", "簡體中文"),
    EN("en", "英文"),
    JA("ja", "日文"),
    KO("ko", "韓文"),
    ES("es", "西班牙文"),
    ID("id", "印尼文"),
    TH("th", "泰文"),
    VI("vi", "越南文");

}