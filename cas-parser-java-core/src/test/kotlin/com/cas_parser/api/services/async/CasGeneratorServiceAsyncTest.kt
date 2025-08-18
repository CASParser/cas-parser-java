// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.casgenerator.CasGeneratorGenerateCasParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class CasGeneratorServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun generateCas() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val casGeneratorServiceAsync = client.casGenerator()

        val responseFuture =
            casGeneratorServiceAsync.generateCas(
                CasGeneratorGenerateCasParams.builder()
                    .email("user@example.com")
                    .fromDate("2023-01-01")
                    .password("Abcdefghi12\$")
                    .toDate("2023-12-31")
                    .casAuthority(CasGeneratorGenerateCasParams.CasAuthority.KFINTECH)
                    .panNo("ABCDE1234F")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
