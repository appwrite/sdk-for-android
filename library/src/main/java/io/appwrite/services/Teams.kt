package io.appwrite.services

import android.net.Uri
import io.appwrite.Client
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import okhttp3.Cookie
import okhttp3.Response
import java.io.File

class Teams(client: Client) : Service(client) {

    /**
     * List Teams
     *
     * Get a list of all the current user teams. You can use the query params to
     * filter your results. On admin mode, this endpoint will return a list of all
     * of the project's teams. [Learn more about different API
     * modes](/docs/admin).
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Results limit value. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Results offset. The default value is 0. Use this param to manage pagination.
     * @param cursor ID of the team used as the starting point for the query, excluding the team itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.TeamList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun list(
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.TeamList {
        val path = "/teams"
        val params = mapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.TeamList = {
            io.appwrite.models.TeamList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.TeamList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Team
     *
     * Create a new team. The user who creates the team will automatically be
     * assigned as the owner of the team. The team owner can invite new members,
     * who will be able add new owners and update or delete the team from your
     * project.
     *
     * @param teamId Unique Id. Choose your own unique ID or pass the string `unique()` to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Team name. Max length: 128 chars.
     * @param roles Array of strings. Use this param to set the roles in the team for the user who created it. The default role is **owner**. A role can be any string. Learn more about [roles and permissions](/docs/permissions). Max length for each role is 32 chars.
     * @return [io.appwrite.models.Team]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun create(
		teamId: String,
		name: String,
		roles: List<Any>? = null
	): io.appwrite.models.Team {
        val path = "/teams"
        val params = mapOf<String, Any?>(
            "teamId" to teamId,
            "name" to name,
            "roles" to roles
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Team
     *
     * Get a team by its unique ID. All team members have read access for this
     * resource.
     *
     * @param teamId Team unique ID.
     * @return [io.appwrite.models.Team]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		teamId: String
	): io.appwrite.models.Team {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Team
     *
     * Update a team by its unique ID. Only team owners have write access for this
     * resource.
     *
     * @param teamId Team unique ID.
     * @param name Team name. Max length: 128 chars.
     * @return [io.appwrite.models.Team]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		teamId: String,
		name: String
	): io.appwrite.models.Team {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mapOf<String, Any?>(
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Team
     *
     * Delete a team by its unique ID. Only team owners have write access for this
     * resource.
     *
     * @param teamId Team unique ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		teamId: String
	): Any {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Get Team Memberships
     *
     * Get a team members by the team unique ID. All team members have read access
     * for this list of resources.
     *
     * @param teamId Team unique ID.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Results limit value. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Results offset. The default value is 0. Use this param to manage pagination.
     * @param cursor ID of the membership used as the starting point for the query, excluding the membership itself. Should be used for efficient pagination when working with large sets of data.
     * @param cursorDirection Direction of the cursor.
     * @param orderType Order result by ASC or DESC order.
     * @return [io.appwrite.models.MembershipList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getMemberships(
		teamId: String,
		search: String? = null,
		limit: Long? = null,
		offset: Long? = null,
		cursor: String? = null,
		cursorDirection: String? = null,
		orderType: String? = null
	): io.appwrite.models.MembershipList {
        val path = "/teams/{teamId}/memberships".replace("{teamId}", teamId)
        val params = mapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.MembershipList = {
            io.appwrite.models.MembershipList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.MembershipList::class.java,
            convert = convert
        )
    }
    
    /**
     * Create Team Membership
     *
     * Use this endpoint to invite a new member to join your team. If initiated
     * from Client SDK, an email with a link to join the team will be sent to the
     * new member's email address if the member doesn't exist in the project it
     * will be created automatically. If initiated from server side SDKs, new
     * member will automatically be added to the team.
     * 
     * Use the 'URL' parameter to redirect the user from the invitation email back
     * to your app. When the user is redirected, use the [Update Team Membership
     * Status](/docs/client/teams#teamsUpdateMembershipStatus) endpoint to allow
     * the user to accept the invitation to the team.  While calling from side
     * SDKs the redirect url can be empty string.
     * 
     * Please note that in order to avoid a [Redirect
     * Attacks](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URL's are the once from domains you have set when
     * added your platforms in the console interface.
     *
     * @param teamId Team unique ID.
     * @param email New team member email.
     * @param roles Array of strings. Use this param to set the user roles in the team. A role can be any string. Learn more about [roles and permissions](/docs/permissions). Max length for each role is 32 chars.
     * @param url URL to redirect the user back to your app from the invitation email.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param name New team member name. Max length: 128 chars.
     * @return [io.appwrite.models.Membership]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun createMembership(
		teamId: String,
		email: String,
		roles: List<Any>,
		url: String,
		name: String? = null
	): io.appwrite.models.Membership {
        val path = "/teams/{teamId}/memberships".replace("{teamId}", teamId)
        val params = mapOf<String, Any?>(
            "email" to email,
            "roles" to roles,
            "url" to url,
            "name" to name
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            convert = convert
        )
    }
    
    /**
     * Get Team Membership
     *
     * Get a team member by the membership unique id. All team members have read
     * access for this resource.
     *
     * @param teamId Team unique ID.
     * @param membershipId membership unique ID.
     * @return [io.appwrite.models.MembershipList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getMembership(
		teamId: String,
		membershipId: String
	): io.appwrite.models.MembershipList {
        val path = "/teams/{teamId}/memberships/{membershipId}".replace("{teamId}", teamId).replace("{membershipId}", membershipId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.MembershipList = {
            io.appwrite.models.MembershipList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.MembershipList::class.java,
            convert = convert
        )
    }
    
    /**
     * Update Membership Roles
     *
     * @param teamId Team unique ID.
     * @param membershipId Membership ID.
     * @param roles Array of strings. Use this param to set the user roles in the team. A role can be any string. Learn more about [roles and permissions](/docs/permissions). Max length for each role is 32 chars.
     * @return [io.appwrite.models.Membership]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMembershipRoles(
		teamId: String,
		membershipId: String,
		roles: List<Any>
	): io.appwrite.models.Membership {
        val path = "/teams/{teamId}/memberships/{membershipId}".replace("{teamId}", teamId).replace("{membershipId}", membershipId)
        val params = mapOf<String, Any?>(
            "roles" to roles
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            convert = convert
        )
    }
    
    /**
     * Delete Team Membership
     *
     * This endpoint allows a user to leave a team or for a team owner to delete
     * the membership of any other team member. You can also use this endpoint to
     * delete a user membership even if it is not accepted.
     *
     * @param teamId Team unique ID.
     * @param membershipId Membership ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun deleteMembership(
		teamId: String,
		membershipId: String
	): Any {
        val path = "/teams/{teamId}/memberships/{membershipId}".replace("{teamId}", teamId).replace("{membershipId}", membershipId)
        val params = mapOf<String, Any?>(
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        return client.call(
            "DELETE",
            path,
            headers,
            params,
            responseType = Any::class.java,
        )
    }
    
    /**
     * Update Team Membership Status
     *
     * Use this endpoint to allow a user to accept an invitation to join a team
     * after being redirected back to your app from the invitation email recieved
     * by the user.
     *
     * @param teamId Team unique ID.
     * @param membershipId Membership ID.
     * @param userId User unique ID.
     * @param secret Secret key.
     * @return [io.appwrite.models.Membership]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun updateMembershipStatus(
		teamId: String,
		membershipId: String,
		userId: String,
		secret: String
	): io.appwrite.models.Membership {
        val path = "/teams/{teamId}/memberships/{membershipId}/status".replace("{teamId}", teamId).replace("{membershipId}", membershipId)
        val params = mapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret
        )
        val headers = mapOf(
            "content-type" to "application/json"
        )
        val convert: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            convert = convert
        )
    }
    
}