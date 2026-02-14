// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.CamsKfintechParseParams
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CamsKfintechServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CamsKfintechServiceAsync

    /**
     * This endpoint specifically parses CAMS/KFintech CAS (Consolidated Account Statement) PDF
     * files and returns data in a unified format. Use this endpoint when you know the PDF is from
     * CAMS or KFintech.
     */
    fun parse(): CompletableFuture<UnifiedResponse> = parse(CamsKfintechParseParams.none())

    /** @see parse */
    fun parse(
        params: CamsKfintechParseParams = CamsKfintechParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see parse */
    fun parse(
        params: CamsKfintechParseParams = CamsKfintechParseParams.none()
    ): CompletableFuture<UnifiedResponse> = parse(params, RequestOptions.none())

    /** @see parse */
    fun parse(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        parse(CamsKfintechParseParams.none(), requestOptions)

    /**
     * A view of [CamsKfintechServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CamsKfintechServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cams_kfintech/parse`, but is otherwise the same
         * as [CamsKfintechServiceAsync.parse].
         */
        fun parse(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(CamsKfintechParseParams.none())

        /** @see parse */
        fun parse(
            params: CamsKfintechParseParams = CamsKfintechParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see parse */
        fun parse(
            params: CamsKfintechParseParams = CamsKfintechParseParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(params, RequestOptions.none())

        /** @see parse */
        fun parse(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(CamsKfintechParseParams.none(), requestOptions)
    }
}
