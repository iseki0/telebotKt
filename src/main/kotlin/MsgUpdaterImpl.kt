import api.func.getUpdates

class MsgUpdaterImpl(val botServer: BotServer, val delay: Long = 200, val timeout: Int = 15) {
    val context = botServer.getApiContext()
    val vertx = botServer.vertx
    var timerId: Long = 0
    var offset = -1
    fun setTimer() {
        timerId = vertx.setTimer(delay) {
            update()
            setTimer()
        }
    }

    fun start() = setTimer()

    private fun update() {
        botServer.getApiContext().getUpdates(offset = offset + 1, timeout = timeout, allowedUpdates = emptyList()) {
            if (it.succeeded()) {
                val result = it.result()!!.result!!
                result.forEach {
                    offset = if (it.updateId > offset) it.updateId else offset
                    botServer.dispatchUpdate(it)
                }
            } else {
                println(it.cause())
            }
        }
    }
}