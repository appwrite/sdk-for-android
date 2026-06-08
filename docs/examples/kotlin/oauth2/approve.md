```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Oauth2

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProjectQuery("<YOUR_PROJECT_ID>") // Your project ID

val oauth2 = Oauth2(client)

val result = oauth2.approve(
    project_id = "<PROJECT_ID>", 
    grant_id = "<GRANT_ID>", 
    authorization_details = "<AUTHORIZATION_DETAILS>", // (optional)
)
```
