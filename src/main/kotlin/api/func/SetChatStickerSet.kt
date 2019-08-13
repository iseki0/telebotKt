@file:Suppress("RemoveExplicitTypeArguments", "DuplicatedCode", "unused", "SpellCheckingInspection")

package api.func

import api.type.*
import api.*
import io.vertx.core.Future
import io.vertx.core.AsyncResult

/**
 * Use this method to set a new group sticker set for a supergroup. The bot must be an administrator in the chat for this to work and must have the appropriate admin rights. Use the field *can_set_sticker_set* optionally returned in [getChat][getChat] requests to check if the bot can use this method. Returns *True* on success.
 *
 * @param[chatId] Unique identifier for the target chat or username of the target supergroup (in the format `@supergroupusername`)
 * @param[stickerSetName] Name of the sticker set to be set as the group sticker set
 */
fun ApiContext.setChatStickerSet(
    chatId: String,
    stickerSetName: String
): Future<Boolean?> = sendRequest<Boolean?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName)),
    object : TypeReference<Boolean> {})

fun ApiContext.setChatStickerSet(
    chatId: String,
    stickerSetName: String,
    callback: (result: AsyncResult<Boolean?>) -> Unit
): ApiContext = sendRequestCallback<Boolean?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName)),
    callback,
    object : TypeReference<Boolean> {})

suspend fun ApiContext.setChatStickerSetAwait(
    chatId: String,
    stickerSetName: String
): Boolean? = sendRequestAwait<Boolean?>(
    "setChatStickerSet",
    listOf(Pair("chat_id", chatId), Pair("sticker_set_name", stickerSetName)),
    object : TypeReference<Boolean> {})