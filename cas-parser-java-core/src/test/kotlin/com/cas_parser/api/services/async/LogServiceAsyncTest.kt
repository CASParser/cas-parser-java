// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.logs.LogCreateParams
import com.cas_parser.api.models.logs.LogGetSummaryParams
import java.time.OffsetDateTime
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class LogServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val logServiceAsync = client.logs()

        val logFuture =
            logServiceAsync.create(
                LogCreateParams.builder()
                    .endTime(OffsetDateTime.parse("2026-01-31T23:59:59Z"))
                    .limit(1L)
                    .startTime(OffsetDateTime.parse("2026-01-01T00:00:00Z"))
                    .build()
            )

        val log = logFuture.get()
        log.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun getSummary() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val logServiceAsync = client.logs()

        val responseFuture =
            logServiceAsync.getSummary(
                LogGetSummaryParams.builder()
                    .endTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .startTime(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
