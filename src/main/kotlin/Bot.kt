import api.type.Update
import com.fasterxml.jackson.databind.ObjectMapper
import io.vertx.core.Vertx

interface Bot {
    val botOption: BotOption
    val vertx: Vertx
    val mapper: ObjectMapper
    var updateHandler: (update: Update) -> Unit
}