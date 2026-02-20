// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CdslServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parsePdf() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val cdslService = client.cdsl()

        val unifiedResponse =
            cdslService.parsePdf(
                CdslParsePdfParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }
}
