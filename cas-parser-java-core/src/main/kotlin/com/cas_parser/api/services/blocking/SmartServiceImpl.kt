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
import com.cas_parser.api.models.camskfintech.UnifiedResponse
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import java.util.function.Consumer

class SmartServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SmartService {

    private val withRawResponse: SmartService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SmartService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SmartService =
        SmartServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun parseCasPdf(
        params: SmartParseCasPdfParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/smart/parse
        withRawResponse().parseCasPdf(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SmartService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SmartService.WithRawResponse =
            SmartServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val parseCasPdfHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun parseCasPdf(
            params: SmartParseCasPdfParams,
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
                    .use { parseCasPdfHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
