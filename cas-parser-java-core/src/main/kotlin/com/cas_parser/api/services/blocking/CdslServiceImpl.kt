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
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import com.cas_parser.api.services.blocking.cdsl.FetchService
import com.cas_parser.api.services.blocking.cdsl.FetchServiceImpl
import java.util.function.Consumer

class CdslServiceImpl internal constructor(private val clientOptions: ClientOptions) : CdslService {

    private val withRawResponse: CdslService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val fetch: FetchService by lazy { FetchServiceImpl(clientOptions) }

    override fun withRawResponse(): CdslService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CdslService =
        CdslServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun fetch(): FetchService = fetch

    override fun parsePdf(
        params: CdslParsePdfParams,
        requestOptions: RequestOptions,
    ): UnifiedResponse =
        // post /v4/cdsl/parse
        withRawResponse().parsePdf(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CdslService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val fetch: FetchService.WithRawResponse by lazy {
            FetchServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CdslService.WithRawResponse =
            CdslServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun fetch(): FetchService.WithRawResponse = fetch

        private val parsePdfHandler: Handler<UnifiedResponse> =
            jsonHandler<UnifiedResponse>(clientOptions.jsonMapper)

        override fun parsePdf(
            params: CdslParsePdfParams,
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
