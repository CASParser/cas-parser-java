// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.cdsl.fetch

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FetchRequestOtpResponseTest {

    @Test
    fun create() {
        val fetchRequestOtpResponse =
            FetchRequestOtpResponse.builder()
                .msg("OTP sent to registered mobile")
                .sessionId("550e8400-e29b-41d4-a716-446655440000")
                .status("success")
                .build()

        assertThat(fetchRequestOtpResponse.msg()).contains("OTP sent to registered mobile")
        assertThat(fetchRequestOtpResponse.sessionId())
            .contains("550e8400-e29b-41d4-a716-446655440000")
        assertThat(fetchRequestOtpResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fetchRequestOtpResponse =
            FetchRequestOtpResponse.builder()
                .msg("OTP sent to registered mobile")
                .sessionId("550e8400-e29b-41d4-a716-446655440000")
                .status("success")
                .build()

        val roundtrippedFetchRequestOtpResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fetchRequestOtpResponse),
                jacksonTypeRef<FetchRequestOtpResponse>(),
            )

        assertThat(roundtrippedFetchRequestOtpResponse).isEqualTo(fetchRequestOtpResponse)
    }
}
