package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VideoCodecId(val value: String) {
    @SerializedName("h264")
    H264("h264"),
    @SerializedName("hevc")
    HEVC("hevc"),
    @SerializedName("vp9")
    VP9("vp9");

    override fun toString() = value
}
