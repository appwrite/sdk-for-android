package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ExecutionResourceType(val value: String) {
    @SerializedName("functions")
    FUNCTIONS("functions"),
    @SerializedName("sites")
    SITES("sites");

    override fun toString() = value
}
