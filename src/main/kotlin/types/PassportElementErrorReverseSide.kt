package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue with the reverse side of a document. The error is considered resolved when the file with reverse side of the document changes.
 *
 * @param[source] Error source, must be *reverse_side*
 * @param[type] The section of the user's Telegram Passport which has the issue, one of “driver_license”, “identity_card”
 * @param[fileHash] Base64-encoded hash of the file with the reverse side of the document
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorReverseSide @JsonCreator constructor(
    @JsonProperty("source")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("file_hash")
    val fileHash: String,
    @JsonProperty("message")
    val message: String
) : PassportElementError