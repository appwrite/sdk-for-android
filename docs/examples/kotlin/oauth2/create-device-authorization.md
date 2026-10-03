```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.createDeviceAuthorization(
    clientId = "<CLIENT_ID>", // (optional)
    scope = "<SCOPE>", // (optional)
    authorizationDetails = "<AUTHORIZATION_DETAILS>", // (optional)
    resource = "", // (optional)
    audience = "<AUDIENCE>", // (optional)
)
```
