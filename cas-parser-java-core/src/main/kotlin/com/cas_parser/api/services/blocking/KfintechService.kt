// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.kfintech.KfintechGenerateCasParams
import com.cas_parser.api.models.kfintech.KfintechGenerateCasResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface KfintechService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): KfintechService

    /**
     * Generate CAS via KFintech mailback. The CAS PDF will be sent to the investor's email.
     *
     * This is an async operation - the investor receives the CAS via email within a few minutes.
     * For instant CAS retrieval, use CDSL Fetch (`/v4/cdsl/fetch`).
     */
    fun generateCas(params: KfintechGenerateCasParams): KfintechGenerateCasResponse =
        generateCas(params, RequestOptions.none())

    /** @see generateCas */
    fun generateCas(
        params: KfintechGenerateCasParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): KfintechGenerateCasResponse

    /** A view of [KfintechService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): KfintechService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/kfintech/generate`, but is otherwise the same
         * as [KfintechService.generateCas].
         */
        @MustBeClosed
        fun generateCas(
            params: KfintechGenerateCasParams
        ): HttpResponseFor<KfintechGenerateCasResponse> = generateCas(params, RequestOptions.none())

        /** @see generateCas */
        @MustBeClosed
        fun generateCas(
            params: KfintechGenerateCasParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<KfintechGenerateCasResponse>
    }
}
