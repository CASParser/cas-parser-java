// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casparser

import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.MultipartField
import com.cas_parser.api.core.Params
import com.cas_parser.api.core.http.Headers
import com.cas_parser.api.core.http.QueryParams
import com.cas_parser.api.core.toImmutable
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Collections
import java.util.Objects
import java.util.Optional

/**
 * This endpoint specifically parses CDSL CAS (Consolidated Account Statement) PDF files and returns
 * data in a unified format. Use this endpoint when you know the PDF is from CDSL.
 */
class CasParserCdslParams
private constructor(
    private val body: Body,
    private val additionalHeaders: Headers,
    private val additionalQueryParams: QueryParams,
) : Params {

    /**
     * Password for the PDF file (if required)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun password(): Optional<String> = body.password()

    /**
     * Base64 encoded CAS PDF file
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pdfFile(): Optional<String> = body.pdfFile()

    /**
     * URL to the CAS PDF file
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun pdfUrl(): Optional<String> = body.pdfUrl()

    /**
     * Returns the raw multipart value of [password].
     *
     * Unlike [password], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _password(): MultipartField<String> = body._password()

    /**
     * Returns the raw multipart value of [pdfFile].
     *
     * Unlike [pdfFile], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _pdfFile(): MultipartField<String> = body._pdfFile()

    /**
     * Returns the raw multipart value of [pdfUrl].
     *
     * Unlike [pdfUrl], this method doesn't throw if the multipart field has an unexpected type.
     */
    fun _pdfUrl(): MultipartField<String> = body._pdfUrl()

    fun _additionalBodyProperties(): Map<String, JsonValue> = body._additionalProperties()

    /** Additional headers to send with the request. */
    fun _additionalHeaders(): Headers = additionalHeaders

    /** Additional query param to send with the request. */
    fun _additionalQueryParams(): QueryParams = additionalQueryParams

    fun toBuilder() = Builder().from(this)

    companion object {

        @JvmStatic fun none(): CasParserCdslParams = builder().build()

        /** Returns a mutable builder for constructing an instance of [CasParserCdslParams]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CasParserCdslParams]. */
    class Builder internal constructor() {

        private var body: Body.Builder = Body.builder()
        private var additionalHeaders: Headers.Builder = Headers.builder()
        private var additionalQueryParams: QueryParams.Builder = QueryParams.builder()

        @JvmSynthetic
        internal fun from(casParserCdslParams: CasParserCdslParams) = apply {
            body = casParserCdslParams.body.toBuilder()
            additionalHeaders = casParserCdslParams.additionalHeaders.toBuilder()
            additionalQueryParams = casParserCdslParams.additionalQueryParams.toBuilder()
        }

        /**
         * Sets the entire request body.
         *
         * This is generally only useful if you are already constructing the body separately.
         * Otherwise, it's more convenient to use the top-level setters instead:
         * - [password]
         * - [pdfFile]
         * - [pdfUrl]
         */
        fun body(body: Body) = apply { this.body = body.toBuilder() }

        /** Password for the PDF file (if required) */
        fun password(password: String) = apply { body.password(password) }

        /**
         * Sets [Builder.password] to an arbitrary multipart value.
         *
         * You should usually call [Builder.password] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun password(password: MultipartField<String>) = apply { body.password(password) }

        /** Base64 encoded CAS PDF file */
        fun pdfFile(pdfFile: String) = apply { body.pdfFile(pdfFile) }

        /**
         * Sets [Builder.pdfFile] to an arbitrary multipart value.
         *
         * You should usually call [Builder.pdfFile] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pdfFile(pdfFile: MultipartField<String>) = apply { body.pdfFile(pdfFile) }

        /** URL to the CAS PDF file */
        fun pdfUrl(pdfUrl: String) = apply { body.pdfUrl(pdfUrl) }

        /**
         * Sets [Builder.pdfUrl] to an arbitrary multipart value.
         *
         * You should usually call [Builder.pdfUrl] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun pdfUrl(pdfUrl: MultipartField<String>) = apply { body.pdfUrl(pdfUrl) }

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
         * Returns an immutable instance of [CasParserCdslParams].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): CasParserCdslParams =
            CasParserCdslParams(
                body.build(),
                additionalHeaders.build(),
                additionalQueryParams.build(),
            )
    }

    fun _body(): Map<String, MultipartField<*>> =
        (mapOf("password" to _password(), "pdf_file" to _pdfFile(), "pdf_url" to _pdfUrl()) +
                _additionalBodyProperties().mapValues { (_, value) -> MultipartField.of(value) })
            .toImmutable()

    override fun _headers(): Headers = additionalHeaders

    override fun _queryParams(): QueryParams = additionalQueryParams

    class Body
    private constructor(
        private val password: MultipartField<String>,
        private val pdfFile: MultipartField<String>,
        private val pdfUrl: MultipartField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        /**
         * Password for the PDF file (if required)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun password(): Optional<String> = password.value.getOptional("password")

        /**
         * Base64 encoded CAS PDF file
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pdfFile(): Optional<String> = pdfFile.value.getOptional("pdf_file")

        /**
         * URL to the CAS PDF file
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pdfUrl(): Optional<String> = pdfUrl.value.getOptional("pdf_url")

        /**
         * Returns the raw multipart value of [password].
         *
         * Unlike [password], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("password") @ExcludeMissing fun _password(): MultipartField<String> = password

        /**
         * Returns the raw multipart value of [pdfFile].
         *
         * Unlike [pdfFile], this method doesn't throw if the multipart field has an unexpected
         * type.
         */
        @JsonProperty("pdf_file") @ExcludeMissing fun _pdfFile(): MultipartField<String> = pdfFile

        /**
         * Returns the raw multipart value of [pdfUrl].
         *
         * Unlike [pdfUrl], this method doesn't throw if the multipart field has an unexpected type.
         */
        @JsonProperty("pdf_url") @ExcludeMissing fun _pdfUrl(): MultipartField<String> = pdfUrl

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

            private var password: MultipartField<String> = MultipartField.of(null)
            private var pdfFile: MultipartField<String> = MultipartField.of(null)
            private var pdfUrl: MultipartField<String> = MultipartField.of(null)
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(body: Body) = apply {
                password = body.password
                pdfFile = body.pdfFile
                pdfUrl = body.pdfUrl
                additionalProperties = body.additionalProperties.toMutableMap()
            }

            /** Password for the PDF file (if required) */
            fun password(password: String) = password(MultipartField.of(password))

            /**
             * Sets [Builder.password] to an arbitrary multipart value.
             *
             * You should usually call [Builder.password] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun password(password: MultipartField<String>) = apply { this.password = password }

            /** Base64 encoded CAS PDF file */
            fun pdfFile(pdfFile: String) = pdfFile(MultipartField.of(pdfFile))

            /**
             * Sets [Builder.pdfFile] to an arbitrary multipart value.
             *
             * You should usually call [Builder.pdfFile] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pdfFile(pdfFile: MultipartField<String>) = apply { this.pdfFile = pdfFile }

            /** URL to the CAS PDF file */
            fun pdfUrl(pdfUrl: String) = pdfUrl(MultipartField.of(pdfUrl))

            /**
             * Sets [Builder.pdfUrl] to an arbitrary multipart value.
             *
             * You should usually call [Builder.pdfUrl] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pdfUrl(pdfUrl: MultipartField<String>) = apply { this.pdfUrl = pdfUrl }

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
            fun build(): Body = Body(password, pdfFile, pdfUrl, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Body = apply {
            if (validated) {
                return@apply
            }

            password()
            pdfFile()
            pdfUrl()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: CasParserInvalidDataException) {
                false
            }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Body &&
                password == other.password &&
                pdfFile == other.pdfFile &&
                pdfUrl == other.pdfUrl &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(password, pdfFile, pdfUrl, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Body{password=$password, pdfFile=$pdfFile, pdfUrl=$pdfUrl, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CasParserCdslParams &&
            body == other.body &&
            additionalHeaders == other.additionalHeaders &&
            additionalQueryParams == other.additionalQueryParams
    }

    override fun hashCode(): Int = Objects.hash(body, additionalHeaders, additionalQueryParams)

    override fun toString() =
        "CasParserCdslParams{body=$body, additionalHeaders=$additionalHeaders, additionalQueryParams=$additionalQueryParams}"
}
