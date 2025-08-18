// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.casparser.CasParserCamsKfintechParams
import com.cas_parser.api.models.casparser.CasParserCdslParams
import com.cas_parser.api.models.casparser.CasParserNsdlParams
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import com.cas_parser.api.models.casparser.UnifiedResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CasParserService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserService

    /**
     * This endpoint specifically parses CAMS/KFintech CAS (Consolidated Account Statement) PDF
     * files and returns data in a unified format. Use this endpoint when you know the PDF is from
     * CAMS or KFintech.
     */
    fun camsKfintech(): UnifiedResponse = camsKfintech(CasParserCamsKfintechParams.none())

    /** @see camsKfintech */
    fun camsKfintech(
        params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see camsKfintech */
    fun camsKfintech(
        params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none()
    ): UnifiedResponse = camsKfintech(params, RequestOptions.none())

    /** @see camsKfintech */
    fun camsKfintech(requestOptions: RequestOptions): UnifiedResponse =
        camsKfintech(CasParserCamsKfintechParams.none(), requestOptions)

    /**
     * This endpoint specifically parses CDSL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from CDSL.
     */
    fun cdsl(): UnifiedResponse = cdsl(CasParserCdslParams.none())

    /** @see cdsl */
    fun cdsl(
        params: CasParserCdslParams = CasParserCdslParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see cdsl */
    fun cdsl(params: CasParserCdslParams = CasParserCdslParams.none()): UnifiedResponse =
        cdsl(params, RequestOptions.none())

    /** @see cdsl */
    fun cdsl(requestOptions: RequestOptions): UnifiedResponse =
        cdsl(CasParserCdslParams.none(), requestOptions)

    /**
     * This endpoint specifically parses NSDL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from NSDL.
     */
    fun nsdl(): UnifiedResponse = nsdl(CasParserNsdlParams.none())

    /** @see nsdl */
    fun nsdl(
        params: CasParserNsdlParams = CasParserNsdlParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see nsdl */
    fun nsdl(params: CasParserNsdlParams = CasParserNsdlParams.none()): UnifiedResponse =
        nsdl(params, RequestOptions.none())

    /** @see nsdl */
    fun nsdl(requestOptions: RequestOptions): UnifiedResponse =
        nsdl(CasParserNsdlParams.none(), requestOptions)

    /**
     * This endpoint parses CAS (Consolidated Account Statement) PDF files from NSDL, CDSL, or
     * CAMS/KFintech and returns data in a unified format. It auto-detects the CAS type and
     * transforms the data into a consistent structure regardless of the source.
     */
    fun smartParse(): UnifiedResponse = smartParse(CasParserSmartParseParams.none())

    /** @see smartParse */
    fun smartParse(
        params: CasParserSmartParseParams = CasParserSmartParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see smartParse */
    fun smartParse(
        params: CasParserSmartParseParams = CasParserSmartParseParams.none()
    ): UnifiedResponse = smartParse(params, RequestOptions.none())

    /** @see smartParse */
    fun smartParse(requestOptions: RequestOptions): UnifiedResponse =
        smartParse(CasParserSmartParseParams.none(), requestOptions)

    /** A view of [CasParserService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cams_kfintech/parse`, but is otherwise the same
         * as [CasParserService.camsKfintech].
         */
        @MustBeClosed
        fun camsKfintech(): HttpResponseFor<UnifiedResponse> =
            camsKfintech(CasParserCamsKfintechParams.none())

        /** @see camsKfintech */
        @MustBeClosed
        fun camsKfintech(
            params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see camsKfintech */
        @MustBeClosed
        fun camsKfintech(
            params: CasParserCamsKfintechParams = CasParserCamsKfintechParams.none()
        ): HttpResponseFor<UnifiedResponse> = camsKfintech(params, RequestOptions.none())

        /** @see camsKfintech */
        @MustBeClosed
        fun camsKfintech(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            camsKfintech(CasParserCamsKfintechParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/parse`, but is otherwise the same as
         * [CasParserService.cdsl].
         */
        @MustBeClosed
        fun cdsl(): HttpResponseFor<UnifiedResponse> = cdsl(CasParserCdslParams.none())

        /** @see cdsl */
        @MustBeClosed
        fun cdsl(
            params: CasParserCdslParams = CasParserCdslParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see cdsl */
        @MustBeClosed
        fun cdsl(
            params: CasParserCdslParams = CasParserCdslParams.none()
        ): HttpResponseFor<UnifiedResponse> = cdsl(params, RequestOptions.none())

        /** @see cdsl */
        @MustBeClosed
        fun cdsl(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            cdsl(CasParserCdslParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/nsdl/parse`, but is otherwise the same as
         * [CasParserService.nsdl].
         */
        @MustBeClosed
        fun nsdl(): HttpResponseFor<UnifiedResponse> = nsdl(CasParserNsdlParams.none())

        /** @see nsdl */
        @MustBeClosed
        fun nsdl(
            params: CasParserNsdlParams = CasParserNsdlParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see nsdl */
        @MustBeClosed
        fun nsdl(
            params: CasParserNsdlParams = CasParserNsdlParams.none()
        ): HttpResponseFor<UnifiedResponse> = nsdl(params, RequestOptions.none())

        /** @see nsdl */
        @MustBeClosed
        fun nsdl(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            nsdl(CasParserNsdlParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /v4/smart/parse`, but is otherwise the same as
         * [CasParserService.smartParse].
         */
        @MustBeClosed
        fun smartParse(): HttpResponseFor<UnifiedResponse> =
            smartParse(CasParserSmartParseParams.none())

        /** @see smartParse */
        @MustBeClosed
        fun smartParse(
            params: CasParserSmartParseParams = CasParserSmartParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see smartParse */
        @MustBeClosed
        fun smartParse(
            params: CasParserSmartParseParams = CasParserSmartParseParams.none()
        ): HttpResponseFor<UnifiedResponse> = smartParse(params, RequestOptions.none())

        /** @see smartParse */
        @MustBeClosed
        fun smartParse(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            smartParse(CasParserSmartParseParams.none(), requestOptions)
    }
}
