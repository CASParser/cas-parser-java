// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface SmartServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartServiceAsync

    /**
     * This endpoint parses CAS (Consolidated Account Statement) PDF files from NSDL, CDSL, or
     * CAMS/KFintech and returns data in a unified format. It auto-detects the CAS type and
     * transforms the data into a consistent structure regardless of the source.
     */
    fun parseCasPdf(): CompletableFuture<UnifiedResponse> =
        parseCasPdf(SmartParseCasPdfParams.none())

    /** @see parseCasPdf */
    fun parseCasPdf(
        params: SmartParseCasPdfParams = SmartParseCasPdfParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see parseCasPdf */
    fun parseCasPdf(
        params: SmartParseCasPdfParams = SmartParseCasPdfParams.none()
    ): CompletableFuture<UnifiedResponse> = parseCasPdf(params, RequestOptions.none())

    /** @see parseCasPdf */
    fun parseCasPdf(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        parseCasPdf(SmartParseCasPdfParams.none(), requestOptions)

    /** A view of [SmartServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmartServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/smart/parse`, but is otherwise the same as
         * [SmartServiceAsync.parseCasPdf].
         */
        fun parseCasPdf(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parseCasPdf(SmartParseCasPdfParams.none())

        /** @see parseCasPdf */
        fun parseCasPdf(
            params: SmartParseCasPdfParams = SmartParseCasPdfParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see parseCasPdf */
        fun parseCasPdf(
            params: SmartParseCasPdfParams = SmartParseCasPdfParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parseCasPdf(params, RequestOptions.none())

        /** @see parseCasPdf */
        fun parseCasPdf(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parseCasPdf(SmartParseCasPdfParams.none(), requestOptions)
    }
}
