// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.cdsl.fetch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FetchVerifyOtpParamsTest {

    @Test
    fun create() {
        FetchVerifyOtpParams.builder().sessionId("session_id").otp("123456").numPeriods(6L).build()
    }

    @Test
    fun pathParams() {
        val params = FetchVerifyOtpParams.builder().sessionId("session_id").otp("123456").build()

        assertThat(params._pathParam(0)).isEqualTo("session_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FetchVerifyOtpParams.builder()
                .sessionId("session_id")
                .otp("123456")
                .numPeriods(6L)
                .build()

        val body = params._body()

        assertThat(body.otp()).isEqualTo("123456")
        assertThat(body.numPeriods()).contains(6L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FetchVerifyOtpParams.builder().sessionId("session_id").otp("123456").build()

        val body = params._body()

        assertThat(body.otp()).isEqualTo("123456")
    }
}
