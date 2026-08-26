```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organization

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val organization = Organization(client)

val result = organization.updateInstallation(
    installationId = "<INSTALLATION_ID>", 
    authorizationDetails = "<AUTHORIZATION_DETAILS>", // (optional)
)
```
