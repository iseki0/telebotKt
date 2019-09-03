package api

import TelegramRequestFail

interface ResultType {
    val ok: Boolean
    val errorCode: Int?
    val description: String?
}

fun ResultType.okOrThrow() {
    if (!this.ok) throw TelegramRequestFail(errorCode ?: -1, description ?: "Unknown.")
}