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
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusParams
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusResponse
import com.cas_parser.api.models.inbox.InboxConnectEmailParams
import com.cas_parser.api.models.inbox.InboxConnectEmailResponse
import com.cas_parser.api.models.inbox.InboxDisconnectEmailParams
import com.cas_parser.api.models.inbox.InboxDisconnectEmailResponse
import com.cas_parser.api.models.inbox.InboxListCasFilesParams
import com.cas_parser.api.models.inbox.InboxListCasFilesResponse
import java.util.function.Consumer

class InboxServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    InboxService {

    private val withRawResponse: InboxService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InboxService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InboxService =
        InboxServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun checkConnectionStatus(
        params: InboxCheckConnectionStatusParams,
        requestOptions: RequestOptions,
    ): InboxCheckConnectionStatusResponse =
        // post /v4/inbox/status
        withRawResponse().checkConnectionStatus(params, requestOptions).parse()

    override fun connectEmail(
        params: InboxConnectEmailParams,
        requestOptions: RequestOptions,
    ): InboxConnectEmailResponse =
        // post /v4/inbox/connect
        withRawResponse().connectEmail(params, requestOptions).parse()

    override fun disconnectEmail(
        params: InboxDisconnectEmailParams,
        requestOptions: RequestOptions,
    ): InboxDisconnectEmailResponse =
        // post /v4/inbox/disconnect
        withRawResponse().disconnectEmail(params, requestOptions).parse()

    override fun listCasFiles(
        params: InboxListCasFilesParams,
        requestOptions: RequestOptions,
    ): InboxListCasFilesResponse =
        // post /v4/inbox/cas
        withRawResponse().listCasFiles(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InboxService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InboxService.WithRawResponse =
            InboxServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val checkConnectionStatusHandler: Handler<InboxCheckConnectionStatusResponse> =
            jsonHandler<InboxCheckConnectionStatusResponse>(clientOptions.jsonMapper)

        override fun checkConnectionStatus(
            params: InboxCheckConnectionStatusParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxCheckConnectionStatusResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbox", "status")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { checkConnectionStatusHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val connectEmailHandler: Handler<InboxConnectEmailResponse> =
            jsonHandler<InboxConnectEmailResponse>(clientOptions.jsonMapper)

        override fun connectEmail(
            params: InboxConnectEmailParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxConnectEmailResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbox", "connect")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { connectEmailHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val disconnectEmailHandler: Handler<InboxDisconnectEmailResponse> =
            jsonHandler<InboxDisconnectEmailResponse>(clientOptions.jsonMapper)

        override fun disconnectEmail(
            params: InboxDisconnectEmailParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxDisconnectEmailResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbox", "disconnect")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { disconnectEmailHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listCasFilesHandler: Handler<InboxListCasFilesResponse> =
            jsonHandler<InboxListCasFilesResponse>(clientOptions.jsonMapper)

        override fun listCasFiles(
            params: InboxListCasFilesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InboxListCasFilesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("v4", "inbox", "cas")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listCasFilesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
