import io.vertx.ext.web.client.WebClientOptions

class BotOption(
    val botKey: String,
    val webClientOptions: WebClientOptions,
    val botServerInfo: BotServerInfo = BotServerInfo()
)

data class BotServerInfo(
    val urlGenerator: (botKey: String, api: String) -> String = { botKey: String, api: String ->
        "https://api.telegram.org/bot$botKey/$api"
    }
)