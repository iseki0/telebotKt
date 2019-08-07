package types

import com.fasterxml.jackson.annotation.JsonValue

enum class ChatMemberStatus(@JsonValue val rawString: String) {
    CREATOR("creator"),
    ADMINISTRATOR("administrator"),
    MEMBER("member"),
    RESTRICTED("restricted"),
    LEFT("left"),
    KICKED("kicked")
}