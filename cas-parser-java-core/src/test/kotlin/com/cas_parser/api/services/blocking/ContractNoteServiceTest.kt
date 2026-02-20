// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.contractnote.ContractNoteParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class ContractNoteServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun parse() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val contractNoteService = client.contractNote()

        val response =
            contractNoteService.parse(
                ContractNoteParseParams.builder()
                    .brokerType(ContractNoteParseParams.BrokerType.ZERODHA)
                    .password("FAXAK2545F")
                    .pdfFile("JVBERi0xLjQKMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwo...")
                    .pdfUrl("https://example.com/contract_note.pdf")
                    .build()
            )

        response.validate()
    }
}
