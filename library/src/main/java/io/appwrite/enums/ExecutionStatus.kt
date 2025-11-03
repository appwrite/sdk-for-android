package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ExecutionStatus(val value: String) {
    @SerializedName("waiting")
    WAITING("waiting"),
    @SerializedName("processing")
    PROCESSING("processing"),
    @SerializedName("completed")
    COMPLETED("completed"),
    @SerializedName("failed")
    FAILED("failed"),
    @SerializedName("scheduled")
    SCHEDULED("scheduled");

    override fun toString() = value
}