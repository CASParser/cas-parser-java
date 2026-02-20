// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.camskfintech.CamsKfintechParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CamsKfintechServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parse() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val camsKfintechService = client.camsKfintech()

        val unifiedResponse =
            camsKfintechService.parse(
                CamsKfintechParseParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }
}
