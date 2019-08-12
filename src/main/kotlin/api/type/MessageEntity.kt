@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.MessageEntityType
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one special entity in a text message. For example, hashtags, usernames, URLs, etc.
 *
 * @param[type] Type of the entity. Can be *mention* (`@username`), *hashtag*, *cashtag*, *bot_command*, *url*, *email*, *phone_number*, *bold* (bold text), *italic* (italic text), *code* (monowidth string), *pre* (monowidth block), *text_link* (for clickable text URLs), *text_mention* (for users [without usernames](https://telegram.org/blog/edit#new-mentions))
 * @param[offset] Offset in UTF-16 code units to the start of the entity
 * @param[length] Length of the entity in UTF-16 code units
 * @param[url] *Optional*. For “text_link” only, url that will be opened after user taps on the text
 * @param[user] *Optional*. For “text_mention” only, the mentioned user
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class MessageEntity @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: MessageEntityType,
    @get:JsonProperty("offset")
    @JsonProperty("offset")
    val offset: Int,
    @get:JsonProperty("length")
    @JsonProperty("length")
    val length: Int,
    @get:JsonProperty("url")
    @JsonProperty("url")
    val url: String? = null,
    @get:JsonProperty("user")
    @JsonProperty("user")
    val user: User? = null
)