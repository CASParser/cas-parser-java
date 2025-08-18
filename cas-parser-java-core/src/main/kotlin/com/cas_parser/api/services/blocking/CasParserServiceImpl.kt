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
import com.cas_parser.api.core.http.multipartFormData
import com.cas_parser.api.core.http.parseable
import com.cas_parser.api.core.prepare
import com.cas_parser.api.models.casparser.CasParserCamsKfintechParams
import com.cas_parser.api.models.casparser.CasParserCdslParams
import com.cas_parser.api.models.casparser.CasParserNsdlParams
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import com.cas_parser.api.models.casparser.UnifiedResponse
import java.util.function.Consumer

class CasParserServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CasParserService {

    private val withRawResponse: CasParserService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CasParserService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserService =
        CasParserServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun camsKfintech(
        params: CasParserCamsKfintechParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/cams_kfintech/parse
        withRawResponse().camsKfintech(params, requestOptions).parse()

    override fun cdsl(
        params: CasParserCdslParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/cdsl/parse
        withRawResponse().cdsl(params, requestOptions).parse()

    override fun nsdl(
        params: CasParserNsdlParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/nsdl/parse
        withRawResponse().nsdl(params, requestOptions).parse()

    override fun smartParse(
        params: CasParserSmartParseParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/smart/parse
        withRawResponse().smartParse(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasParserService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserService.WithRawResponse =
            CasParserServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val camsKfintechHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun camsKfintech(
            params: CasParserCamsKfintechParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UnifiedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cams_kfintech", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { camsKfintechHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val cdslHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun cdsl(
            params: CasParserCdslParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UnifiedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cdsl", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cdslHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val nsdlHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun nsdl(
            params: CasParserNsdlParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UnifiedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "nsdl", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { nsdlHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val smartParseHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun smartParse(
            params: CasParserSmartParseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UnifiedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "smart", "parse")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
