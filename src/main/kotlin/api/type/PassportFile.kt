@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a file uploaded to Telegram Passport. Currently all Telegram Passport files are in JPEG format when decrypted and don't exceed 10MB.
 *
 * @param[fileId] Identifier for this file
 * @param[fileSize] File size
 * @param[fileDate] Unix time when the file was uploaded
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class PassportFile @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int,
    @get:JsonProperty("file_date")
    @JsonProperty("file_date")
    val fileDate: Int
)