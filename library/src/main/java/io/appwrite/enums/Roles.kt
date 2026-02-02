package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Roles(val value: String) {
    @SerializedName("admin")
    ADMIN("admin"),
    @SerializedName("developer")
    DEVELOPER("developer"),
    @SerializedName("owner")
    OWNER("owner");

    override fun toString() = value
}