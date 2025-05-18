package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ImageFormat(val value: String) {
    @SerializedName("jpg")
    JPG("jpg"),
    @SerializedName("jpeg")
    JPEG("jpeg"),
    @SerializedName("png")
    PNG("png"),
    @SerializedName("webp")
    WEBP("webp"),
    @SerializedName("heic")
    HEIC("heic"),
    @SerializedName("avif")
    AVIF("avif");

    override fun toString() = value
}