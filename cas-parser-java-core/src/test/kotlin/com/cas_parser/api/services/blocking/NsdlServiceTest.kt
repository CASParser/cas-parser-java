// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.nsdl.NsdlParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NsdlServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun parse() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val nsdlService = client.nsdl()

        val unifiedResponse =
            nsdlService.parse(
                NsdlParseParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }
}
