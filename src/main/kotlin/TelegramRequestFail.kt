import api.ResultType

class TelegramRequestFail(val errorCode: Int, val description: String) :
    RuntimeException("""[$errorCode]: $description""") {
    constructor(resultType: ResultType) : this(resultType.errorCode ?: -1, resultType.description ?: "Unknown.")
}