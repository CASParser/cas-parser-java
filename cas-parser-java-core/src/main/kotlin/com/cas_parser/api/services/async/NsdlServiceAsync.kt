// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.nsdl.NsdlParseParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface NsdlServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): NsdlServiceAsync

    /**
     * This endpoint specifically parses NSDL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from NSDL.
     */
    fun parse(): CompletableFuture<UnifiedResponse> = parse(NsdlParseParams.none())

    /** @see parse */
    fun parse(
        params: NsdlParseParams = NsdlParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see parse */
    fun parse(
        params: NsdlParseParams = NsdlParseParams.none()
    ): CompletableFuture<UnifiedResponse> = parse(params, RequestOptions.none())

    /** @see parse */
    fun parse(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        parse(NsdlParseParams.none(), requestOptions)

    /** A view of [NsdlServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): NsdlServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/nsdl/parse`, but is otherwise the same as
         * [NsdlServiceAsync.parse].
         */
        fun parse(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(NsdlParseParams.none())

        /** @see parse */
        fun parse(
            params: NsdlParseParams = NsdlParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see parse */
        fun parse(
            params: NsdlParseParams = NsdlParseParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(params, RequestOptions.none())

        /** @see parse */
        fun parse(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parse(NsdlParseParams.none(), requestOptions)
    }
}
