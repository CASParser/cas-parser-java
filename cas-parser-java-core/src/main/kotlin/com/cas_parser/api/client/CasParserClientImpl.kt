// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.getPackageVersion
import com.cas_parser.api.services.blocking.CasGeneratorService
import com.cas_parser.api.services.blocking.CasGeneratorServiceImpl
import com.cas_parser.api.services.blocking.CasParserService
import com.cas_parser.api.services.blocking.CasParserServiceImpl
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

    private val casParser: CasParserService by lazy {
        CasParserServiceImpl(clientOptionsWithUserAgent)
    }

    private val casGenerator: CasGeneratorService by lazy {
        CasGeneratorServiceImpl(clientOptionsWithUserAgent)
    }

    override fun async(): CasParserClientAsync = async

    override fun withRawResponse(): CasParserClient.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClient =
        CasParserClientImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun casParser(): CasParserService = casParser

    override fun casGenerator(): CasGeneratorService = casGenerator

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserClient.WithRawResponse {

        private val casParser: CasParserService.WithRawResponse by lazy {
            CasParserServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val casGenerator: CasGeneratorService.WithRawResponse by lazy {
            CasGeneratorServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClient.WithRawResponse =
            CasParserClientImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun casParser(): CasParserService.WithRawResponse = casParser

        override fun casGenerator(): CasGeneratorService.WithRawResponse = casGenerator
    }
}
