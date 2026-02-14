// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

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

class InboxConnectEmailResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val expiresIn: JsonField<Long>,
    private val oauthUrl: JsonField<String>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("expires_in") @ExcludeMissing expiresIn: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("oauth_url") @ExcludeMissing oauthUrl: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(expiresIn, oauthUrl, status, mutableMapOf())

    /**
     * Seconds until the OAuth URL expires (typically 10 minutes)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun expiresIn(): Optional<Long> = expiresIn.getOptional("expires_in")

    /**
     * Redirect user to this URL to start OAuth flow
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun oauthUrl(): Optional<String> = oauthUrl.getOptional("oauth_url")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [expiresIn].
     *
     * Unlike [expiresIn], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("expires_in") @ExcludeMissing fun _expiresIn(): JsonField<Long> = expiresIn

    /**
     * Returns the raw JSON value of [oauthUrl].
     *
     * Unlike [oauthUrl], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("oauth_url") @ExcludeMissing fun _oauthUrl(): JsonField<String> = oauthUrl

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
         * Returns a mutable builder for constructing an instance of [InboxConnectEmailResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxConnectEmailResponse]. */
    class Builder internal constructor() {

        private var expiresIn: JsonField<Long> = JsonMissing.of()
        private var oauthUrl: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboxConnectEmailResponse: InboxConnectEmailResponse) = apply {
            expiresIn = inboxConnectEmailResponse.expiresIn
            oauthUrl = inboxConnectEmailResponse.oauthUrl
            status = inboxConnectEmailResponse.status
            additionalProperties = inboxConnectEmailResponse.additionalProperties.toMutableMap()
        }

        /** Seconds until the OAuth URL expires (typically 10 minutes) */
        fun expiresIn(expiresIn: Long) = expiresIn(JsonField.of(expiresIn))

        /**
         * Sets [Builder.expiresIn] to an arbitrary JSON value.
         *
         * You should usually call [Builder.expiresIn] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun expiresIn(expiresIn: JsonField<Long>) = apply { this.expiresIn = expiresIn }

        /** Redirect user to this URL to start OAuth flow */
        fun oauthUrl(oauthUrl: String) = oauthUrl(JsonField.of(oauthUrl))

        /**
         * Sets [Builder.oauthUrl] to an arbitrary JSON value.
         *
         * You should usually call [Builder.oauthUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun oauthUrl(oauthUrl: JsonField<String>) = apply { this.oauthUrl = oauthUrl }

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
         * Returns an immutable instance of [InboxConnectEmailResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboxConnectEmailResponse =
            InboxConnectEmailResponse(
                expiresIn,
                oauthUrl,
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InboxConnectEmailResponse = apply {
        if (validated) {
            return@apply
        }

        expiresIn()
        oauthUrl()
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
        (if (expiresIn.asKnown().isPresent) 1 else 0) +
            (if (oauthUrl.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxConnectEmailResponse &&
            expiresIn == other.expiresIn &&
            oauthUrl == other.oauthUrl &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(expiresIn, oauthUrl, status, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboxConnectEmailResponse{expiresIn=$expiresIn, oauthUrl=$oauthUrl, status=$status, additionalProperties=$additionalProperties}"
}
