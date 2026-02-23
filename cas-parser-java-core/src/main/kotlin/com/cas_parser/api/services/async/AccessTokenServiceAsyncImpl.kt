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
import com.cas_parser.api.models.accesstoken.AccessTokenCreateParams
import com.cas_parser.api.models.accesstoken.AccessTokenCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class AccessTokenServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AccessTokenServiceAsync {

    private val withRawResponse: AccessTokenServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AccessTokenServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AccessTokenServiceAsync =
        AccessTokenServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: AccessTokenCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AccessTokenCreateResponse> =
        // post /v1/token
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AccessTokenServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AccessTokenServiceAsync.WithRawResponse =
            AccessTokenServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<AccessTokenCreateResponse> =
            jsonHandler<AccessTokenCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: AccessTokenCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AccessTokenCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v1", "token")
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
    }
}
