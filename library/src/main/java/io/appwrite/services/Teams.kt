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
     * Get a list of all the teams in which the current user is a member. You can
     * use the parameters to filter your results.
     * 
     * In admin mode, this endpoint returns a list of all the teams in the current
     * project. [Learn more about different API modes](/docs/admin).
     *
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of teams to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this param to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the team used as the starting point for the query, excluding the team itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
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
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.TeamList = {
            io.appwrite.models.TeamList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.TeamList::class.java,
            converter,
        )
    }
    
    /**
     * Create Team
     *
     * Create a new team. The user who creates the team will automatically be
     * assigned as the owner of the team. Only the users with the owner role can
     * invite new members, add new owners and delete or update the team.
     *
     * @param teamId Team ID. Choose your own unique ID or pass the string &quot;unique()&quot; to auto generate it. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can&#039;t start with a special char. Max length is 36 chars.
     * @param name Team name. Max length: 128 chars.
     * @param roles Array of strings. Use this param to set the roles in the team for the user who created it. The default role is **owner**. A role can be any string. Learn more about [roles and permissions](/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
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
        val params = mutableMapOf<String, Any?>(
            "teamId" to teamId,
            "name" to name,
            "roles" to roles
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            converter,
        )
    }
    
    /**
     * Get Team
     *
     * Get a team by its ID. All team members have read access for this resource.
     *
     * @param teamId Team ID.
     * @return [io.appwrite.models.Team]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun get(
		teamId: String
	): io.appwrite.models.Team {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            converter,
        )
    }
    
    /**
     * Update Team
     *
     * Update a team using its ID. Only members with the owner role can update the
     * team.
     *
     * @param teamId Team ID.
     * @param name New team name. Max length: 128 chars.
     * @return [io.appwrite.models.Team]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun update(
		teamId: String,
		name: String
	): io.appwrite.models.Team {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mutableMapOf<String, Any?>(
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Team = {
            io.appwrite.models.Team.from(map = it)
        }
        return client.call(
            "PUT",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Team::class.java,
            converter,
        )
    }
    
    /**
     * Delete Team
     *
     * Delete a team using its ID. Only team members with the owner role can
     * delete the team.
     *
     * @param teamId Team ID.
     * @return [Any]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun delete(
		teamId: String
	): Any {
        val path = "/teams/{teamId}".replace("{teamId}", teamId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
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
     * Use this endpoint to list a team's members using the team's ID. All team
     * members have read access to this endpoint.
     *
     * @param teamId Team ID.
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param limit Maximum number of memberships to return in response. By default will return maximum 25 results. Maximum of 100 results allowed per request.
     * @param offset Offset value. The default value is 0. Use this value to manage pagination. [learn more about pagination](https://appwrite.io/docs/pagination)
     * @param cursor ID of the membership used as the starting point for the query, excluding the membership itself. Should be used for efficient pagination when working with large sets of data. [learn more about pagination](https://appwrite.io/docs/pagination)
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
        val params = mutableMapOf<String, Any?>(
            "search" to search,
            "limit" to limit,
            "offset" to offset,
            "cursor" to cursor,
            "cursorDirection" to cursorDirection,
            "orderType" to orderType
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.MembershipList = {
            io.appwrite.models.MembershipList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.MembershipList::class.java,
            converter,
        )
    }
    
    /**
     * Create Team Membership
     *
     * Invite a new member to join your team. If initiated from the client SDK, an
     * email with a link to join the team will be sent to the member's email
     * address and an account will be created for them should they not be signed
     * up already. If initiated from server-side SDKs, the new member will
     * automatically be added to the team.
     * 
     * Use the 'url' parameter to redirect the user from the invitation email back
     * to your app. When the user is redirected, use the [Update Team Membership
     * Status](/docs/client/teams#teamsUpdateMembershipStatus) endpoint to allow
     * the user to accept the invitation to the team. 
     * 
     * Please note that to avoid a [Redirect
     * Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md)
     * the only valid redirect URL's are the once from domains you have set when
     * adding your platforms in the console interface.
     *
     * @param teamId Team ID.
     * @param email Email of the new team member.
     * @param roles Array of strings. Use this param to set the user roles in the team. A role can be any string. Learn more about [roles and permissions](/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
     * @param url URL to redirect the user back to your app from the invitation email.  Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param name Name of the new team member. Max length: 128 chars.
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
        val params = mutableMapOf<String, Any?>(
            "email" to email,
            "roles" to roles,
            "url" to url,
            "name" to name
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "POST",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }
    
    /**
     * Get Team Membership
     *
     * Get a team member by the membership unique id. All team members have read
     * access for this resource.
     *
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     * @return [io.appwrite.models.MembershipList]     
     */
    @JvmOverloads
    @Throws(AppwriteException::class)
    suspend fun getMembership(
		teamId: String,
		membershipId: String
	): io.appwrite.models.MembershipList {
        val path = "/teams/{teamId}/memberships/{membershipId}".replace("{teamId}", teamId).replace("{membershipId}", membershipId)
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.MembershipList = {
            io.appwrite.models.MembershipList.from(map = it)
        }
        return client.call(
            "GET",
            path,
            headers,
            params,
            responseType = io.appwrite.models.MembershipList::class.java,
            converter,
        )
    }
    
    /**
     * Update Membership Roles
     *
     * Modify the roles of a team member. Only team members with the owner role
     * have access to this endpoint. Learn more about [roles and
     * permissions](/docs/permissions).
     *
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     * @param roles An array of strings. Use this param to set the user&#039;s roles in the team. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
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
        val params = mutableMapOf<String, Any?>(
            "roles" to roles
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }
    
    /**
     * Delete Team Membership
     *
     * This endpoint allows a user to leave a team or for a team owner to delete
     * the membership of any other team member. You can also use this endpoint to
     * delete a user membership even if it is not accepted.
     *
     * @param teamId Team ID.
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
        val params = mutableMapOf<String, Any?>(
        )
        val headers = mutableMapOf(
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
     * after being redirected back to your app from the invitation email received
     * by the user.
     * 
     * If the request is successful, a session for the user is automatically
     * created.
     * 
     *
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     * @param userId User ID.
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
        val params = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret
        )
        val headers = mutableMapOf(
            "content-type" to "application/json"
        )
        val converter: (Map<String, Any>) -> io.appwrite.models.Membership = {
            io.appwrite.models.Membership.from(map = it)
        }
        return client.call(
            "PATCH",
            path,
            headers,
            params,
            responseType = io.appwrite.models.Membership::class.java,
            converter,
        )
    }
    
}