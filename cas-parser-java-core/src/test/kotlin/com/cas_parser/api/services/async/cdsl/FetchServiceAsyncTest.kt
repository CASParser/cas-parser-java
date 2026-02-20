// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async.cdsl

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FetchServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun requestOtp() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val fetchServiceAsync = client.cdsl().fetch()

        val responseFuture =
            fetchServiceAsync.requestOtp(
                FetchRequestOtpParams.builder()
                    .boId("1234567890123456")
                    .dob("1990-01-15")
                    .pan("ABCDE1234F")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun verifyOtp() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val fetchServiceAsync = client.cdsl().fetch()

        val responseFuture =
            fetchServiceAsync.verifyOtp(
                FetchVerifyOtpParams.builder()
                    .sessionId("session_id")
                    .otp("123456")
                    .numPeriods(6L)
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
