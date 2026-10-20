```java
import android.util.Log;

import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.exceptions.AppwriteException;
import io.appwrite.Permission;
import io.appwrite.Role;
import io.appwrite.services.VectorsDB;
import java.util.List;
import java.util.Map;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

VectorsDB vectorsDB = new VectorsDB(client);

try {
    vectorsDB.updateDocument(
        "<DATABASE_ID>", // databaseId
        "<COLLECTION_ID>", // collectionId
        "<DOCUMENT_ID>", // documentId
        Map.of("a", "b"), // data (optional)
        List.of(Permission.read(Role.any())), // permissions (optional)
        "<TRANSACTION_ID>", // transactionId (optional)
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
