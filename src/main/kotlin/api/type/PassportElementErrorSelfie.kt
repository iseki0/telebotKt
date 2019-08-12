@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.PassportElementError
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue with the selfie with a document. The error is considered resolved when the file with the selfie changes.
 *
 * @param[source] Error source, must be *selfie*
 * @param[type] The section of the user's Telegram Passport which has the issue, one of “passport”, “driver_license”, “identity_card”, “internal_passport”
 * @param[fileHash] Base64-encoded hash of the file with the selfie
 * @param[message] Error message
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorSelfie @JsonCreator constructor(
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