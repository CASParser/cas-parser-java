// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.logs

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogCreateResponseTest {

    @Test
    fun create() {
        val logCreateResponse =
            LogCreateResponse.builder()
                .count(25L)
                .addLog(
                    LogCreateResponse.Log.builder()
                        .credits(1.0)
                        .feature("cdsl_cas_parser")
                        .path("/v4/cdsl/parse")
                        .requestId("req_2xYz7KpL8mN3Ab")
                        .statusCode(200L)
                        .timestamp(OffsetDateTime.parse("2026-01-15T14:30:00Z"))
                        .build()
                )
                .status("success")
                .build()

        assertThat(logCreateResponse.count()).contains(25L)
        assertThat(logCreateResponse.logs().getOrNull())
            .containsExactly(
                LogCreateResponse.Log.builder()
                    .credits(1.0)
                    .feature("cdsl_cas_parser")
                    .path("/v4/cdsl/parse")
                    .requestId("req_2xYz7KpL8mN3Ab")
                    .statusCode(200L)
                    .timestamp(OffsetDateTime.parse("2026-01-15T14:30:00Z"))
                    .build()
            )
        assertThat(logCreateResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val logCreateResponse =
            LogCreateResponse.builder()
                .count(25L)
                .addLog(
                    LogCreateResponse.Log.builder()
                        .credits(1.0)
                        .feature("cdsl_cas_parser")
                        .path("/v4/cdsl/parse")
                        .requestId("req_2xYz7KpL8mN3Ab")
                        .statusCode(200L)
                        .timestamp(OffsetDateTime.parse("2026-01-15T14:30:00Z"))
                        .build()
                )
                .status("success")
                .build()

        val roundtrippedLogCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(logCreateResponse),
                jacksonTypeRef<LogCreateResponse>(),
            )

        assertThat(roundtrippedLogCreateResponse).isEqualTo(logCreateResponse)
    }
}
