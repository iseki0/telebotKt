import api.InputFile
import io.vertx.ext.web.multipart.MultipartForm
import java.nio.file.Files

fun Bot.fillRequestForm(args: List<Pair<String, Any?>>): MultipartForm {
    val form = MultipartForm.create()

    args.forEach { (key, value) ->
        if (value != null) {
            when {
                isSimpleType(value) -> form.attribute(key, value.toString())
                value is InputFile -> {
                    when {
                        value.fileId != null -> form.attribute(key, value.fileId)
                        value.file != null -> form.binaryFileUpload(
                            key,
                            value.file.name,
                            value.file.absolutePath,
                            detectMIME(value) ?: ""
                        )
                        else -> throw InvalidInputFile()
                    }
                }
                else -> {

                    val json = mapper.writeValueAsString(value)
                    form.attribute(key, json)
                }
            }
        }
    }
    return form
}

fun isSimpleType(o: Any): Boolean =
    when (o) {
        is String -> true
        is Int -> true
        is Long -> true
        is Float -> true
        is Double -> true
        else -> false
    }

fun detectMIME(inputFile: InputFile): String? =
    Files.probeContentType(inputFile.file!!.toPath())


class InvalidInputFile : RuntimeException("InvalidInputFile")