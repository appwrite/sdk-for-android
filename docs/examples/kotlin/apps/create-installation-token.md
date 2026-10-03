```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Apps

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val apps = Apps(client)

val result = apps.createInstallationToken(
    appId = "<APP_ID>", 
    installationId = "<INSTALLATION_ID>", 
)
```
