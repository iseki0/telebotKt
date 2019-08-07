package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents one button of the reply keyboard. For simple text buttons *String* can be used instead of this object to specify text of the button. Optional fields are mutually exclusive.
 * **Note:** *request_contact* and *request_location* options will only work in Telegram versions released after 9 April, 2016. Older clients will ignore them.
 *
 * @param[text] Text of the button. If none of the optional fields are used, it will be sent as a message when the button is pressed
 * @param[requestContact] *Optional*. If *True*, the user's phone number will be sent as a contact when the button is pressed. Available in private chats only
 * @param[requestLocation] *Optional*. If *True*, the user's current location will be sent when the button is pressed. Available in private chats only
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class KeyboardButton @JsonCreator constructor(
    @JsonProperty("text")
    val text: String,
    @JsonProperty("request_contact")
    val requestContact: Boolean? = null,
    @JsonProperty("request_location")
    val requestLocation: Boolean? = null
)