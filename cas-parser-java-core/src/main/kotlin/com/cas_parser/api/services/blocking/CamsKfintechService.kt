// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.CamsKfintechParseParams
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CamsKfintechService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CamsKfintechService

    /**
     * This endpoint specifically parses CAMS/KFintech CAS (Consolidated Account Statement) PDF
     * files and returns data in a unified format. Use this endpoint when you know the PDF is from
     * CAMS or KFintech.
     */
    fun parse(): UnifiedResponse = parse(CamsKfintechParseParams.none())

    /** @see parse */
    fun parse(
        params: CamsKfintechParseParams = CamsKfintechParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see parse */
    fun parse(params: CamsKfintechParseParams = CamsKfintechParseParams.none()): UnifiedResponse =
        parse(params, RequestOptions.none())

    /** @see parse */
    fun parse(requestOptions: RequestOptions): UnifiedResponse =
        parse(CamsKfintechParseParams.none(), requestOptions)

    /**
     * A view of [CamsKfintechService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CamsKfintechService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cams_kfintech/parse`, but is otherwise the same
         * as [CamsKfintechService.parse].
         */
        @MustBeClosed
        fun parse(): HttpResponseFor<UnifiedResponse> = parse(CamsKfintechParseParams.none())

        /** @see parse */
        @MustBeClosed
        fun parse(
            params: CamsKfintechParseParams = CamsKfintechParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see parse */
        @MustBeClosed
        fun parse(
            params: CamsKfintechParseParams = CamsKfintechParseParams.none()
        ): HttpResponseFor<UnifiedResponse> = parse(params, RequestOptions.none())

        /** @see parse */
        @MustBeClosed
        fun parse(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            parse(CamsKfintechParseParams.none(), requestOptions)
    }
}
