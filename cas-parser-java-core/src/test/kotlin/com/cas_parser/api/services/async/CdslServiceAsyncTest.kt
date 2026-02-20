// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.cdsl.CdslParsePdfParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CdslServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parsePdf() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val cdslServiceAsync = client.cdsl()

        val unifiedResponseFuture =
            cdslServiceAsync.parsePdf(
                CdslParsePdfParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        val unifiedResponse = unifiedResponseFuture.get()
        unifiedResponse.validate()
    }
}
