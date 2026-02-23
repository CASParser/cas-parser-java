// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.logs

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
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class LogGetSummaryResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val status: JsonField<String>,
    private val summary: JsonField<Summary>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
        @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
    ) : this(status, summary, mutableMapOf())

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun summary(): Optional<Summary> = summary.getOptional("summary")

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

    /**
     * Returns the raw JSON value of [summary].
     *
     * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

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

        /** Returns a mutable builder for constructing an instance of [LogGetSummaryResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LogGetSummaryResponse]. */
    class Builder internal constructor() {

        private var status: JsonField<String> = JsonMissing.of()
        private var summary: JsonField<Summary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(logGetSummaryResponse: LogGetSummaryResponse) = apply {
            status = logGetSummaryResponse.status
            summary = logGetSummaryResponse.summary
            additionalProperties = logGetSummaryResponse.additionalProperties.toMutableMap()
        }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

        fun summary(summary: Summary) = summary(JsonField.of(summary))

        /**
         * Sets [Builder.summary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summary] with a well-typed [Summary] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
         * Returns an immutable instance of [LogGetSummaryResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): LogGetSummaryResponse =
            LogGetSummaryResponse(status, summary, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): LogGetSummaryResponse = apply {
        if (validated) {
            return@apply
        }

        status()
        summary().ifPresent { it.validate() }
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
        (if (status.asKnown().isPresent) 1 else 0) +
            (summary.asKnown().getOrNull()?.validity() ?: 0)

    class Summary
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val byFeature: JsonField<List<ByFeature>>,
        private val totalCredits: JsonField<Double>,
        private val totalRequests: JsonField<Long>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("by_feature")
            @ExcludeMissing
            byFeature: JsonField<List<ByFeature>> = JsonMissing.of(),
            @JsonProperty("total_credits")
            @ExcludeMissing
            totalCredits: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("total_requests")
            @ExcludeMissing
            totalRequests: JsonField<Long> = JsonMissing.of(),
        ) : this(byFeature, totalCredits, totalRequests, mutableMapOf())

        /**
         * Usage breakdown by feature
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun byFeature(): Optional<List<ByFeature>> = byFeature.getOptional("by_feature")

        /**
         * Total credits consumed in the period
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun totalCredits(): Optional<Double> = totalCredits.getOptional("total_credits")

        /**
         * Total API requests made in the period
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun totalRequests(): Optional<Long> = totalRequests.getOptional("total_requests")

        /**
         * Returns the raw JSON value of [byFeature].
         *
         * Unlike [byFeature], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("by_feature")
        @ExcludeMissing
        fun _byFeature(): JsonField<List<ByFeature>> = byFeature

        /**
         * Returns the raw JSON value of [totalCredits].
         *
         * Unlike [totalCredits], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("total_credits")
        @ExcludeMissing
        fun _totalCredits(): JsonField<Double> = totalCredits

        /**
         * Returns the raw JSON value of [totalRequests].
         *
         * Unlike [totalRequests], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("total_requests")
        @ExcludeMissing
        fun _totalRequests(): JsonField<Long> = totalRequests

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

            /** Returns a mutable builder for constructing an instance of [Summary]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Summary]. */
        class Builder internal constructor() {

            private var byFeature: JsonField<MutableList<ByFeature>>? = null
            private var totalCredits: JsonField<Double> = JsonMissing.of()
            private var totalRequests: JsonField<Long> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(summary: Summary) = apply {
                byFeature = summary.byFeature.map { it.toMutableList() }
                totalCredits = summary.totalCredits
                totalRequests = summary.totalRequests
                additionalProperties = summary.additionalProperties.toMutableMap()
            }

            /** Usage breakdown by feature */
            fun byFeature(byFeature: List<ByFeature>) = byFeature(JsonField.of(byFeature))

            /**
             * Sets [Builder.byFeature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.byFeature] with a well-typed `List<ByFeature>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun byFeature(byFeature: JsonField<List<ByFeature>>) = apply {
                this.byFeature = byFeature.map { it.toMutableList() }
            }

            /**
             * Adds a single [ByFeature] to [Builder.byFeature].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addByFeature(byFeature: ByFeature) = apply {
                this.byFeature =
                    (this.byFeature ?: JsonField.of(mutableListOf())).also {
                        checkKnown("byFeature", it).add(byFeature)
                    }
            }

            /** Total credits consumed in the period */
            fun totalCredits(totalCredits: Double) = totalCredits(JsonField.of(totalCredits))

            /**
             * Sets [Builder.totalCredits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalCredits] with a well-typed [Double] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalCredits(totalCredits: JsonField<Double>) = apply {
                this.totalCredits = totalCredits
            }

            /** Total API requests made in the period */
            fun totalRequests(totalRequests: Long) = totalRequests(JsonField.of(totalRequests))

            /**
             * Sets [Builder.totalRequests] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalRequests] with a well-typed [Long] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalRequests(totalRequests: JsonField<Long>) = apply {
                this.totalRequests = totalRequests
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
             * Returns an immutable instance of [Summary].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Summary =
                Summary(
                    (byFeature ?: JsonMissing.of()).map { it.toImmutable() },
                    totalCredits,
                    totalRequests,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Summary = apply {
            if (validated) {
                return@apply
            }

            byFeature().ifPresent { it.forEach { it.validate() } }
            totalCredits()
            totalRequests()
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
            (byFeature.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (totalCredits.asKnown().isPresent) 1 else 0) +
                (if (totalRequests.asKnown().isPresent) 1 else 0)

        class ByFeature
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val credits: JsonField<Double>,
            private val feature: JsonField<String>,
            private val requests: JsonField<Long>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("credits")
                @ExcludeMissing
                credits: JsonField<Double> = JsonMissing.of(),
                @JsonProperty("feature")
                @ExcludeMissing
                feature: JsonField<String> = JsonMissing.of(),
                @JsonProperty("requests")
                @ExcludeMissing
                requests: JsonField<Long> = JsonMissing.of(),
            ) : this(credits, feature, requests, mutableMapOf())

            /**
             * Credits consumed by this feature
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun credits(): Optional<Double> = credits.getOptional("credits")

            /**
             * API feature name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun feature(): Optional<String> = feature.getOptional("feature")

            /**
             * Number of requests for this feature
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun requests(): Optional<Long> = requests.getOptional("requests")

            /**
             * Returns the raw JSON value of [credits].
             *
             * Unlike [credits], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("credits") @ExcludeMissing fun _credits(): JsonField<Double> = credits

            /**
             * Returns the raw JSON value of [feature].
             *
             * Unlike [feature], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("feature") @ExcludeMissing fun _feature(): JsonField<String> = feature

            /**
             * Returns the raw JSON value of [requests].
             *
             * Unlike [requests], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("requests") @ExcludeMissing fun _requests(): JsonField<Long> = requests

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

                /** Returns a mutable builder for constructing an instance of [ByFeature]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ByFeature]. */
            class Builder internal constructor() {

                private var credits: JsonField<Double> = JsonMissing.of()
                private var feature: JsonField<String> = JsonMissing.of()
                private var requests: JsonField<Long> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(byFeature: ByFeature) = apply {
                    credits = byFeature.credits
                    feature = byFeature.feature
                    requests = byFeature.requests
                    additionalProperties = byFeature.additionalProperties.toMutableMap()
                }

                /** Credits consumed by this feature */
                fun credits(credits: Double) = credits(JsonField.of(credits))

                /**
                 * Sets [Builder.credits] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.credits] with a well-typed [Double] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun credits(credits: JsonField<Double>) = apply { this.credits = credits }

                /** API feature name */
                fun feature(feature: String) = feature(JsonField.of(feature))

                /**
                 * Sets [Builder.feature] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.feature] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun feature(feature: JsonField<String>) = apply { this.feature = feature }

                /** Number of requests for this feature */
                fun requests(requests: Long) = requests(JsonField.of(requests))

                /**
                 * Sets [Builder.requests] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.requests] with a well-typed [Long] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun requests(requests: JsonField<Long>) = apply { this.requests = requests }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ByFeature].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ByFeature =
                    ByFeature(credits, feature, requests, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): ByFeature = apply {
                if (validated) {
                    return@apply
                }

                credits()
                feature()
                requests()
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
                (if (credits.asKnown().isPresent) 1 else 0) +
                    (if (feature.asKnown().isPresent) 1 else 0) +
                    (if (requests.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ByFeature &&
                    credits == other.credits &&
                    feature == other.feature &&
                    requests == other.requests &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(credits, feature, requests, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ByFeature{credits=$credits, feature=$feature, requests=$requests, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Summary &&
                byFeature == other.byFeature &&
                totalCredits == other.totalCredits &&
                totalRequests == other.totalRequests &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(byFeature, totalCredits, totalRequests, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Summary{byFeature=$byFeature, totalCredits=$totalCredits, totalRequests=$totalRequests, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LogGetSummaryResponse &&
            status == other.status &&
            summary == other.summary &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(status, summary, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LogGetSummaryResponse{status=$status, summary=$summary, additionalProperties=$additionalProperties}"
}
