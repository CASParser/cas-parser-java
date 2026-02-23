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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class LogCreateResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val logs: JsonField<List<Log>>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("logs") @ExcludeMissing logs: JsonField<List<Log>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(count, logs, status, mutableMapOf())

    /**
     * Number of logs returned
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun count(): Optional<Long> = count.getOptional("count")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun logs(): Optional<List<Log>> = logs.getOptional("logs")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [count].
     *
     * Unlike [count], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

    /**
     * Returns the raw JSON value of [logs].
     *
     * Unlike [logs], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("logs") @ExcludeMissing fun _logs(): JsonField<List<Log>> = logs

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

        /** Returns a mutable builder for constructing an instance of [LogCreateResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LogCreateResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long> = JsonMissing.of()
        private var logs: JsonField<MutableList<Log>>? = null
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(logCreateResponse: LogCreateResponse) = apply {
            count = logCreateResponse.count
            logs = logCreateResponse.logs.map { it.toMutableList() }
            status = logCreateResponse.status
            additionalProperties = logCreateResponse.additionalProperties.toMutableMap()
        }

        /** Number of logs returned */
        fun count(count: Long) = count(JsonField.of(count))

        /**
         * Sets [Builder.count] to an arbitrary JSON value.
         *
         * You should usually call [Builder.count] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun logs(logs: List<Log>) = logs(JsonField.of(logs))

        /**
         * Sets [Builder.logs] to an arbitrary JSON value.
         *
         * You should usually call [Builder.logs] with a well-typed `List<Log>` value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun logs(logs: JsonField<List<Log>>) = apply { this.logs = logs.map { it.toMutableList() } }

        /**
         * Adds a single [Log] to [logs].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addLog(log: Log) = apply {
            logs = (logs ?: JsonField.of(mutableListOf())).also { checkKnown("logs", it).add(log) }
        }

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
         * Returns an immutable instance of [LogCreateResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): LogCreateResponse =
            LogCreateResponse(
                count,
                (logs ?: JsonMissing.of()).map { it.toImmutable() },
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): LogCreateResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        logs().ifPresent { it.forEach { it.validate() } }
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
        (if (count.asKnown().isPresent) 1 else 0) +
            (logs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    class Log
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val credits: JsonField<Double>,
        private val feature: JsonField<String>,
        private val path: JsonField<String>,
        private val requestId: JsonField<String>,
        private val statusCode: JsonField<Long>,
        private val timestamp: JsonField<OffsetDateTime>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("credits") @ExcludeMissing credits: JsonField<Double> = JsonMissing.of(),
            @JsonProperty("feature") @ExcludeMissing feature: JsonField<String> = JsonMissing.of(),
            @JsonProperty("path") @ExcludeMissing path: JsonField<String> = JsonMissing.of(),
            @JsonProperty("request_id")
            @ExcludeMissing
            requestId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("status_code")
            @ExcludeMissing
            statusCode: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("timestamp")
            @ExcludeMissing
            timestamp: JsonField<OffsetDateTime> = JsonMissing.of(),
        ) : this(credits, feature, path, requestId, statusCode, timestamp, mutableMapOf())

        /**
         * Credits consumed for this request
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun credits(): Optional<Double> = credits.getOptional("credits")

        /**
         * API feature used
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun feature(): Optional<String> = feature.getOptional("feature")

        /**
         * API endpoint path
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun path(): Optional<String> = path.getOptional("path")

        /**
         * Unique request identifier
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun requestId(): Optional<String> = requestId.getOptional("request_id")

        /**
         * HTTP response status code
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun statusCode(): Optional<Long> = statusCode.getOptional("status_code")

        /**
         * When the request was made
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun timestamp(): Optional<OffsetDateTime> = timestamp.getOptional("timestamp")

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
         * Returns the raw JSON value of [path].
         *
         * Unlike [path], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("path") @ExcludeMissing fun _path(): JsonField<String> = path

        /**
         * Returns the raw JSON value of [requestId].
         *
         * Unlike [requestId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("request_id") @ExcludeMissing fun _requestId(): JsonField<String> = requestId

        /**
         * Returns the raw JSON value of [statusCode].
         *
         * Unlike [statusCode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("status_code") @ExcludeMissing fun _statusCode(): JsonField<Long> = statusCode

        /**
         * Returns the raw JSON value of [timestamp].
         *
         * Unlike [timestamp], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("timestamp")
        @ExcludeMissing
        fun _timestamp(): JsonField<OffsetDateTime> = timestamp

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

            /** Returns a mutable builder for constructing an instance of [Log]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Log]. */
        class Builder internal constructor() {

            private var credits: JsonField<Double> = JsonMissing.of()
            private var feature: JsonField<String> = JsonMissing.of()
            private var path: JsonField<String> = JsonMissing.of()
            private var requestId: JsonField<String> = JsonMissing.of()
            private var statusCode: JsonField<Long> = JsonMissing.of()
            private var timestamp: JsonField<OffsetDateTime> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(log: Log) = apply {
                credits = log.credits
                feature = log.feature
                path = log.path
                requestId = log.requestId
                statusCode = log.statusCode
                timestamp = log.timestamp
                additionalProperties = log.additionalProperties.toMutableMap()
            }

            /** Credits consumed for this request */
            fun credits(credits: Double) = credits(JsonField.of(credits))

            /**
             * Sets [Builder.credits] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credits] with a well-typed [Double] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credits(credits: JsonField<Double>) = apply { this.credits = credits }

            /** API feature used */
            fun feature(feature: String) = feature(JsonField.of(feature))

            /**
             * Sets [Builder.feature] to an arbitrary JSON value.
             *
             * You should usually call [Builder.feature] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun feature(feature: JsonField<String>) = apply { this.feature = feature }

            /** API endpoint path */
            fun path(path: String) = path(JsonField.of(path))

            /**
             * Sets [Builder.path] to an arbitrary JSON value.
             *
             * You should usually call [Builder.path] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun path(path: JsonField<String>) = apply { this.path = path }

            /** Unique request identifier */
            fun requestId(requestId: String) = requestId(JsonField.of(requestId))

            /**
             * Sets [Builder.requestId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.requestId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun requestId(requestId: JsonField<String>) = apply { this.requestId = requestId }

            /** HTTP response status code */
            fun statusCode(statusCode: Long) = statusCode(JsonField.of(statusCode))

            /**
             * Sets [Builder.statusCode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.statusCode] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun statusCode(statusCode: JsonField<Long>) = apply { this.statusCode = statusCode }

            /** When the request was made */
            fun timestamp(timestamp: OffsetDateTime) = timestamp(JsonField.of(timestamp))

            /**
             * Sets [Builder.timestamp] to an arbitrary JSON value.
             *
             * You should usually call [Builder.timestamp] with a well-typed [OffsetDateTime] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun timestamp(timestamp: JsonField<OffsetDateTime>) = apply {
                this.timestamp = timestamp
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
             * Returns an immutable instance of [Log].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Log =
                Log(
                    credits,
                    feature,
                    path,
                    requestId,
                    statusCode,
                    timestamp,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Log = apply {
            if (validated) {
                return@apply
            }

            credits()
            feature()
            path()
            requestId()
            statusCode()
            timestamp()
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
                (if (path.asKnown().isPresent) 1 else 0) +
                (if (requestId.asKnown().isPresent) 1 else 0) +
                (if (statusCode.asKnown().isPresent) 1 else 0) +
                (if (timestamp.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Log &&
                credits == other.credits &&
                feature == other.feature &&
                path == other.path &&
                requestId == other.requestId &&
                statusCode == other.statusCode &&
                timestamp == other.timestamp &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                credits,
                feature,
                path,
                requestId,
                statusCode,
                timestamp,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Log{credits=$credits, feature=$feature, path=$path, requestId=$requestId, statusCode=$statusCode, timestamp=$timestamp, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is LogCreateResponse &&
            count == other.count &&
            logs == other.logs &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, logs, status, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "LogCreateResponse{count=$count, logs=$logs, status=$status, additionalProperties=$additionalProperties}"
}
