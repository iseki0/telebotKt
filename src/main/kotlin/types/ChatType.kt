package types

import com.fasterxml.jackson.annotation.JsonValue

enum class ChatType(@JsonValue val rawType: String) {
    PRIVATE("private"),
    GROUP("group"),
    SUPERGROUP("supergroup"),
    CHANNEL("channel")
}