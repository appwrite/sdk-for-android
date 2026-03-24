```java
import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.DocumentsDB;

Client client = new Client(context)
    .setEndpoint("https://<REGION>.cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("<YOUR_PROJECT_ID>"); // Your project ID

DocumentsDB documentsDB = new DocumentsDB(client);

documentsDB.updateTransaction(
    "<TRANSACTION_ID>", // transactionId 
    false, // commit (optional)
    false, // rollback (optional)
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

```
