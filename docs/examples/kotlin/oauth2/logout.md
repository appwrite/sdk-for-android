```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.logout(
    id_token_hint = "<ID_TOKEN_HINT>", // (optional)
    logout_hint = "<LOGOUT_HINT>", // (optional)
    client_id = "<CLIENT_ID>", // (optional)
    post_logout_redirect_uri = "https://example.com", // (optional)
    state = "<STATE>", // (optional)
    ui_locales = "<UI_LOCALES>", // (optional)
)
```
