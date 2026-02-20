// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.contractnote.ContractNoteParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContractNoteServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parse() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val contractNoteServiceAsync = client.contractNote()

        val responseFuture =
            contractNoteServiceAsync.parse(
                ContractNoteParseParams.builder()
                    .brokerType(ContractNoteParseParams.BrokerType.ZERODHA)
                    .password("FAXAK2545F")
                    .pdfFile("JVBERi0xLjQKMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwo...")
                    .pdfUrl("https://example.com/contract_note.pdf")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
