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
import com.cas_parser.api.models.casgenerator.CasGeneratorGenerateCasParams
import com.cas_parser.api.models.casgenerator.CasGeneratorGenerateCasResponse
import java.util.function.Consumer

class CasGeneratorServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CasGeneratorService {

    private val withRawResponse: CasGeneratorService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CasGeneratorService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasGeneratorService =
        CasGeneratorServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun generateCas(
        params: CasGeneratorGenerateCasParams,
        requestOptions: RequestOptions,
    ): CasGeneratorGenerateCasResponse =
        // post /v4/generate
        withRawResponse().generateCas(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CasGeneratorService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasGeneratorService.WithRawResponse =
            CasGeneratorServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val generateCasHandler: Handler<CasGeneratorGenerateCasResponse> =
            jsonHandler<CasGeneratorGenerateCasResponse>(clientOptions.jsonMapper)

        override fun generateCas(
            params: CasGeneratorGenerateCasParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CasGeneratorGenerateCasResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "generate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
