```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val vectorsDB = VectorsDB(client)

val result = vectorsDB.getDocument(
    databaseId = "<DATABASE_ID>", 
    collectionId = "<COLLECTION_ID>", 
    documentId = "<DOCUMENT_ID>", 
    queries = listOf(), // (optional)
    transactionId = "<TRANSACTION_ID>", // (optional)
)
```
