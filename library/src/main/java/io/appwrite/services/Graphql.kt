package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The GraphQL API allows you to query and mutate your Appwrite server using GraphQL.
**/
class Graphql(client: Client) : Service(client) {

    /**
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    suspend fun query(
        query: Any,
    ): Any {
        val apiPath = "/graphql"

        val apiParams = mutableMapOf<String, Any?>(
            "query" to query,
        )
        val apiHeaders = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
            converter,
        )
    }


    /**
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    suspend fun mutation(
        query: Any,
    ): Any {
        val apiPath = "/graphql/mutation"

        val apiParams = mutableMapOf<String, Any?>(
            "query" to query,
        )
        val apiHeaders = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class.java,
            converter,
        )
    }


}