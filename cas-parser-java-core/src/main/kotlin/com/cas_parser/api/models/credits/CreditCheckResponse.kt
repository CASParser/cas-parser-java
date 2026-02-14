// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.credits

import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.checkKnown
import com.cas_parser.api.core.toImmutable
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class CreditCheckResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val enabledFeatures: JsonField<List<String>>,
    private val isUnlimited: JsonField<Boolean>,
    private val limit: JsonField<Long>,
    private val remaining: JsonField<Double>,
    private val resetsAt: JsonField<OffsetDateTime>,
    private val used: JsonField<Double>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("enabled_features")
        @ExcludeMissing
        enabledFeatures: JsonField<List<String>> = JsonMissing.of(),
        @JsonProperty("is_unlimited")
        @ExcludeMissing
        isUnlimited: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("limit") @ExcludeMissing limit: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("remaining") @ExcludeMissing remaining: JsonField<Double> = JsonMissing.of(),
        @JsonProperty("resets_at")
        @ExcludeMissing
        resetsAt: JsonField<OffsetDateTime> = JsonMissing.of(),
        @JsonProperty("used") @ExcludeMissing used: JsonField<Double> = JsonMissing.of(),
    ) : this(enabledFeatures, isUnlimited, limit, remaining, resetsAt, used, mutableMapOf())

    /**
     * List of API features enabled for your plan
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun enabledFeatures(): Optional<List<String>> = enabledFeatures.getOptional("enabled_features")

    /**
     * Whether the account has unlimited credits
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun isUnlimited(): Optional<Boolean> = isUnlimited.getOptional("is_unlimited")

    /**
     * Total credit limit for billing period
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun limit(): Optional<Long> = limit.getOptional("limit")

    /**
     * Remaining credits (null if unlimited)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun remaining(): Optional<Double> = remaining.getOptional("remaining")

    /**
     * When credits reset (ISO 8601)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun resetsAt(): Optional<OffsetDateTime> = resetsAt.getOptional("resets_at")

    /**
     * Number of credits used this billing period
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun used(): Optional<Double> = used.getOptional("used")

    /**
     * Returns the raw JSON value of [enabledFeatures].
     *
     * Unlike [enabledFeatures], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("enabled_features")
    @ExcludeMissing
    fun _enabledFeatures(): JsonField<List<String>> = enabledFeatures

    /**
     * Returns the raw JSON value of [isUnlimited].
     *
     * Unlike [isUnlimited], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("is_unlimited")
    @ExcludeMissing
    fun _isUnlimited(): JsonField<Boolean> = isUnlimited

    /**
     * Returns the raw JSON value of [limit].
     *
     * Unlike [limit], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("limit") @ExcludeMissing fun _limit(): JsonField<Long> = limit

    /**
     * Returns the raw JSON value of [remaining].
     *
     * Unlike [remaining], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("remaining") @ExcludeMissing fun _remaining(): JsonField<Double> = remaining

    /**
     * Returns the raw JSON value of [resetsAt].
     *
     * Unlike [resetsAt], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("resets_at") @ExcludeMissing fun _resetsAt(): JsonField<OffsetDateTime> = resetsAt

    /**
     * Returns the raw JSON value of [used].
     *
     * Unlike [used], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("used") @ExcludeMissing fun _used(): JsonField<Double> = used

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

        /** Returns a mutable builder for constructing an instance of [CreditCheckResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CreditCheckResponse]. */
    class Builder internal constructor() {

        private var enabledFeatures: JsonField<MutableList<String>>? = null
        private var isUnlimited: JsonField<Boolean> = JsonMissing.of()
        private var limit: JsonField<Long> = JsonMissing.of()
        private var remaining: JsonField<Double> = JsonMissing.of()
        private var resetsAt: JsonField<OffsetDateTime> = JsonMissing.of()
        private var used: JsonField<Double> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(creditCheckResponse: CreditCheckResponse) = apply {
            enabledFeatures = creditCheckResponse.enabledFeatures.map { it.toMutableList() }
            isUnlimited = creditCheckResponse.isUnlimited
            limit = creditCheckResponse.limit
            remaining = creditCheckResponse.remaining
            resetsAt = creditCheckResponse.resetsAt
            used = creditCheckResponse.used
            additionalProperties = creditCheckResponse.additionalProperties.toMutableMap()
        }

        /** List of API features enabled for your plan */
        fun enabledFeatures(enabledFeatures: List<String>) =
            enabledFeatures(JsonField.of(enabledFeatures))

        /**
         * Sets [Builder.enabledFeatures] to an arbitrary JSON value.
         *
         * You should usually call [Builder.enabledFeatures] with a well-typed `List<String>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun enabledFeatures(enabledFeatures: JsonField<List<String>>) = apply {
            this.enabledFeatures = enabledFeatures.map { it.toMutableList() }
        }

        /**
         * Adds a single [String] to [enabledFeatures].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addEnabledFeature(enabledFeature: String) = apply {
            enabledFeatures =
                (enabledFeatures ?: JsonField.of(mutableListOf())).also {
                    checkKnown("enabledFeatures", it).add(enabledFeature)
                }
        }

        /** Whether the account has unlimited credits */
        fun isUnlimited(isUnlimited: Boolean) = isUnlimited(JsonField.of(isUnlimited))

        /**
         * Sets [Builder.isUnlimited] to an arbitrary JSON value.
         *
         * You should usually call [Builder.isUnlimited] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun isUnlimited(isUnlimited: JsonField<Boolean>) = apply { this.isUnlimited = isUnlimited }

        /** Total credit limit for billing period */
        fun limit(limit: Long) = limit(JsonField.of(limit))

        /**
         * Sets [Builder.limit] to an arbitrary JSON value.
         *
         * You should usually call [Builder.limit] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun limit(limit: JsonField<Long>) = apply { this.limit = limit }

        /** Remaining credits (null if unlimited) */
        fun remaining(remaining: Double?) = remaining(JsonField.ofNullable(remaining))

        /**
         * Alias for [Builder.remaining].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun remaining(remaining: Double) = remaining(remaining as Double?)

        /** Alias for calling [Builder.remaining] with `remaining.orElse(null)`. */
        fun remaining(remaining: Optional<Double>) = remaining(remaining.getOrNull())

        /**
         * Sets [Builder.remaining] to an arbitrary JSON value.
         *
         * You should usually call [Builder.remaining] with a well-typed [Double] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun remaining(remaining: JsonField<Double>) = apply { this.remaining = remaining }

        /** When credits reset (ISO 8601) */
        fun resetsAt(resetsAt: OffsetDateTime?) = resetsAt(JsonField.ofNullable(resetsAt))

        /** Alias for calling [Builder.resetsAt] with `resetsAt.orElse(null)`. */
        fun resetsAt(resetsAt: Optional<OffsetDateTime>) = resetsAt(resetsAt.getOrNull())

        /**
         * Sets [Builder.resetsAt] to an arbitrary JSON value.
         *
         * You should usually call [Builder.resetsAt] with a well-typed [OffsetDateTime] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun resetsAt(resetsAt: JsonField<OffsetDateTime>) = apply { this.resetsAt = resetsAt }

        /** Number of credits used this billing period */
        fun used(used: Double) = used(JsonField.of(used))

        /**
         * Sets [Builder.used] to an arbitrary JSON value.
         *
         * You should usually call [Builder.used] with a well-typed [Double] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun used(used: JsonField<Double>) = apply { this.used = used }

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
         * Returns an immutable instance of [CreditCheckResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CreditCheckResponse =
            CreditCheckResponse(
                (enabledFeatures ?: JsonMissing.of()).map { it.toImmutable() },
                isUnlimited,
                limit,
                remaining,
                resetsAt,
                used,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): CreditCheckResponse = apply {
        if (validated) {
            return@apply
        }

        enabledFeatures()
        isUnlimited()
        limit()
        remaining()
        resetsAt()
        used()
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
        (enabledFeatures.asKnown().getOrNull()?.size ?: 0) +
            (if (isUnlimited.asKnown().isPresent) 1 else 0) +
            (if (limit.asKnown().isPresent) 1 else 0) +
            (if (remaining.asKnown().isPresent) 1 else 0) +
            (if (resetsAt.asKnown().isPresent) 1 else 0) +
            (if (used.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CreditCheckResponse &&
            enabledFeatures == other.enabledFeatures &&
            isUnlimited == other.isUnlimited &&
            limit == other.limit &&
            remaining == other.remaining &&
            resetsAt == other.resetsAt &&
            used == other.used &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            enabledFeatures,
            isUnlimited,
            limit,
            remaining,
            resetsAt,
            used,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "CreditCheckResponse{enabledFeatures=$enabledFeatures, isUnlimited=$isUnlimited, limit=$limit, remaining=$remaining, resetsAt=$resetsAt, used=$used, additionalProperties=$additionalProperties}"
}
