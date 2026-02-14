// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking.cdsl

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.checkRequired
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
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpResponse
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FetchServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FetchService {

    private val withRawResponse: FetchService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FetchService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FetchService =
        FetchServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun requestOtp(
        params: FetchRequestOtpParams,
        requestOptions: RequestOptions,
    ): FetchRequestOtpResponse =
        // post /v4/cdsl/fetch
        withRawResponse().requestOtp(params, requestOptions).parse()

    override fun verifyOtp(
        params: FetchVerifyOtpParams,
        requestOptions: RequestOptions,
    ): FetchVerifyOtpResponse =
        // post /v4/cdsl/fetch/{session_id}/verify
        withRawResponse().verifyOtp(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FetchService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FetchService.WithRawResponse =
            FetchServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val requestOtpHandler: Handler<FetchRequestOtpResponse> =
            jsonHandler<FetchRequestOtpResponse>(clientOptions.jsonMapper)

        override fun requestOtp(
            params: FetchRequestOtpParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchRequestOtpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cdsl", "fetch")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { requestOtpHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val verifyOtpHandler: Handler<FetchVerifyOtpResponse> =
            jsonHandler<FetchVerifyOtpResponse>(clientOptions.jsonMapper)

        override fun verifyOtp(
            params: FetchVerifyOtpParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FetchVerifyOtpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "cdsl", "fetch", params._pathParam(0), "verify")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { verifyOtpHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
