package io.appwrite.enums

enum class ExecutionMethod(val value: String) {
    GET("GET"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS");

    override fun toString() = value
}