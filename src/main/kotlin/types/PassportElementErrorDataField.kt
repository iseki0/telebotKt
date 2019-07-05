package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Represents an issue in one of the data fields that was provided by the user. The error is considered resolved when the field's value changes.
 *
 * @param[source] Error source, must be *data*
 * @param[type] The section of the user's Telegram Passport which has the error, one of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”
 * @param[fieldName] Name of the data field which has the error
 * @param[dataHash] Base64-encoded data hash
 * @param[message] Error message
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportElementErrorDataField @JsonCreator constructor(
    @JsonProperty("source")
    val source: String,
    @JsonProperty("type")
    val type: String,
    @JsonProperty("field_name")
    val fieldName: String,
    @JsonProperty("data_hash")
    val dataHash: String,
    @JsonProperty("message")
    val message: String
) : PassportElementError