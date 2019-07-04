package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents the [content][InputMessageContent] of a contact message to be sent as the result of an inline query.
 *
 * @param[phoneNumber] types.Contact's phone number
 * @param[firstName] types.Contact's first name
 * @param[lastName] *Optional*. types.Contact's last name
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard), 0-2048 bytes
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class InputContactMessageContent @JsonCreator constructor(
    @JsonProperty("phone_number")
    val phoneNumber: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String?,
    @JsonProperty("vcard")
    val vcard: String?
)