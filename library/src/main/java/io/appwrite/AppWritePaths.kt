package io.appwrite

internal object AppWritePaths {


    /**Account Paths Const*/
    const val BASE_URL = "https://appwrite.io/v1"
    const val ACCOUNT = "/account"
    const val ACCOUNT_EMAIL = "/account/email"
    const val ACCOUNT_JWT = "/account/jwt"
    const val ACCOUNT_LOGS = "/account/logs"
    const val ACCOUNT_NAME = "/account/name"
    const val ACCOUNT_STATUS = "/account/status"
    const val ACCOUNT_VERIFICATION = "/account/verification"
    const val ACCOUNT_PASSWORD = "/account/password"
    const val ACCOUNT_PREFS = "/account/prefs"
    const val ACCOUNT_RECOVERY = "/account/recovery"
    const val ACCOUNT_SESSIONS = "/account/sessions"
    const val ACCOUNT_SESSIONS_ANONYMOUS = "/account/sessions/anonymous"
    const val ACCOUNT_SESSIONS_MAGIC_URL = "/account/sessions/magic-url"

    @JvmStatic
    fun getProvider(provider: String): String {
        return "/account/sessions/oauth2/{provider}".replace("{provider}", provider)
    }

    @JvmStatic
    fun getSessionId(sessionId: String): String {
        return "/account/sessions/{sessionId}".replace("{sessionId}", sessionId)
    }


    /**Avatars Paths Const*/
    const val AVATAR_FAVICON = "/avatars/favicon"

    const val AVATAR_IMAGE = "/avatars/image"

    const val AVATAR_INITIALS = "/avatars/initials"

    const val AVATAR_QR = "/avatars/qr"


    @JvmStatic
    fun getBrowserCodePath(code: String): String {
        return "/avatars/browsers/{code}".replace("{code}", code)
    }


    @JvmStatic
    fun getCreditCardsCodePath(code: String): String {
        return "/avatars/credit-cards/{code}".replace("{code}", code)
    }

    @JvmStatic
    fun getFlagsCodePath(code: String): String {
        return "/avatars/flags/{code}".replace("{code}", code)
    }



    /**Database Paths Const*/


    @JvmStatic
    fun getCollectionIdPath(collectionId: String): String {
        return "/database/collections/{collectionId}/documents".replace(
            "{collectionId}",
            collectionId
        )

    }

    @JvmStatic
    fun getDocumentIdPath(collectionId: String, documentId: String): String {
        return "/database/collections/{collectionId}/documents/{documentId}".replace(
            "{collectionId}",
            collectionId
        ).replace("{documentId}", documentId)


    }



    /**Functions Paths Const*/
    @JvmStatic
    fun getRetryPathPath(functionId: String, deploymentId: String, buildId: String): String {
        return "/functions/{functionId}/deployments/{deploymentId}/builds/{buildId}".replace(
            "{functionId}",
            functionId
        ).replace("{deploymentId}", deploymentId).replace("{buildId}", buildId)

    }


    @JvmStatic
    fun getExecutionPath(functionId: String): String {
        return "/functions/{functionId}/executions".replace("{functionId}", functionId)

    }

    @JvmStatic
    fun getExecutionIdPath(functionId: String, executionId: String): String {
        return "/functions/{functionId}/executions/{executionId}".replace(
            "{functionId}",
            functionId
        )
            .replace("{executionId}", executionId)

    }




    /**Bucket Paths Const*/

    @JvmStatic
    fun getBucketPath(bucketId: String): String {
        return "/storage/buckets/{bucketId}/files".replace("{bucketId}", bucketId)

    }

    @JvmStatic
    fun getFileIdPath(fileId: String, bucketId: String): String {
        return "/storage/buckets/{bucketId}/files/{fileId}".replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

    }


    @JvmStatic
    fun getDownloadPath(fileId: String, bucketId: String): String {
        return "/storage/buckets/{bucketId}/files/{fileId}/download".replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

    }

    @JvmStatic
    fun getFilePreviewPath(fileId: String, bucketId: String): String {
        return "/storage/buckets/{bucketId}/files/{fileId}/preview".replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

    }

    @JvmStatic
    fun getFileViewPath(fileId: String, bucketId: String): String {
        return "/storage/buckets/{bucketId}/files/{fileId}/view".replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)

    }


    /**Teams Paths Const*/
    const val TEAMS = "/teams"

    @JvmStatic
    fun getTeamIdPath(teamId: String): String {
        return "/teams/{teamId}".replace("{teamId}", teamId)

    }

    @JvmStatic
    fun getMembershipsPath(teamId: String): String {
        return "/teams/{teamId}/memberships".replace("{teamId}", teamId)

    }

    @JvmStatic
    fun getMembershipsIdPath(teamId: String, membershipId: String): String {
        return "/teams/{teamId}/memberships/{membershipId}".replace("{teamId}", teamId)
            .replace("{membershipId}", membershipId)
    }



    /**Locale Paths Const*/

    const val LOCALE = "/locale"
    const val LOCALE_CONTINENTS = "/locale/continents"

    const val LOCALE_COUNTRIES = "/locale/countries"
    const val LOCALE_COUNTRIES_EU = "/locale/countries/eu"


    const val LOCALE_COUNTRIES_PHONES = "/locale/countries/phones"

    const val LOCALE_CURRENCIES= "/locale/currencies"
    const val LOCALE_LANGUAGES=   "/locale/languages"



}