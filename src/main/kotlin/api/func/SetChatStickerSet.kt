@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.*
import io.vertx.core.AsyncResult
import io.vertx.core.Future

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field *can_set_sticker_set* optionally returned in [getChat][getChat] requests to check if the bot can use this method. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format `@supergroupusername`)
 * @param[stickerSetName] Name of the sticker set to be set as the group sticker set
 */
fun ApiContext.setChatStickerSet(
    chatId: String,
    stickerSetName: String
): Future<SetChatStickerSetResult?> = sendRequest<SetChatStickerSetResult?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName))
)

fun ApiContext.setChatStickerSet(
    chatId: String,
    stickerSetName: String,
    callback: (result: AsyncResult<SetChatStickerSetResult?>) -> Unit
): ApiContext = sendRequestCallback<SetChatStickerSetResult?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName)),
    callback
)

suspend fun ApiContext.setChatStickerSetAwait(
    chatId: String,
    stickerSetName: String
): SetChatStickerSetResult? = sendRequestAwait<SetChatStickerSetResult?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName))
)