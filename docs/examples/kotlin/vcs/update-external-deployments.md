import io.appwrite.Client
import io.appwrite.services.Vcs

val client = Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID

val vcs = Vcs(client)

val response = vcs.updateExternalDeployments(
    installationId = "[INSTALLATION_ID]",
    repositoryId = "[REPOSITORY_ID]",
    providerPullRequestId = "[PROVIDER_PULL_REQUEST_ID]"
)