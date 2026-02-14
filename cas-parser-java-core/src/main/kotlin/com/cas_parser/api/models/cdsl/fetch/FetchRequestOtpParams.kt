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

/**
 * **Step 1 of 2**: Request OTP for CDSL CAS fetch.
 *
 * This endpoint:
 * 1. Solves reCAPTCHA automatically (~15-20 seconds)
 * 2. Submits login credentials to CDSL portal
 * 3. Triggers OTP to user's registered mobile number
 *
 * After user receives OTP, call `/v4/cdsl/fetch/{session_id}/verify` to complete.
 */
class FetchRequestOtpParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * CDSL BO ID (16 digits)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun boId(): String = body.boId()

    /**
     * Date of birth (YYYY-MM-DD)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun dob(): String = body.dob()

    /**
     * PAN number
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun pan(): String = body.pan()

    /**
     * Returns the raw JSON value of [boId].
     *
     * Unlike [boId], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _boId(): JsonField<String> = body._boId()

    /**
     * Returns the raw JSON value of [dob].
     *
     * Unlike [dob], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _dob(): JsonField<String> = body._dob()

    /**
     * Returns the raw JSON value of [pan].
     *
     * Unlike [pan], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _pan(): JsonField<String> = body._pan()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FetchRequestOtpParams].
         *
         * The following fields are required:
         * ```java
         * .boId()
         * .dob()
         * .pan()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FetchRequestOtpParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(fetchRequestOtpParams: FetchRequestOtpParams) = apply {
            body = fetchRequestOtpParams.body.toBuilder()
            additionalHeaders = fetchRequestOtpParams.additionalHeaders.toBuilder()
            additionalQueryParams = fetchRequestOtpParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [boId]
         * - [dob]
         * - [pan]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** CDSL BO ID (16 digits) */
        fun boId(boId: String) = apply { body.boId(boId) }

        /**
         * Sets [Builder.boId] to an arbitrary JSON value.
         *
         * You should usually call [Builder.boId] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun boId(boId: JsonField<String>) = apply { body.boId(boId) }

        /** Date of birth (YYYY-MM-DD) */
        fun dob(dob: String) = apply { body.dob(dob) }

        /**
         * Sets [Builder.dob] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dob] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun dob(dob: JsonField<String>) = apply { body.dob(dob) }

        /** PAN number */
        fun pan(pan: String) = apply { body.pan(pan) }

        /**
         * Sets [Builder.pan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pan] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pan(pan: JsonField<String>) = apply { body.pan(pan) }

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
         * Returns an immutable instance of [FetchRequestOtpParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .boId()
         * .dob()
         * .pan()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FetchRequestOtpParams =
            FetchRequestOtpParams(
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
        private val boId: JsonField<String>,
        private val dob: JsonField<String>,
        private val pan: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("bo_id") @ExcludeMissing boId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dob") @ExcludeMissing dob: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pan") @ExcludeMissing pan: JsonField<String> = JsonMissing.of(),
        ) : this(boId, dob, pan, mutableMapOf())

        /**
         * CDSL BO ID (16 digits)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun boId(): String = boId.getRequired("bo_id")

        /**
         * Date of birth (YYYY-MM-DD)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun dob(): String = dob.getRequired("dob")

        /**
         * PAN number
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun pan(): String = pan.getRequired("pan")

        /**
         * Returns the raw JSON value of [boId].
         *
         * Unlike [boId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bo_id") @ExcludeMissing fun _boId(): JsonField<String> = boId

        /**
         * Returns the raw JSON value of [dob].
         *
         * Unlike [dob], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dob") @ExcludeMissing fun _dob(): JsonField<String> = dob

        /**
         * Returns the raw JSON value of [pan].
         *
         * Unlike [pan], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pan") @ExcludeMissing fun _pan(): JsonField<String> = pan

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
             * .boId()
             * .dob()
             * .pan()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var boId: JsonField<String>? = null
            private var dob: JsonField<String>? = null
            private var pan: JsonField<String>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                boId = body.boId
                dob = body.dob
                pan = body.pan
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** CDSL BO ID (16 digits) */
            fun boId(boId: String) = boId(JsonField.of(boId))

            /**
             * Sets [Builder.boId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.boId] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun boId(boId: JsonField<String>) = apply { this.boId = boId }

            /** Date of birth (YYYY-MM-DD) */
            fun dob(dob: String) = dob(JsonField.of(dob))

            /**
             * Sets [Builder.dob] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dob] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun dob(dob: JsonField<String>) = apply { this.dob = dob }

            /** PAN number */
            fun pan(pan: String) = pan(JsonField.of(pan))

            /**
             * Sets [Builder.pan] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pan] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun pan(pan: JsonField<String>) = apply { this.pan = pan }

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
             * .boId()
             * .dob()
             * .pan()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("boId", boId),
                    checkRequired("dob", dob),
                    checkRequired("pan", pan),
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            boId()
            dob()
            pan()
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
            (if (boId.asKnown().isPresent) 1 else 0) +
                (if (dob.asKnown().isPresent) 1 else 0) +
                (if (pan.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                boId == other.boId &&
                dob == other.dob &&
                pan == other.pan &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(boId, dob, pan, additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{boId=$boId, dob=$dob, pan=$pan, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FetchRequestOtpParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "FetchRequestOtpParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
