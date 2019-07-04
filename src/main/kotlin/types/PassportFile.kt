package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 *
 * @param[fileId] Unique identifier for this file
 * @param[fileSize] types.File size
 * @param[fileDate] Unix time when the file was uploaded
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportFile @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: String,
    @JsonProperty("file_size")
    val fileSize: Int,
    @JsonProperty("file_date")
    val fileDate: Int
)