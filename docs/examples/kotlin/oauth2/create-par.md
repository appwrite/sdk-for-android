```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.createPAR(
    client_id = "<CLIENT_ID>", 
    redirect_uri = "https://example.com", 
    response_type = "code", 
    scope = "<SCOPE>", // (optional)
    state = "<STATE>", // (optional)
    nonce = "<NONCE>", // (optional)
    code_challenge = "<CODE_CHALLENGE>", // (optional)
    code_challenge_method = "s256", // (optional)
    prompt = "<PROMPT>", // (optional)
    max_age = 0, // (optional)
    authorization_details = "<AUTHORIZATION_DETAILS>", // (optional)
    resource = "", // (optional)
    audience = "<AUDIENCE>", // (optional)
)
```
