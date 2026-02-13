```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Organizations

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val organizations = Organizations(client)

val result = organizations.getPaymentMethod(
    organizationId = "<ORGANIZATION_ID>", 
    paymentMethodId = "<PAYMENT_METHOD_ID>", 
)
```
