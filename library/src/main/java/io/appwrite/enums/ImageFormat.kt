package io.appwrite.enums

enum class ImageFormat(val value: String) {
    JPG("jpg"),
    JPEG("jpeg"),
    GIF("gif"),
    PNG("png"),
    WEBP("webp");

    override fun toString() = value
}