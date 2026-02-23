// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailListResponseTest {

    @Test
    fun create() {
        val inboundEmailListResponse =
            InboundEmailListResponse.builder()
                .addInboundEmail(
                    InboundEmailListResponse.InboundEmail.builder()
                        .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.CDSL)
                        .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.NSDL)
                        .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                        .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                        .email("ie_a1b2c3d4e5f6@import.casparser.in")
                        .inboundEmailId("ie_a1b2c3d4e5f6")
                        .metadata(
                            InboundEmailListResponse.InboundEmail.Metadata.builder()
                                .putAdditionalProperty("plan", JsonValue.from("premium"))
                                .build()
                        )
                        .reference("user_12345")
                        .status(InboundEmailListResponse.InboundEmail.Status.ACTIVE)
                        .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                        .build()
                )
                .limit(50L)
                .offset(0L)
                .status("success")
                .total(15L)
                .build()

        assertThat(inboundEmailListResponse.inboundEmails().getOrNull())
            .containsExactly(
                InboundEmailListResponse.InboundEmail.builder()
                    .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.CDSL)
                    .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.NSDL)
                    .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                    .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                    .email("ie_a1b2c3d4e5f6@import.casparser.in")
                    .inboundEmailId("ie_a1b2c3d4e5f6")
                    .metadata(
                        InboundEmailListResponse.InboundEmail.Metadata.builder()
                            .putAdditionalProperty("plan", JsonValue.from("premium"))
                            .build()
                    )
                    .reference("user_12345")
                    .status(InboundEmailListResponse.InboundEmail.Status.ACTIVE)
                    .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                    .build()
            )
        assertThat(inboundEmailListResponse.limit()).contains(50L)
        assertThat(inboundEmailListResponse.offset()).contains(0L)
        assertThat(inboundEmailListResponse.status()).contains("success")
        assertThat(inboundEmailListResponse.total()).contains(15L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundEmailListResponse =
            InboundEmailListResponse.builder()
                .addInboundEmail(
                    InboundEmailListResponse.InboundEmail.builder()
                        .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.CDSL)
                        .addAllowedSource(InboundEmailListResponse.InboundEmail.AllowedSource.NSDL)
                        .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                        .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                        .email("ie_a1b2c3d4e5f6@import.casparser.in")
                        .inboundEmailId("ie_a1b2c3d4e5f6")
                        .metadata(
                            InboundEmailListResponse.InboundEmail.Metadata.builder()
                                .putAdditionalProperty("plan", JsonValue.from("premium"))
                                .build()
                        )
                        .reference("user_12345")
                        .status(InboundEmailListResponse.InboundEmail.Status.ACTIVE)
                        .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                        .build()
                )
                .limit(50L)
                .offset(0L)
                .status("success")
                .total(15L)
                .build()

        val roundtrippedInboundEmailListResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundEmailListResponse),
                jacksonTypeRef<InboundEmailListResponse>(),
            )

        assertThat(roundtrippedInboundEmailListResponse).isEqualTo(inboundEmailListResponse)
    }
}
