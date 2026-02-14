// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.cdsl.fetch

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FetchVerifyOtpResponseTest {

    @Test
    fun create() {
        val fetchVerifyOtpResponse =
            FetchVerifyOtpResponse.builder()
                .addFile(
                    FetchVerifyOtpResponse.File.builder()
                        .filename("CDSL_CAS_1234567890123456_NOV2025.pdf")
                        .url(
                            "https://cdn.casparser.in/cdsl-cas/session-id/CDSL_CAS_1234567890123456_NOV2025.pdf"
                        )
                        .build()
                )
                .msg("Fetched 6 CAS files")
                .status("success")
                .build()

        assertThat(fetchVerifyOtpResponse.files().getOrNull())
            .containsExactly(
                FetchVerifyOtpResponse.File.builder()
                    .filename("CDSL_CAS_1234567890123456_NOV2025.pdf")
                    .url(
                        "https://cdn.casparser.in/cdsl-cas/session-id/CDSL_CAS_1234567890123456_NOV2025.pdf"
                    )
                    .build()
            )
        assertThat(fetchVerifyOtpResponse.msg()).contains("Fetched 6 CAS files")
        assertThat(fetchVerifyOtpResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val fetchVerifyOtpResponse =
            FetchVerifyOtpResponse.builder()
                .addFile(
                    FetchVerifyOtpResponse.File.builder()
                        .filename("CDSL_CAS_1234567890123456_NOV2025.pdf")
                        .url(
                            "https://cdn.casparser.in/cdsl-cas/session-id/CDSL_CAS_1234567890123456_NOV2025.pdf"
                        )
                        .build()
                )
                .msg("Fetched 6 CAS files")
                .status("success")
                .build()

        val roundtrippedFetchVerifyOtpResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(fetchVerifyOtpResponse),
                jacksonTypeRef<FetchVerifyOtpResponse>(),
            )

        assertThat(roundtrippedFetchVerifyOtpResponse).isEqualTo(fetchVerifyOtpResponse)
    }
}
