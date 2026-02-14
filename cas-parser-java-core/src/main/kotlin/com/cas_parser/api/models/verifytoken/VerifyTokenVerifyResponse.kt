// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.verifytoken

import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional

class VerifyTokenVerifyResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val error: JsonField<String>,
    private val maskedApiKey: JsonField<String>,
    private val valid: JsonField<Boolean>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("error") @ExcludeMissing error: JsonField<String> = JsonMissing.of(),
        @JsonProperty("masked_api_key")
        @ExcludeMissing
        maskedApiKey: JsonField<String> = JsonMissing.of(),
        @JsonProperty("valid") @ExcludeMissing valid: JsonField<Boolean> = JsonMissing.of(),
    ) : this(error, maskedApiKey, valid, mutableMapOf())

    /**
     * Error message (only shown if invalid)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun error(): Optional<String> = error.getOptional("error")

    /**
     * Masked API key (only shown if valid)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun maskedApiKey(): Optional<String> = maskedApiKey.getOptional("masked_api_key")

    /**
     * Whether the token is valid
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun valid(): Optional<Boolean> = valid.getOptional("valid")

    /**
     * Returns the raw JSON value of [error].
     *
     * Unlike [error], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("error") @ExcludeMissing fun _error(): JsonField<String> = error

    /**
     * Returns the raw JSON value of [maskedApiKey].
     *
     * Unlike [maskedApiKey], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("masked_api_key")
    @ExcludeMissing
    fun _maskedApiKey(): JsonField<String> = maskedApiKey

    /**
     * Returns the raw JSON value of [valid].
     *
     * Unlike [valid], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("valid") @ExcludeMissing fun _valid(): JsonField<Boolean> = valid

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VerifyTokenVerifyResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [VerifyTokenVerifyResponse]. */
    class Builder internal constructor() {

        private var error: JsonField<String> = JsonMissing.of()
        private var maskedApiKey: JsonField<String> = JsonMissing.of()
        private var valid: JsonField<Boolean> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(verifyTokenVerifyResponse: VerifyTokenVerifyResponse) = apply {
            error = verifyTokenVerifyResponse.error
            maskedApiKey = verifyTokenVerifyResponse.maskedApiKey
            valid = verifyTokenVerifyResponse.valid
            additionalProperties = verifyTokenVerifyResponse.additionalProperties.toMutableMap()
        }

        /** Error message (only shown if invalid) */
        fun error(error: String) = error(JsonField.of(error))

        /**
         * Sets [Builder.error] to an arbitrary JSON value.
         *
         * You should usually call [Builder.error] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun error(error: JsonField<String>) = apply { this.error = error }

        /** Masked API key (only shown if valid) */
        fun maskedApiKey(maskedApiKey: String) = maskedApiKey(JsonField.of(maskedApiKey))

        /**
         * Sets [Builder.maskedApiKey] to an arbitrary JSON value.
         *
         * You should usually call [Builder.maskedApiKey] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun maskedApiKey(maskedApiKey: JsonField<String>) = apply {
            this.maskedApiKey = maskedApiKey
        }

        /** Whether the token is valid */
        fun valid(valid: Boolean) = valid(JsonField.of(valid))

        /**
         * Sets [Builder.valid] to an arbitrary JSON value.
         *
         * You should usually call [Builder.valid] with a well-typed [Boolean] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun valid(valid: JsonField<Boolean>) = apply { this.valid = valid }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [VerifyTokenVerifyResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): VerifyTokenVerifyResponse =
            VerifyTokenVerifyResponse(
                error,
                maskedApiKey,
                valid,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): VerifyTokenVerifyResponse = apply {
        if (validated) {
            return@apply
        }

        error()
        maskedApiKey()
        valid()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: CasParserInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (error.asKnown().isPresent) 1 else 0) +
            (if (maskedApiKey.asKnown().isPresent) 1 else 0) +
            (if (valid.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VerifyTokenVerifyResponse &&
            error == other.error &&
            maskedApiKey == other.maskedApiKey &&
            valid == other.valid &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(error, maskedApiKey, valid, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "VerifyTokenVerifyResponse{error=$error, maskedApiKey=$maskedApiKey, valid=$valid, additionalProperties=$additionalProperties}"
}
