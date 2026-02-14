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

    override fun async(): CasParserClientAsync = async

    override fun withRawResponse(): CasParserClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClient =
        CasParserClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun credits(): CreditService = credits

    override fun logs(): LogService = logs

    override fun accessToken(): AccessTokenService = accessToken

    override fun verifyToken(): VerifyTokenService = verifyToken

    override fun camsKfintech(): CamsKfintechService = camsKfintech

    override fun cdsl(): CdslService = cdsl

    override fun contractNote(): ContractNoteService = contractNote

    override fun inbox(): InboxService = inbox

    override fun kfintech(): KfintechService = kfintech

    override fun nsdl(): NsdlService = nsdl

    override fun smart(): SmartService = smart

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

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClient.WithRawResponse =
            CasParserClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun credits(): CreditService.WithRawResponse = credits

        override fun logs(): LogService.WithRawResponse = logs

        override fun accessToken(): AccessTokenService.WithRawResponse = accessToken

        override fun verifyToken(): VerifyTokenService.WithRawResponse = verifyToken

        override fun camsKfintech(): CamsKfintechService.WithRawResponse = camsKfintech

        override fun cdsl(): CdslService.WithRawResponse = cdsl

        override fun contractNote(): ContractNoteService.WithRawResponse = contractNote

        override fun inbox(): InboxService.WithRawResponse = inbox

        override fun kfintech(): KfintechService.WithRawResponse = kfintech

        override fun nsdl(): NsdlService.WithRawResponse = nsdl

        override fun smart(): SmartService.WithRawResponse = smart
    }
}
