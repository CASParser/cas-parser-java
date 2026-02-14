// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface SmartService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartService

    /**
     * This endpoint parses CAS (Consolidated Account Statement) PDF files from NSDL, CDSL, or
     * CAMS/KFintech and returns data in a unified format. It auto-detects the CAS type and
     * transforms the data into a consistent structure regardless of the source.
     */
    fun parseCasPdf(): UnifiedResponse = parseCasPdf(SmartParseCasPdfParams.none())

    /** @see parseCasPdf */
    fun parseCasPdf(
        params: SmartParseCasPdfParams = SmartParseCasPdfParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UnifiedResponse

    /** @see parseCasPdf */
    fun parseCasPdf(
        params: SmartParseCasPdfParams = SmartParseCasPdfParams.none()
    ): UnifiedResponse = parseCasPdf(params, RequestOptions.none())

    /** @see parseCasPdf */
    fun parseCasPdf(requestOptions: RequestOptions): UnifiedResponse =
        parseCasPdf(SmartParseCasPdfParams.none(), requestOptions)

    /** A view of [SmartService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/smart/parse`, but is otherwise the same as
         * [SmartService.parseCasPdf].
         */
        @MustBeClosed
        fun parseCasPdf(): HttpResponseFor<UnifiedResponse> =
            parseCasPdf(SmartParseCasPdfParams.none())

        /** @see parseCasPdf */
        @MustBeClosed
        fun parseCasPdf(
            params: SmartParseCasPdfParams = SmartParseCasPdfParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UnifiedResponse>

        /** @see parseCasPdf */
        @MustBeClosed
        fun parseCasPdf(
            params: SmartParseCasPdfParams = SmartParseCasPdfParams.none()
        ): HttpResponseFor<UnifiedResponse> = parseCasPdf(params, RequestOptions.none())

        /** @see parseCasPdf */
        @MustBeClosed
        fun parseCasPdf(requestOptions: RequestOptions): HttpResponseFor<UnifiedResponse> =
            parseCasPdf(SmartParseCasPdfParams.none(), requestOptions)
    }
}
