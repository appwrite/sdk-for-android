```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.VectorsDB;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

VectorsDB vectorsDB = new VectorsDB(client);

vectorsDB.createDocument(
    "<DATABASE_ID>", // databaseId 
    "<COLLECTION_ID>", // collectionId 
    "<DOCUMENT_ID>", // documentId 
    Map.of(
        "embeddings", List.of(0.12, -0.55, 0.88, 1.02),
        "metadata", Map.of(
            "key", "value"
        )
    ), // data 
    List.of(Permission.read(Role.any())), // permissions (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
