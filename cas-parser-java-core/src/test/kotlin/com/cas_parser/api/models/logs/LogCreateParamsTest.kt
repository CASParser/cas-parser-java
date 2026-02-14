// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.logs

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogCreateParamsTest {

    @Test
    fun create() {
        LogCreateParams.builder()
            .endTime(OffsetDateTime.parse("2026-01-31T23:59:59Z"))
            .limit(1L)
            .startTime(OffsetDateTime.parse("2026-01-01T00:00:00Z"))
            .build()
    }

    @Test
    fun body() {
        val params =
            LogCreateParams.builder()
                .endTime(OffsetDateTime.parse("2026-01-31T23:59:59Z"))
                .limit(1L)
                .startTime(OffsetDateTime.parse("2026-01-01T00:00:00Z"))
                .build()

        val body = params._body()

        assertThat(body.endTime()).contains(OffsetDateTime.parse("2026-01-31T23:59:59Z"))
        assertThat(body.limit()).contains(1L)
        assertThat(body.startTime()).contains(OffsetDateTime.parse("2026-01-01T00:00:00Z"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = LogCreateParams.builder().build()

        val body = params._body()
    }
}
