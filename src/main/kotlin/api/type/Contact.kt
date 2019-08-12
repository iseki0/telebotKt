@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a phone contact.
 *
 * @param[phoneNumber] Contact's phone number
 * @param[firstName] Contact's first name
 * @param[lastName] *Optional*. Contact's last name
 * @param[userId] *Optional*. Contact's user identifier in Telegram
 * @param[vcard] *Optional*. Additional data about the contact in the form of a [vCard](https://en.wikipedia.org/wiki/VCard)
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Contact @JsonCreator constructor(
    @get:JsonProperty("phone_number")
    @JsonProperty("phone_number")
    val phoneNumber: String,
    @get:JsonProperty("first_name")
    @JsonProperty("first_name")
    val firstName: String,
    @get:JsonProperty("last_name")
    @JsonProperty("last_name")
    val lastName: String? = null,
    @get:JsonProperty("user_id")
    @JsonProperty("user_id")
    val userId: Int? = null,
    @get:JsonProperty("vcard")
    @JsonProperty("vcard")
    val vcard: String? = null
)