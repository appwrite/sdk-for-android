package io.appwrite.android.utils

import android.content.Context
import io.appwrite.Client

object Client {
    lateinit var client : Client

    fun create(context: Context) {
        client = Client(context)
            .setEndpoint("https://<REGION>.cloud.appwrite.io/v1")
            .setProject("65a8e2b4632c04b1f5da")
            .setSelfSigned(true)
    }
}