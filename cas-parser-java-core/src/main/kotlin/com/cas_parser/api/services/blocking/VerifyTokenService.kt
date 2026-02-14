// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.verifytoken.VerifyTokenVerifyParams
import com.cas_parser.api.models.verifytoken.VerifyTokenVerifyResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface VerifyTokenService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VerifyTokenService

    /** Verify an access token and check if it's still valid. Useful for debugging token issues. */
    fun verify(): VerifyTokenVerifyResponse = verify(VerifyTokenVerifyParams.none())

    /** @see verify */
    fun verify(
        params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VerifyTokenVerifyResponse

    /** @see verify */
    fun verify(
        params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none()
    ): VerifyTokenVerifyResponse = verify(params, RequestOptions.none())

    /** @see verify */
    fun verify(requestOptions: RequestOptions): VerifyTokenVerifyResponse =
        verify(VerifyTokenVerifyParams.none(), requestOptions)

    /**
     * A view of [VerifyTokenService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VerifyTokenService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/verify-token`, but is otherwise the same as
         * [VerifyTokenService.verify].
         */
        @MustBeClosed
        fun verify(): HttpResponseFor<VerifyTokenVerifyResponse> =
            verify(VerifyTokenVerifyParams.none())

        /** @see verify */
        @MustBeClosed
        fun verify(
            params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VerifyTokenVerifyResponse>

        /** @see verify */
        @MustBeClosed
        fun verify(
            params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none()
        ): HttpResponseFor<VerifyTokenVerifyResponse> = verify(params, RequestOptions.none())

        /** @see verify */
        @MustBeClosed
        fun verify(requestOptions: RequestOptions): HttpResponseFor<VerifyTokenVerifyResponse> =
            verify(VerifyTokenVerifyParams.none(), requestOptions)
    }
}
