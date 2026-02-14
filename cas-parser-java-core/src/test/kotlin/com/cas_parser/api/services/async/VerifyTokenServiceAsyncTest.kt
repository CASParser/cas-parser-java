// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VerifyTokenServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun verify() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val verifyTokenServiceAsync = client.verifyToken()

        val responseFuture = verifyTokenServiceAsync.verify()

        val response = responseFuture.get()
        response.validate()
    }
}
