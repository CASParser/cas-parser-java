// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.casparser.CasParserCamsKfintechParams
import com.cas_parser.api.models.casparser.CasParserCdslParams
import com.cas_parser.api.models.casparser.CasParserNsdlParams
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import com.cas_parser.api.models.casparser.UnifiedResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CasParserServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserServiceAsync

    /**
     * This endpoint specifically parses CAMS/KFintech CAS (Consolidated Account Statement) PDF
     * files and returns data in a unified format. Use this endpoint when you know the PDF is from
     * CAMS or KFintech.
     */
    fun camsKfintech(): CompletableFuture<UnifiedResponse> =
        camsKfintech(CasParserCamsKfintechParams.none())

    /** @see camsKfintech */
    fun camsKfintech(
        params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see camsKfintech */
    fun camsKfintech(
        params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none()
    ): CompletableFuture<UnifiedResponse> = camsKfintech(params, RequestOptions.none())

    /** @see camsKfintech */
    fun camsKfintech(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        camsKfintech(CasParserCamsKfintechParams.none(), requestOptions)

    /**
     * This endpoint specifically parses CDSL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from CDSL.
     */
    fun cdsl(): CompletableFuture<UnifiedResponse> = cdsl(CasParserCdslParams.none())

    /** @see cdsl */
    fun cdsl(
        params: CasParserCdslParams = CasParserCdslParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see cdsl */
    fun cdsl(
        params: CasParserCdslParams = CasParserCdslParams.none()
    ): CompletableFuture<UnifiedResponse> = cdsl(params, RequestOptions.none())

    /** @see cdsl */
    fun cdsl(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        cdsl(CasParserCdslParams.none(), requestOptions)

    /**
     * This endpoint specifically parses NSDL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from NSDL.
     */
    fun nsdl(): CompletableFuture<UnifiedResponse> = nsdl(CasParserNsdlParams.none())

    /** @see nsdl */
    fun nsdl(
        params: CasParserNsdlParams = CasParserNsdlParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see nsdl */
    fun nsdl(
        params: CasParserNsdlParams = CasParserNsdlParams.none()
    ): CompletableFuture<UnifiedResponse> = nsdl(params, RequestOptions.none())

    /** @see nsdl */
    fun nsdl(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        nsdl(CasParserNsdlParams.none(), requestOptions)

    /**
     * This endpoint parses CAS (Consolidated Account Statement) PDF files from NSDL, CDSL, or
     * CAMS/KFintech and returns data in a unified format. It auto-detects the CAS type and
     * transforms the data into a consistent structure regardless of the source.
     */
    fun smartParse(): CompletableFuture<UnifiedResponse> =
        smartParse(CasParserSmartParseParams.none())

    /** @see smartParse */
    fun smartParse(
        params: CasParserSmartParseParams = CasParserSmartParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see smartParse */
    fun smartParse(
        params: CasParserSmartParseParams = CasParserSmartParseParams.none()
    ): CompletableFuture<UnifiedResponse> = smartParse(params, RequestOptions.none())

    /** @see smartParse */
    fun smartParse(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        smartParse(CasParserSmartParseParams.none(), requestOptions)

    /**
     * A view of [CasParserServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cams_kfintech/parse`, but is otherwise the same
         * as [CasParserServiceAsync.camsKfintech].
         */
        fun camsKfintech(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            camsKfintech(CasParserCamsKfintechParams.none())

        /** @see camsKfintech */
        fun camsKfintech(
            params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see camsKfintech */
        fun camsKfintech(
            params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            camsKfintech(params, RequestOptions.none())

        /** @see camsKfintech */
        fun camsKfintech(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            camsKfintech(CasParserCamsKfintechParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/parse`, but is otherwise the same as
         * [CasParserServiceAsync.cdsl].
         */
        fun cdsl(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            cdsl(CasParserCdslParams.none())

        /** @see cdsl */
        fun cdsl(
            params: CasParserCdslParams = CasParserCdslParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see cdsl */
        fun cdsl(
            params: CasParserCdslParams = CasParserCdslParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> = cdsl(params, RequestOptions.none())

        /** @see cdsl */
        fun cdsl(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            cdsl(CasParserCdslParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/nsdl/parse`, but is otherwise the same as
         * [CasParserServiceAsync.nsdl].
         */
        fun nsdl(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            nsdl(CasParserNsdlParams.none())

        /** @see nsdl */
        fun nsdl(
            params: CasParserNsdlParams = CasParserNsdlParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see nsdl */
        fun nsdl(
            params: CasParserNsdlParams = CasParserNsdlParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> = nsdl(params, RequestOptions.none())

        /** @see nsdl */
        fun nsdl(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            nsdl(CasParserNsdlParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/smart/parse`, but is otherwise the same as
         * [CasParserServiceAsync.smartParse].
         */
        fun smartParse(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            smartParse(CasParserSmartParseParams.none())

        /** @see smartParse */
        fun smartParse(
            params: CasParserSmartParseParams = CasParserSmartParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see smartParse */
        fun smartParse(
            params: CasParserSmartParseParams = CasParserSmartParseParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            smartParse(params, RequestOptions.none())

        /** @see smartParse */
        fun smartParse(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            smartParse(CasParserSmartParseParams.none(), requestOptions)
    }
}
