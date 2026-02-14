// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async.cdsl

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpResponse
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FetchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FetchServiceAsync

    /**
     * **Step 1 of 2**: Request OTP for CDSL CAS fetch.
     *
     * This endpoint:
     * 1. Solves reCAPTCHA automatically (~15-20 seconds)
     * 2. Submits login credentials to CDSL portal
     * 3. Triggers OTP to user's registered mobile number
     *
     * After user receives OTP, call `/v4/cdsl/fetch/{session_id}/verify` to complete.
     */
    fun requestOtp(params: FetchRequestOtpParams): CompletableFuture<FetchRequestOtpResponse> =
        requestOtp(params, RequestOptions.none())

    /** @see requestOtp */
    fun requestOtp(
        params: FetchRequestOtpParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FetchRequestOtpResponse>

    /**
     * **Step 2 of 2**: Verify OTP and retrieve CDSL CAS files.
     *
     * After successful verification, CAS PDFs are fetched from CDSL portal, uploaded to cloud
     * storage, and returned as direct download URLs.
     */
    fun verifyOtp(
        sessionId: String,
        params: FetchVerifyOtpParams,
    ): CompletableFuture<FetchVerifyOtpResponse> =
        verifyOtp(sessionId, params, RequestOptions.none())

    /** @see verifyOtp */
    fun verifyOtp(
        sessionId: String,
        params: FetchVerifyOtpParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FetchVerifyOtpResponse> =
        verifyOtp(params.toBuilder().sessionId(sessionId).build(), requestOptions)

    /** @see verifyOtp */
    fun verifyOtp(params: FetchVerifyOtpParams): CompletableFuture<FetchVerifyOtpResponse> =
        verifyOtp(params, RequestOptions.none())

    /** @see verifyOtp */
    fun verifyOtp(
        params: FetchVerifyOtpParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FetchVerifyOtpResponse>

    /** A view of [FetchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FetchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/fetch`, but is otherwise the same as
         * [FetchServiceAsync.requestOtp].
         */
        fun requestOtp(
            params: FetchRequestOtpParams
        ): CompletableFuture<HttpResponseFor<FetchRequestOtpResponse>> =
            requestOtp(params, RequestOptions.none())

        /** @see requestOtp */
        fun requestOtp(
            params: FetchRequestOtpParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FetchRequestOtpResponse>>

        /**
         * Returns a raw HTTP response for `post /v4/cdsl/fetch/{session_id}/verify`, but is
         * otherwise the same as [FetchServiceAsync.verifyOtp].
         */
        fun verifyOtp(
            sessionId: String,
            params: FetchVerifyOtpParams,
        ): CompletableFuture<HttpResponseFor<FetchVerifyOtpResponse>> =
            verifyOtp(sessionId, params, RequestOptions.none())

        /** @see verifyOtp */
        fun verifyOtp(
            sessionId: String,
            params: FetchVerifyOtpParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FetchVerifyOtpResponse>> =
            verifyOtp(params.toBuilder().sessionId(sessionId).build(), requestOptions)

        /** @see verifyOtp */
        fun verifyOtp(
            params: FetchVerifyOtpParams
        ): CompletableFuture<HttpResponseFor<FetchVerifyOtpResponse>> =
            verifyOtp(params, RequestOptions.none())

        /** @see verifyOtp */
        fun verifyOtp(
            params: FetchVerifyOtpParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FetchVerifyOtpResponse>>
    }
}
