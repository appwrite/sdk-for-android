import io.appwrite.Client;
import io.appwrite.coroutines.CoroutineCallback;
import io.appwrite.services.Vcs;

Client client = new Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2"); // Your project ID

Vcs vcs = new Vcs(client);

vcs.updateExternalDeployments(
    "[INSTALLATION_ID]",
    "[REPOSITORY_ID]",
    "[PROVIDER_PULL_REQUEST_ID]"
    new CoroutineCallback<>((result, error) -> {
        if (error != null) {
            error.printStackTrace();
            return;
        }

        Log.d("Appwrite", result.toString());
    })
);
