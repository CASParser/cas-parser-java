// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreditServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun check() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val creditService = client.credits()

        val response = creditService.check()

        response.validate()
    }
}
