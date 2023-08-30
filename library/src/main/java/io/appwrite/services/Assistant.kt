package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * 
**/
class Assistant : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Ask Query
     *
     * 
     *
     * @param prompt Prompt. A string containing questions asked to the AI assistant.
     * @return [Any]
     */
    suspend fun chat(
        prompt: String,
    ): Any {
        val apiPath = "/console/assistant"

        val params = mutableMapOf<String, Any?>(
            "prompt" to prompt,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            headers,
            params,
            responseType = Any::class.java,
        )
    }


}