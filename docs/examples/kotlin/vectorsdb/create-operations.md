```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val vectorsDB = VectorsDB(client)

val result = vectorsDB.createOperations(
    transactionId = "<TRANSACTION_ID>", 
    operations = listOf(mapOf(
        "action" to "create",
        "databaseId" to "<DATABASE_ID>",
        "collectionId" to "<COLLECTION_ID>",
        "documentId" to "<DOCUMENT_ID>",
        "data" to mapOf(
            "name" to "Walter O'Brien"
        )
    )), // (optional)
)
```
