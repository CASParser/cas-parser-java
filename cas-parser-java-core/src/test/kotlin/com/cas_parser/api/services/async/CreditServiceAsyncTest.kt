// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class CreditServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun check() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val creditServiceAsync = client.credits()

        val responseFuture = creditServiceAsync.check()

        val response = responseFuture.get()
        response.validate()
    }
}
