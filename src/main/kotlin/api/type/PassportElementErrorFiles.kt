@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import api.PassportElementError
import com.fasterxml.jackson.annotation.JsonCreator
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
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorFiles @JsonCreator constructor(
    @get:JsonProperty("source")
    @JsonProperty("source")
    val source: String,
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("file_hashes")
    @JsonProperty("file_hashes")
    val fileHashes: List<String>,
    @get:JsonProperty("message")
    @JsonProperty("message")
    val message: String
) : PassportElementError