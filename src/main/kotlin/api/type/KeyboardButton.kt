@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one button of the reply keyboard. For simple text buttons *String* can be used instead of this object to specify text of the button. Optional fields are mutually exclusive.
 *
 * @param[text] Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @param[requestContact] *Optional*. If *True*, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
 * @param[requestLocation] *Optional*. If *True*, the user's current location will be sent when the button is pressed. Available in private chats only
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class KeyboardButton @JsonCreator constructor(
    @get:JsonProperty("text")
    @JsonProperty("text")
    val text: String,
    @get:JsonProperty("request_contact")
    @JsonProperty("request_contact")
    val requestContact: Boolean? = null,
    @get:JsonProperty("request_location")
    @JsonProperty("request_location")
    val requestLocation: Boolean? = null
)