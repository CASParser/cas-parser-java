// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.Enum
import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.Params
import com.cas_parser.api.core.checkKnown
import com.cas_parser.api.core.checkRequired
import com.cas_parser.api.core.http.Headers
import com.cas_parser.api.core.http.QueryParams
import com.cas_parser.api.core.toImmutable
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Search the user's email inbox for CAS files from known senders (CAMS, KFintech, CDSL, NSDL).
 *
 * Files are uploaded to temporary cloud storage. **URLs expire in 24 hours.**
 *
 * Optionally filter by CAS provider and date range.
 *
 * **Billing:** 0.2 credits per request (charged regardless of success or number of files found).
 */
class InboxListCasFilesParams
private constructor(
    private val xInboxToken: String,
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    fun xInboxToken(): String = xInboxToken

    /**
     * Filter by CAS provider(s):
     * - `cdsl` → eCAS@cdslstatement.com
     * - `nsdl` → NSDL-CAS@nsdl.co.in
     * - `cams` → donotreply@camsonline.com
     * - `kfintech` → samfS@kfintech.com
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun casTypes(): Optional<List<CasType>> = body.casTypes()

    /**
     * End date in ISO format (YYYY-MM-DD). Defaults to today.
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun endDate(): Optional<LocalDate> = body.endDate()

    /**
     * Start date in ISO format (YYYY-MM-DD). Defaults to 30 days ago.
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun startDate(): Optional<LocalDate> = body.startDate()

    /**
     * Returns the raw JSON value of [casTypes].
     *
     * Unlike [casTypes], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _casTypes(): JsonField<List<CasType>> = body._casTypes()

    /**
     * Returns the raw JSON value of [endDate].
     *
     * Unlike [endDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _endDate(): JsonField<LocalDate> = body._endDate()

    /**
     * Returns the raw JSON value of [startDate].
     *
     * Unlike [startDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _startDate(): JsonField<LocalDate> = body._startDate()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InboxListCasFilesParams].
         *
         * The following fields are required:
         * ```java
         * .xInboxToken()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxListCasFilesParams]. */
    class Builder internal constructor() {

        private var xInboxToken: String? = null
        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inboxListCasFilesParams: InboxListCasFilesParams) = apply {
            xInboxToken = inboxListCasFilesParams.xInboxToken
            body = inboxListCasFilesParams.body.toBuilder()
            additionalHeaders = inboxListCasFilesParams.additionalHeaders.toBuilder()
            additionalQueryParams = inboxListCasFilesParams.additionalQueryParams.toBuilder()
        }

        fun xInboxToken(xInboxToken: String) = apply { this.xInboxToken = xInboxToken }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [casTypes]
         * - [endDate]
         * - [startDate]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Filter by CAS provider(s):
         * - `cdsl` → eCAS@cdslstatement.com
         * - `nsdl` → NSDL-CAS@nsdl.co.in
         * - `cams` → donotreply@camsonline.com
         * - `kfintech` → samfS@kfintech.com
         */
        fun casTypes(casTypes: List<CasType>) = apply { body.casTypes(casTypes) }

        /**
         * Sets [Builder.casTypes] to an arbitrary JSON value.
         *
         * You should usually call [Builder.casTypes] with a well-typed `List<CasType>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun casTypes(casTypes: JsonField<List<CasType>>) = apply { body.casTypes(casTypes) }

        /**
         * Adds a single [CasType] to [casTypes].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addCasType(casType: CasType) = apply { body.addCasType(casType) }

        /** End date in ISO format (YYYY-MM-DD). Defaults to today. */
        fun endDate(endDate: LocalDate) = apply { body.endDate(endDate) }

        /**
         * Sets [Builder.endDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.endDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun endDate(endDate: JsonField<LocalDate>) = apply { body.endDate(endDate) }

        /** Start date in ISO format (YYYY-MM-DD). Defaults to 30 days ago. */
        fun startDate(startDate: LocalDate) = apply { body.startDate(startDate) }

        /**
         * Sets [Builder.startDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.startDate] with a well-typed [LocalDate] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun startDate(startDate: JsonField<LocalDate>) = apply { body.startDate(startDate) }

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
         * Returns an immutable instance of [InboxListCasFilesParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .xInboxToken()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboxListCasFilesParams =
            InboxListCasFilesParams(
                checkRequired("xInboxToken", xInboxToken),
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers =
        Headers.builder()
            .apply {
                put("x-inbox-token", xInboxToken)
                putAll(additionalHeaders)
            }
            .build()

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val casTypes: JsonField<List<CasType>>,
        private val endDate: JsonField<LocalDate>,
        private val startDate: JsonField<LocalDate>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cas_types")
            @ExcludeMissing
            casTypes: JsonField<List<CasType>> = JsonMissing.of(),
            @JsonProperty("end_date")
            @ExcludeMissing
            endDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("start_date")
            @ExcludeMissing
            startDate: JsonField<LocalDate> = JsonMissing.of(),
        ) : this(casTypes, endDate, startDate, mutableMapOf())

        /**
         * Filter by CAS provider(s):
         * - `cdsl` → eCAS@cdslstatement.com
         * - `nsdl` → NSDL-CAS@nsdl.co.in
         * - `cams` → donotreply@camsonline.com
         * - `kfintech` → samfS@kfintech.com
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun casTypes(): Optional<List<CasType>> = casTypes.getOptional("cas_types")

        /**
         * End date in ISO format (YYYY-MM-DD). Defaults to today.
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun endDate(): Optional<LocalDate> = endDate.getOptional("end_date")

        /**
         * Start date in ISO format (YYYY-MM-DD). Defaults to 30 days ago.
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun startDate(): Optional<LocalDate> = startDate.getOptional("start_date")

        /**
         * Returns the raw JSON value of [casTypes].
         *
         * Unlike [casTypes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cas_types")
        @ExcludeMissing
        fun _casTypes(): JsonField<List<CasType>> = casTypes

        /**
         * Returns the raw JSON value of [endDate].
         *
         * Unlike [endDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("end_date") @ExcludeMissing fun _endDate(): JsonField<LocalDate> = endDate

        /**
         * Returns the raw JSON value of [startDate].
         *
         * Unlike [startDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("start_date")
        @ExcludeMissing
        fun _startDate(): JsonField<LocalDate> = startDate

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

            /** Returns a mutable builder for constructing an instance of [Body]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var casTypes: JsonField<MutableList<CasType>>? = null
            private var endDate: JsonField<LocalDate> = JsonMissing.of()
            private var startDate: JsonField<LocalDate> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                casTypes = body.casTypes.map { it.toMutableList() }
                endDate = body.endDate
                startDate = body.startDate
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Filter by CAS provider(s):
             * - `cdsl` → eCAS@cdslstatement.com
             * - `nsdl` → NSDL-CAS@nsdl.co.in
             * - `cams` → donotreply@camsonline.com
             * - `kfintech` → samfS@kfintech.com
             */
            fun casTypes(casTypes: List<CasType>) = casTypes(JsonField.of(casTypes))

            /**
             * Sets [Builder.casTypes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.casTypes] with a well-typed `List<CasType>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun casTypes(casTypes: JsonField<List<CasType>>) = apply {
                this.casTypes = casTypes.map { it.toMutableList() }
            }

            /**
             * Adds a single [CasType] to [casTypes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addCasType(casType: CasType) = apply {
                casTypes =
                    (casTypes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("casTypes", it).add(casType)
                    }
            }

            /** End date in ISO format (YYYY-MM-DD). Defaults to today. */
            fun endDate(endDate: LocalDate) = endDate(JsonField.of(endDate))

            /**
             * Sets [Builder.endDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.endDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun endDate(endDate: JsonField<LocalDate>) = apply { this.endDate = endDate }

            /** Start date in ISO format (YYYY-MM-DD). Defaults to 30 days ago. */
            fun startDate(startDate: LocalDate) = startDate(JsonField.of(startDate))

            /**
             * Sets [Builder.startDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.startDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun startDate(startDate: JsonField<LocalDate>) = apply { this.startDate = startDate }

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
             */
            fun build(): Body =
                Body(
                    (casTypes ?: JsonMissing.of()).map { it.toImmutable() },
                    endDate,
                    startDate,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            casTypes().ifPresent { it.forEach { it.validate() } }
            endDate()
            startDate()
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
            (casTypes.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (endDate.asKnown().isPresent) 1 else 0) +
                (if (startDate.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                casTypes == other.casTypes &&
                endDate == other.endDate &&
                startDate == other.startDate &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(casTypes, endDate, startDate, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{casTypes=$casTypes, endDate=$endDate, startDate=$startDate, additionalProperties=$additionalProperties}"
    }

    class CasType @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val CDSL = of("cdsl")

            @JvmField val NSDL = of("nsdl")

            @JvmField val CAMS = of("cams")

            @JvmField val KFINTECH = of("kfintech")

            @JvmStatic fun of(value: String) = CasType(JsonField.of(value))
        }

        /** An enum containing [CasType]'s known values. */
        enum class Known {
            CDSL,
            NSDL,
            CAMS,
            KFINTECH,
        }

        /**
         * An enum containing [CasType]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CasType] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            CDSL,
            NSDL,
            CAMS,
            KFINTECH,
            /** An enum member indicating that [CasType] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                CDSL -> Value.CDSL
                NSDL -> Value.NSDL
                CAMS -> Value.CAMS
                KFINTECH -> Value.KFINTECH
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws CasParserInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                CDSL -> Known.CDSL
                NSDL -> Known.NSDL
                CAMS -> Known.CAMS
                KFINTECH -> Known.KFINTECH
                else -> throw CasParserInvalidDataException("Unknown CasType: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws CasParserInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                CasParserInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): CasType = apply {
            if (validated) {
                return@apply
            }

            known()
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
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is CasType && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxListCasFilesParams &&
            xInboxToken == other.xInboxToken &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int =
        Objects.hash(xInboxToken, body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InboxListCasFilesParams{xInboxToken=$xInboxToken, body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
