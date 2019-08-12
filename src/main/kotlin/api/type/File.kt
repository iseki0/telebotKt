@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.func.getFile
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link `https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;`. It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling [getFile][getFile].
 * >  Maximum file size to download is 20 MB
 *
 * @param[fileId] Identifier for this file
 * @param[fileSize] *Optional*. File size, if known
 * @param[filePath] *Optional*. File path. Use `https://api.telegram.org/file/bot&lt;token&gt;/&lt;file_path&gt;` to get the file.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
data class File @JsonCreator constructor(
    @get:JsonProperty("file_id")
    @JsonProperty("file_id")
    val fileId: String,
    @get:JsonProperty("file_size")
    @JsonProperty("file_size")
    val fileSize: Int? = null,
    @get:JsonProperty("file_path")
    @JsonProperty("file_path")
    val filePath: String? = null
)