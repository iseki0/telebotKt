package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue with a list of scans. The error is considered resolved when the list of files containing the scans changes.
 *
 * @param[source] Error source, must be *files*
 * @param[type] The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @param[fileHashes] List of base64-encoded file hashes
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorFiles @JsonCreator constructor(
    @JsonProperty("source")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("file_hashes")
    val fileHashes: Array<String>,
    @JsonProperty("message")
    val message: String
) : PassportElementError {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PassportElementErrorFiles

        if (source != other.source) return false
        if (type != other.type) return false
        if (!fileHashes.contentEquals(other.fileHashes)) return false
        if (message != other.message) return false

        return true
    }

    override fun hashCode(): Int {
        var result = source.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + fileHashes.contentHashCode()
        result = 31 * result + message.hashCode()
        return result
    }
}