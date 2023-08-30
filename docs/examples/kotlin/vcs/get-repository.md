import io.appwrite.Client
import io.appwrite.services.Vcs

val client = Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID

val vcs = Vcs(client)

val response = vcs.getRepository(
    installationId = "[INSTALLATION_ID]",
    providerRepositoryId = "[PROVIDER_REPOSITORY_ID]"
)
