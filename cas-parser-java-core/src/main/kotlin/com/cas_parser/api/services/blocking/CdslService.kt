// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import com.cas_parser.api.services.blocking.cdsl.FetchService
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CdslService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslService

    fun fetch(): FetchService

    /**
     * This endpoint specifically parses CDSL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from CDSL.
     */
    fun parsePdf(): UnifiedResponse = parsePdf(CdslParsePdfParams.none())

    /** @see parsePdf */
    fun parsePdf(
        params: CdslParsePdfParams = CdslParsePdfParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see parsePdf */
    fun parsePdf(params: CdslParsePdfParams = CdslParsePdfParams.none()): UnifiedResponse =
        parsePdf(params, RequestOptions.none())

    /** @see parsePdf */
    fun parsePdf(requestOptions: RequestOptions): UnifiedResponse =
        parsePdf(CdslParsePdfParams.none(), requestOptions)

    /** A view of [CdslService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslService.WithRawResponse

        fun fetch(): FetchService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/parse`, but is otherwise the same as
         * [CdslService.parsePdf].
         */
        @MustBeClosed
        fun parsePdf(): HttpResponseFor<UnifiedResponse> = parsePdf(CdslParsePdfParams.none())

        /** @see parsePdf */
        @MustBeClosed
        fun parsePdf(
            params: CdslParsePdfParams = CdslParsePdfParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see parsePdf */
        @MustBeClosed
        fun parsePdf(
            params: CdslParsePdfParams = CdslParsePdfParams.none()
        ): HttpResponseFor<UnifiedResponse> = parsePdf(params, RequestOptions.none())

        /** @see parsePdf */
        @MustBeClosed
        fun parsePdf(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            parsePdf(CdslParsePdfParams.none(), requestOptions)
    }
}
