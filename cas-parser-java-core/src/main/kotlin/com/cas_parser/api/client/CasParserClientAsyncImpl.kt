// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.getPackageVersion
import com.cas_parser.api.services.async.AccessTokenServiceAsync
import com.cas_parser.api.services.async.AccessTokenServiceAsyncImpl
import com.cas_parser.api.services.async.CamsKfintechServiceAsync
import com.cas_parser.api.services.async.CamsKfintechServiceAsyncImpl
import com.cas_parser.api.services.async.CdslServiceAsync
import com.cas_parser.api.services.async.CdslServiceAsyncImpl
import com.cas_parser.api.services.async.ContractNoteServiceAsync
import com.cas_parser.api.services.async.ContractNoteServiceAsyncImpl
import com.cas_parser.api.services.async.CreditServiceAsync
import com.cas_parser.api.services.async.CreditServiceAsyncImpl
import com.cas_parser.api.services.async.InboundEmailServiceAsync
import com.cas_parser.api.services.async.InboundEmailServiceAsyncImpl
import com.cas_parser.api.services.async.InboxServiceAsync
import com.cas_parser.api.services.async.InboxServiceAsyncImpl
import com.cas_parser.api.services.async.KfintechServiceAsync
import com.cas_parser.api.services.async.KfintechServiceAsyncImpl
import com.cas_parser.api.services.async.LogServiceAsync
import com.cas_parser.api.services.async.LogServiceAsyncImpl
import com.cas_parser.api.services.async.NsdlServiceAsync
import com.cas_parser.api.services.async.NsdlServiceAsyncImpl
import com.cas_parser.api.services.async.SmartServiceAsync
import com.cas_parser.api.services.async.SmartServiceAsyncImpl
import com.cas_parser.api.services.async.VerifyTokenServiceAsync
import com.cas_parser.api.services.async.VerifyTokenServiceAsyncImpl
import java.util.function.Consumer

class CasParserClientAsyncImpl(private val clientOptions: ClientOptions) : CasParserClientAsync {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val sync: CasParserClient by lazy { CasParserClientImpl(clientOptions) }

    private val withRawResponse: CasParserClientAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val credits: CreditServiceAsync by lazy {
        CreditServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val logs: LogServiceAsync by lazy { LogServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val accessToken: AccessTokenServiceAsync by lazy {
        AccessTokenServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val verifyToken: VerifyTokenServiceAsync by lazy {
        VerifyTokenServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val camsKfintech: CamsKfintechServiceAsync by lazy {
        CamsKfintechServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val cdsl: CdslServiceAsync by lazy { CdslServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val contractNote: ContractNoteServiceAsync by lazy {
        ContractNoteServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val inbox: InboxServiceAsync by lazy {
        InboxServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val kfintech: KfintechServiceAsync by lazy {
        KfintechServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val nsdl: NsdlServiceAsync by lazy { NsdlServiceAsyncImpl(clientOptionsWithUserAgent) }

    private val smart: SmartServiceAsync by lazy {
        SmartServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val inboundEmail: InboundEmailServiceAsync by lazy {
        InboundEmailServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): CasParserClient = sync

    override fun withRawResponse(): CasParserClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClientAsync =
        CasParserClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    override fun credits(): CreditServiceAsync = credits

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    override fun logs(): LogServiceAsync = logs

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    override fun accessToken(): AccessTokenServiceAsync = accessToken

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    override fun verifyToken(): VerifyTokenServiceAsync = verifyToken

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun camsKfintech(): CamsKfintechServiceAsync = camsKfintech

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun cdsl(): CdslServiceAsync = cdsl

    /**
     * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha, Groww,
     * Upstox, ICICI etc.
     */
    override fun contractNote(): ContractNoteServiceAsync = contractNote

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
    override fun inbox(): InboxServiceAsync = inbox

    /** Endpoints for generating new CAS documents via email mailback (KFintech). */
    override fun kfintech(): KfintechServiceAsync = kfintech

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun nsdl(): NsdlServiceAsync = nsdl

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun smart(): SmartServiceAsync = smart

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
    override fun inboundEmail(): InboundEmailServiceAsync = inboundEmail

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserClientAsync.WithRawResponse {

        private val credits: CreditServiceAsync.WithRawResponse by lazy {
            CreditServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val logs: LogServiceAsync.WithRawResponse by lazy {
            LogServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val accessToken: AccessTokenServiceAsync.WithRawResponse by lazy {
            AccessTokenServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val verifyToken: VerifyTokenServiceAsync.WithRawResponse by lazy {
            VerifyTokenServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val camsKfintech: CamsKfintechServiceAsync.WithRawResponse by lazy {
            CamsKfintechServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val cdsl: CdslServiceAsync.WithRawResponse by lazy {
            CdslServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val contractNote: ContractNoteServiceAsync.WithRawResponse by lazy {
            ContractNoteServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val inbox: InboxServiceAsync.WithRawResponse by lazy {
            InboxServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val kfintech: KfintechServiceAsync.WithRawResponse by lazy {
            KfintechServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val nsdl: NsdlServiceAsync.WithRawResponse by lazy {
            NsdlServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val smart: SmartServiceAsync.WithRawResponse by lazy {
            SmartServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val inboundEmail: InboundEmailServiceAsync.WithRawResponse by lazy {
            InboundEmailServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClientAsync.WithRawResponse =
            CasParserClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        override fun credits(): CreditServiceAsync.WithRawResponse = credits

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        override fun logs(): LogServiceAsync.WithRawResponse = logs

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        override fun accessToken(): AccessTokenServiceAsync.WithRawResponse = accessToken

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        override fun verifyToken(): VerifyTokenServiceAsync.WithRawResponse = verifyToken

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun camsKfintech(): CamsKfintechServiceAsync.WithRawResponse = camsKfintech

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun cdsl(): CdslServiceAsync.WithRawResponse = cdsl

        /**
         * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha,
         * Groww, Upstox, ICICI etc.
         */
        override fun contractNote(): ContractNoteServiceAsync.WithRawResponse = contractNote

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
        override fun inbox(): InboxServiceAsync.WithRawResponse = inbox

        /** Endpoints for generating new CAS documents via email mailback (KFintech). */
        override fun kfintech(): KfintechServiceAsync.WithRawResponse = kfintech

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun nsdl(): NsdlServiceAsync.WithRawResponse = nsdl

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun smart(): SmartServiceAsync.WithRawResponse = smart

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
        override fun inboundEmail(): InboundEmailServiceAsync.WithRawResponse = inboundEmail
    }
}
