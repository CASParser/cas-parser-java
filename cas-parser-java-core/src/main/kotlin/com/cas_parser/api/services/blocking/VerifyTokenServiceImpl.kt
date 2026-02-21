// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import java.util.function.Consumer

class VerifyTokenServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VerifyTokenService {

    private val withRawResponse: VerifyTokenService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VerifyTokenService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VerifyTokenService =
        VerifyTokenServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VerifyTokenService.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VerifyTokenService.WithRawResponse =
            VerifyTokenServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
