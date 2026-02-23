// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.inboundemail.InboundEmailCreateParams
import com.cas_parser.api.models.inboundemail.InboundEmailCreateResponse
import com.cas_parser.api.models.inboundemail.InboundEmailDeleteParams
import com.cas_parser.api.models.inboundemail.InboundEmailDeleteResponse
import com.cas_parser.api.models.inboundemail.InboundEmailListParams
import com.cas_parser.api.models.inboundemail.InboundEmailListResponse
import com.cas_parser.api.models.inboundemail.InboundEmailRetrieveParams
import com.cas_parser.api.models.inboundemail.InboundEmailRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InboundEmailServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboundEmailServiceAsync

    /**
     * Create a dedicated inbound email address for collecting CAS statements via email forwarding.
     *
     * **How it works:**
     * 1. Create an inbound email with your webhook URL
     * 2. Display the email address to your user (e.g., "Forward your CAS to
     *    ie_xxx@import.casparser.in")
     * 3. When an investor forwards a CAS email, we verify the sender and deliver to your webhook
     *
     * **Webhook Delivery:**
     * - We POST to your `callback_url` with JSON body containing files (matching EmailCASFile
     *   schema)
     * - Failed deliveries are retried automatically with exponential backoff
     *
     * **Inactivity:**
     * - Inbound emails with no activity in 30 days are marked inactive
     * - Active inbound emails remain operational indefinitely
     */
    fun create(params: InboundEmailCreateParams): CompletableFuture<InboundEmailCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InboundEmailCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailCreateResponse>

    /** Retrieve details of a specific mailbox including statistics. */
    fun retrieve(inboundEmailId: String): CompletableFuture<InboundEmailRetrieveResponse> =
        retrieve(inboundEmailId, InboundEmailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailRetrieveResponse> =
        retrieve(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
    ): CompletableFuture<InboundEmailRetrieveResponse> =
        retrieve(inboundEmailId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InboundEmailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailRetrieveResponse>

    /** @see retrieve */
    fun retrieve(
        params: InboundEmailRetrieveParams
    ): CompletableFuture<InboundEmailRetrieveResponse> = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InboundEmailRetrieveResponse> =
        retrieve(inboundEmailId, InboundEmailRetrieveParams.none(), requestOptions)

    /**
     * List all mailboxes associated with your API key. Returns active and inactive mailboxes
     * (deleted mailboxes are excluded).
     */
    fun list(): CompletableFuture<InboundEmailListResponse> = list(InboundEmailListParams.none())

    /** @see list */
    fun list(
        params: InboundEmailListParams = InboundEmailListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailListResponse>

    /** @see list */
    fun list(
        params: InboundEmailListParams = InboundEmailListParams.none()
    ): CompletableFuture<InboundEmailListResponse> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<InboundEmailListResponse> =
        list(InboundEmailListParams.none(), requestOptions)

    /**
     * Permanently delete an inbound email address. It will stop accepting emails.
     *
     * **Note:** Deletion is immediate and cannot be undone. Any emails received after deletion will
     * be rejected.
     */
    fun delete(inboundEmailId: String): CompletableFuture<InboundEmailDeleteResponse> =
        delete(inboundEmailId, InboundEmailDeleteParams.none())

    /** @see delete */
    fun delete(
        inboundEmailId: String,
        params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailDeleteResponse> =
        delete(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inboundEmailId: String,
        params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
    ): CompletableFuture<InboundEmailDeleteResponse> =
        delete(inboundEmailId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InboundEmailDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InboundEmailDeleteResponse>

    /** @see delete */
    fun delete(params: InboundEmailDeleteParams): CompletableFuture<InboundEmailDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        inboundEmailId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InboundEmailDeleteResponse> =
        delete(inboundEmailId, InboundEmailDeleteParams.none(), requestOptions)

    /**
     * A view of [InboundEmailServiceAsync] that provides access to raw HTTP responses for each
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
        ): InboundEmailServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/inbound-email`, but is otherwise the same as
         * [InboundEmailServiceAsync.create].
         */
        fun create(
            params: InboundEmailCreateParams
        ): CompletableFuture<HttpResponseFor<InboundEmailCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: InboundEmailCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /v4/inbound-email/{inbound_email_id}`, but is
         * otherwise the same as [InboundEmailServiceAsync.retrieve].
         */
        fun retrieve(
            inboundEmailId: String
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>> =
            retrieve(inboundEmailId, InboundEmailRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            inboundEmailId: String,
            params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>> =
            retrieve(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            inboundEmailId: String,
            params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>> =
            retrieve(inboundEmailId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: InboundEmailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>>

        /** @see retrieve */
        fun retrieve(
            params: InboundEmailRetrieveParams
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            inboundEmailId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InboundEmailRetrieveResponse>> =
            retrieve(inboundEmailId, InboundEmailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v4/inbound-email`, but is otherwise the same as
         * [InboundEmailServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<InboundEmailListResponse>> =
            list(InboundEmailListParams.none())

        /** @see list */
        fun list(
            params: InboundEmailListParams = InboundEmailListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailListResponse>>

        /** @see list */
        fun list(
            params: InboundEmailListParams = InboundEmailListParams.none()
        ): CompletableFuture<HttpResponseFor<InboundEmailListResponse>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<InboundEmailListResponse>> =
            list(InboundEmailListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v4/inbound-email/{inbound_email_id}`, but is
         * otherwise the same as [InboundEmailServiceAsync.delete].
         */
        fun delete(
            inboundEmailId: String
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>> =
            delete(inboundEmailId, InboundEmailDeleteParams.none())

        /** @see delete */
        fun delete(
            inboundEmailId: String,
            params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>> =
            delete(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

        /** @see delete */
        fun delete(
            inboundEmailId: String,
            params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>> =
            delete(inboundEmailId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: InboundEmailDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>>

        /** @see delete */
        fun delete(
            params: InboundEmailDeleteParams
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            inboundEmailId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InboundEmailDeleteResponse>> =
            delete(inboundEmailId, InboundEmailDeleteParams.none(), requestOptions)
    }
}
