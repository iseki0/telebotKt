@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about Telegram Passport data shared with the bot by the user.
 *
 * @param[data] Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @param[credentials] Encrypted credentials required to decrypt the data
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportData @JsonCreator constructor(
    @get:JsonProperty("data")
    @JsonProperty("data")
    val data: List<EncryptedPassportElement>,
    @get:JsonProperty("credentials")
    @JsonProperty("credentials")
    val credentials: EncryptedCredentials
)