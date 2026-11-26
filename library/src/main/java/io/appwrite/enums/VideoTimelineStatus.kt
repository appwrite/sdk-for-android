package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class VideoTimelineStatus(val value: String) {
    @SerializedName("pending")
    PENDING("pending"),
    @SerializedName("started")
    STARTED("started"),
    @SerializedName("ready")
    READY("ready"),
    @SerializedName("skipped")
    SKIPPED("skipped"),
    @SerializedName("error")
    ERROR("error");

    override fun toString() = value
}
