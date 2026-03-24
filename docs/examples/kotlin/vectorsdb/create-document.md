```kotlin
import io.appwrite.Client
import io.appwrite.coroutines.CoroutineCallback
import io.appwrite.services.VectorsDB
import io.appwrite.Permission
import io.appwrite.Role

val client = Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>") // Your project ID

val vectorsDB = VectorsDB(client)

val result = vectorsDB.createDocument(
    databaseId = "<DATABASE_ID>", 
    collectionId = "<COLLECTION_ID>", 
    documentId = "<DOCUMENT_ID>", 
    data = mapOf(
        "embeddings" to listOf(0.12, -0.55, 0.88, 1.02),
        "metadata" to mapOf(
            "key" to "value"
        )
    ), 
    permissions = listOf(Permission.read(Role.any())), // (optional)
)
```
