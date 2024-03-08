package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ImageGravity(val value: String) {
    @SerializedName("center")
    CENTER("center"),
    @SerializedName("top-left")
    TOP_LEFT("top-left"),
    @SerializedName("top")
    TOP("top"),
    @SerializedName("top-right")
    TOP_RIGHT("top-right"),
    @SerializedName("left")
    LEFT("left"),
    @SerializedName("right")
    RIGHT("right"),
    @SerializedName("bottom-left")
    BOTTOM_LEFT("bottom-left"),
    @SerializedName("bottom")
    BOTTOM("bottom"),
    @SerializedName("bottom-right")
    BOTTOM_RIGHT("bottom-right");

    override fun toString() = value
}