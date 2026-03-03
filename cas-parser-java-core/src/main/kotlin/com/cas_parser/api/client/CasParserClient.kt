// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.services.blocking.AccessTokenService
import com.cas_parser.api.services.blocking.CamsKfintechService
import com.cas_parser.api.services.blocking.CdslService
import com.cas_parser.api.services.blocking.ContractNoteService
import com.cas_parser.api.services.blocking.CreditService
import com.cas_parser.api.services.blocking.InboundEmailService
import com.cas_parser.api.services.blocking.InboxService
import com.cas_parser.api.services.blocking.KfintechService
import com.cas_parser.api.services.blocking.LogService
import com.cas_parser.api.services.blocking.NsdlService
import com.cas_parser.api.services.blocking.SmartService
import com.cas_parser.api.services.blocking.VerifyTokenService
import java.util.function.Consumer

/**
 * A client for interacting with the Cas Parser REST API synchronously. You can also switch to
 * asynchronous execution via the [async] method.
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
interface CasParserClient {

    /**
     * Returns a version of this client that uses asynchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun async(): CasParserClientAsync

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClient

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    fun credits(): CreditService

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    fun logs(): LogService

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    fun accessToken(): AccessTokenService

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    fun verifyToken(): VerifyTokenService

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun camsKfintech(): CamsKfintechService

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun cdsl(): CdslService

    /**
     * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha, Groww,
     * Upstox, ICICI etc.
     */
    fun contractNote(): ContractNoteService

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
    fun inbox(): InboxService

    /** Endpoints for generating new CAS documents via email mailback (KFintech). */
    fun kfintech(): KfintechService

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun nsdl(): NsdlService

    /** Endpoints for parsing CAS PDF files from different sources. */
    fun smart(): SmartService

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
    fun inboundEmail(): InboundEmailService

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

    /** A view of [CasParserClient] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClient.WithRawResponse

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        fun credits(): CreditService.WithRawResponse

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        fun logs(): LogService.WithRawResponse

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        fun accessToken(): AccessTokenService.WithRawResponse

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        fun verifyToken(): VerifyTokenService.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun camsKfintech(): CamsKfintechService.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun cdsl(): CdslService.WithRawResponse

        /**
         * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha,
         * Groww, Upstox, ICICI etc.
         */
        fun contractNote(): ContractNoteService.WithRawResponse

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
        fun inbox(): InboxService.WithRawResponse

        /** Endpoints for generating new CAS documents via email mailback (KFintech). */
        fun kfintech(): KfintechService.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun nsdl(): NsdlService.WithRawResponse

        /** Endpoints for parsing CAS PDF files from different sources. */
        fun smart(): SmartService.WithRawResponse

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
        fun inboundEmail(): InboundEmailService.WithRawResponse
    }
}
