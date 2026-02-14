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
import com.cas_parser.api.models.camskfintech.CamsKfintechParseParams
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CamsKfintechServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CamsKfintechServiceAsync {

    private val withRawResponse: CamsKfintechServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CamsKfintechServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CamsKfintechServiceAsync =
        CamsKfintechServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun parse(
        params: CamsKfintechParseParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/cams_kfintech/parse
        withRawResponse().parse(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CamsKfintechServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CamsKfintechServiceAsync.WithRawResponse =
            CamsKfintechServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val parseHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun parse(
            params: CamsKfintechParseParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cams_kfintech", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { parseHandler.handle(it) }
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
