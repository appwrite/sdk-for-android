package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Browser(val value: String) {
    @SerializedName("aa")
    AVANT_BROWSER("aa"),
    @SerializedName("an")
    ANDROID_WEBVIEW_BETA("an"),
    @SerializedName("ch")
    GOOGLE_CHROME("ch"),
    @SerializedName("ci")
    GOOGLE_CHROME_IOS("ci"),
    @SerializedName("cm")
    GOOGLE_CHROME_MOBILE("cm"),
    @SerializedName("cr")
    CHROMIUM("cr"),
    @SerializedName("ff")
    MOZILLA_FIREFOX("ff"),
    @SerializedName("sf")
    SAFARI("sf"),
    @SerializedName("mf")
    MOBILE_SAFARI("mf"),
    @SerializedName("ps")
    MICROSOFT_EDGE("ps"),
    @SerializedName("oi")
    MICROSOFT_EDGE_IOS("oi"),
    @SerializedName("om")
    OPERA_MINI("om"),
    @SerializedName("op")
    OPERA("op"),
    @SerializedName("on")
    OPERA_NEXT("on");

    override fun toString() = value
}