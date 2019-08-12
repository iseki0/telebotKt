@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.PassportElementError
import com.fasterxml.jackson.annotation.JsonCreator
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

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorFile @JsonCreator constructor(
    @get:JsonProperty("source")
    @JsonProperty("source")
    val source: String,
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("file_hash")
    @JsonProperty("file_hash")
    val fileHash: String,
    @get:JsonProperty("message")
    @JsonProperty("message")
    val message: String
) : PassportElementError