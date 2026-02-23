// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogGetSummaryParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LogServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val logService = client.logs()

        val log =
            logService.create(
                LogCreateParams.builder()
                    .endTime(OffsetDateTime.parse("2026-01-31T23:59:59Z"))
                    .limit(1L)
                    .startTime(OffsetDateTime.parse("2026-01-01T00:00:00Z"))
                    .build()
            )

        log.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun getSummary() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val logService = client.logs()

        val response =
            logService.getSummary(
                LogGetSummaryParams.builder()
                    .endTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        response.validate()
    }
}
