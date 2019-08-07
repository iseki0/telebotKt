package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents a contact with a phone number. By default, this contact will be sent by the user. Alternatively, you can use *input_message_content* to send a message with the specified content instead of the contact.
 * **Note:** This will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.
 *
 * @param[type] Type of the result, must be *contact*
 * @param[id] Unique identifier for this result, 1-64 Bytes
 * @param[phoneNumber] types.Contact's phone number
 * @param[firstName] types.Contact's first name
 * @param[lastName] *Optional*. types.Contact's last name
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 * @param[replyMarkup] *Optional*. [Inline keyboard](https://core.telegram.org/bots#inline-keyboards-and-on-the-fly-updating) attached to the message
 * @param[inputMessageContent] *Optional*. Content of the message to be sent instead of the contact
 * @param[thumbUrl] *Optional*. Url of the thumbnail for the result
 * @param[thumbWidth] *Optional*. Thumbnail width
 * @param[thumbHeight] *Optional*. Thumbnail height
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InlineQueryResultContact @JsonCreator constructor(
    @ValueMustBe("contact")
    @JsonProperty("type")
    val type: String = "contact",
    @JsonProperty("id")
    val id: String,
    @JsonProperty("phone_number")
    val phoneNumber: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String? = null,
    @JsonProperty("vcard")
    val vcard: String? = null,
    @JsonProperty("reply_markup")
    val replyMarkup: InlineKeyboardMarkup? = null,
    @JsonProperty("input_message_content")
    val inputMessageContent: InputMessageContent? = null,
    @JsonProperty("thumb_url")
    val thumbUrl: String? = null,
    @JsonProperty("thumb_width")
    val thumbWidth: Int? = null,
    @JsonProperty("thumb_height")
    val thumbHeight: Int? = null
) : InlineQueryResult