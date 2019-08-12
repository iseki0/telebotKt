@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.PassportElementError
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue in an unspecified place. The error is considered resolved when new data is added.
 *
 * @param[source] Error source, must be *unspecified*
 * @param[type] Type of element of the user's Telegram Passport which has the issue
 * @param[elementHash] Base64-encoded element hash
 * @param[message] Error message
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorUnspecified @JsonCreator constructor(
    @get:JsonProperty("source")
    @JsonProperty("source")
    val source: String,
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: String,
    @get:JsonProperty("element_hash")
    @JsonProperty("element_hash")
    val elementHash: String,
    @get:JsonProperty("message")
    @JsonProperty("message")
    val message: String
) : PassportElementError
