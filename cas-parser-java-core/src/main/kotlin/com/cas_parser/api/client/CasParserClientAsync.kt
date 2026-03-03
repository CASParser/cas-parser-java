// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.services.async.AccessTokenServiceAsync
import com.cas_parser.api.services.async.CamsKfintechServiceAsync
import com.cas_parser.api.services.async.CdslServiceAsync
import com.cas_parser.api.services.async.ContractNoteServiceAsync
import com.cas_parser.api.services.async.CreditServiceAsync
import com.cas_parser.api.services.async.InboundEmailServiceAsync
import com.cas_parser.api.services.async.InboxServiceAsync
import com.cas_parser.api.services.async.KfintechServiceAsync
import com.cas_parser.api.services.async.LogServiceAsync
import com.cas_parser.api.services.async.NsdlServiceAsync
import com.cas_parser.api.services.async.SmartServiceAsync
import com.cas_parser.api.services.async.VerifyTokenServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Cas Parser REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface CasParserClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): CasParserClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClientAsync

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    fun credits(): CreditServiceAsync

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    fun logs(): LogServiceAsync

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    fun accessToken(): AccessTokenServiceAsync

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    fun verifyToken(): VerifyTokenServiceAsync

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun camsKfintech(): CamsKfintechServiceAsync

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun cdsl(): CdslServiceAsync

    /**
     * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha, Groww,
     * Upstox, ICICI etc.
     */
    fun contractNote(): ContractNoteServiceAsync

    /**
     * Endpoints for importing CAS files directly from user email inboxes.
     *
     * **Supported Providers:** Gmail (more coming soon)
     *
     * **How it works:**
     * 1. Call `POST /v4/inbox/connect` to get an OAuth URL
     * 2. Redirect user to the OAuth URL for consent
     * 3. User is redirected back to your `redirect_uri` with an encrypted `inbox_token`
     * 4. Use the token to list/fetch CAS files from their inbox (`/v4/inbox/cas`)
     * 5. Files are uploaded to temporary cloud storage (URLs expire in 24 hours)
     *
     * **Security:**
     * - Read-only access (we cannot send emails)
     * - Tokens are encrypted with server-side secret
     * - User can revoke access anytime via `/v4/inbox/disconnect`
     */
    fun inbox(): InboxServiceAsync

    /** Endpoints for generating new CAS documents via email mailback (KFintech). */
    fun kfintech(): KfintechServiceAsync

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun nsdl(): NsdlServiceAsync

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun smart(): SmartServiceAsync

    /**
     * Create dedicated inbound email addresses for investors to forward their CAS statements.
     *
     * **Use Case:** Your app wants to collect CAS statements from users without requiring OAuth or
     * file upload.
     *
     * **How it works:**
     * 1. Call `POST /v4/inbound-email` to create a unique inbound email address
     * 2. Display this email to your user: "Forward your CAS statement to
     *    ie_xxx@import.casparser.in"
     * 3. When user forwards a CAS email, we verify sender authenticity (SPF/DKIM) and call your
     *    webhook
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
    fun inboundEmail(): InboundEmailServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [CasParserClientAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClientAsync.WithRawResponse

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        fun credits(): CreditServiceAsync.WithRawResponse

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        fun logs(): LogServiceAsync.WithRawResponse

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        fun accessToken(): AccessTokenServiceAsync.WithRawResponse

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        fun verifyToken(): VerifyTokenServiceAsync.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun camsKfintech(): CamsKfintechServiceAsync.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun cdsl(): CdslServiceAsync.WithRawResponse

        /**
         * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha,
         * Groww, Upstox, ICICI etc.
         */
        fun contractNote(): ContractNoteServiceAsync.WithRawResponse

        /**
         * Endpoints for importing CAS files directly from user email inboxes.
         *
         * **Supported Providers:** Gmail (more coming soon)
         *
         * **How it works:**
         * 1. Call `POST /v4/inbox/connect` to get an OAuth URL
         * 2. Redirect user to the OAuth URL for consent
         * 3. User is redirected back to your `redirect_uri` with an encrypted `inbox_token`
         * 4. Use the token to list/fetch CAS files from their inbox (`/v4/inbox/cas`)
         * 5. Files are uploaded to temporary cloud storage (URLs expire in 24 hours)
         *
         * **Security:**
         * - Read-only access (we cannot send emails)
         * - Tokens are encrypted with server-side secret
         * - User can revoke access anytime via `/v4/inbox/disconnect`
         */
        fun inbox(): InboxServiceAsync.WithRawResponse

        /** Endpoints for generating new CAS documents via email mailback (KFintech). */
        fun kfintech(): KfintechServiceAsync.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun nsdl(): NsdlServiceAsync.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun smart(): SmartServiceAsync.WithRawResponse

        /**
         * Create dedicated inbound email addresses for investors to forward their CAS statements.
         *
         * **Use Case:** Your app wants to collect CAS statements from users without requiring OAuth
         * or file upload.
         *
         * **How it works:**
         * 1. Call `POST /v4/inbound-email` to create a unique inbound email address
         * 2. Display this email to your user: "Forward your CAS statement to
         *    ie_xxx@import.casparser.in"
         * 3. When user forwards a CAS email, we verify sender authenticity (SPF/DKIM) and call your
         *    webhook
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
        fun inboundEmail(): InboundEmailServiceAsync.WithRawResponse
    }
}
