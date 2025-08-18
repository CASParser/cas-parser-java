// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casgenerator

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

class CasGeneratorGenerateCasResponse
private constructor(
    private val msg: JsonField<String>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("msg") @ExcludeMissing msg: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(msg, status, mutableMapOf())

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun msg(): Optional<String> = msg.getOptional("msg")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [msg].
     *
     * Unlike [msg], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("msg") @ExcludeMissing fun _msg(): JsonField<String> = msg

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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
         * Returns a mutable builder for constructing an instance of
         * [CasGeneratorGenerateCasResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CasGeneratorGenerateCasResponse]. */
    class Builder internal constructor() {

        private var msg: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(casGeneratorGenerateCasResponse: CasGeneratorGenerateCasResponse) =
            apply {
                msg = casGeneratorGenerateCasResponse.msg
                status = casGeneratorGenerateCasResponse.status
                additionalProperties =
                    casGeneratorGenerateCasResponse.additionalProperties.toMutableMap()
            }

        fun msg(msg: String) = msg(JsonField.of(msg))

        /**
         * Sets [Builder.msg] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msg] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun msg(msg: JsonField<String>) = apply { this.msg = msg }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [CasGeneratorGenerateCasResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CasGeneratorGenerateCasResponse =
            CasGeneratorGenerateCasResponse(msg, status, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): CasGeneratorGenerateCasResponse = apply {
        if (validated) {
            return@apply
        }

        msg()
        status()
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
        (if (msg.asKnown().isPresent) 1 else 0) + (if (status.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CasGeneratorGenerateCasResponse &&
            msg == other.msg &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(msg, status, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CasGeneratorGenerateCasResponse{msg=$msg, status=$status, additionalProperties=$additionalProperties}"
}
