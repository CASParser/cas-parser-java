// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import java.util.function.Consumer

class VerifyTokenServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VerifyTokenServiceAsync {

    private val withRawResponse: VerifyTokenServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VerifyTokenServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VerifyTokenServiceAsync =
        VerifyTokenServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VerifyTokenServiceAsync.WithRawResponse {

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VerifyTokenServiceAsync.WithRawResponse =
            VerifyTokenServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )
    }
}
