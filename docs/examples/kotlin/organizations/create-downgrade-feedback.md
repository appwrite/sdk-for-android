```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organizations

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val organizations = Organizations(client)

val result = organizations.createDowngradeFeedback(
    organizationId = "<ORGANIZATION_ID>", 
    reason = "<REASON>", 
    message = "<MESSAGE>", 
    fromPlanId = "<FROM_PLAN_ID>", 
    toPlanId = "<TO_PLAN_ID>", 
)
```
