```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.createToken(
    grant_type = "<GRANT_TYPE>", 
    code = "<CODE>", // (optional)
    refresh_token = "<REFRESH_TOKEN>", // (optional)
    device_code = "<DEVICE_CODE>", // (optional)
    client_id = "<CLIENT_ID>", // (optional)
    client_secret = "<CLIENT_SECRET>", // (optional)
    code_verifier = "<CODE_VERIFIER>", // (optional)
    redirect_uri = "https://example.com", // (optional)
    resource = "", // (optional)
    audience = "<AUDIENCE>", // (optional)
)
```
