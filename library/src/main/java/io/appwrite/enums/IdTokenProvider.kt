package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class IdTokenProvider(val value: String) {
    @SerializedName("apple")
    APPLE("apple"),
    @SerializedName("google")
    GOOGLE("google");

    override fun toString() = value
}
