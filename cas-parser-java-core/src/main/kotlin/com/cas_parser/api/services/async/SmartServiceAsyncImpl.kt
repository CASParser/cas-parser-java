// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.handlers.errorBodyHandler
import com.cas_parser.api.core.handlers.errorHandler
import com.cas_parser.api.core.handlers.jsonHandler
import com.cas_parser.api.core.http.HttpMethod
import com.cas_parser.api.core.http.HttpRequest
import com.cas_parser.api.core.http.HttpResponse
import com.cas_parser.api.core.http.HttpResponse.Handler
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.core.http.multipartFormData
import com.cas_parser.api.core.http.parseable
import com.cas_parser.api.core.prepareAsync
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class SmartServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SmartServiceAsync {

    private val withRawResponse: SmartServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SmartServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartServiceAsync =
        SmartServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun parseCasPdf(
        params: SmartParseCasPdfParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/smart/parse
        withRawResponse().parseCasPdf(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SmartServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmartServiceAsync.WithRawResponse =
            SmartServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val parseCasPdfHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun parseCasPdf(
            params: SmartParseCasPdfParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "smart", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { parseCasPdfHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
