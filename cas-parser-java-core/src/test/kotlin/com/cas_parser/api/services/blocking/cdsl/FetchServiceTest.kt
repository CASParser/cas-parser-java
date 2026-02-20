// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking.cdsl

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.cdsl.fetch.FetchRequestOtpParams
import com.cas_parser.api.models.cdsl.fetch.FetchVerifyOtpParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class FetchServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun requestOtp() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val fetchService = client.cdsl().fetch()

        val response =
            fetchService.requestOtp(
                FetchRequestOtpParams.builder()
                    .boId("1234567890123456")
                    .dob("1990-01-15")
                    .pan("ABCDE1234F")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun verifyOtp() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val fetchService = client.cdsl().fetch()

        val response =
            fetchService.verifyOtp(
                FetchVerifyOtpParams.builder()
                    .sessionId("session_id")
                    .otp("123456")
                    .numPeriods(6L)
                    .build()
            )

        response.validate()
    }
}
