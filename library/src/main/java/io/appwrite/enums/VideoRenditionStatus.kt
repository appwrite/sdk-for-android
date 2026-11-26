package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VideoRenditionStatus(val value: String) {
    @SerializedName("pending")
    PENDING("pending"),
    @SerializedName("started")
    STARTED("started"),
    @SerializedName("ended")
    ENDED("ended"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("error")
    ERROR("error"),
    @SerializedName("aborted")
    ABORTED("aborted");

    override fun toString() = value
}
