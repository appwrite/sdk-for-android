```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.logout(
    idTokenHint = "<ID_TOKEN_HINT>", // (optional)
    logoutHint = "<LOGOUT_HINT>", // (optional)
    clientId = "<CLIENT_ID>", // (optional)
    postLogoutRedirectUri = "https://example.com", // (optional)
    state = "<STATE>", // (optional)
    uiLocales = "<UI_LOCALES>", // (optional)
)
```
