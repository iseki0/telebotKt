package api

import com.fasterxml.jackson.annotation.JsonValue

enum class ChatType(@JsonValue val rawString: String) {
    PRIVATE("private"),
    GROUP("group"),
    SUPERGROUP("supergroup"),
    CHANNEL("channel")
}