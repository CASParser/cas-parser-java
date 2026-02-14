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

class InboxCheckConnectionStatusResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val connected: JsonField<Boolean>,
    private val email: JsonField<String>,
    private val provider: JsonField<String>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("connected") @ExcludeMissing connected: JsonField<Boolean> = JsonMissing.of(),
        @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
        @JsonProperty("provider") @ExcludeMissing provider: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(connected, email, provider, status, mutableMapOf())

    /**
     * Whether the token is valid and usable
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun connected(): Optional<Boolean> = connected.getOptional("connected")

    /**
     * Email address of the connected account
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun email(): Optional<String> = email.getOptional("email")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun provider(): Optional<String> = provider.getOptional("provider")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [connected].
     *
     * Unlike [connected], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("connected") @ExcludeMissing fun _connected(): JsonField<Boolean> = connected

    /**
     * Returns the raw JSON value of [email].
     *
     * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

    /**
     * Returns the raw JSON value of [provider].
     *
     * Unlike [provider], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

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
         * [InboxCheckConnectionStatusResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxCheckConnectionStatusResponse]. */
    class Builder internal constructor() {

        private var connected: JsonField<Boolean> = JsonMissing.of()
        private var email: JsonField<String> = JsonMissing.of()
        private var provider: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboxCheckConnectionStatusResponse: InboxCheckConnectionStatusResponse) =
            apply {
                connected = inboxCheckConnectionStatusResponse.connected
                email = inboxCheckConnectionStatusResponse.email
                provider = inboxCheckConnectionStatusResponse.provider
                status = inboxCheckConnectionStatusResponse.status
                additionalProperties =
                    inboxCheckConnectionStatusResponse.additionalProperties.toMutableMap()
            }

        /** Whether the token is valid and usable */
        fun connected(connected: Boolean) = connected(JsonField.of(connected))

        /**
         * Sets [Builder.connected] to an arbitrary JSON value.
         *
         * You should usually call [Builder.connected] with a well-typed [Boolean] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun connected(connected: JsonField<Boolean>) = apply { this.connected = connected }

        /** Email address of the connected account */
        fun email(email: String) = email(JsonField.of(email))

        /**
         * Sets [Builder.email] to an arbitrary JSON value.
         *
         * You should usually call [Builder.email] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun email(email: JsonField<String>) = apply { this.email = email }

        fun provider(provider: String) = provider(JsonField.of(provider))

        /**
         * Sets [Builder.provider] to an arbitrary JSON value.
         *
         * You should usually call [Builder.provider] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun provider(provider: JsonField<String>) = apply { this.provider = provider }

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
         * Returns an immutable instance of [InboxCheckConnectionStatusResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboxCheckConnectionStatusResponse =
            InboxCheckConnectionStatusResponse(
                connected,
                email,
                provider,
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InboxCheckConnectionStatusResponse = apply {
        if (validated) {
            return@apply
        }

        connected()
        email()
        provider()
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
        (if (connected.asKnown().isPresent) 1 else 0) +
            (if (email.asKnown().isPresent) 1 else 0) +
            (if (provider.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxCheckConnectionStatusResponse &&
            connected == other.connected &&
            email == other.email &&
            provider == other.provider &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(connected, email, provider, status, additionalProperties)
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboxCheckConnectionStatusResponse{connected=$connected, email=$email, provider=$provider, status=$status, additionalProperties=$additionalProperties}"
}
