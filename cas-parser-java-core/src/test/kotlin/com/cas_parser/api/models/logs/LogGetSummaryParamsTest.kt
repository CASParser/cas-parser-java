// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.logs

import java.time.OffsetDateTime
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LogGetSummaryParamsTest {

    @Test
    fun create() {
        LogGetSummaryParams.builder()
            .endTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
            .build()
    }

    @Test
    fun body() {
        val params =
            LogGetSummaryParams.builder()
                .endTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .build()

        val body = params._body()

        assertThat(body.endTime()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
        assertThat(body.startTime()).contains(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = LogGetSummaryParams.builder().build()

        val body = params._body()
    }
}
