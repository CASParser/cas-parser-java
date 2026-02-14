// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import java.util.function.Consumer

class CasGeneratorServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CasGeneratorService {

    private val withRawResponse: CasGeneratorService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CasGeneratorService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasGeneratorService =
        CasGeneratorServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasGeneratorService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasGeneratorService.WithRawResponse =
            CasGeneratorServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
