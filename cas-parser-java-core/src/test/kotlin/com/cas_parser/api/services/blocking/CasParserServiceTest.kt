// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.casparser.CasParserCamsKfintechParams
import com.cas_parser.api.models.casparser.CasParserCdslParams
import com.cas_parser.api.models.casparser.CasParserNsdlParams
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CasParserServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun camsKfintech() {
        val client =
            CasParserOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val casParserService = client.casParser()

        val unifiedResponse =
            casParserService.camsKfintech(
                CasParserCamsKfintechParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun cdsl() {
        val client =
            CasParserOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val casParserService = client.casParser()

        val unifiedResponse =
            casParserService.cdsl(
                CasParserCdslParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun nsdl() {
        val client =
            CasParserOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val casParserService = client.casParser()

        val unifiedResponse =
            casParserService.nsdl(
                CasParserNsdlParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun smartParse() {
        val client =
            CasParserOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val casParserService = client.casParser()

        val unifiedResponse =
            casParserService.smartParse(
                CasParserSmartParseParams.builder()
                    .password("password")
                    .pdfFile("pdf_file")
                    .pdfUrl("https://example.com")
                    .build()
            )

        unifiedResponse.validate()
    }
}
