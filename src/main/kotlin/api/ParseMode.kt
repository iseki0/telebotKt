package api

import com.fasterxml.jackson.annotation.JsonValue

enum class ParseMode(@JsonValue val rawString: String) {
    MARKDOWN("Markdown"),
    HTML("HTML")
}