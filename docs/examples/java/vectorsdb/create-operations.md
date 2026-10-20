```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.services.VectorsDB;
import java.util.List;
import java.util.Map;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

VectorsDB vectorsDB = new VectorsDB(client);

try {
    vectorsDB.createOperations(
        "<TRANSACTION_ID>", // transactionId
        List.of(Map.of(
            "action", "create",
            "databaseId", "<DATABASE_ID>",
            "collectionId", "<COLLECTION_ID>",
            "documentId", "<DOCUMENT_ID>",
            "data", Map.of(
                "embeddings", List.of(0.12, -0.55, 0.88, 1.02),
                "metadata", Map.of(
                    "name", "First document"
                )
            )
        )), // operations (optional)
        new CoroutineCallback<>((result, error) -> {
            if (error != null) {
                error.printStackTrace();
                return;
            }

            Log.d("Appwrite", result.toString());
        })
    );
} catch (AppwriteException e) {
    e.printStackTrace();
}
```
