```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.authorizePost(
    clientId = "<CLIENT_ID>", // (optional)
    redirectUri = "https://example.com", // (optional)
    responseType = "", // (optional)
    scope = "<SCOPE>", // (optional)
    state = "<STATE>", // (optional)
    nonce = "<NONCE>", // (optional)
    codeChallenge = "<CODE_CHALLENGE>", // (optional)
    codeChallengeMethod = "s256", // (optional)
    prompt = "<PROMPT>", // (optional)
    maxAge = 0, // (optional)
    authorizationDetails = "<AUTHORIZATION_DETAILS>", // (optional)
    resource = listOf(), // (optional)
    audience = "<AUDIENCE>", // (optional)
    requestUri = "<REQUEST_URI>", // (optional)
)
```
