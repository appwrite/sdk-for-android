package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ImageGravity(val value: String) {
    @SerializedName("center")
    CENTER("center"),
    @SerializedName("top-left")
    TOPLEFT("top-left"),
    @SerializedName("top")
    TOP("top"),
    @SerializedName("top-right")
    TOPRIGHT("top-right"),
    @SerializedName("left")
    LEFT("left"),
    @SerializedName("right")
    RIGHT("right"),
    @SerializedName("bottom-left")
    BOTTOMLEFT("bottom-left"),
    @SerializedName("bottom")
    BOTTOM("bottom"),
    @SerializedName("bottom-right")
    BOTTOMRIGHT("bottom-right");

    override fun toString() = value
}