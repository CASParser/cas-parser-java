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
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import com.cas_parser.api.services.async.cdsl.FetchServiceAsync
import com.cas_parser.api.services.async.cdsl.FetchServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class CdslServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CdslServiceAsync {

    private val withRawResponse: CdslServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val fetch: FetchServiceAsync by lazy { FetchServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): CdslServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslServiceAsync =
        CdslServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun fetch(): FetchServiceAsync = fetch

    override fun parsePdf(
        params: CdslParsePdfParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UnifiedResponse> =
        // post /v4/cdsl/parse
        withRawResponse().parsePdf(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CdslServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val fetch: FetchServiceAsync.WithRawResponse by lazy {
            FetchServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CdslServiceAsync.WithRawResponse =
            CdslServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun fetch(): FetchServiceAsync.WithRawResponse = fetch

        private val parsePdfHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun parsePdf(
            params: CdslParsePdfParams,
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
                            .use { parsePdfHandler.handle(it) }
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
