// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxListCasFilesResponseTest {

    @Test
    fun create() {
        val inboxListCasFilesResponse =
            InboxListCasFilesResponse.builder()
                .count(5L)
                .addFile(
                    InboxListCasFilesResponse.File.builder()
                        .casType(InboxListCasFilesResponse.File.CasType.CDSL)
                        .expiresIn(86400L)
                        .filename("cdsl_20250115_a1b2c3d4.pdf")
                        .messageDate(LocalDate.parse("2025-01-15"))
                        .messageId("18d4a2b3c4d5e6f7")
                        .originalFilename("CDSL_CAS_Statement.pdf")
                        .size(245000L)
                        .url(
                            "https://cdn.casparser.in/email-cas/user123/cdsl_20250115_a1b2c3d4.pdf"
                        )
                        .build()
                )
                .status("success")
                .build()

        assertThat(inboxListCasFilesResponse.count()).contains(5L)
        assertThat(inboxListCasFilesResponse.files().getOrNull())
            .containsExactly(
                InboxListCasFilesResponse.File.builder()
                    .casType(InboxListCasFilesResponse.File.CasType.CDSL)
                    .expiresIn(86400L)
                    .filename("cdsl_20250115_a1b2c3d4.pdf")
                    .messageDate(LocalDate.parse("2025-01-15"))
                    .messageId("18d4a2b3c4d5e6f7")
                    .originalFilename("CDSL_CAS_Statement.pdf")
                    .size(245000L)
                    .url("https://cdn.casparser.in/email-cas/user123/cdsl_20250115_a1b2c3d4.pdf")
                    .build()
            )
        assertThat(inboxListCasFilesResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxListCasFilesResponse =
            InboxListCasFilesResponse.builder()
                .count(5L)
                .addFile(
                    InboxListCasFilesResponse.File.builder()
                        .casType(InboxListCasFilesResponse.File.CasType.CDSL)
                        .expiresIn(86400L)
                        .filename("cdsl_20250115_a1b2c3d4.pdf")
                        .messageDate(LocalDate.parse("2025-01-15"))
                        .messageId("18d4a2b3c4d5e6f7")
                        .originalFilename("CDSL_CAS_Statement.pdf")
                        .size(245000L)
                        .url(
                            "https://cdn.casparser.in/email-cas/user123/cdsl_20250115_a1b2c3d4.pdf"
                        )
                        .build()
                )
                .status("success")
                .build()

        val roundtrippedInboxListCasFilesResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxListCasFilesResponse),
                jacksonTypeRef<InboxListCasFilesResponse>(),
            )

        assertThat(roundtrippedInboxListCasFilesResponse).isEqualTo(inboxListCasFilesResponse)
    }
}
