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
import com.cas_parser.api.core.http.json
import com.cas_parser.api.core.http.parseable
import com.cas_parser.api.core.prepareAsync
import com.cas_parser.api.models.kfintech.KfintechGenerateCasParams
import com.cas_parser.api.models.kfintech.KfintechGenerateCasResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class KfintechServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    KfintechServiceAsync {

    private val withRawResponse: KfintechServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KfintechServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): KfintechServiceAsync =
        KfintechServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun generateCas(
        params: KfintechGenerateCasParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<KfintechGenerateCasResponse> =
        // post /v4/kfintech/generate
        withRawResponse().generateCas(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KfintechServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): KfintechServiceAsync.WithRawResponse =
            KfintechServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val generateCasHandler: Handler<KfintechGenerateCasResponse> =
            jsonHandler<KfintechGenerateCasResponse>(clientOptions.jsonMapper)

        override fun generateCas(
            params: KfintechGenerateCasParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<KfintechGenerateCasResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "kfintech", "generate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { generateCasHandler.handle(it) }
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
