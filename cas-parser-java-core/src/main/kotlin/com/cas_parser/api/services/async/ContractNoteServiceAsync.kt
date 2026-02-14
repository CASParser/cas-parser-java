// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.contractnote.ContractNoteParseParams
import com.cas_parser.api.models.contractnote.ContractNoteParseResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContractNoteServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContractNoteServiceAsync

    /**
     * This endpoint parses Contract Note PDF files from various brokers including Zerodha, Groww,
     * Upstox, ICICI Securities, and others.
     *
     * **What is a Contract Note?** A contract note is a legal document that provides details of all
     * trades executed by an investor. It includes:
     * - Trade details with timestamps, quantities, and prices
     * - Brokerage and charges breakdown
     * - Settlement information
     * - Regulatory compliance details
     *
     * **Supported Brokers:**
     * - Zerodha Broking Limited
     * - Groww Invest Tech Private Limited
     * - Upstox (RKSV Securities)
     * - ICICI Securities Limited
     * - Auto-detection for unknown brokers
     *
     * **Key Features:**
     * - **Auto-detection**: Automatically identifies broker type from PDF content
     * - **Comprehensive parsing**: Extracts equity transactions, derivatives transactions, detailed
     *   trades, and charges
     * - **Flexible input**: Accepts both file upload and URL-based PDF input
     * - **Password protection**: Supports password-protected PDFs
     *
     * The API returns structured data including contract note information, client details,
     * transaction summaries, and detailed trade-by-trade breakdowns.
     */
    fun parse(): CompletableFuture<ContractNoteParseResponse> =
        parse(ContractNoteParseParams.none())

    /** @see parse */
    fun parse(
        params: ContractNoteParseParams = ContractNoteParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ContractNoteParseResponse>

    /** @see parse */
    fun parse(
        params: ContractNoteParseParams = ContractNoteParseParams.none()
    ): CompletableFuture<ContractNoteParseResponse> = parse(params, RequestOptions.none())

    /** @see parse */
    fun parse(requestOptions: RequestOptions): CompletableFuture<ContractNoteParseResponse> =
        parse(ContractNoteParseParams.none(), requestOptions)

    /**
     * A view of [ContractNoteServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContractNoteServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/contract_note/parse`, but is otherwise the same
         * as [ContractNoteServiceAsync.parse].
         */
        fun parse(): CompletableFuture<HttpResponseFor<ContractNoteParseResponse>> =
            parse(ContractNoteParseParams.none())

        /** @see parse */
        fun parse(
            params: ContractNoteParseParams = ContractNoteParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ContractNoteParseResponse>>

        /** @see parse */
        fun parse(
            params: ContractNoteParseParams = ContractNoteParseParams.none()
        ): CompletableFuture<HttpResponseFor<ContractNoteParseResponse>> =
            parse(params, RequestOptions.none())

        /** @see parse */
        fun parse(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<ContractNoteParseResponse>> =
            parse(ContractNoteParseParams.none(), requestOptions)
    }
}
