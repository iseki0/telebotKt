package api

import com.fasterxml.jackson.annotation.JsonValue

enum class UpdateType(@JsonValue val rawString: String) {
    MESSAGE("message"),
    EDITED_MESSAGE("edited_message"),
    CHANNEL_POST("channel_post"),
    EDITED_CHANNEL_POST("edited_channel_post"),
    INLINE_QUERY("inline_query"),
    CHOSEN_INLINE_QUERY("chosen_inline_result"),
    CALLBACK_QUERY("callback_query"),
    SHIPPING_QUERY("shipping_query"),
    PRE_CHECKOUT_QUERY("pre_checkout_query"),
    POLL("poll"),
}