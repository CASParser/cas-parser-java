// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class SmartServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parseCasPdf() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val smartService = client.smart()

        val unifiedResponse =
            smartService.parseCasPdf(
                SmartParseCasPdfParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }
}
