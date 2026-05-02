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

/**
 * Create dedicated inbound email addresses for investors to forward their CAS statements.
 *
 * **Use Case:** Your app wants to collect CAS statements from users without requiring OAuth or file
 * upload.
 *
 * **How it works:**
 * 1. Call `POST /v4/inbound-email` to create a unique inbound email address
 * 2. Display this email to your user: "Forward your CAS statement to ie_xxx@import.casparser.in"
 * 3. When user forwards a CAS email, we verify sender authenticity (SPF/DKIM) and call your webhook
 * 4. Your webhook receives email metadata + attachment download URLs
 *
 * **Sender Validation:**
 * - Only emails from verified CAS authorities are processed:
 *     - CDSL: `eCAS@cdslstatement.com`
 *     - NSDL: `NSDL-CAS@nsdl.co.in`
 *     - CAMS: `donotreply@camsonline.com`
 *     - KFintech: `samfS@kfintech.com`
 * - Emails failing SPF/DKIM/DMARC are rejected
 * - Forwarded emails must contain the original sender in headers
 *
 * **Billing:** 0.2 credits per successfully processed valid email
 */
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
     * When an investor forwards a CAS email to this address, we verify the sender and make the file
     * available to you.
     *
     * `callback_url` is **optional**:
     * - **Set it** — we POST each parsed email to your webhook as it arrives.
     * - **Omit it** — retrieve files via `GET /v4/inbound-email/{id}/files` without building a
     *   webhook consumer.
     */
    fun create(): InboundEmailCreateResponse = create(InboundEmailCreateParams.none())

    /** @see create */
    fun create(
        params: InboundEmailCreateParams = InboundEmailCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InboundEmailCreateResponse

    /** @see create */
    fun create(
        params: InboundEmailCreateParams = InboundEmailCreateParams.none()
    ): InboundEmailCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): InboundEmailCreateResponse =
        create(InboundEmailCreateParams.none(), requestOptions)

    /** Retrieve details of a specific inbound email including statistics. */
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
     * List all inbound emails associated with your API key. Returns active and paused inbound
     * emails (deleted ones are excluded).
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
        fun create(): HttpResponseFor<InboundEmailCreateResponse> =
            create(InboundEmailCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: InboundEmailCreateParams = InboundEmailCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InboundEmailCreateResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: InboundEmailCreateParams = InboundEmailCreateParams.none()
        ): HttpResponseFor<InboundEmailCreateResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<InboundEmailCreateResponse> =
            create(InboundEmailCreateParams.none(), requestOptions)

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
