@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains data required for decrypting and authenticating [EncryptedPassportElement][EncryptedPassportElement]. See the [Telegram Passport Documentation](https://core.telegram.org/passport#receiving-information) for a complete description of the data decryption and authentication processes.
 *
 * @param[data] Base64-encoded encrypted JSON-serialized data with unique user's payload, data hashes and secrets required for [EncryptedPassportElement][EncryptedPassportElement] decryption and authentication
 * @param[hash] Base64-encoded data hash for data authentication
 * @param[secret] Base64-encoded secret, encrypted with the bot's public RSA key, required for data decryption
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class EncryptedCredentials @JsonCreator constructor(
    @get:JsonProperty("data")
    @JsonProperty("data")
    val data: String,
    @get:JsonProperty("hash")
    @JsonProperty("hash")
    val hash: String,
    @get:JsonProperty("secret")
    @JsonProperty("secret")
    val secret: String
)