import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Functions;

Client client = new Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2"); // Your project ID

Functions functions = new Functions(client);

functions.getExecution(
    "<FUNCTION_ID>", // functionId 
    "<EXECUTION_ID>", // executionId 
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);

