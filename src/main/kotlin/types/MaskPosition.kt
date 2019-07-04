package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * This object describes the position on faces where a mask should be placed by default.
 *
 * @param[point] The part of the face relative to which the mask should be placed. One of “forehead”, “eyes”, “mouth”, or “chin”.
 * @param[xShift] Shift by X-axis measured in widths of the mask scaled to the face size, from left to right. For example, choosing -1.0 will place mask just to the left of the default mask position.
 * @param[yShift] Shift by Y-axis measured in heights of the mask scaled to the face size, from top to bottom. For example, 1.0 will place the mask just below the default mask position.
 * @param[scale] Mask scaling coefficient. For example, 2.0 means double size.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class MaskPosition @JsonCreator constructor(
    @JsonProperty("point")
    val point: String,
    @JsonProperty("x_shift")
    val xShift: Double,
    @JsonProperty("y_shift")
    val yShift: Double,
    @JsonProperty("scale")
    val scale: Double
)