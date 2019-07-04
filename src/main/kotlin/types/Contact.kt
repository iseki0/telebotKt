package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a phone contact.
 *
 * @param[phoneNumber] types.Contact's phone number
 * @param[firstName] types.Contact's first name
 * @param[lastName] *Optional*. types.Contact's last name
 * @param[userId] *Optional*. types.Contact's user identifier in Telegram
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class Contact @JsonCreator constructor(
    @JsonProperty("phone_number")
    val phoneNumber: String,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String?,
    @JsonProperty("user_id")
    val userId: Int?,
    @JsonProperty("vcard")
    val vcard: String?
)