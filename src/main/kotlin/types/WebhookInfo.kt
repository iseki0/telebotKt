@file:Suppress("unused")

package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about the current status of a webhook.
 * All types used in the Bot API responses are represented as JSON-objects.
 * It is safe to use 32-bit signed integers for storing all **Integer** fields unless otherwise noted.
 * **Optional** fields may be not returned when irrelevant.
 *
 * @param[url] Webhook URL, may be empty if webhook is not set up
 * @param[hasCustomCertificate] True, if a custom certificate was provided for webhook certificate checks
 * @param[pendingUpdateCount] Number of updates awaiting delivery
 * @param[lastErrorDate] *Optional*. Unix time for the most recent error that happened when trying to deliver an update via webhook
 * @param[lastErrorMessage] *Optional*. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
 * @param[maxConnections] *Optional*. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
 * @param[allowedUpdates] *Optional*. A list of update types the bot is subscribed to. Defaults to all update types
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class WebhookInfo @JsonCreator constructor(
    @JsonProperty("url")
    val url: String,
    @JsonProperty("has_custom_certificate")
    val hasCustomCertificate: Boolean,
    @JsonProperty("pending_update_count")
    val pendingUpdateCount: Int,
    @JsonProperty("last_error_date")
    val lastErrorDate: Int?,
    @JsonProperty("last_error_message")
    val lastErrorMessage: String?,
    @JsonProperty("max_connections")
    val maxConnections: Int?,
    @JsonProperty("allowed_updates")
    val allowedUpdates: Array<String>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as WebhookInfo

        if (url != other.url) return false
        if (hasCustomCertificate != other.hasCustomCertificate) return false
        if (pendingUpdateCount != other.pendingUpdateCount) return false
        if (lastErrorDate != other.lastErrorDate) return false
        if (lastErrorMessage != other.lastErrorMessage) return false
        if (maxConnections != other.maxConnections) return false
        if (allowedUpdates != null) {
            if (other.allowedUpdates == null) return false
            if (!allowedUpdates.contentEquals(other.allowedUpdates)) return false
        } else if (other.allowedUpdates != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = url.hashCode()
        result = 31 * result + hasCustomCertificate.hashCode()
        result = 31 * result + pendingUpdateCount
        result = 31 * result + (lastErrorDate ?: 0)
        result = 31 * result + (lastErrorMessage?.hashCode() ?: 0)
        result = 31 * result + (maxConnections ?: 0)
        result = 31 * result + (allowedUpdates?.contentHashCode() ?: 0)
        return result
    }
}