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

    override fun credits(): CreditServiceAsync = credits

    override fun logs(): LogServiceAsync = logs

    override fun accessToken(): AccessTokenServiceAsync = accessToken

    override fun verifyToken(): VerifyTokenServiceAsync = verifyToken

    override fun camsKfintech(): CamsKfintechServiceAsync = camsKfintech

    override fun cdsl(): CdslServiceAsync = cdsl

    override fun contractNote(): ContractNoteServiceAsync = contractNote

    override fun inbox(): InboxServiceAsync = inbox

    override fun kfintech(): KfintechServiceAsync = kfintech

    override fun nsdl(): NsdlServiceAsync = nsdl

    override fun smart(): SmartServiceAsync = smart

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

        override fun credits(): CreditServiceAsync.WithRawResponse = credits

        override fun logs(): LogServiceAsync.WithRawResponse = logs

        override fun accessToken(): AccessTokenServiceAsync.WithRawResponse = accessToken

        override fun verifyToken(): VerifyTokenServiceAsync.WithRawResponse = verifyToken

        override fun camsKfintech(): CamsKfintechServiceAsync.WithRawResponse = camsKfintech

        override fun cdsl(): CdslServiceAsync.WithRawResponse = cdsl

        override fun contractNote(): ContractNoteServiceAsync.WithRawResponse = contractNote

        override fun inbox(): InboxServiceAsync.WithRawResponse = inbox

        override fun kfintech(): KfintechServiceAsync.WithRawResponse = kfintech

        override fun nsdl(): NsdlServiceAsync.WithRawResponse = nsdl

        override fun smart(): SmartServiceAsync.WithRawResponse = smart

        override fun inboundEmail(): InboundEmailServiceAsync.WithRawResponse = inboundEmail
    }
}
