package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object represents a file ready to be downloaded. The file can be downloaded via the link  `https://api.telegram.org/file/bot<token>/<file_path>` . It is guaranteed that the link will be valid for at least 1 hour. When the link expires, a new one can be requested by calling [getFile][getFile].
 * Maximum file size to download is 20 MB
 *
 * @param[fileId] Unique identifier for this file
 * @param[fileSize] *Optional*. types.File size, if known
 * @param[filePath] *Optional*. types.File path. Use  `https://api.telegram.org/file/bot<token>/<file_path>`  to get the file.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class File @JsonCreator constructor(
    @JsonProperty("file_id")
    val fileId: FileId,
    @JsonProperty("file_size")
    val fileSize: Int? = null,
    @JsonProperty("file_path")
    val filePath: String? = null
)