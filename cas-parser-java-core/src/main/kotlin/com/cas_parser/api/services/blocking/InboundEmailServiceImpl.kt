// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

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
import com.cas_parser.api.models.inboundemail.InboundEmailCreateParams
import com.cas_parser.api.models.inboundemail.InboundEmailCreateResponse
import com.cas_parser.api.models.inboundemail.InboundEmailDeleteParams
import com.cas_parser.api.models.inboundemail.InboundEmailDeleteResponse
import com.cas_parser.api.models.inboundemail.InboundEmailListParams
import com.cas_parser.api.models.inboundemail.InboundEmailListResponse
import com.cas_parser.api.models.inboundemail.InboundEmailRetrieveParams
import com.cas_parser.api.models.inboundemail.InboundEmailRetrieveResponse
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class InboundEmailServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InboundEmailService {

    private val withRawResponse: InboundEmailService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InboundEmailService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboundEmailService =
        InboundEmailServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: InboundEmailCreateParams,
        requestOptions: RequestOptions,
    ): InboundEmailCreateResponse =
        // post /v4/inbound-email
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: InboundEmailRetrieveParams,
        requestOptions: RequestOptions,
    ): InboundEmailRetrieveResponse =
        // get /v4/inbound-email/{inbound_email_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: InboundEmailListParams,
        requestOptions: RequestOptions,
    ): InboundEmailListResponse =
        // get /v4/inbound-email
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: InboundEmailDeleteParams,
        requestOptions: RequestOptions,
    ): InboundEmailDeleteResponse =
        // delete /v4/inbound-email/{inbound_email_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InboundEmailService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboundEmailService.WithRawResponse =
            InboundEmailServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<InboundEmailCreateResponse> =
            jsonHandler<InboundEmailCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: InboundEmailCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbound-email")
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

        private val retrieveHandler: Handler<InboundEmailRetrieveResponse> =
            jsonHandler<InboundEmailRetrieveResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: InboundEmailRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailRetrieveResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboundEmailId", params.inboundEmailId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbound-email", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<InboundEmailListResponse> =
            jsonHandler<InboundEmailListResponse>(clientOptions.jsonMapper)

        override fun list(
            params: InboundEmailListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailListResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbound-email")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<InboundEmailDeleteResponse> =
            jsonHandler<InboundEmailDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: InboundEmailDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboundEmailDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("inboundEmailId", params.inboundEmailId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbound-email", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
