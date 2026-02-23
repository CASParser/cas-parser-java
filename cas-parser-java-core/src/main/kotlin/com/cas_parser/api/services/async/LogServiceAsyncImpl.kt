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
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogCreateResponse
import com.cas_parser.api.models.logs.LogGetSummaryParams
import com.cas_parser.api.models.logs.LogGetSummaryResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class LogServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    LogServiceAsync {

    private val withRawResponse: LogServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LogServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogServiceAsync =
        LogServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: LogCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<LogCreateResponse> =
        // post /v1/usage
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun getSummary(
        params: LogGetSummaryParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<LogGetSummaryResponse> =
        // post /v1/usage/summary
        withRawResponse().getSummary(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LogServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LogServiceAsync.WithRawResponse =
            LogServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<LogCreateResponse> =
            jsonHandler<LogCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: LogCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<LogCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "usage")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val getSummaryHandler: Handler<LogGetSummaryResponse> =
            jsonHandler<LogGetSummaryResponse>(clientOptions.jsonMapper)

        override fun getSummary(
            params: LogGetSummaryParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<LogGetSummaryResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "usage", "summary")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getSummaryHandler.handle(it) }
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
