package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ExecutionTrigger(val value: String) {
    @SerializedName("http")
    HTTP("http"),
    @SerializedName("schedule")
    SCHEDULE("schedule"),
    @SerializedName("event")
    EVENT("event");

    override fun toString() = value
}