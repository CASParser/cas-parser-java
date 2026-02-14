// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.Enum
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
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class InboxListCasFilesResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val count: JsonField<Long>,
    private val files: JsonField<List<File>>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("count") @ExcludeMissing count: JsonField<Long> = JsonMissing.of(),
        @JsonProperty("files") @ExcludeMissing files: JsonField<List<File>> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(count, files, status, mutableMapOf())

    /**
     * Number of CAS files found
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun count(): Optional<Long> = count.getOptional("count")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun files(): Optional<List<File>> = files.getOptional("files")

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
     * Returns the raw JSON value of [files].
     *
     * Unlike [files], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("files") @ExcludeMissing fun _files(): JsonField<List<File>> = files

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
         * Returns a mutable builder for constructing an instance of [InboxListCasFilesResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InboxListCasFilesResponse]. */
    class Builder internal constructor() {

        private var count: JsonField<Long> = JsonMissing.of()
        private var files: JsonField<MutableList<File>>? = null
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(inboxListCasFilesResponse: InboxListCasFilesResponse) = apply {
            count = inboxListCasFilesResponse.count
            files = inboxListCasFilesResponse.files.map { it.toMutableList() }
            status = inboxListCasFilesResponse.status
            additionalProperties = inboxListCasFilesResponse.additionalProperties.toMutableMap()
        }

        /** Number of CAS files found */
        fun count(count: Long) = count(JsonField.of(count))

        /**
         * Sets [Builder.count] to an arbitrary JSON value.
         *
         * You should usually call [Builder.count] with a well-typed [Long] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun count(count: JsonField<Long>) = apply { this.count = count }

        fun files(files: List<File>) = files(JsonField.of(files))

        /**
         * Sets [Builder.files] to an arbitrary JSON value.
         *
         * You should usually call [Builder.files] with a well-typed `List<File>` value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun files(files: JsonField<List<File>>) = apply {
            this.files = files.map { it.toMutableList() }
        }

        /**
         * Adds a single [File] to [files].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addFile(file: File) = apply {
            files =
                (files ?: JsonField.of(mutableListOf())).also { checkKnown("files", it).add(file) }
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
         * Returns an immutable instance of [InboxListCasFilesResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): InboxListCasFilesResponse =
            InboxListCasFilesResponse(
                count,
                (files ?: JsonMissing.of()).map { it.toImmutable() },
                status,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): InboxListCasFilesResponse = apply {
        if (validated) {
            return@apply
        }

        count()
        files().ifPresent { it.forEach { it.validate() } }
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
            (files.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    /** A CAS file found in the user's email inbox */
    class File
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val casType: JsonField<CasType>,
        private val expiresIn: JsonField<Long>,
        private val filename: JsonField<String>,
        private val messageDate: JsonField<LocalDate>,
        private val messageId: JsonField<String>,
        private val originalFilename: JsonField<String>,
        private val size: JsonField<Long>,
        private val url: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cas_type")
            @ExcludeMissing
            casType: JsonField<CasType> = JsonMissing.of(),
            @JsonProperty("expires_in")
            @ExcludeMissing
            expiresIn: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("filename")
            @ExcludeMissing
            filename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("message_date")
            @ExcludeMissing
            messageDate: JsonField<LocalDate> = JsonMissing.of(),
            @JsonProperty("message_id")
            @ExcludeMissing
            messageId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("original_filename")
            @ExcludeMissing
            originalFilename: JsonField<String> = JsonMissing.of(),
            @JsonProperty("size") @ExcludeMissing size: JsonField<Long> = JsonMissing.of(),
            @JsonProperty("url") @ExcludeMissing url: JsonField<String> = JsonMissing.of(),
        ) : this(
            casType,
            expiresIn,
            filename,
            messageDate,
            messageId,
            originalFilename,
            size,
            url,
            mutableMapOf(),
        )

        /**
         * Detected CAS provider based on sender email
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun casType(): Optional<CasType> = casType.getOptional("cas_type")

        /**
         * URL expiration time in seconds (default 86400 = 24 hours)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun expiresIn(): Optional<Long> = expiresIn.getOptional("expires_in")

        /**
         * Standardized filename (provider_YYYYMMDD_uniqueid.pdf)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun filename(): Optional<String> = filename.getOptional("filename")

        /**
         * Date the email was received
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun messageDate(): Optional<LocalDate> = messageDate.getOptional("message_date")

        /**
         * Unique identifier for the email message (use for subsequent API calls)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun messageId(): Optional<String> = messageId.getOptional("message_id")

        /**
         * Original attachment filename from the email
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun originalFilename(): Optional<String> = originalFilename.getOptional("original_filename")

        /**
         * File size in bytes
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun size(): Optional<Long> = size.getOptional("size")

        /**
         * Direct download URL (presigned, expires based on expires_in)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun url(): Optional<String> = url.getOptional("url")

        /**
         * Returns the raw JSON value of [casType].
         *
         * Unlike [casType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cas_type") @ExcludeMissing fun _casType(): JsonField<CasType> = casType

        /**
         * Returns the raw JSON value of [expiresIn].
         *
         * Unlike [expiresIn], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("expires_in") @ExcludeMissing fun _expiresIn(): JsonField<Long> = expiresIn

        /**
         * Returns the raw JSON value of [filename].
         *
         * Unlike [filename], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("filename") @ExcludeMissing fun _filename(): JsonField<String> = filename

        /**
         * Returns the raw JSON value of [messageDate].
         *
         * Unlike [messageDate], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message_date")
        @ExcludeMissing
        fun _messageDate(): JsonField<LocalDate> = messageDate

        /**
         * Returns the raw JSON value of [messageId].
         *
         * Unlike [messageId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("message_id") @ExcludeMissing fun _messageId(): JsonField<String> = messageId

        /**
         * Returns the raw JSON value of [originalFilename].
         *
         * Unlike [originalFilename], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("original_filename")
        @ExcludeMissing
        fun _originalFilename(): JsonField<String> = originalFilename

        /**
         * Returns the raw JSON value of [size].
         *
         * Unlike [size], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("size") @ExcludeMissing fun _size(): JsonField<Long> = size

        /**
         * Returns the raw JSON value of [url].
         *
         * Unlike [url], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("url") @ExcludeMissing fun _url(): JsonField<String> = url

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

            /** Returns a mutable builder for constructing an instance of [File]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [File]. */
        class Builder internal constructor() {

            private var casType: JsonField<CasType> = JsonMissing.of()
            private var expiresIn: JsonField<Long> = JsonMissing.of()
            private var filename: JsonField<String> = JsonMissing.of()
            private var messageDate: JsonField<LocalDate> = JsonMissing.of()
            private var messageId: JsonField<String> = JsonMissing.of()
            private var originalFilename: JsonField<String> = JsonMissing.of()
            private var size: JsonField<Long> = JsonMissing.of()
            private var url: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(file: File) = apply {
                casType = file.casType
                expiresIn = file.expiresIn
                filename = file.filename
                messageDate = file.messageDate
                messageId = file.messageId
                originalFilename = file.originalFilename
                size = file.size
                url = file.url
                additionalProperties = file.additionalProperties.toMutableMap()
            }

            /** Detected CAS provider based on sender email */
            fun casType(casType: CasType) = casType(JsonField.of(casType))

            /**
             * Sets [Builder.casType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.casType] with a well-typed [CasType] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun casType(casType: JsonField<CasType>) = apply { this.casType = casType }

            /** URL expiration time in seconds (default 86400 = 24 hours) */
            fun expiresIn(expiresIn: Long) = expiresIn(JsonField.of(expiresIn))

            /**
             * Sets [Builder.expiresIn] to an arbitrary JSON value.
             *
             * You should usually call [Builder.expiresIn] with a well-typed [Long] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun expiresIn(expiresIn: JsonField<Long>) = apply { this.expiresIn = expiresIn }

            /** Standardized filename (provider_YYYYMMDD_uniqueid.pdf) */
            fun filename(filename: String) = filename(JsonField.of(filename))

            /**
             * Sets [Builder.filename] to an arbitrary JSON value.
             *
             * You should usually call [Builder.filename] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun filename(filename: JsonField<String>) = apply { this.filename = filename }

            /** Date the email was received */
            fun messageDate(messageDate: LocalDate) = messageDate(JsonField.of(messageDate))

            /**
             * Sets [Builder.messageDate] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageDate] with a well-typed [LocalDate] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageDate(messageDate: JsonField<LocalDate>) = apply {
                this.messageDate = messageDate
            }

            /** Unique identifier for the email message (use for subsequent API calls) */
            fun messageId(messageId: String) = messageId(JsonField.of(messageId))

            /**
             * Sets [Builder.messageId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.messageId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun messageId(messageId: JsonField<String>) = apply { this.messageId = messageId }

            /** Original attachment filename from the email */
            fun originalFilename(originalFilename: String) =
                originalFilename(JsonField.of(originalFilename))

            /**
             * Sets [Builder.originalFilename] to an arbitrary JSON value.
             *
             * You should usually call [Builder.originalFilename] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun originalFilename(originalFilename: JsonField<String>) = apply {
                this.originalFilename = originalFilename
            }

            /** File size in bytes */
            fun size(size: Long) = size(JsonField.of(size))

            /**
             * Sets [Builder.size] to an arbitrary JSON value.
             *
             * You should usually call [Builder.size] with a well-typed [Long] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun size(size: JsonField<Long>) = apply { this.size = size }

            /** Direct download URL (presigned, expires based on expires_in) */
            fun url(url: String) = url(JsonField.of(url))

            /**
             * Sets [Builder.url] to an arbitrary JSON value.
             *
             * You should usually call [Builder.url] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun url(url: JsonField<String>) = apply { this.url = url }

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
             * Returns an immutable instance of [File].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): File =
                File(
                    casType,
                    expiresIn,
                    filename,
                    messageDate,
                    messageId,
                    originalFilename,
                    size,
                    url,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): File = apply {
            if (validated) {
                return@apply
            }

            casType().ifPresent { it.validate() }
            expiresIn()
            filename()
            messageDate()
            messageId()
            originalFilename()
            size()
            url()
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
            (casType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (expiresIn.asKnown().isPresent) 1 else 0) +
                (if (filename.asKnown().isPresent) 1 else 0) +
                (if (messageDate.asKnown().isPresent) 1 else 0) +
                (if (messageId.asKnown().isPresent) 1 else 0) +
                (if (originalFilename.asKnown().isPresent) 1 else 0) +
                (if (size.asKnown().isPresent) 1 else 0) +
                (if (url.asKnown().isPresent) 1 else 0)

        /** Detected CAS provider based on sender email */
        class CasType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
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
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                CDSL,
                NSDL,
                CAMS,
                KFINTECH,
                /**
                 * An enum member indicating that [CasType] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
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
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
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
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CasParserInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
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

            return other is File &&
                casType == other.casType &&
                expiresIn == other.expiresIn &&
                filename == other.filename &&
                messageDate == other.messageDate &&
                messageId == other.messageId &&
                originalFilename == other.originalFilename &&
                size == other.size &&
                url == other.url &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                casType,
                expiresIn,
                filename,
                messageDate,
                messageId,
                originalFilename,
                size,
                url,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "File{casType=$casType, expiresIn=$expiresIn, filename=$filename, messageDate=$messageDate, messageId=$messageId, originalFilename=$originalFilename, size=$size, url=$url, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InboxListCasFilesResponse &&
            count == other.count &&
            files == other.files &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(count, files, status, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "InboxListCasFilesResponse{count=$count, files=$files, status=$status, additionalProperties=$additionalProperties}"
}
