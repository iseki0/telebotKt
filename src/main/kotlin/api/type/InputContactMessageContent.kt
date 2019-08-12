@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.InputMessageContent
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content](https://core.telegram.org#inputmessagecontent) of a contact message to be sent as the result of an inline query.
 *
 * @param[phoneNumber] Contact's phone number
 * @param[firstName] Contact's first name
 * @param[lastName] *Optional*. Contact's last name
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputContactMessageContent @JsonCreator constructor(
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
    val vcard: String? = null
) : InputMessageContent