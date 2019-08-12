@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import api.func.editMessageText
import api.func.setGameScore
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a game. Use BotFather to create and edit games, their short names will act as unique identifiers.
 *
 * @param[title] Title of the game
 * @param[description] Description of the game
 * @param[photo] Photo that will be displayed in the game message in chats.
 * @param[text] *Optional*. Brief description of the game or high scores included in the game message. Can be automatically edited to include current high scores for the game when the bot calls [setGameScore][setGameScore], or manually edited using [editMessageText][editMessageText]. 0-4096 characters.
 * @param[textEntities] *Optional*. Special entities that appear in *text*, such as usernames, URLs, bot commands, etc.
 * @param[animation] *Optional*. Animation that will be displayed in the game message in chats. Upload via [BotFather](https://t.me/botfather)
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Game @JsonCreator constructor(
    @get:JsonProperty("title")
    @JsonProperty("title")
    val title: String,
    @get:JsonProperty("description")
    @JsonProperty("description")
    val description: String,
    @get:JsonProperty("photo")
    @JsonProperty("photo")
    val photo: List<PhotoSize>,
    @get:JsonProperty("text")
    @JsonProperty("text")
    val text: String? = null,
    @get:JsonProperty("text_entities")
    @JsonProperty("text_entities")
    val textEntities: List<MessageEntity>? = null,
    @get:JsonProperty("animation")
    @JsonProperty("animation")
    val animation: Animation? = null
)