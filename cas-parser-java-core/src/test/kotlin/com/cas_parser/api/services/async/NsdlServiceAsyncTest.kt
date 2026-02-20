// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.nsdl.NsdlParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class NsdlServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun parse() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val nsdlServiceAsync = client.nsdl()

        val unifiedResponseFuture =
            nsdlServiceAsync.parse(
                NsdlParseParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        val unifiedResponse = unifiedResponseFuture.get()
        unifiedResponse.validate()
    }
}
