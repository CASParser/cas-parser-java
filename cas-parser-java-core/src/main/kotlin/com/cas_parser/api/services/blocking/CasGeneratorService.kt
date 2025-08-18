// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.casgenerator.CasGeneratorGenerateCasParams
import com.cas_parser.api.models.casgenerator.CasGeneratorGenerateCasResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface CasGeneratorService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasGeneratorService

    /**
     * This endpoint generates CAS (Consolidated Account Statement) documents by submitting a
     * mailback request to the specified CAS authority. Currently only supports KFintech, with plans
     * to support CAMS, CDSL, and NSDL in the future.
     */
    fun generateCas(params: CasGeneratorGenerateCasParams): CasGeneratorGenerateCasResponse =
        generateCas(params, RequestOptions.none())

    /** @see generateCas */
    fun generateCas(
        params: CasGeneratorGenerateCasParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CasGeneratorGenerateCasResponse

    /**
     * A view of [CasGeneratorService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasGeneratorService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/generate`, but is otherwise the same as
         * [CasGeneratorService.generateCas].
         */
        @MustBeClosed
        fun generateCas(
            params: CasGeneratorGenerateCasParams
        ): HttpResponseFor<CasGeneratorGenerateCasResponse> =
            generateCas(params, RequestOptions.none())

        /** @see generateCas */
        @MustBeClosed
        fun generateCas(
            params: CasGeneratorGenerateCasParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CasGeneratorGenerateCasResponse>
    }
}
