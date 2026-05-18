```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Advisor

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val advisor = Advisor(client)

val result = advisor.listInsights(
    reportId = "<REPORT_ID>", 
    queries = listOf(), // (optional)
    total = false, // (optional)
)
```
