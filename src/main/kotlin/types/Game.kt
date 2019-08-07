package types

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
 * @param[animation] *Optional*. types.Animation that will be displayed in the game message in chats. Upload via [BotFather](https://t.me/botfather)
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Game @JsonCreator constructor(
    @JsonProperty("title")
    val title: String,
    @JsonProperty("description")
    val description: String,
    @JsonProperty("photo")
    val photo: Array<PhotoSize>,
    @JsonProperty("text")
    val text: String? = null,
    @JsonProperty("text_entities")
    val textEntities: Array<MessageEntity>?,
    @JsonProperty("animation")
    val animation: Animation? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (title != other.title) return false
        if (description != other.description) return false
        if (!photo.contentEquals(other.photo)) return false
        if (text != other.text) return false
        if (textEntities != null) {
            if (other.textEntities == null) return false
            if (!textEntities.contentEquals(other.textEntities)) return false
        } else if (other.textEntities != null) return false
        if (animation != other.animation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + photo.contentHashCode()
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + (textEntities?.contentHashCode() ?: 0)
        result = 31 * result + (animation?.hashCode() ?: 0)
        return result
    }
}