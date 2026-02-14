// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.camskfintech

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

class LinkedHolder
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val name: JsonField<String>,
    private val pan: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
        @JsonProperty("pan") @ExcludeMissing pan: JsonField<String> = JsonMissing.of(),
    ) : this(name, pan, mutableMapOf())

    /**
     * Name of the account holder
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun name(): Optional<String> = name.getOptional("name")

    /**
     * PAN of the account holder
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pan(): Optional<String> = pan.getOptional("pan")

    /**
     * Returns the raw JSON value of [name].
     *
     * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

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

        /** Returns a mutable builder for constructing an instance of [LinkedHolder]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LinkedHolder]. */
    class Builder internal constructor() {

        private var name: JsonField<String> = JsonMissing.of()
        private var pan: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(linkedHolder: LinkedHolder) = apply {
            name = linkedHolder.name
            pan = linkedHolder.pan
            additionalProperties = linkedHolder.additionalProperties.toMutableMap()
        }

        /** Name of the account holder */
        fun name(name: String) = name(JsonField.of(name))

        /**
         * Sets [Builder.name] to an arbitrary JSON value.
         *
         * You should usually call [Builder.name] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun name(name: JsonField<String>) = apply { this.name = name }

        /** PAN of the account holder */
        fun pan(pan: String) = pan(JsonField.of(pan))

        /**
         * Sets [Builder.pan] to an arbitrary JSON value.
         *
         * You should usually call [Builder.pan] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
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
         * Returns an immutable instance of [LinkedHolder].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): LinkedHolder = LinkedHolder(name, pan, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): LinkedHolder = apply {
        if (validated) {
            return@apply
        }

        name()
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
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (if (name.asKnown().isPresent) 1 else 0) + (if (pan.asKnown().isPresent) 1 else 0)

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LinkedHolder &&
            name == other.name &&
            pan == other.pan &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(name, pan, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LinkedHolder{name=$name, pan=$pan, additionalProperties=$additionalProperties}"
}
