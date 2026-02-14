// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import com.cas_parser.api.services.async.cdsl.FetchServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CdslServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslServiceAsync

    fun fetch(): FetchServiceAsync

    /**
     * This endpoint specifically parses CDSL CAS (Consolidated Account Statement) PDF files and
     * returns data in a unified format. Use this endpoint when you know the PDF is from CDSL.
     */
    fun parsePdf(): CompletableFuture<UnifiedResponse> = parsePdf(CdslParsePdfParams.none())

    /** @see parsePdf */
    fun parsePdf(
        params: CdslParsePdfParams = CdslParsePdfParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<UnifiedResponse>

    /** @see parsePdf */
    fun parsePdf(
        params: CdslParsePdfParams = CdslParsePdfParams.none()
    ): CompletableFuture<UnifiedResponse> = parsePdf(params, RequestOptions.none())

    /** @see parsePdf */
    fun parsePdf(requestOptions: RequestOptions): CompletableFuture<UnifiedResponse> =
        parsePdf(CdslParsePdfParams.none(), requestOptions)

    /** A view of [CdslServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslServiceAsync.WithRawResponse

        fun fetch(): FetchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/parse`, but is otherwise the same as
         * [CdslServiceAsync.parsePdf].
         */
        fun parsePdf(): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parsePdf(CdslParsePdfParams.none())

        /** @see parsePdf */
        fun parsePdf(
            params: CdslParsePdfParams = CdslParsePdfParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>>

        /** @see parsePdf */
        fun parsePdf(
            params: CdslParsePdfParams = CdslParsePdfParams.none()
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parsePdf(params, RequestOptions.none())

        /** @see parsePdf */
        fun parsePdf(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> =
            parsePdf(CdslParsePdfParams.none(), requestOptions)
    }
}
