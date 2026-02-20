// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VerifyTokenServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun verify() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val verifyTokenService = client.verifyToken()

        val response = verifyTokenService.verify()

        response.validate()
    }
}
