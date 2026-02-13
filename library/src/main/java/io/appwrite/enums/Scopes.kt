package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class Scopes(val value: String) {
    @SerializedName("account")
    ACCOUNT("account"),
    @SerializedName("teams.read")
    TEAMS_READ("teams.read"),
    @SerializedName("teams.write")
    TEAMS_WRITE("teams.write");

    override fun toString() = value
}