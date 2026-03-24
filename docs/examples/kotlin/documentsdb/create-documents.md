```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.DocumentsDB

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val documentsDB = DocumentsDB(client)

val result = documentsDB.createDocuments(
    databaseId = "<DATABASE_ID>", 
    collectionId = "<COLLECTION_ID>", 
    documents = listOf(), 
)
```
