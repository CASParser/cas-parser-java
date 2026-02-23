// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.credits.CreditCheckParams
import com.cas_parser.api.models.credits.CreditCheckResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CreditService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService

    /**
     * Check your remaining API credits and usage for the current billing period.
     *
     * Returns:
     * - Number of API calls used and remaining credits
     * - Credit limit and reset date
     * - List of enabled features for your plan
     *
     * Credits reset at the start of each billing period.
     */
    fun check(): CreditCheckResponse = check(CreditCheckParams.none())

    /** @see check */
    fun check(
        params: CreditCheckParams = CreditCheckParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreditCheckResponse

    /** @see check */
    fun check(params: CreditCheckParams = CreditCheckParams.none()): CreditCheckResponse =
        check(params, RequestOptions.none())

    /** @see check */
    fun check(requestOptions: RequestOptions): CreditCheckResponse =
        check(CreditCheckParams.none(), requestOptions)

    /** A view of [CreditService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CreditService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/credits`, but is otherwise the same as
         * [CreditService.check].
         */
        @MustBeClosed
        fun check(): HttpResponseFor<CreditCheckResponse> = check(CreditCheckParams.none())

        /** @see check */
        @MustBeClosed
        fun check(
            params: CreditCheckParams = CreditCheckParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreditCheckResponse>

        /** @see check */
        @MustBeClosed
        fun check(
            params: CreditCheckParams = CreditCheckParams.none()
        ): HttpResponseFor<CreditCheckResponse> = check(params, RequestOptions.none())

        /** @see check */
        @MustBeClosed
        fun check(requestOptions: RequestOptions): HttpResponseFor<CreditCheckResponse> =
            check(CreditCheckParams.none(), requestOptions)
    }
}
