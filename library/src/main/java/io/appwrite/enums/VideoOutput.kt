package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VideoOutput(val value: String) {
    @SerializedName("hls")
    HLS("hls"),
    @SerializedName("dash")
    DASH("dash"),
    @SerializedName("cmaf")
    CMAF("cmaf");

    override fun toString() = value
}
