package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class BrowserPermission(val value: String) {
    @SerializedName("geolocation")
    GEOLOCATION("geolocation"),
    @SerializedName("camera")
    CAMERA("camera"),
    @SerializedName("microphone")
    MICROPHONE("microphone"),
    @SerializedName("notifications")
    NOTIFICATIONS("notifications"),
    @SerializedName("midi")
    MIDI("midi"),
    @SerializedName("push")
    PUSH("push"),
    @SerializedName("clipboard-read")
    CLIPBOARD_READ("clipboard-read"),
    @SerializedName("clipboard-write")
    CLIPBOARD_WRITE("clipboard-write"),
    @SerializedName("payment-handler")
    PAYMENT_HANDLER("payment-handler"),
    @SerializedName("usb")
    USB("usb"),
    @SerializedName("bluetooth")
    BLUETOOTH("bluetooth"),
    @SerializedName("accelerometer")
    ACCELEROMETER("accelerometer"),
    @SerializedName("gyroscope")
    GYROSCOPE("gyroscope"),
    @SerializedName("magnetometer")
    MAGNETOMETER("magnetometer"),
    @SerializedName("ambient-light-sensor")
    AMBIENT_LIGHT_SENSOR("ambient-light-sensor"),
    @SerializedName("background-sync")
    BACKGROUND_SYNC("background-sync"),
    @SerializedName("persistent-storage")
    PERSISTENT_STORAGE("persistent-storage"),
    @SerializedName("screen-wake-lock")
    SCREEN_WAKE_LOCK("screen-wake-lock"),
    @SerializedName("web-share")
    WEB_SHARE("web-share"),
    @SerializedName("xr-spatial-tracking")
    XR_SPATIAL_TRACKING("xr-spatial-tracking");

    override fun toString() = value
}