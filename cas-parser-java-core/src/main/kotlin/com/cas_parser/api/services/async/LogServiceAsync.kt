// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogCreateResponse
import com.cas_parser.api.models.logs.LogGetSummaryParams
import com.cas_parser.api.models.logs.LogGetSummaryResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface LogServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogServiceAsync

    /**
     * Retrieve detailed API usage logs for your account.
     *
     * Returns a list of API calls with timestamps, features used, status codes, and credits
     * consumed. Useful for monitoring usage patterns and debugging.
     */
    fun create(): CompletableFuture<LogCreateResponse> = create(LogCreateParams.none())

    /** @see create */
    fun create(
        params: LogCreateParams = LogCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LogCreateResponse>

    /** @see create */
    fun create(
        params: LogCreateParams = LogCreateParams.none()
    ): CompletableFuture<LogCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<LogCreateResponse> =
        create(LogCreateParams.none(), requestOptions)

    /**
     * Get aggregated usage statistics grouped by feature.
     *
     * Useful for understanding which API features are being used most and tracking usage trends.
     */
    fun getSummary(): CompletableFuture<LogGetSummaryResponse> =
        getSummary(LogGetSummaryParams.none())

    /** @see getSummary */
    fun getSummary(
        params: LogGetSummaryParams = LogGetSummaryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LogGetSummaryResponse>

    /** @see getSummary */
    fun getSummary(
        params: LogGetSummaryParams = LogGetSummaryParams.none()
    ): CompletableFuture<LogGetSummaryResponse> = getSummary(params, RequestOptions.none())

    /** @see getSummary */
    fun getSummary(requestOptions: RequestOptions): CompletableFuture<LogGetSummaryResponse> =
        getSummary(LogGetSummaryParams.none(), requestOptions)

    /** A view of [LogServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /logs`, but is otherwise the same as
         * [LogServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<LogCreateResponse>> =
            create(LogCreateParams.none())

        /** @see create */
        fun create(
            params: LogCreateParams = LogCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LogCreateResponse>>

        /** @see create */
        fun create(
            params: LogCreateParams = LogCreateParams.none()
        ): CompletableFuture<HttpResponseFor<LogCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<LogCreateResponse>> =
            create(LogCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /logs/summary`, but is otherwise the same as
         * [LogServiceAsync.getSummary].
         */
        fun getSummary(): CompletableFuture<HttpResponseFor<LogGetSummaryResponse>> =
            getSummary(LogGetSummaryParams.none())

        /** @see getSummary */
        fun getSummary(
            params: LogGetSummaryParams = LogGetSummaryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LogGetSummaryResponse>>

        /** @see getSummary */
        fun getSummary(
            params: LogGetSummaryParams = LogGetSummaryParams.none()
        ): CompletableFuture<HttpResponseFor<LogGetSummaryResponse>> =
            getSummary(params, RequestOptions.none())

        /** @see getSummary */
        fun getSummary(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<LogGetSummaryResponse>> =
            getSummary(LogGetSummaryParams.none(), requestOptions)
    }
}
