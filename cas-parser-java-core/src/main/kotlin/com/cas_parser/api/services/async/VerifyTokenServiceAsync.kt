// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.verifytoken.VerifyTokenVerifyParams
import com.cas_parser.api.models.verifytoken.VerifyTokenVerifyResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface VerifyTokenServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VerifyTokenServiceAsync

    /** Verify an access token and check if it's still valid. Useful for debugging token issues. */
    fun verify(): CompletableFuture<VerifyTokenVerifyResponse> =
        verify(VerifyTokenVerifyParams.none())

    /** @see verify */
    fun verify(
        params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VerifyTokenVerifyResponse>

    /** @see verify */
    fun verify(
        params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none()
    ): CompletableFuture<VerifyTokenVerifyResponse> = verify(params, RequestOptions.none())

    /** @see verify */
    fun verify(requestOptions: RequestOptions): CompletableFuture<VerifyTokenVerifyResponse> =
        verify(VerifyTokenVerifyParams.none(), requestOptions)

    /**
     * A view of [VerifyTokenServiceAsync] that provides access to raw HTTP responses for each
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
        ): VerifyTokenServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/verify-token`, but is otherwise the same as
         * [VerifyTokenServiceAsync.verify].
         */
        fun verify(): CompletableFuture<HttpResponseFor<VerifyTokenVerifyResponse>> =
            verify(VerifyTokenVerifyParams.none())

        /** @see verify */
        fun verify(
            params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VerifyTokenVerifyResponse>>

        /** @see verify */
        fun verify(
            params: VerifyTokenVerifyParams = VerifyTokenVerifyParams.none()
        ): CompletableFuture<HttpResponseFor<VerifyTokenVerifyResponse>> =
            verify(params, RequestOptions.none())

        /** @see verify */
        fun verify(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VerifyTokenVerifyResponse>> =
            verify(VerifyTokenVerifyParams.none(), requestOptions)
    }
}
