// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.getPackageVersion
import com.cas_parser.api.services.blocking.AccessTokenService
import com.cas_parser.api.services.blocking.AccessTokenServiceImpl
import com.cas_parser.api.services.blocking.CamsKfintechService
import com.cas_parser.api.services.blocking.CamsKfintechServiceImpl
import com.cas_parser.api.services.blocking.CdslService
import com.cas_parser.api.services.blocking.CdslServiceImpl
import com.cas_parser.api.services.blocking.ContractNoteService
import com.cas_parser.api.services.blocking.ContractNoteServiceImpl
import com.cas_parser.api.services.blocking.CreditService
import com.cas_parser.api.services.blocking.CreditServiceImpl
import com.cas_parser.api.services.blocking.InboundEmailService
import com.cas_parser.api.services.blocking.InboundEmailServiceImpl
import com.cas_parser.api.services.blocking.InboxService
import com.cas_parser.api.services.blocking.InboxServiceImpl
import com.cas_parser.api.services.blocking.KfintechService
import com.cas_parser.api.services.blocking.KfintechServiceImpl
import com.cas_parser.api.services.blocking.LogService
import com.cas_parser.api.services.blocking.LogServiceImpl
import com.cas_parser.api.services.blocking.NsdlService
import com.cas_parser.api.services.blocking.NsdlServiceImpl
import com.cas_parser.api.services.blocking.SmartService
import com.cas_parser.api.services.blocking.SmartServiceImpl
import com.cas_parser.api.services.blocking.VerifyTokenService
import com.cas_parser.api.services.blocking.VerifyTokenServiceImpl
import java.util.function.Consumer

class CasParserClientImpl(private val clientOptions: ClientOptions) : CasParserClient {

    private val clientOptionsWithUserAgent =
        if (clientOptions.headers.names().contains("User-Agent")) clientOptions
        else
            clientOptions
                .toBuilder()
                .putHeader("User-Agent", "${javaClass.simpleName}/Java ${getPackageVersion()}")
                .build()

    // Pass the original clientOptions so that this client sets its own User-Agent.
    private val async: CasParserClientAsync by lazy { CasParserClientAsyncImpl(clientOptions) }

    private val withRawResponse: CasParserClient.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val credits: CreditService by lazy { CreditServiceImpl(clientOptionsWithUserAgent) }

    private val logs: LogService by lazy { LogServiceImpl(clientOptionsWithUserAgent) }

    private val accessToken: AccessTokenService by lazy {
        AccessTokenServiceImpl(clientOptionsWithUserAgent)
    }

    private val verifyToken: VerifyTokenService by lazy {
        VerifyTokenServiceImpl(clientOptionsWithUserAgent)
    }

    private val camsKfintech: CamsKfintechService by lazy {
        CamsKfintechServiceImpl(clientOptionsWithUserAgent)
    }

    private val cdsl: CdslService by lazy { CdslServiceImpl(clientOptionsWithUserAgent) }

    private val contractNote: ContractNoteService by lazy {
        ContractNoteServiceImpl(clientOptionsWithUserAgent)
    }

    private val inbox: InboxService by lazy { InboxServiceImpl(clientOptionsWithUserAgent) }

    private val kfintech: KfintechService by lazy {
        KfintechServiceImpl(clientOptionsWithUserAgent)
    }

    private val nsdl: NsdlService by lazy { NsdlServiceImpl(clientOptionsWithUserAgent) }

    private val smart: SmartService by lazy { SmartServiceImpl(clientOptionsWithUserAgent) }

    private val inboundEmail: InboundEmailService by lazy {
        InboundEmailServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): CasParserClientAsync = async

    override fun withRawResponse(): CasParserClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClient =
        CasParserClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    override fun credits(): CreditService = credits

    /**
     * Endpoints for checking API quota and credits usage. These endpoints help you monitor your API
     * usage and remaining quota.
     */
    override fun logs(): LogService = logs

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    override fun accessToken(): AccessTokenService = accessToken

    /**
     * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
     * short-lived `at_` prefixed tokens that can be safely passed to frontend applications. Access
     * tokens can be used in place of API keys on all v4 endpoints.
     */
    override fun verifyToken(): VerifyTokenService = verifyToken

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun camsKfintech(): CamsKfintechService = camsKfintech

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun cdsl(): CdslService = cdsl

    /**
     * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha, Groww,
     * Upstox, ICICI etc.
     */
    override fun contractNote(): ContractNoteService = contractNote

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
    override fun inbox(): InboxService = inbox

    /** Endpoints for generating new CAS documents via email mailback (KFintech). */
    override fun kfintech(): KfintechService = kfintech

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun nsdl(): NsdlService = nsdl

    /** Endpoints for parsing CAS PDF files from different sources. */
    override fun smart(): SmartService = smart

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
    override fun inboundEmail(): InboundEmailService = inboundEmail

    override fun close() = clientOptions.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserClient.WithRawResponse {

        private val credits: CreditService.WithRawResponse by lazy {
            CreditServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val logs: LogService.WithRawResponse by lazy {
            LogServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val accessToken: AccessTokenService.WithRawResponse by lazy {
            AccessTokenServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val verifyToken: VerifyTokenService.WithRawResponse by lazy {
            VerifyTokenServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val camsKfintech: CamsKfintechService.WithRawResponse by lazy {
            CamsKfintechServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val cdsl: CdslService.WithRawResponse by lazy {
            CdslServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val contractNote: ContractNoteService.WithRawResponse by lazy {
            ContractNoteServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val inbox: InboxService.WithRawResponse by lazy {
            InboxServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val kfintech: KfintechService.WithRawResponse by lazy {
            KfintechServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val nsdl: NsdlService.WithRawResponse by lazy {
            NsdlServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val smart: SmartService.WithRawResponse by lazy {
            SmartServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val inboundEmail: InboundEmailService.WithRawResponse by lazy {
            InboundEmailServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClient.WithRawResponse =
            CasParserClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        override fun credits(): CreditService.WithRawResponse = credits

        /**
         * Endpoints for checking API quota and credits usage. These endpoints help you monitor your
         * API usage and remaining quota.
         */
        override fun logs(): LogService.WithRawResponse = logs

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        override fun accessToken(): AccessTokenService.WithRawResponse = accessToken

        /**
         * Endpoints for managing access tokens for the Portfolio Connect SDK. Use these to generate
         * short-lived `at_` prefixed tokens that can be safely passed to frontend applications.
         * Access tokens can be used in place of API keys on all v4 endpoints.
         */
        override fun verifyToken(): VerifyTokenService.WithRawResponse = verifyToken

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun camsKfintech(): CamsKfintechService.WithRawResponse = camsKfintech

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun cdsl(): CdslService.WithRawResponse = cdsl

        /**
         * Endpoints for parsing Contract Note PDF files from various SEBI brokers like Zerodha,
         * Groww, Upstox, ICICI etc.
         */
        override fun contractNote(): ContractNoteService.WithRawResponse = contractNote

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
        override fun inbox(): InboxService.WithRawResponse = inbox

        /** Endpoints for generating new CAS documents via email mailback (KFintech). */
        override fun kfintech(): KfintechService.WithRawResponse = kfintech

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun nsdl(): NsdlService.WithRawResponse = nsdl

        /** Endpoints for parsing CAS PDF files from different sources. */
        override fun smart(): SmartService.WithRawResponse = smart

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
        override fun inboundEmail(): InboundEmailService.WithRawResponse = inboundEmail
    }
}
