package io.appwrite.enums

enum class ImageGravity(val value: String) {
    CENTER("center"),
    TOPLEFT("top-left"),
    TOP("top"),
    TOPRIGHT("top-right"),
    LEFT("left"),
    RIGHT("right"),
    BOTTOMLEFT("bottom-left"),
    BOTTOM("bottom"),
    BOTTOMRIGHT("bottom-right");

    override fun toString() = value
}