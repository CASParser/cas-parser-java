// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailCreateResponseTest {

    @Test
    fun create() {
        val inboundEmailCreateResponse =
            InboundEmailCreateResponse.builder()
                .addAllowedSource(InboundEmailCreateResponse.AllowedSource.CDSL)
                .addAllowedSource(InboundEmailCreateResponse.AllowedSource.NSDL)
                .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .email("ie_a1b2c3d4e5f6@import.casparser.in")
                .inboundEmailId("ie_a1b2c3d4e5f6")
                .metadata(
                    InboundEmailCreateResponse.Metadata.builder()
                        .putAdditionalProperty("plan", JsonValue.from("premium"))
                        .build()
                )
                .reference("user_12345")
                .status(InboundEmailCreateResponse.Status.ACTIVE)
                .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .build()

        assertThat(inboundEmailCreateResponse.allowedSources().getOrNull())
            .containsExactly(
                InboundEmailCreateResponse.AllowedSource.CDSL,
                InboundEmailCreateResponse.AllowedSource.NSDL,
            )
        assertThat(inboundEmailCreateResponse.callbackUrl())
            .contains("https://api.yourapp.com/webhooks/cas-email")
        assertThat(inboundEmailCreateResponse.createdAt())
            .contains(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
        assertThat(inboundEmailCreateResponse.email())
            .contains("ie_a1b2c3d4e5f6@import.casparser.in")
        assertThat(inboundEmailCreateResponse.inboundEmailId()).contains("ie_a1b2c3d4e5f6")
        assertThat(inboundEmailCreateResponse.metadata())
            .contains(
                InboundEmailCreateResponse.Metadata.builder()
                    .putAdditionalProperty("plan", JsonValue.from("premium"))
                    .build()
            )
        assertThat(inboundEmailCreateResponse.reference()).contains("user_12345")
        assertThat(inboundEmailCreateResponse.status())
            .contains(InboundEmailCreateResponse.Status.ACTIVE)
        assertThat(inboundEmailCreateResponse.updatedAt())
            .contains(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundEmailCreateResponse =
            InboundEmailCreateResponse.builder()
                .addAllowedSource(InboundEmailCreateResponse.AllowedSource.CDSL)
                .addAllowedSource(InboundEmailCreateResponse.AllowedSource.NSDL)
                .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .email("ie_a1b2c3d4e5f6@import.casparser.in")
                .inboundEmailId("ie_a1b2c3d4e5f6")
                .metadata(
                    InboundEmailCreateResponse.Metadata.builder()
                        .putAdditionalProperty("plan", JsonValue.from("premium"))
                        .build()
                )
                .reference("user_12345")
                .status(InboundEmailCreateResponse.Status.ACTIVE)
                .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .build()

        val roundtrippedInboundEmailCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundEmailCreateResponse),
                jacksonTypeRef<InboundEmailCreateResponse>(),
            )

        assertThat(roundtrippedInboundEmailCreateResponse).isEqualTo(inboundEmailCreateResponse)
    }
}
