```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.DocumentsDB

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val documentsDB = DocumentsDB(client)

val result = documentsDB.decrementDocumentAttribute(
    databaseId = "<DATABASE_ID>", 
    collectionId = "<COLLECTION_ID>", 
    documentId = "<DOCUMENT_ID>", 
    attribute = "", 
    value = 0, // (optional)
    min = 0, // (optional)
    transactionId = "<TRANSACTION_ID>", // (optional)
)
```
