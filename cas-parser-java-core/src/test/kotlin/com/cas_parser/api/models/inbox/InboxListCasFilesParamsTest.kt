// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.http.Headers
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxListCasFilesParamsTest {

    @Test
    fun create() {
        InboxListCasFilesParams.builder()
            .xInboxToken("x-inbox-token")
            .addCasType(InboxListCasFilesParams.CasType.CDSL)
            .addCasType(InboxListCasFilesParams.CasType.NSDL)
            .endDate(LocalDate.parse("2025-12-31"))
            .startDate(LocalDate.parse("2025-12-01"))
            .build()
    }

    @Test
    fun headers() {
        val params =
            InboxListCasFilesParams.builder()
                .xInboxToken("x-inbox-token")
                .addCasType(InboxListCasFilesParams.CasType.CDSL)
                .addCasType(InboxListCasFilesParams.CasType.NSDL)
                .endDate(LocalDate.parse("2025-12-31"))
                .startDate(LocalDate.parse("2025-12-01"))
                .build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("x-inbox-token", "x-inbox-token").build())
    }

    @Test
    fun headersWithoutOptionalFields() {
        val params = InboxListCasFilesParams.builder().xInboxToken("x-inbox-token").build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("x-inbox-token", "x-inbox-token").build())
    }

    @Test
    fun body() {
        val params =
            InboxListCasFilesParams.builder()
                .xInboxToken("x-inbox-token")
                .addCasType(InboxListCasFilesParams.CasType.CDSL)
                .addCasType(InboxListCasFilesParams.CasType.NSDL)
                .endDate(LocalDate.parse("2025-12-31"))
                .startDate(LocalDate.parse("2025-12-01"))
                .build()

        val body = params._body()

        assertThat(body.casTypes().getOrNull())
            .containsExactly(
                InboxListCasFilesParams.CasType.CDSL,
                InboxListCasFilesParams.CasType.NSDL,
            )
        assertThat(body.endDate()).contains(LocalDate.parse("2025-12-31"))
        assertThat(body.startDate()).contains(LocalDate.parse("2025-12-01"))
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = InboxListCasFilesParams.builder().xInboxToken("x-inbox-token").build()

        val body = params._body()
    }
}
