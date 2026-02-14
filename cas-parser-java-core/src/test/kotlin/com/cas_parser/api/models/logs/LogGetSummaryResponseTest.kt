// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.logs

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogGetSummaryResponseTest {

    @Test
    fun create() {
        val logGetSummaryResponse =
            LogGetSummaryResponse.builder()
                .status("success")
                .summary(
                    LogGetSummaryResponse.Summary.builder()
                        .addByFeature(
                            LogGetSummaryResponse.Summary.ByFeature.builder()
                                .credits(15.0)
                                .feature("cdsl_cas_parser")
                                .requests(15L)
                                .build()
                        )
                        .totalCredits(45.5)
                        .totalRequests(42L)
                        .build()
                )
                .build()

        assertThat(logGetSummaryResponse.status()).contains("success")
        assertThat(logGetSummaryResponse.summary())
            .contains(
                LogGetSummaryResponse.Summary.builder()
                    .addByFeature(
                        LogGetSummaryResponse.Summary.ByFeature.builder()
                            .credits(15.0)
                            .feature("cdsl_cas_parser")
                            .requests(15L)
                            .build()
                    )
                    .totalCredits(45.5)
                    .totalRequests(42L)
                    .build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val logGetSummaryResponse =
            LogGetSummaryResponse.builder()
                .status("success")
                .summary(
                    LogGetSummaryResponse.Summary.builder()
                        .addByFeature(
                            LogGetSummaryResponse.Summary.ByFeature.builder()
                                .credits(15.0)
                                .feature("cdsl_cas_parser")
                                .requests(15L)
                                .build()
                        )
                        .totalCredits(45.5)
                        .totalRequests(42L)
                        .build()
                )
                .build()

        val roundtrippedLogGetSummaryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logGetSummaryResponse),
                jacksonTypeRef<LogGetSummaryResponse>(),
            )

        assertThat(roundtrippedLogGetSummaryResponse).isEqualTo(logGetSummaryResponse)
    }
}
