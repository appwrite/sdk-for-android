package io.appwrite.enums

enum class Browser(val value: String) {
    AVANT_BROWSER("aa"),
    ANDROID_WEB_VIEW_BETA("an"),
    GOOGLE_CHROME("ch"),
    GOOGLE_CHROMEI_OS("ci"),
    GOOGLE_CHROME_MOBILE("cm"),
    CHROMIUM("cr"),
    MOZILLA_FIREFOX("ff"),
    SAFARI("sf"),
    MOBILE_SAFARI("mf"),
    MICROSOFT_EDGE("ps"),
    MICROSOFT_EDGEI_OS("oi"),
    OPERA_MINI("om"),
    OPERA("op"),
    OPERA_NEXT("on");

    override fun toString() = value
}