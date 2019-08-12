@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InlineQueryResult
import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the contact.
 *
 * @param[type] Type of the result, must be *contact*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[phoneNumber] Contact's phone number
 * @param[firstName] Contact's first name
 * @param[lastName] *Optional*. Contact's last name
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the contact
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultContact @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("id")
    @JsonProperty("id")
    val id: String,
    @get:JsonProperty("phone_number")
    @JsonProperty("phone_number")
    val phoneNumber: String,
    @get:JsonProperty("first_name")
    @JsonProperty("first_name")
    val firstName: String,
    @get:JsonProperty("last_name")
    @JsonProperty("last_name")
    val lastName: String? = null,
    @get:JsonProperty("vcard")
    @JsonProperty("vcard")
    val vcard: String? = null,
    @get:JsonProperty("reply_markup")
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @get:JsonProperty("input_message_content")
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @get:JsonProperty("thumb_url")
    @JsonProperty("thumb_url")
    val thumbUrl: String? = null,
    @get:JsonProperty("thumb_width")
    @JsonProperty("thumb_width")
    val thumbWidth: Int? = null,
    @get:JsonProperty("thumb_height")
    @JsonProperty("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult