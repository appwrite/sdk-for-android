package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.classOf
import okhttp3.Cookie
import java.io.File

/**
 * The Migrations service allows you to migrate third-party data to your Appwrite project.
**/
class Migrations : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * Revoke Appwrite&#039;s authorization to access Firebase Projects
     *
     * 
     *
     * @return [Any]
     */
    suspend fun deleteFirebaseAuth(
    ): Any {
        val apiPath = "/migrations/firebase/deauthorize"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = Any::class.java,
        )
    }


    /**
     * List Firebase Projects
     *
     * 
     *
     * @return [io.appwrite.models.FirebaseProjectList]
     */
    suspend fun listFirebaseProjects(
    ): io.appwrite.models.FirebaseProjectList {
        val apiPath = "/migrations/firebase/projects"

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.FirebaseProjectList = {
            io.appwrite.models.FirebaseProjectList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.FirebaseProjectList::class.java,
            converter,
        )
    }


}