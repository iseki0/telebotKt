package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue with a document scan. The error is considered resolved when the file with the document scan changes.
 *
 * @param[source] Error source, must be *file*
 * @param[type] The section of the user's Telegram Passport which has the issue, one of “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @param[fileHash] Base64-encoded file hash
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorFile @JsonCreator constructor(
    @JsonProperty("source")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("file_hash")
    val fileHash: String,
    @JsonProperty("message")
    val message: String
)