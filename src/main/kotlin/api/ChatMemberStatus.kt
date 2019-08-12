package api

import com.fasterxml.jackson.annotation.JsonValue

enum class ChatMemberStatus(@JsonValue val rawString: String) {
    CREATOR("creator"),
    ADMIN("administrator"),
    MEMBER("member"),
    RESTRICTED("restricted"),
    LEFT("left"),
    KICKED("kicked")
}