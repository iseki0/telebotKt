class MsgUpdaterImpl(val botServer: BotServer) {
    val context = botServer.getApiContext()
    val vertx = botServer.vertx
}