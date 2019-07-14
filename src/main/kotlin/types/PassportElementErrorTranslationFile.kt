package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty
import deserializer.ValueMustBe

/**
 * Represents an issue with one of the files that constitute the translation of a document. The error is considered resolved when the file changes.
 *
 * @param[source] Error source, must be *translation_file*
 * @param[type] Type of element of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”
 * @param[fileHash] Base64-encoded file hash
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorTranslationFile @JsonCreator constructor(
    @JsonProperty("source")
    @ValueMustBe("translation_file")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("file_hash")
    val fileHash: String,
    @JsonProperty("message")
    val message: String
) : PassportElementError