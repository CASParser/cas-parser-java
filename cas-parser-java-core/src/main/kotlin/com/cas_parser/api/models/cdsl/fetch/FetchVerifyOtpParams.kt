// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.cdsl.fetch

import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.Params
import com.cas_parser.api.core.checkRequired
import com.cas_parser.api.core.http.Headers
import com.cas_parser.api.core.http.QueryParams
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * **Step 2 of 2**: Verify OTP and retrieve CDSL CAS files.
 *
 * After successful verification, CAS PDFs are fetched from CDSL portal, uploaded to cloud storage,
 * and returned as direct download URLs.
 */
class FetchVerifyOtpParams
private constructor(
    private val sessionId: String?,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun sessionId(): Optional<String> = Optional.ofNullable(sessionId)

    /**
     * OTP received on mobile
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun otp(): String = body.otp()

    /**
     * Number of monthly statements to fetch (default 6)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun numPeriods(): Optional<Long> = body.numPeriods()

    /**
     * Returns the raw JSON value of [otp].
     *
     * Unlike [otp], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _otp(): JsonField<String> = body._otp()

    /**
     * Returns the raw JSON value of [numPeriods].
     *
     * Unlike [numPeriods], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _numPeriods(): JsonField<Long> = body._numPeriods()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FetchVerifyOtpParams].
         *
         * The following fields are required:
         * ```java
         * .otp()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FetchVerifyOtpParams]. */
    class Builder internal constructor() {

        private var sessionId: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fetchVerifyOtpParams: FetchVerifyOtpParams) = apply {
            sessionId = fetchVerifyOtpParams.sessionId
            body = fetchVerifyOtpParams.body.toBuilder()
            additionalHeaders = fetchVerifyOtpParams.additionalHeaders.toBuilder()
            additionalQueryParams = fetchVerifyOtpParams.additionalQueryParams.toBuilder()
        }

        fun sessionId(sessionId: String?) = apply { this.sessionId = sessionId }

        /** Alias for calling [Builder.sessionId] with `sessionId.orElse(null)`. */
        fun sessionId(sessionId: Optional<String>) = sessionId(sessionId.getOrNull())

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [otp]
         * - [numPeriods]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** OTP received on mobile */
        fun otp(otp: String) = apply { body.otp(otp) }

        /**
         * Sets [Builder.otp] to an arbitrary JSON value.
         *
         * You should usually call [Builder.otp] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun otp(otp: JsonField<String>) = apply { body.otp(otp) }

        /** Number of monthly statements to fetch (default 6) */
        fun numPeriods(numPeriods: Long) = apply { body.numPeriods(numPeriods) }

        /**
         * Sets [Builder.numPeriods] to an arbitrary JSON value.
         *
         * You should usually call [Builder.numPeriods] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun numPeriods(numPeriods: JsonField<Long>) = apply { body.numPeriods(numPeriods) }

        fun additionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) = apply {
            body.additionalProperties(additionalBodyProperties)
        }

        fun putAdditionalBodyProperty(key: String, value: JsonValue) = apply {
            body.putAdditionalProperty(key, value)
        }

        fun putAllAdditionalBodyProperties(additionalBodyProperties: Map<String, JsonValue>) =
            apply {
                body.putAllAdditionalProperties(additionalBodyProperties)
            }

        fun removeAdditionalBodyProperty(key: String) = apply { body.removeAdditionalProperty(key) }

        fun removeAllAdditionalBodyProperties(keys: Set<String>) = apply {
            body.removeAllAdditionalProperties(keys)
        }

        fun additionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun additionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.clear()
            putAllAdditionalHeaders(additionalHeaders)
        }

        fun putAdditionalHeader(name: String, value: String) = apply {
            additionalHeaders.put(name, value)
        }

        fun putAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.put(name, values)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun putAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.putAll(additionalHeaders)
        }

        fun replaceAdditionalHeaders(name: String, value: String) = apply {
            additionalHeaders.replace(name, value)
        }

        fun replaceAdditionalHeaders(name: String, values: Iterable<String>) = apply {
            additionalHeaders.replace(name, values)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Headers) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun replaceAllAdditionalHeaders(additionalHeaders: Map<String, Iterable<String>>) = apply {
            this.additionalHeaders.replaceAll(additionalHeaders)
        }

        fun removeAdditionalHeaders(name: String) = apply { additionalHeaders.remove(name) }

        fun removeAllAdditionalHeaders(names: Set<String>) = apply {
            additionalHeaders.removeAll(names)
        }

        fun additionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun additionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) = apply {
            this.additionalQueryParams.clear()
            putAllAdditionalQueryParams(additionalQueryParams)
        }

        fun putAdditionalQueryParam(key: String, value: String) = apply {
            additionalQueryParams.put(key, value)
        }

        fun putAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.put(key, values)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.putAll(additionalQueryParams)
        }

        fun putAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.putAll(additionalQueryParams)
            }

        fun replaceAdditionalQueryParams(key: String, value: String) = apply {
            additionalQueryParams.replace(key, value)
        }

        fun replaceAdditionalQueryParams(key: String, values: Iterable<String>) = apply {
            additionalQueryParams.replace(key, values)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: QueryParams) = apply {
            this.additionalQueryParams.replaceAll(additionalQueryParams)
        }

        fun replaceAllAdditionalQueryParams(additionalQueryParams: Map<String, Iterable<String>>) =
            apply {
                this.additionalQueryParams.replaceAll(additionalQueryParams)
            }

        fun removeAdditionalQueryParams(key: String) = apply { additionalQueryParams.remove(key) }

        fun removeAllAdditionalQueryParams(keys: Set<String>) = apply {
            additionalQueryParams.removeAll(keys)
        }

        /**
         * Returns an immutable instance of [FetchVerifyOtpParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .otp()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FetchVerifyOtpParams =
            FetchVerifyOtpParams(
                sessionId,
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    fun _pathParam(index: Int): String =
        when (index) {
            0 -> sessionId ?: ""
            else -> ""
        }

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val otp: JsonField<String>,
        private val numPeriods: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("otp") @ExcludeMissing otp: JsonField<String> = JsonMissing.of(),
            @JsonProperty("num_periods")
            @ExcludeMissing
            numPeriods: JsonField<Long> = JsonMissing.of(),
        ) : this(otp, numPeriods, mutableMapOf())

        /**
         * OTP received on mobile
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun otp(): String = otp.getRequired("otp")

        /**
         * Number of monthly statements to fetch (default 6)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun numPeriods(): Optional<Long> = numPeriods.getOptional("num_periods")

        /**
         * Returns the raw JSON value of [otp].
         *
         * Unlike [otp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("otp") @ExcludeMissing fun _otp(): JsonField<String> = otp

        /**
         * Returns the raw JSON value of [numPeriods].
         *
         * Unlike [numPeriods], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("num_periods") @ExcludeMissing fun _numPeriods(): JsonField<Long> = numPeriods

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
             * Returns a mutable builder for constructing an instance of [Body].
             *
             * The following fields are required:
             * ```java
             * .otp()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var otp: JsonField<String>? = null
            private var numPeriods: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                otp = body.otp
                numPeriods = body.numPeriods
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** OTP received on mobile */
            fun otp(otp: String) = otp(JsonField.of(otp))

            /**
             * Sets [Builder.otp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.otp] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun otp(otp: JsonField<String>) = apply { this.otp = otp }

            /** Number of monthly statements to fetch (default 6) */
            fun numPeriods(numPeriods: Long) = numPeriods(JsonField.of(numPeriods))

            /**
             * Sets [Builder.numPeriods] to an arbitrary JSON value.
             *
             * You should usually call [Builder.numPeriods] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun numPeriods(numPeriods: JsonField<Long>) = apply { this.numPeriods = numPeriods }

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
             * Returns an immutable instance of [Body].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             *
             * The following fields are required:
             * ```java
             * .otp()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(checkRequired("otp", otp), numPeriods, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            otp()
            numPeriods()
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
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (otp.asKnown().isPresent) 1 else 0) + (if (numPeriods.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                otp == other.otp &&
                numPeriods == other.numPeriods &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(otp, numPeriods, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{otp=$otp, numPeriods=$numPeriods, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FetchVerifyOtpParams &&
            sessionId == other.sessionId &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(sessionId, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FetchVerifyOtpParams{sessionId=$sessionId, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
