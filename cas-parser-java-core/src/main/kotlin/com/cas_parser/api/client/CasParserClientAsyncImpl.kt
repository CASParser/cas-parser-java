// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.getPackageVersion
import com.cas_parser.api.services.async.CasGeneratorServiceAsync
import com.cas_parser.api.services.async.CasGeneratorServiceAsyncImpl
import com.cas_parser.api.services.async.CasParserServiceAsync
import com.cas_parser.api.services.async.CasParserServiceAsyncImpl
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

    private val casParser: CasParserServiceAsync by lazy {
        CasParserServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    private val casGenerator: CasGeneratorServiceAsync by lazy {
        CasGeneratorServiceAsyncImpl(clientOptionsWithUserAgent)
    }

    override fun sync(): CasParserClient = sync

    override fun withRawResponse(): CasParserClientAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClientAsync =
        CasParserClientAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun casParser(): CasParserServiceAsync = casParser

    override fun casGenerator(): CasGeneratorServiceAsync = casGenerator

    override fun close() = clientOptions.httpClient.close()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserClientAsync.WithRawResponse {

        private val casParser: CasParserServiceAsync.WithRawResponse by lazy {
            CasParserServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val casGenerator: CasGeneratorServiceAsync.WithRawResponse by lazy {
            CasGeneratorServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClientAsync.WithRawResponse =
            CasParserClientAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun casParser(): CasParserServiceAsync.WithRawResponse = casParser

        override fun casGenerator(): CasGeneratorServiceAsync.WithRawResponse = casGenerator
    }
}
