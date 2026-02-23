// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class VerifyTokenServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun verify() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val verifyTokenServiceAsync = client.verifyToken()

        val responseFuture = verifyTokenServiceAsync.verify()

        val response = responseFuture.get()
        response.validate()
    }
}
