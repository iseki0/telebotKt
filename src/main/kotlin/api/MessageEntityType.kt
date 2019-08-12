package api

import com.fasterxml.jackson.annotation.JsonValue

enum class MessageEntityType(@JsonValue val rawString: String) {
    MENTION("mention"),
    HASHTAG("hashtag"),
    CASHTAG("cashtag"),
    BOT_COMMAND("bot_command"),
    URL("url"),
    EMAIL("email"),
    PHONE_NUMBER("phone_number"),
    BOLD("bold"),
    ITALIC("italic"),
    CODE("code"),
    PRE("pre"),
    TEXT_LINK("text_link"),
    TEXT_MENTION("text_mention")
}