// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogCreateResponse
import com.cas_parser.api.models.logs.LogGetSummaryParams
import com.cas_parser.api.models.logs.LogGetSummaryResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface LogService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogService

    /**
     * Retrieve detailed API usage logs for your account.
     *
     * Returns a list of API calls with timestamps, features used, status codes, and credits
     * consumed. Useful for monitoring usage patterns and debugging.
     */
    fun create(): LogCreateResponse = create(LogCreateParams.none())

    /** @see create */
    fun create(
        params: LogCreateParams = LogCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogCreateResponse

    /** @see create */
    fun create(params: LogCreateParams = LogCreateParams.none()): LogCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): LogCreateResponse =
        create(LogCreateParams.none(), requestOptions)

    /**
     * Get aggregated usage statistics grouped by feature.
     *
     * Useful for understanding which API features are being used most and tracking usage trends.
     */
    fun getSummary(): LogGetSummaryResponse = getSummary(LogGetSummaryParams.none())

    /** @see getSummary */
    fun getSummary(
        params: LogGetSummaryParams = LogGetSummaryParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LogGetSummaryResponse

    /** @see getSummary */
    fun getSummary(
        params: LogGetSummaryParams = LogGetSummaryParams.none()
    ): LogGetSummaryResponse = getSummary(params, RequestOptions.none())

    /** @see getSummary */
    fun getSummary(requestOptions: RequestOptions): LogGetSummaryResponse =
        getSummary(LogGetSummaryParams.none(), requestOptions)

    /** A view of [LogService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /logs`, but is otherwise the same as
         * [LogService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<LogCreateResponse> = create(LogCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: LogCreateParams = LogCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: LogCreateParams = LogCreateParams.none()
        ): HttpResponseFor<LogCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<LogCreateResponse> =
            create(LogCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /logs/summary`, but is otherwise the same as
         * [LogService.getSummary].
         */
        @MustBeClosed
        fun getSummary(): HttpResponseFor<LogGetSummaryResponse> =
            getSummary(LogGetSummaryParams.none())

        /** @see getSummary */
        @MustBeClosed
        fun getSummary(
            params: LogGetSummaryParams = LogGetSummaryParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LogGetSummaryResponse>

        /** @see getSummary */
        @MustBeClosed
        fun getSummary(
            params: LogGetSummaryParams = LogGetSummaryParams.none()
        ): HttpResponseFor<LogGetSummaryResponse> = getSummary(params, RequestOptions.none())

        /** @see getSummary */
        @MustBeClosed
        fun getSummary(requestOptions: RequestOptions): HttpResponseFor<LogGetSummaryResponse> =
            getSummary(LogGetSummaryParams.none(), requestOptions)
    }
}
