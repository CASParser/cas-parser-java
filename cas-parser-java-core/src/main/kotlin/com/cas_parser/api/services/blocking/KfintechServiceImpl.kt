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
import com.cas_parser.api.models.kfintech.KfintechGenerateCasParams
import com.cas_parser.api.models.kfintech.KfintechGenerateCasResponse
import java.util.function.Consumer

class KfintechServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    KfintechService {

    private val withRawResponse: KfintechService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): KfintechService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): KfintechService =
        KfintechServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun generateCas(
        params: KfintechGenerateCasParams,
        requestOptions: RequestOptions,
    ): KfintechGenerateCasResponse =
        // post /v4/kfintech/generate
        withRawResponse().generateCas(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        KfintechService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): KfintechService.WithRawResponse =
            KfintechServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val generateCasHandler: Handler<KfintechGenerateCasResponse> =
            jsonHandler<KfintechGenerateCasResponse>(clientOptions.jsonMapper)

        override fun generateCas(
            params: KfintechGenerateCasParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<KfintechGenerateCasResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "kfintech", "generate")
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
