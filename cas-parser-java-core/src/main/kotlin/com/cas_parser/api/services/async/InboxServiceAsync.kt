// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusParams
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusResponse
import com.cas_parser.api.models.inbox.InboxConnectEmailParams
import com.cas_parser.api.models.inbox.InboxConnectEmailResponse
import com.cas_parser.api.models.inbox.InboxDisconnectEmailParams
import com.cas_parser.api.models.inbox.InboxDisconnectEmailResponse
import com.cas_parser.api.models.inbox.InboxListCasFilesParams
import com.cas_parser.api.models.inbox.InboxListCasFilesResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InboxServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxServiceAsync

    /**
     * Verify if an `inbox_token` is still valid and check connection status.
     *
     * Use this to check if the user needs to re-authenticate (e.g., if they revoked access in their
     * email provider settings).
     */
    fun checkConnectionStatus(
        params: InboxCheckConnectionStatusParams
    ): CompletableFuture<InboxCheckConnectionStatusResponse> =
        checkConnectionStatus(params, RequestOptions.none())

    /** @see checkConnectionStatus */
    fun checkConnectionStatus(
        params: InboxCheckConnectionStatusParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxCheckConnectionStatusResponse>

    /**
     * Initiate OAuth flow to connect user's email inbox.
     *
     * Returns an `oauth_url` that you should redirect the user to. After authorization, they are
     * redirected back to your `redirect_uri` with the following query parameters:
     *
     * **On success:**
     * - `inbox_token` - Encrypted token to store client-side
     * - `email` - Email address of the connected account
     * - `state` - Your original state parameter (for CSRF verification)
     *
     * **On error:**
     * - `error` - Error code (e.g., `access_denied`, `token_exchange_failed`)
     * - `state` - Your original state parameter
     *
     * **Store the `inbox_token` client-side** and use it for all subsequent inbox API calls.
     */
    fun connectEmail(
        params: InboxConnectEmailParams
    ): CompletableFuture<InboxConnectEmailResponse> = connectEmail(params, RequestOptions.none())

    /** @see connectEmail */
    fun connectEmail(
        params: InboxConnectEmailParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxConnectEmailResponse>

    /**
     * Revoke email access and invalidate the token.
     *
     * This calls the provider's token revocation API (e.g., Google's revoke endpoint) to ensure the
     * user's consent is properly removed.
     *
     * After calling this, the `inbox_token` becomes unusable.
     */
    fun disconnectEmail(
        params: InboxDisconnectEmailParams
    ): CompletableFuture<InboxDisconnectEmailResponse> =
        disconnectEmail(params, RequestOptions.none())

    /** @see disconnectEmail */
    fun disconnectEmail(
        params: InboxDisconnectEmailParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxDisconnectEmailResponse>

    /**
     * Search the user's email inbox for CAS files from known senders (CAMS, KFintech, CDSL, NSDL).
     *
     * Files are uploaded to temporary cloud storage. **URLs expire in 24 hours.**
     *
     * Optionally filter by CAS provider and date range.
     *
     * **Billing:** 0.2 credits per request (charged regardless of success or number of files
     * found).
     */
    fun listCasFiles(
        params: InboxListCasFilesParams
    ): CompletableFuture<InboxListCasFilesResponse> = listCasFiles(params, RequestOptions.none())

    /** @see listCasFiles */
    fun listCasFiles(
        params: InboxListCasFilesParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboxListCasFilesResponse>

    /** A view of [InboxServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboxServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/inbox/status`, but is otherwise the same as
         * [InboxServiceAsync.checkConnectionStatus].
         */
        fun checkConnectionStatus(
            params: InboxCheckConnectionStatusParams
        ): CompletableFuture<HttpResponseFor<InboxCheckConnectionStatusResponse>> =
            checkConnectionStatus(params, RequestOptions.none())

        /** @see checkConnectionStatus */
        fun checkConnectionStatus(
            params: InboxCheckConnectionStatusParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxCheckConnectionStatusResponse>>

        /**
         * Returns a raw HTTP response for `post /v4/inbox/connect`, but is otherwise the same as
         * [InboxServiceAsync.connectEmail].
         */
        fun connectEmail(
            params: InboxConnectEmailParams
        ): CompletableFuture<HttpResponseFor<InboxConnectEmailResponse>> =
            connectEmail(params, RequestOptions.none())

        /** @see connectEmail */
        fun connectEmail(
            params: InboxConnectEmailParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxConnectEmailResponse>>

        /**
         * Returns a raw HTTP response for `post /v4/inbox/disconnect`, but is otherwise the same as
         * [InboxServiceAsync.disconnectEmail].
         */
        fun disconnectEmail(
            params: InboxDisconnectEmailParams
        ): CompletableFuture<HttpResponseFor<InboxDisconnectEmailResponse>> =
            disconnectEmail(params, RequestOptions.none())

        /** @see disconnectEmail */
        fun disconnectEmail(
            params: InboxDisconnectEmailParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxDisconnectEmailResponse>>

        /**
         * Returns a raw HTTP response for `post /v4/inbox/cas`, but is otherwise the same as
         * [InboxServiceAsync.listCasFiles].
         */
        fun listCasFiles(
            params: InboxListCasFilesParams
        ): CompletableFuture<HttpResponseFor<InboxListCasFilesResponse>> =
            listCasFiles(params, RequestOptions.none())

        /** @see listCasFiles */
        fun listCasFiles(
            params: InboxListCasFilesParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboxListCasFilesResponse>>
    }
}
