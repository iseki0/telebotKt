data class BotVerticleConfig(
    val botToken: String,
    val webhookUrl: String =botToken,
    val webhookLocalPort: Int = 8888,
    val enableWebhookMode:Boolean=true //now only support it.
)