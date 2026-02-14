// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.core.RequestOptions
import com.cas_parser.api.core.http.HttpResponseFor
import com.cas_parser.api.models.contractnote.ContractNoteParseParams
import com.cas_parser.api.models.contractnote.ContractNoteParseResponse
import com.google.errorprone.annotations.MustBeClosed
import java.util.function.Consumer

interface ContractNoteService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContractNoteService

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
    fun parse(): ContractNoteParseResponse = parse(ContractNoteParseParams.none())

    /** @see parse */
    fun parse(
        params: ContractNoteParseParams = ContractNoteParseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ContractNoteParseResponse

    /** @see parse */
    fun parse(
        params: ContractNoteParseParams = ContractNoteParseParams.none()
    ): ContractNoteParseResponse = parse(params, RequestOptions.none())

    /** @see parse */
    fun parse(requestOptions: RequestOptions): ContractNoteParseResponse =
        parse(ContractNoteParseParams.none(), requestOptions)

    /**
     * A view of [ContractNoteService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContractNoteService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /v4/contract_note/parse`, but is otherwise the same
         * as [ContractNoteService.parse].
         */
        @MustBeClosed
        fun parse(): HttpResponseFor<ContractNoteParseResponse> =
            parse(ContractNoteParseParams.none())

        /** @see parse */
        @MustBeClosed
        fun parse(
            params: ContractNoteParseParams = ContractNoteParseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ContractNoteParseResponse>

        /** @see parse */
        @MustBeClosed
        fun parse(
            params: ContractNoteParseParams = ContractNoteParseParams.none()
        ): HttpResponseFor<ContractNoteParseResponse> = parse(params, RequestOptions.none())

        /** @see parse */
        @MustBeClosed
        fun parse(requestOptions: RequestOptions): HttpResponseFor<ContractNoteParseResponse> =
            parse(ContractNoteParseParams.none(), requestOptions)
    }
}
