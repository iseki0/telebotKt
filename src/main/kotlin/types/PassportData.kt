package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about Telegram Passport data shared with the bot by the user.
 *
 * @param[data] Array with information about documents and other Telegram Passport elements that was shared with the bot
 * @param[credentials] Encrypted credentials required to decrypt the data
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportData @JsonCreator constructor(
    @JsonProperty("data")
    val data: Array<EncryptedPassportElement>,
    @JsonProperty("credentials")
    val credentials: EncryptedCredentials
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PassportData

        if (!data.contentEquals(other.data)) return false
        if (credentials != other.credentials) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + credentials.hashCode()
        return result
    }
}