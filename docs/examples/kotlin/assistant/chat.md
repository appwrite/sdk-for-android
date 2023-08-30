import io.appwrite.Client
import io.appwrite.services.Assistant

val client = Client(context)
    .setEndpoint("https://cloud.appwrite.io/v1") // Your API Endpoint
    .setProject("5df5acd0d48c2") // Your project ID

val assistant = Assistant(client)

val response = assistant.chat(
    prompt = "[PROMPT]"
)
