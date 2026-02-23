// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

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
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface InboundEmailService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboundEmailService

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
    fun create(params: InboundEmailCreateParams): InboundEmailCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: InboundEmailCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailCreateResponse

    /** Retrieve details of a specific mailbox including statistics. */
    fun retrieve(inboundEmailId: String): InboundEmailRetrieveResponse =
        retrieve(inboundEmailId, InboundEmailRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailRetrieveResponse =
        retrieve(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
    ): InboundEmailRetrieveResponse = retrieve(inboundEmailId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: InboundEmailRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailRetrieveResponse

    /** @see retrieve */
    fun retrieve(params: InboundEmailRetrieveParams): InboundEmailRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        inboundEmailId: String,
        requestOptions: RequestOptions,
    ): InboundEmailRetrieveResponse =
        retrieve(inboundEmailId, InboundEmailRetrieveParams.none(), requestOptions)

    /**
     * List all mailboxes associated with your API key. Returns active and inactive mailboxes
     * (deleted mailboxes are excluded).
     */
    fun list(): InboundEmailListResponse = list(InboundEmailListParams.none())

    /** @see list */
    fun list(
        params: InboundEmailListParams = InboundEmailListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailListResponse

    /** @see list */
    fun list(
        params: InboundEmailListParams = InboundEmailListParams.none()
    ): InboundEmailListResponse = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): InboundEmailListResponse =
        list(InboundEmailListParams.none(), requestOptions)

    /**
     * Permanently delete an inbound email address. It will stop accepting emails.
     *
     * **Note:** Deletion is immediate and cannot be undone. Any emails received after deletion will
     * be rejected.
     */
    fun delete(inboundEmailId: String): InboundEmailDeleteResponse =
        delete(inboundEmailId, InboundEmailDeleteParams.none())

    /** @see delete */
    fun delete(
        inboundEmailId: String,
        params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailDeleteResponse =
        delete(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

    /** @see delete */
    fun delete(
        inboundEmailId: String,
        params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
    ): InboundEmailDeleteResponse = delete(inboundEmailId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: InboundEmailDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailDeleteResponse

    /** @see delete */
    fun delete(params: InboundEmailDeleteParams): InboundEmailDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(inboundEmailId: String, requestOptions: RequestOptions): InboundEmailDeleteResponse =
        delete(inboundEmailId, InboundEmailDeleteParams.none(), requestOptions)

    /**
     * A view of [InboundEmailService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboundEmailService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/inbound-email`, but is otherwise the same as
         * [InboundEmailService.create].
         */
        @MustBeClosed
        fun create(params: InboundEmailCreateParams): HttpResponseFor<InboundEmailCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InboundEmailCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailCreateResponse>

        /**
         * Returns a raw HTTP response for `get /v4/inbound-email/{inbound_email_id}`, but is
         * otherwise the same as [InboundEmailService.retrieve].
         */
        @MustBeClosed
        fun retrieve(inboundEmailId: String): HttpResponseFor<InboundEmailRetrieveResponse> =
            retrieve(inboundEmailId, InboundEmailRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inboundEmailId: String,
            params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailRetrieveResponse> =
            retrieve(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inboundEmailId: String,
            params: InboundEmailRetrieveParams = InboundEmailRetrieveParams.none(),
        ): HttpResponseFor<InboundEmailRetrieveResponse> =
            retrieve(inboundEmailId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InboundEmailRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailRetrieveResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: InboundEmailRetrieveParams
        ): HttpResponseFor<InboundEmailRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            inboundEmailId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailRetrieveResponse> =
            retrieve(inboundEmailId, InboundEmailRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /v4/inbound-email`, but is otherwise the same as
         * [InboundEmailService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<InboundEmailListResponse> = list(InboundEmailListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: InboundEmailListParams = InboundEmailListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailListResponse>

        /** @see list */
        @MustBeClosed
        fun list(
            params: InboundEmailListParams = InboundEmailListParams.none()
        ): HttpResponseFor<InboundEmailListResponse> = list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<InboundEmailListResponse> =
            list(InboundEmailListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /v4/inbound-email/{inbound_email_id}`, but is
         * otherwise the same as [InboundEmailService.delete].
         */
        @MustBeClosed
        fun delete(inboundEmailId: String): HttpResponseFor<InboundEmailDeleteResponse> =
            delete(inboundEmailId, InboundEmailDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboundEmailId: String,
            params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailDeleteResponse> =
            delete(params.toBuilder().inboundEmailId(inboundEmailId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboundEmailId: String,
            params: InboundEmailDeleteParams = InboundEmailDeleteParams.none(),
        ): HttpResponseFor<InboundEmailDeleteResponse> =
            delete(inboundEmailId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: InboundEmailDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: InboundEmailDeleteParams): HttpResponseFor<InboundEmailDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            inboundEmailId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailDeleteResponse> =
            delete(inboundEmailId, InboundEmailDeleteParams.none(), requestOptions)
    }
}
