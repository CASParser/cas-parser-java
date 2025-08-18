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
import com.cas_parser.api.models.casparser.CasParserCamsKfintechParams
import com.cas_parser.api.models.casparser.CasParserCdslParams
import com.cas_parser.api.models.casparser.CasParserNsdlParams
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import com.cas_parser.api.models.casparser.UnifiedResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CasParserServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CasParserServiceAsync {

    private val withRawResponse: CasParserServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CasParserServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserServiceAsync =
        CasParserServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun camsKfintech(
        params: CasParserCamsKfintechParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/cams_kfintech/parse
        withRawResponse().camsKfintech(params, requestOptions).thenApply { it.parse() }

    override fun cdsl(
        params: CasParserCdslParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/cdsl/parse
        withRawResponse().cdsl(params, requestOptions).thenApply { it.parse() }

    override fun nsdl(
        params: CasParserNsdlParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/nsdl/parse
        withRawResponse().nsdl(params, requestOptions).thenApply { it.parse() }

    override fun smartParse(
        params: CasParserSmartParseParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/smart/parse
        withRawResponse().smartParse(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserServiceAsync.WithRawResponse =
            CasParserServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val camsKfintechHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun camsKfintech(
            params: CasParserCamsKfintechParams,
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
                            .use { camsKfintechHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val cdslHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun cdsl(
            params: CasParserCdslParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cdsl", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { cdslHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val nsdlHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun nsdl(
            params: CasParserNsdlParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UnifiedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "nsdl", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { nsdlHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val smartParseHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun smartParse(
            params: CasParserSmartParseParams,
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
                            .use { smartParseHandler.handle(it) }
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
