```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val apps = Apps(client)

val result = apps.update(
    appId = "<APP_ID>", 
    name = "<NAME>", 
    description = "<DESCRIPTION>", // (optional)
    clientUri = "https://example.com", // (optional)
    logoUri = "https://example.com", // (optional)
    privacyPolicyUrl = "https://example.com", // (optional)
    termsUrl = "https://example.com", // (optional)
    contacts = listOf(), // (optional)
    tagline = "<TAGLINE>", // (optional)
    tags = listOf(), // (optional)
    images = listOf(), // (optional)
    supportUrl = "https://example.com", // (optional)
    dataDeletionUrl = "https://example.com", // (optional)
    enabled = false, // (optional)
    redirectUris = listOf(), // (optional)
    postLogoutRedirectUris = listOf(), // (optional)
    type = "public", // (optional)
    deviceFlow = false, // (optional)
    installationScopes = listOf(), // (optional)
    installationRedirectUrl = "https://example.com", // (optional)
)
```
