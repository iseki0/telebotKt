@file:Suppress("SpellCheckingInspection", "unused")

package api.type

import api.EncryptedPassportElementType
import api.HasList
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about documents or other Telegram Passport elements shared with the bot by the user.
 *
 * @param[type] Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @param[data] *Optional*. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[phoneNumber] *Optional*. User's verified phone number, available only for “phone_number” type
 * @param[email] *Optional*. User's verified email address, available only for “email” type
 * @param[files] *Optional*. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[frontSide] *Optional*. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[reverseSide] *Optional*. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[selfie] *Optional*. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[translation] *Optional*. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying [EncryptedCredentials][EncryptedCredentials].
 * @param[hash] Base64-encoded element hash for using in [PassportElementErrorUnspecified][PassportElementErrorUnspecified]
 */
@HasList
@JsonInclude(JsonInclude.Include.NON_NULL)
data class EncryptedPassportElement @JsonCreator constructor(
    @get:JsonProperty("type")
    @JsonProperty("type")
    val type: EncryptedPassportElementType,
    @get:JsonProperty("data")
    @JsonProperty("data")
    val data: String? = null,
    @get:JsonProperty("phone_number")
    @JsonProperty("phone_number")
    val phoneNumber: String? = null,
    @get:JsonProperty("email")
    @JsonProperty("email")
    val email: String? = null,
    @get:JsonProperty("files")
    @JsonProperty("files")
    val files: List<PassportFile>? = null,
    @get:JsonProperty("front_side")
    @JsonProperty("front_side")
    val frontSide: PassportFile? = null,
    @get:JsonProperty("reverse_side")
    @JsonProperty("reverse_side")
    val reverseSide: PassportFile? = null,
    @get:JsonProperty("selfie")
    @JsonProperty("selfie")
    val selfie: PassportFile? = null,
    @get:JsonProperty("translation")
    @JsonProperty("translation")
    val translation: List<PassportFile>? = null,
    @get:JsonProperty("hash")
    @JsonProperty("hash")
    val hash: String
)