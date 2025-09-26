// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casgenerator

import com.cas_parser.api.core.Enum
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
 * This endpoint generates CAS (Consolidated Account Statement) documents by submitting a mailback
 * request to the specified CAS authority. Currently only supports KFintech, with plans to support
 * CAMS, CDSL, and NSDL in the future.
 */
class CasGeneratorGenerateCasParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Email address to receive the CAS document
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun email(): String = body.email()

    /**
     * Start date for the CAS period (format YYYY-MM-DD)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun fromDate(): String = body.fromDate()

    /**
     * Password to protect the generated CAS PDF
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun password(): String = body.password()

    /**
     * End date for the CAS period (format YYYY-MM-DD)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun toDate(): String = body.toDate()

    /**
     * CAS authority to generate the document from (currently only kfintech is supported)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun casAuthority(): Optional<CasAuthority> = body.casAuthority()

    /**
     * PAN number (optional for some CAS authorities)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun panNo(): Optional<String> = body.panNo()

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _email(): JsonField<String> = body._email()

    /**
     * Returns the raw JSON value of [fromDate].
     *
     * Unlike [fromDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _fromDate(): JsonField<String> = body._fromDate()

    /**
     * Returns the raw JSON value of [password].
     *
     * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _password(): JsonField<String> = body._password()

    /**
     * Returns the raw JSON value of [toDate].
     *
     * Unlike [toDate], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _toDate(): JsonField<String> = body._toDate()

    /**
     * Returns the raw JSON value of [casAuthority].
     *
     * Unlike [casAuthority], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _casAuthority(): JsonField<CasAuthority> = body._casAuthority()

    /**
     * Returns the raw JSON value of [panNo].
     *
     * Unlike [panNo], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _panNo(): JsonField<String> = body._panNo()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [CasGeneratorGenerateCasParams].
         *
         * The following fields are required:
         * ```java
         * .email()
         * .fromDate()
         * .password()
         * .toDate()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CasGeneratorGenerateCasParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(casGeneratorGenerateCasParams: CasGeneratorGenerateCasParams) = apply {
            body = casGeneratorGenerateCasParams.body.toBuilder()
            additionalHeaders = casGeneratorGenerateCasParams.additionalHeaders.toBuilder()
            additionalQueryParams = casGeneratorGenerateCasParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [email]
         * - [fromDate]
         * - [password]
         * - [toDate]
         * - [casAuthority]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Email address to receive the CAS document */
        fun email(email: String) = apply { body.email(email) }

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { body.email(email) }

        /** Start date for the CAS period (format YYYY-MM-DD) */
        fun fromDate(fromDate: String) = apply { body.fromDate(fromDate) }

        /**
         * Sets [Builder.fromDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.fromDate] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun fromDate(fromDate: JsonField<String>) = apply { body.fromDate(fromDate) }

        /** Password to protect the generated CAS PDF */
        fun password(password: String) = apply { body.password(password) }

        /**
         * Sets [Builder.password] to an arbitrary JSON value.
         *
         * You should usually call [Builder.password] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun password(password: JsonField<String>) = apply { body.password(password) }

        /** End date for the CAS period (format YYYY-MM-DD) */
        fun toDate(toDate: String) = apply { body.toDate(toDate) }

        /**
         * Sets [Builder.toDate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.toDate] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun toDate(toDate: JsonField<String>) = apply { body.toDate(toDate) }

        /** CAS authority to generate the document from (currently only kfintech is supported) */
        fun casAuthority(casAuthority: CasAuthority) = apply { body.casAuthority(casAuthority) }

        /**
         * Sets [Builder.casAuthority] to an arbitrary JSON value.
         *
         * You should usually call [Builder.casAuthority] with a well-typed [CasAuthority] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun casAuthority(casAuthority: JsonField<CasAuthority>) = apply {
            body.casAuthority(casAuthority)
        }

        /** PAN number (optional for some CAS authorities) */
        fun panNo(panNo: String) = apply { body.panNo(panNo) }

        /**
         * Sets [Builder.panNo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.panNo] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun panNo(panNo: JsonField<String>) = apply { body.panNo(panNo) }

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
         * Returns an immutable instance of [CasGeneratorGenerateCasParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .email()
         * .fromDate()
         * .password()
         * .toDate()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CasGeneratorGenerateCasParams =
            CasGeneratorGenerateCasParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Body = body

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val email: JsonField<String>,
        private val fromDate: JsonField<String>,
        private val password: JsonField<String>,
        private val toDate: JsonField<String>,
        private val casAuthority: JsonField<CasAuthority>,
        private val panNo: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("from_date")
            @ExcludeMissing
            fromDate: JsonField<String> = JsonMissing.of(),
            @JsonProperty("password")
            @ExcludeMissing
            password: JsonField<String> = JsonMissing.of(),
            @JsonProperty("to_date") @ExcludeMissing toDate: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cas_authority")
            @ExcludeMissing
            casAuthority: JsonField<CasAuthority> = JsonMissing.of(),
            @JsonProperty("pan_no") @ExcludeMissing panNo: JsonField<String> = JsonMissing.of(),
        ) : this(email, fromDate, password, toDate, casAuthority, panNo, mutableMapOf())

        /**
         * Email address to receive the CAS document
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun email(): String = email.getRequired("email")

        /**
         * Start date for the CAS period (format YYYY-MM-DD)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun fromDate(): String = fromDate.getRequired("from_date")

        /**
         * Password to protect the generated CAS PDF
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun password(): String = password.getRequired("password")

        /**
         * End date for the CAS period (format YYYY-MM-DD)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun toDate(): String = toDate.getRequired("to_date")

        /**
         * CAS authority to generate the document from (currently only kfintech is supported)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun casAuthority(): Optional<CasAuthority> = casAuthority.getOptional("cas_authority")

        /**
         * PAN number (optional for some CAS authorities)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun panNo(): Optional<String> = panNo.getOptional("pan_no")

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [fromDate].
         *
         * Unlike [fromDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("from_date") @ExcludeMissing fun _fromDate(): JsonField<String> = fromDate

        /**
         * Returns the raw JSON value of [password].
         *
         * Unlike [password], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("password") @ExcludeMissing fun _password(): JsonField<String> = password

        /**
         * Returns the raw JSON value of [toDate].
         *
         * Unlike [toDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("to_date") @ExcludeMissing fun _toDate(): JsonField<String> = toDate

        /**
         * Returns the raw JSON value of [casAuthority].
         *
         * Unlike [casAuthority], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("cas_authority")
        @ExcludeMissing
        fun _casAuthority(): JsonField<CasAuthority> = casAuthority

        /**
         * Returns the raw JSON value of [panNo].
         *
         * Unlike [panNo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pan_no") @ExcludeMissing fun _panNo(): JsonField<String> = panNo

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
             * .email()
             * .fromDate()
             * .password()
             * .toDate()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var email: JsonField<String>? = null
            private var fromDate: JsonField<String>? = null
            private var password: JsonField<String>? = null
            private var toDate: JsonField<String>? = null
            private var casAuthority: JsonField<CasAuthority> = JsonMissing.of()
            private var panNo: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                email = body.email
                fromDate = body.fromDate
                password = body.password
                toDate = body.toDate
                casAuthority = body.casAuthority
                panNo = body.panNo
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Email address to receive the CAS document */
            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Start date for the CAS period (format YYYY-MM-DD) */
            fun fromDate(fromDate: String) = fromDate(JsonField.of(fromDate))

            /**
             * Sets [Builder.fromDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.fromDate] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun fromDate(fromDate: JsonField<String>) = apply { this.fromDate = fromDate }

            /** Password to protect the generated CAS PDF */
            fun password(password: String) = password(JsonField.of(password))

            /**
             * Sets [Builder.password] to an arbitrary JSON value.
             *
             * You should usually call [Builder.password] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun password(password: JsonField<String>) = apply { this.password = password }

            /** End date for the CAS period (format YYYY-MM-DD) */
            fun toDate(toDate: String) = toDate(JsonField.of(toDate))

            /**
             * Sets [Builder.toDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.toDate] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun toDate(toDate: JsonField<String>) = apply { this.toDate = toDate }

            /**
             * CAS authority to generate the document from (currently only kfintech is supported)
             */
            fun casAuthority(casAuthority: CasAuthority) = casAuthority(JsonField.of(casAuthority))

            /**
             * Sets [Builder.casAuthority] to an arbitrary JSON value.
             *
             * You should usually call [Builder.casAuthority] with a well-typed [CasAuthority] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun casAuthority(casAuthority: JsonField<CasAuthority>) = apply {
                this.casAuthority = casAuthority
            }

            /** PAN number (optional for some CAS authorities) */
            fun panNo(panNo: String) = panNo(JsonField.of(panNo))

            /**
             * Sets [Builder.panNo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.panNo] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun panNo(panNo: JsonField<String>) = apply { this.panNo = panNo }

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
             * .email()
             * .fromDate()
             * .password()
             * .toDate()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("email", email),
                    checkRequired("fromDate", fromDate),
                    checkRequired("password", password),
                    checkRequired("toDate", toDate),
                    casAuthority,
                    panNo,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            email()
            fromDate()
            password()
            toDate()
            casAuthority().ifPresent { it.validate() }
            panNo()
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
            (if (email.asKnown().isPresent) 1 else 0) +
                (if (fromDate.asKnown().isPresent) 1 else 0) +
                (if (password.asKnown().isPresent) 1 else 0) +
                (if (toDate.asKnown().isPresent) 1 else 0) +
                (casAuthority.asKnown().getOrNull()?.validity() ?: 0) +
                (if (panNo.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                email == other.email &&
                fromDate == other.fromDate &&
                password == other.password &&
                toDate == other.toDate &&
                casAuthority == other.casAuthority &&
                panNo == other.panNo &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                email,
                fromDate,
                password,
                toDate,
                casAuthority,
                panNo,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{email=$email, fromDate=$fromDate, password=$password, toDate=$toDate, casAuthority=$casAuthority, panNo=$panNo, additionalProperties=$additionalProperties}"
    }

    /** CAS authority to generate the document from (currently only kfintech is supported) */
    class CasAuthority @JsonCreator private constructor(private val value: JsonField<String>) :
        Enum {

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

            @JvmField val KFINTECH = of("kfintech")

            @JvmField val CAMS = of("cams")

            @JvmField val CDSL = of("cdsl")

            @JvmField val NSDL = of("nsdl")

            @JvmStatic fun of(value: String) = CasAuthority(JsonField.of(value))
        }

        /** An enum containing [CasAuthority]'s known values. */
        enum class Known {
            KFINTECH,
            CAMS,
            CDSL,
            NSDL,
        }

        /**
         * An enum containing [CasAuthority]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [CasAuthority] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            KFINTECH,
            CAMS,
            CDSL,
            NSDL,
            /**
             * An enum member indicating that [CasAuthority] was instantiated with an unknown value.
             */
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
                KFINTECH -> Value.KFINTECH
                CAMS -> Value.CAMS
                CDSL -> Value.CDSL
                NSDL -> Value.NSDL
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
                KFINTECH -> Known.KFINTECH
                CAMS -> Known.CAMS
                CDSL -> Known.CDSL
                NSDL -> Known.NSDL
                else -> throw CasParserInvalidDataException("Unknown CasAuthority: $value")
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

        fun validate(): CasAuthority = apply {
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

            return other is CasAuthority && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CasGeneratorGenerateCasParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CasGeneratorGenerateCasParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
