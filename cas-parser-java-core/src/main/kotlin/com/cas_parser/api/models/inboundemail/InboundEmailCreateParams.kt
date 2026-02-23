// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/**
 * Create a dedicated inbound email address for collecting CAS statements via email forwarding.
 *
 * **How it works:**
 * 1. Create an inbound email with your webhook URL
 * 2. Display the email address to your user (e.g., "Forward your CAS to
 *    ie_xxx@import.casparser.in")
 * 3. When an investor forwards a CAS email, we verify the sender and deliver to your webhook
 *
 * **Webhook Delivery:**
 * - We POST to your `callback_url` with JSON body containing files (matching EmailCASFile schema)
 * - Failed deliveries are retried automatically with exponential backoff
 *
 * **Inactivity:**
 * - Inbound emails with no activity in 30 days are marked inactive
 * - Active inbound emails remain operational indefinitely
 */
class InboundEmailCreateParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Webhook URL where we POST email notifications. Must be HTTPS in production (HTTP allowed for
     * localhost during development).
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
     *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
     */
    fun callbackUrl(): String = body.callbackUrl()

    /**
     * Optional custom email prefix for user-friendly addresses.
     * - Must be 3-32 characters
     * - Alphanumeric + hyphens only
     * - Must start and end with letter/number
     * - Example: `john-portfolio@import.casparser.in`
     * - If omitted, generates random ID like `ie_abc123xyz@import.casparser.in`
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun alias(): Optional<String> = body.alias()

    /**
     * Filter emails by CAS provider. If omitted, accepts all providers.
     * - `cdsl` → eCAS@cdslstatement.com
     * - `nsdl` → NSDL-CAS@nsdl.co.in
     * - `cams` → donotreply@camsonline.com
     * - `kfintech` → samfS@kfintech.com
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun allowedSources(): Optional<List<AllowedSource>> = body.allowedSources()

    /**
     * Optional key-value pairs (max 10) to include in webhook payload. Useful for passing context
     * like plan_type, campaign_id, etc.
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun metadata(): Optional<Metadata> = body.metadata()

    /**
     * Your internal identifier (e.g., user_id, account_id). Returned in webhook payload for
     * correlation.
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun reference(): Optional<String> = body.reference()

    /**
     * Returns the raw JSON value of [callbackUrl].
     *
     * Unlike [callbackUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _callbackUrl(): JsonField<String> = body._callbackUrl()

    /**
     * Returns the raw JSON value of [alias].
     *
     * Unlike [alias], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _alias(): JsonField<String> = body._alias()

    /**
     * Returns the raw JSON value of [allowedSources].
     *
     * Unlike [allowedSources], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _allowedSources(): JsonField<List<AllowedSource>> = body._allowedSources()

    /**
     * Returns the raw JSON value of [metadata].
     *
     * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _metadata(): JsonField<Metadata> = body._metadata()

    /**
     * Returns the raw JSON value of [reference].
     *
     * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
     */
    fun _reference(): JsonField<String> = body._reference()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InboundEmailCreateParams].
         *
         * The following fields are required:
         * ```java
         * .callbackUrl()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboundEmailCreateParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(inboundEmailCreateParams: InboundEmailCreateParams) = apply {
            body = inboundEmailCreateParams.body.toBuilder()
            additionalHeaders = inboundEmailCreateParams.additionalHeaders.toBuilder()
            additionalQueryParams = inboundEmailCreateParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [callbackUrl]
         * - [alias]
         * - [allowedSources]
         * - [metadata]
         * - [reference]
         * - etc.
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /**
         * Webhook URL where we POST email notifications. Must be HTTPS in production (HTTP allowed
         * for localhost during development).
         */
        fun callbackUrl(callbackUrl: String) = apply { body.callbackUrl(callbackUrl) }

        /**
         * Sets [Builder.callbackUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.callbackUrl] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun callbackUrl(callbackUrl: JsonField<String>) = apply { body.callbackUrl(callbackUrl) }

        /**
         * Optional custom email prefix for user-friendly addresses.
         * - Must be 3-32 characters
         * - Alphanumeric + hyphens only
         * - Must start and end with letter/number
         * - Example: `john-portfolio@import.casparser.in`
         * - If omitted, generates random ID like `ie_abc123xyz@import.casparser.in`
         */
        fun alias(alias: String) = apply { body.alias(alias) }

        /**
         * Sets [Builder.alias] to an arbitrary JSON value.
         *
         * You should usually call [Builder.alias] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun alias(alias: JsonField<String>) = apply { body.alias(alias) }

        /**
         * Filter emails by CAS provider. If omitted, accepts all providers.
         * - `cdsl` → eCAS@cdslstatement.com
         * - `nsdl` → NSDL-CAS@nsdl.co.in
         * - `cams` → donotreply@camsonline.com
         * - `kfintech` → samfS@kfintech.com
         */
        fun allowedSources(allowedSources: List<AllowedSource>) = apply {
            body.allowedSources(allowedSources)
        }

        /**
         * Sets [Builder.allowedSources] to an arbitrary JSON value.
         *
         * You should usually call [Builder.allowedSources] with a well-typed `List<AllowedSource>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun allowedSources(allowedSources: JsonField<List<AllowedSource>>) = apply {
            body.allowedSources(allowedSources)
        }

        /**
         * Adds a single [AllowedSource] to [allowedSources].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addAllowedSource(allowedSource: AllowedSource) = apply {
            body.addAllowedSource(allowedSource)
        }

        /**
         * Optional key-value pairs (max 10) to include in webhook payload. Useful for passing
         * context like plan_type, campaign_id, etc.
         */
        fun metadata(metadata: Metadata) = apply { body.metadata(metadata) }

        /**
         * Sets [Builder.metadata] to an arbitrary JSON value.
         *
         * You should usually call [Builder.metadata] with a well-typed [Metadata] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun metadata(metadata: JsonField<Metadata>) = apply { body.metadata(metadata) }

        /**
         * Your internal identifier (e.g., user_id, account_id). Returned in webhook payload for
         * correlation.
         */
        fun reference(reference: String) = apply { body.reference(reference) }

        /**
         * Sets [Builder.reference] to an arbitrary JSON value.
         *
         * You should usually call [Builder.reference] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun reference(reference: JsonField<String>) = apply { body.reference(reference) }

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
         * Returns an immutable instance of [InboundEmailCreateParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .callbackUrl()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InboundEmailCreateParams =
            InboundEmailCreateParams(
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
        private val callbackUrl: JsonField<String>,
        private val alias: JsonField<String>,
        private val allowedSources: JsonField<List<AllowedSource>>,
        private val metadata: JsonField<Metadata>,
        private val reference: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("callback_url")
            @ExcludeMissing
            callbackUrl: JsonField<String> = JsonMissing.of(),
            @JsonProperty("alias") @ExcludeMissing alias: JsonField<String> = JsonMissing.of(),
            @JsonProperty("allowed_sources")
            @ExcludeMissing
            allowedSources: JsonField<List<AllowedSource>> = JsonMissing.of(),
            @JsonProperty("metadata")
            @ExcludeMissing
            metadata: JsonField<Metadata> = JsonMissing.of(),
            @JsonProperty("reference")
            @ExcludeMissing
            reference: JsonField<String> = JsonMissing.of(),
        ) : this(callbackUrl, alias, allowedSources, metadata, reference, mutableMapOf())

        /**
         * Webhook URL where we POST email notifications. Must be HTTPS in production (HTTP allowed
         * for localhost during development).
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type or is
         *   unexpectedly missing or null (e.g. if the server responded with an unexpected value).
         */
        fun callbackUrl(): String = callbackUrl.getRequired("callback_url")

        /**
         * Optional custom email prefix for user-friendly addresses.
         * - Must be 3-32 characters
         * - Alphanumeric + hyphens only
         * - Must start and end with letter/number
         * - Example: `john-portfolio@import.casparser.in`
         * - If omitted, generates random ID like `ie_abc123xyz@import.casparser.in`
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun alias(): Optional<String> = alias.getOptional("alias")

        /**
         * Filter emails by CAS provider. If omitted, accepts all providers.
         * - `cdsl` → eCAS@cdslstatement.com
         * - `nsdl` → NSDL-CAS@nsdl.co.in
         * - `cams` → donotreply@camsonline.com
         * - `kfintech` → samfS@kfintech.com
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun allowedSources(): Optional<List<AllowedSource>> =
            allowedSources.getOptional("allowed_sources")

        /**
         * Optional key-value pairs (max 10) to include in webhook payload. Useful for passing
         * context like plan_type, campaign_id, etc.
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun metadata(): Optional<Metadata> = metadata.getOptional("metadata")

        /**
         * Your internal identifier (e.g., user_id, account_id). Returned in webhook payload for
         * correlation.
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun reference(): Optional<String> = reference.getOptional("reference")

        /**
         * Returns the raw JSON value of [callbackUrl].
         *
         * Unlike [callbackUrl], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("callback_url")
        @ExcludeMissing
        fun _callbackUrl(): JsonField<String> = callbackUrl

        /**
         * Returns the raw JSON value of [alias].
         *
         * Unlike [alias], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("alias") @ExcludeMissing fun _alias(): JsonField<String> = alias

        /**
         * Returns the raw JSON value of [allowedSources].
         *
         * Unlike [allowedSources], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("allowed_sources")
        @ExcludeMissing
        fun _allowedSources(): JsonField<List<AllowedSource>> = allowedSources

        /**
         * Returns the raw JSON value of [metadata].
         *
         * Unlike [metadata], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("metadata") @ExcludeMissing fun _metadata(): JsonField<Metadata> = metadata

        /**
         * Returns the raw JSON value of [reference].
         *
         * Unlike [reference], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("reference") @ExcludeMissing fun _reference(): JsonField<String> = reference

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
             * .callbackUrl()
             * ```
             */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Body]. */
        class Builder internal constructor() {

            private var callbackUrl: JsonField<String>? = null
            private var alias: JsonField<String> = JsonMissing.of()
            private var allowedSources: JsonField<MutableList<AllowedSource>>? = null
            private var metadata: JsonField<Metadata> = JsonMissing.of()
            private var reference: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                callbackUrl = body.callbackUrl
                alias = body.alias
                allowedSources = body.allowedSources.map { it.toMutableList() }
                metadata = body.metadata
                reference = body.reference
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /**
             * Webhook URL where we POST email notifications. Must be HTTPS in production (HTTP
             * allowed for localhost during development).
             */
            fun callbackUrl(callbackUrl: String) = callbackUrl(JsonField.of(callbackUrl))

            /**
             * Sets [Builder.callbackUrl] to an arbitrary JSON value.
             *
             * You should usually call [Builder.callbackUrl] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun callbackUrl(callbackUrl: JsonField<String>) = apply {
                this.callbackUrl = callbackUrl
            }

            /**
             * Optional custom email prefix for user-friendly addresses.
             * - Must be 3-32 characters
             * - Alphanumeric + hyphens only
             * - Must start and end with letter/number
             * - Example: `john-portfolio@import.casparser.in`
             * - If omitted, generates random ID like `ie_abc123xyz@import.casparser.in`
             */
            fun alias(alias: String) = alias(JsonField.of(alias))

            /**
             * Sets [Builder.alias] to an arbitrary JSON value.
             *
             * You should usually call [Builder.alias] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun alias(alias: JsonField<String>) = apply { this.alias = alias }

            /**
             * Filter emails by CAS provider. If omitted, accepts all providers.
             * - `cdsl` → eCAS@cdslstatement.com
             * - `nsdl` → NSDL-CAS@nsdl.co.in
             * - `cams` → donotreply@camsonline.com
             * - `kfintech` → samfS@kfintech.com
             */
            fun allowedSources(allowedSources: List<AllowedSource>) =
                allowedSources(JsonField.of(allowedSources))

            /**
             * Sets [Builder.allowedSources] to an arbitrary JSON value.
             *
             * You should usually call [Builder.allowedSources] with a well-typed
             * `List<AllowedSource>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun allowedSources(allowedSources: JsonField<List<AllowedSource>>) = apply {
                this.allowedSources = allowedSources.map { it.toMutableList() }
            }

            /**
             * Adds a single [AllowedSource] to [allowedSources].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addAllowedSource(allowedSource: AllowedSource) = apply {
                allowedSources =
                    (allowedSources ?: JsonField.of(mutableListOf())).also {
                        checkKnown("allowedSources", it).add(allowedSource)
                    }
            }

            /**
             * Optional key-value pairs (max 10) to include in webhook payload. Useful for passing
             * context like plan_type, campaign_id, etc.
             */
            fun metadata(metadata: Metadata) = metadata(JsonField.of(metadata))

            /**
             * Sets [Builder.metadata] to an arbitrary JSON value.
             *
             * You should usually call [Builder.metadata] with a well-typed [Metadata] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun metadata(metadata: JsonField<Metadata>) = apply { this.metadata = metadata }

            /**
             * Your internal identifier (e.g., user_id, account_id). Returned in webhook payload for
             * correlation.
             */
            fun reference(reference: String) = reference(JsonField.of(reference))

            /**
             * Sets [Builder.reference] to an arbitrary JSON value.
             *
             * You should usually call [Builder.reference] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun reference(reference: JsonField<String>) = apply { this.reference = reference }

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
             * .callbackUrl()
             * ```
             *
             * @throws IllegalStateException if any required field is unset.
             */
            fun build(): Body =
                Body(
                    checkRequired("callbackUrl", callbackUrl),
                    alias,
                    (allowedSources ?: JsonMissing.of()).map { it.toImmutable() },
                    metadata,
                    reference,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            callbackUrl()
            alias()
            allowedSources().ifPresent { it.forEach { it.validate() } }
            metadata().ifPresent { it.validate() }
            reference()
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
            (if (callbackUrl.asKnown().isPresent) 1 else 0) +
                (if (alias.asKnown().isPresent) 1 else 0) +
                (allowedSources.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (metadata.asKnown().getOrNull()?.validity() ?: 0) +
                (if (reference.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                callbackUrl == other.callbackUrl &&
                alias == other.alias &&
                allowedSources == other.allowedSources &&
                metadata == other.metadata &&
                reference == other.reference &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                callbackUrl,
                alias,
                allowedSources,
                metadata,
                reference,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{callbackUrl=$callbackUrl, alias=$alias, allowedSources=$allowedSources, metadata=$metadata, reference=$reference, additionalProperties=$additionalProperties}"
    }

    class AllowedSource @JsonCreator private constructor(private val value: JsonField<String>) :
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

            @JvmField val CDSL = of("cdsl")

            @JvmField val NSDL = of("nsdl")

            @JvmField val CAMS = of("cams")

            @JvmField val KFINTECH = of("kfintech")

            @JvmStatic fun of(value: String) = AllowedSource(JsonField.of(value))
        }

        /** An enum containing [AllowedSource]'s known values. */
        enum class Known {
            CDSL,
            NSDL,
            CAMS,
            KFINTECH,
        }

        /**
         * An enum containing [AllowedSource]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [AllowedSource] can contain an unknown value in a couple of cases:
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
            /**
             * An enum member indicating that [AllowedSource] was instantiated with an unknown
             * value.
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
                else -> throw CasParserInvalidDataException("Unknown AllowedSource: $value")
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

        fun validate(): AllowedSource = apply {
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

            return other is AllowedSource && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    /**
     * Optional key-value pairs (max 10) to include in webhook payload. Useful for passing context
     * like plan_type, campaign_id, etc.
     */
    class Metadata
    @JsonCreator
    private constructor(
        @com.fasterxml.jackson.annotation.JsonValue
        private val additionalProperties: Map<String, JsonValue>
    ) {

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> = additionalProperties

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [Metadata]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Metadata]. */
        class Builder internal constructor() {

            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(metadata: Metadata) = apply {
                additionalProperties = metadata.additionalProperties.toMutableMap()
            }

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
             * Returns an immutable instance of [Metadata].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Metadata = Metadata(additionalProperties.toImmutable())
        }

        private var validated: Boolean = false

        fun validate(): Metadata = apply {
            if (validated) {
                return@apply
            }

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
            additionalProperties.count { (_, value) -> !value.isNull() && !value.isMissing() }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Metadata && additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy { Objects.hash(additionalProperties) }

        override fun hashCode(): Int = hashCode

        override fun toString() = "Metadata{additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboundEmailCreateParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "InboundEmailCreateParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
