package types

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

/**
 * Contains information about documents or other Telegram Passport elements shared with the bot by the user.
 *
 * @param[type] Element type. One of “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport”, “address”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration”, “temporary_registration”, “phone_number”, “email”.
 * @param[data] *Optional*. Base64-encoded encrypted Telegram Passport element data provided by the user, available for “personal_details”, “passport”, “driver_license”, “identity_card”, “internal_passport” and “address” types. Can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[phoneNumber] *Optional*. types.User's verified phone number, available only for “phone_number” type
 * @param[email] *Optional*. types.User's verified email address, available only for “email” type
 * @param[files] *Optional*. Array of encrypted files with documents provided by the user, available for “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[frontSide] *Optional*. Encrypted file with the front side of the document, provided by the user. Available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[reverseSide] *Optional*. Encrypted file with the reverse side of the document, provided by the user. Available for “driver_license” and “identity_card”. The file can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[selfie] *Optional*. Encrypted file with the selfie of the user holding a document, provided by the user; available for “passport”, “driver_license”, “identity_card” and “internal_passport”. The file can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[translation] *Optional*. Array of encrypted files with translated versions of documents provided by the user. Available if requested for “passport”, “driver_license”, “identity_card”, “internal_passport”, “utility_bill”, “bank_statement”, “rental_agreement”, “passport_registration” and “temporary_registration” types. Files can be decrypted and verified using the accompanying [types.EncryptedCredentials][EncryptedCredentials].
 * @param[hash] Base64-encoded element hash for using in [types.PassportElementErrorUnspecified][PassportElementErrorUnspecified]
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
data class EncryptedPassportElement @JsonCreator constructor(
    @JsonProperty("type")
    val type: String,
    @JsonProperty("data")
    val data: String?,
    @JsonProperty("phone_number")
    val phoneNumber: String?,
    @JsonProperty("email")
    val email: String?,
    @JsonProperty("files")
    val files: Array<PassportFile>?,
    @JsonProperty("front_side")
    val frontSide: PassportFile?,
    @JsonProperty("reverse_side")
    val reverseSide: PassportFile?,
    @JsonProperty("selfie")
    val selfie: PassportFile?,
    @JsonProperty("translation")
    val translation: Array<PassportFile>?,
    @JsonProperty("hash")
    val hash: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EncryptedPassportElement

        if (type != other.type) return false
        if (data != other.data) return false
        if (phoneNumber != other.phoneNumber) return false
        if (email != other.email) return false
        if (files != null) {
            if (other.files == null) return false
            if (!files.contentEquals(other.files)) return false
        } else if (other.files != null) return false
        if (frontSide != other.frontSide) return false
        if (reverseSide != other.reverseSide) return false
        if (selfie != other.selfie) return false
        if (translation != null) {
            if (other.translation == null) return false
            if (!translation.contentEquals(other.translation)) return false
        } else if (other.translation != null) return false
        if (hash != other.hash) return false

        return true
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + (data?.hashCode() ?: 0)
        result = 31 * result + (phoneNumber?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (files?.contentHashCode() ?: 0)
        result = 31 * result + (frontSide?.hashCode() ?: 0)
        result = 31 * result + (reverseSide?.hashCode() ?: 0)
        result = 31 * result + (selfie?.hashCode() ?: 0)
        result = 31 * result + (translation?.contentHashCode() ?: 0)
        result = 31 * result + hash.hashCode()
        return result
    }
}