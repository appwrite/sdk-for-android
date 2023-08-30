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
class Vcs : Service {

    public constructor (client: Client) : super(client) { }

    /**
     * List Repositories
     *
     * 
     *
     * @param installationId Installation Id
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @return [io.appwrite.models.ProviderRepositoryList]
     */
    @JvmOverloads
    suspend fun listRepositories(
        installationId: String,
        search: String? = null,
    ): io.appwrite.models.ProviderRepositoryList {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories"
            .replace("{installationId}", installationId)

        val params = mutableMapOf<String, Any?>(
            "search" to search,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProviderRepositoryList = {
            io.appwrite.models.ProviderRepositoryList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProviderRepositoryList::class.java,
            converter,
        )
    }


    /**
     * Create repository
     *
     * 
     *
     * @param installationId Installation Id
     * @param name Repository name (slug)
     * @param private Mark repository public or private
     * @return [io.appwrite.models.ProviderRepository]
     */
    suspend fun createRepository(
        installationId: String,
        name: String,
        private: Boolean,
    ): io.appwrite.models.ProviderRepository {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories"
            .replace("{installationId}", installationId)

        val params = mutableMapOf<String, Any?>(
            "name" to name,
            "private" to private,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProviderRepository = {
            io.appwrite.models.ProviderRepository.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProviderRepository::class.java,
            converter,
        )
    }


    /**
     * Get repository
     *
     * 
     *
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     * @return [io.appwrite.models.ProviderRepository]
     */
    suspend fun getRepository(
        installationId: String,
        providerRepositoryId: String,
    ): io.appwrite.models.ProviderRepository {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.ProviderRepository = {
            io.appwrite.models.ProviderRepository.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.ProviderRepository::class.java,
            converter,
        )
    }


    /**
     * List Repository Branches
     *
     * 
     *
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     * @return [io.appwrite.models.BranchList]
     */
    suspend fun listRepositoryBranches(
        installationId: String,
        providerRepositoryId: String,
    ): io.appwrite.models.BranchList {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}/branches"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)

        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.BranchList = {
            io.appwrite.models.BranchList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.BranchList::class.java,
            converter,
        )
    }


    /**
     * Detect runtime settings from source code
     *
     * 
     *
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     * @param providerRootDirectory Path to Root Directory
     * @return [io.appwrite.models.Detection]
     */
    @JvmOverloads
    suspend fun createRepositoryDetection(
        installationId: String,
        providerRepositoryId: String,
        providerRootDirectory: String? = null,
    ): io.appwrite.models.Detection {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}/detection"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)

        val params = mutableMapOf<String, Any?>(
            "providerRootDirectory" to providerRootDirectory,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Detection = {
            io.appwrite.models.Detection.from(map = it as Map<String, Any>)
        }
        return client.call(
            "POST",
            apiPath,
            headers,
            params,
            responseType = io.appwrite.models.Detection::class.java,
            converter,
        )
    }


    /**
     * Authorize external deployment
     *
     * 
     *
     * @param installationId Installation Id
     * @param repositoryId VCS Repository Id
     * @param providerPullRequestId GitHub Pull Request Id
     * @return [Any]
     */
    suspend fun updateExternalDeployments(
        installationId: String,
        repositoryId: String,
        providerPullRequestId: String,
    ): Any {
        val apiPath = "/vcs/github/installations/{installationId}/repositories/{repositoryId}"
            .replace("{installationId}", installationId)
            .replace("{repositoryId}", repositoryId)

        val params = mutableMapOf<String, Any?>(
            "providerPullRequestId" to providerPullRequestId,
        )
        val headers = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "PATCH",
            apiPath,
            headers,
            params,
            responseType = Any::class.java,
        )
    }


}