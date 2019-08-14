package api

interface ResultType {
    val ok: Boolean
    val errorCode: Int?
    val description: String?
}