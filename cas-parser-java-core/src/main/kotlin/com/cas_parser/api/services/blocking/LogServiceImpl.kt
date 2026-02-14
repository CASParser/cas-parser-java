// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

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
import com.cas_parser.api.core.prepare
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogCreateResponse
import com.cas_parser.api.models.logs.LogGetSummaryParams
import com.cas_parser.api.models.logs.LogGetSummaryResponse
import java.util.function.Consumer

class LogServiceImpl internal constructor(private val clientOptions: ClientOptions) : LogService {

    private val withRawResponse: LogService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): LogService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LogService =
        LogServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: LogCreateParams,
        requestOptions: RequestOptions,
    ): LogCreateResponse =
        // post /logs
        withRawResponse().create(params, requestOptions).parse()

    override fun getSummary(
        params: LogGetSummaryParams,
        requestOptions: RequestOptions,
    ): LogGetSummaryResponse =
        // post /logs/summary
        withRawResponse().getSummary(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LogService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LogService.WithRawResponse =
            LogServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<LogCreateResponse> =
            jsonHandler<LogCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: LogCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LogCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("logs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val getSummaryHandler: Handler<LogGetSummaryResponse> =
            jsonHandler<LogGetSummaryResponse>(clientOptions.jsonMapper)

        override fun getSummary(
            params: LogGetSummaryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<LogGetSummaryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("logs", "summary")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
