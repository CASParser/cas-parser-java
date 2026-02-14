// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.smart.SmartParseCasPdfParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SmartServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun parseCasPdf() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val smartServiceAsync = client.smart()

        val unifiedResponseFuture =
            smartServiceAsync.parseCasPdf(
                SmartParseCasPdfParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        val unifiedResponse = unifiedResponseFuture.get()
        unifiedResponse.validate()
    }
}
