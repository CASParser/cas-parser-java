// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.accesstoken.AccessTokenCreateParams
import com.cas_parser.api.models.accesstoken.AccessTokenCreateResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface AccessTokenService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccessTokenService

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
    fun create(): AccessTokenCreateResponse = create(AccessTokenCreateParams.none())

    /** @see create */
    fun create(
        params: AccessTokenCreateParams = AccessTokenCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AccessTokenCreateResponse

    /** @see create */
    fun create(
        params: AccessTokenCreateParams = AccessTokenCreateParams.none()
    ): AccessTokenCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): AccessTokenCreateResponse =
        create(AccessTokenCreateParams.none(), requestOptions)

    /**
     * A view of [AccessTokenService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccessTokenService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v1/token`, but is otherwise the same as
         * [AccessTokenService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<AccessTokenCreateResponse> =
            create(AccessTokenCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: AccessTokenCreateParams = AccessTokenCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AccessTokenCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: AccessTokenCreateParams = AccessTokenCreateParams.none()
        ): HttpResponseFor<AccessTokenCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<AccessTokenCreateResponse> =
            create(AccessTokenCreateParams.none(), requestOptions)
    }
}
