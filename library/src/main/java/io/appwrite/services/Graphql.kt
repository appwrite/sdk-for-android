package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The GraphQL API allows you to query and mutate your Appwrite server using GraphQL.
**/
class Graphql : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * GraphQL Endpoint
     *
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    suspend fun query(
        query: Any,
    ): Any {
        val path = "/graphql"

        val params = mutableMapOf<String, Any?>(
            "query" to query,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = Any::class.java,
            converter,
        )
    }


    /**
     * GraphQL Endpoint
     *
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    suspend fun mutation(
        query: Any,
    ): Any {
        val path = "/graphql/mutation"

        val params = mutableMapOf<String, Any?>(
            "query" to query,
            "project" to client.config["project"],
        )
        val headers = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = Any::class.java,
            converter,
        )
    }


}