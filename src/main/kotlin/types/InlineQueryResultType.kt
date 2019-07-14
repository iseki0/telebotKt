package types

import com.fasterxml.jackson.annotation.JsonValue

enum class InlineQueryResultType(@JsonValue val rawType: String) {
    ARTICLE("article"),
    PHOTO("photo"),
    GIF("gif"),
    MPEG4_GIF("mpeg4_gif"),
    VIDEO("video"),
    AUDIO("audio"),
    VOICE("voice"),
    DOCUMENT("document"),
    LOCATION("location"),
    VENUE("venue"),
    CONTACT("contact"),
    GAME("game"),
    STICKER("sticker"),
    ;
}