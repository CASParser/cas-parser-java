// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.kfintech.KfintechGenerateCasParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class KfintechServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun generateCas() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val kfintechService = client.kfintech()

        val response =
            kfintechService.generateCas(
                KfintechGenerateCasParams.builder()
                    .email("user@example.com")
                    .fromDate("2023-01-01")
                    .password("Abcdefghi12\$")
                    .toDate("2023-12-31")
                    .panNo("ABCDE1234F")
                    .build()
            )

        response.validate()
    }
}
