// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.accesstoken.AccessTokenCreateParams
import com.cas_parser.api.models.accesstoken.AccessTokenCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface AccessTokenServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccessTokenServiceAsync

    /**
     * Generate a short-lived access token from your API key.
     *
     * **Use this endpoint from your backend** to create tokens that can be safely passed to
     * frontend/SDK.
     *
     * **Legacy path:** `/v1/access-token` (still supported)
     *
     * Access tokens:
     * - Are prefixed with `at_` for easy identification
     * - Valid for up to 60 minutes
     * - Can be used in place of API keys on all v4 endpoints
     * - Cannot be used to generate other access tokens
     */
    fun create(): CompletableFuture<AccessTokenCreateResponse> =
        create(AccessTokenCreateParams.none())

    /** @see create */
    fun create(
        params: AccessTokenCreateParams = AccessTokenCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AccessTokenCreateResponse>

    /** @see create */
    fun create(
        params: AccessTokenCreateParams = AccessTokenCreateParams.none()
    ): CompletableFuture<AccessTokenCreateResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<AccessTokenCreateResponse> =
        create(AccessTokenCreateParams.none(), requestOptions)

    /**
     * A view of [AccessTokenServiceAsync] that provides access to raw HTTP responses for each
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
        ): AccessTokenServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/token`, but is otherwise the same as
         * [AccessTokenServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<AccessTokenCreateResponse>> =
            create(AccessTokenCreateParams.none())

        /** @see create */
        fun create(
            params: AccessTokenCreateParams = AccessTokenCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AccessTokenCreateResponse>>

        /** @see create */
        fun create(
            params: AccessTokenCreateParams = AccessTokenCreateParams.none()
        ): CompletableFuture<HttpResponseFor<AccessTokenCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<AccessTokenCreateResponse>> =
            create(AccessTokenCreateParams.none(), requestOptions)
    }
}
