@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.HasList
import api.UpdateType
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about the current status of a webhook.
 *
 * @param[url] Webhook URL, may be empty if webhook is not set up
 * @param[hasCustomCertificate] True, if a custom certificate was provided for webhook certificate checks
 * @param[pendingUpdateCount] Number of updates awaiting delivery
 * @param[lastErrorDate] *Optional*. Unix time for the most recent error that happened when trying to deliver an update via webhook
 * @param[lastErrorMessage] *Optional*. Error message in human-readable format for the most recent error that happened when trying to deliver an update via webhook
 * @param[maxConnections] *Optional*. Maximum allowed number of simultaneous HTTPS connections to the webhook for update delivery
 * @param[updateTypes] *Optional*. A list of update types the bot is subscribed to. Defaults to all update types
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class WebhookInfo @JsonCreator constructor(
    @get:JsonProperty("url")
    @JsonProperty("url")
    val url: String,
    @get:JsonProperty("has_custom_certificate")
    @JsonProperty("has_custom_certificate")
    val hasCustomCertificate: Boolean,
    @get:JsonProperty("pending_update_count")
    @JsonProperty("pending_update_count")
    val pendingUpdateCount: Int,
    @get:JsonProperty("last_error_date")
    @JsonProperty("last_error_date")
    val lastErrorDate: Int? = null,
    @get:JsonProperty("last_error_message")
    @JsonProperty("last_error_message")
    val lastErrorMessage: String? = null,
    @get:JsonProperty("max_connections")
    @JsonProperty("max_connections")
    val maxConnections: Int? = null,
    @get:JsonProperty("allowed_updates")
    @JsonProperty("allowed_updates")
    val updateTypes: List<UpdateType>? = null
)