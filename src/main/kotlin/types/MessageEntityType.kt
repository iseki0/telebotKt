package types

import com.fasterxml.jackson.annotation.JsonValue

enum class MessageEntityType(@JsonValue val rawType: String) {
    MENTION("mention"),
    HASHTAG("hashtag"),
    CASHTAG("cashtag"),
    BOT_COMMAND("bot_command"),
    URL("url"),
    EMAIL("email"),
    PHONE_NUMBER("phone_number"),
    BOLD_TEXT("bold"),
    ITALIC_TEXT("italic"),
    CODE_TEXT("code"),
    PRE_BLOCK("pre"),
    TEXT_LINK("text_link"),
    TEXT_MENTION("text_mention"),
}