package io.appwrite.enums

import com.google.gson.annotations.SerializedName

enum class ExecutionMethod(val value: String) {
    @SerializedName("GET")
    GET("GET"),
    @SerializedName("POST")
    POST("POST"),
    @SerializedName("PUT")
    PUT("PUT"),
    @SerializedName("PATCH")
    PATCH("PATCH"),
    @SerializedName("DELETE")
    DELETE("DELETE"),
    @SerializedName("OPTIONS")
    OPTIONS("OPTIONS"),
    @SerializedName("HEAD")
    HEAD("HEAD");

    override fun toString() = value
}