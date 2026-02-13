```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.Account

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val account = Account(client)

val result = account.updatePaymentMethod(
    paymentMethodId = "<PAYMENT_METHOD_ID>", 
    expiryMonth = 1, 
    expiryYear = 2026, 
    state = "<STATE>", // (optional)
)
```
