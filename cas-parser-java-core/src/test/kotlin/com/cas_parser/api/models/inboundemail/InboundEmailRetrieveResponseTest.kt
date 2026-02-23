// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailRetrieveResponseTest {

    @Test
    fun create() {
        val inboundEmailRetrieveResponse =
            InboundEmailRetrieveResponse.builder()
                .addAllowedSource(InboundEmailRetrieveResponse.AllowedSource.CDSL)
                .addAllowedSource(InboundEmailRetrieveResponse.AllowedSource.NSDL)
                .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .email("ie_a1b2c3d4e5f6@import.casparser.in")
                .inboundEmailId("ie_a1b2c3d4e5f6")
                .metadata(
                    InboundEmailRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("plan", JsonValue.from("premium"))
                        .build()
                )
                .reference("user_12345")
                .status(InboundEmailRetrieveResponse.Status.ACTIVE)
                .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .build()

        assertThat(inboundEmailRetrieveResponse.allowedSources().getOrNull())
            .containsExactly(
                InboundEmailRetrieveResponse.AllowedSource.CDSL,
                InboundEmailRetrieveResponse.AllowedSource.NSDL,
            )
        assertThat(inboundEmailRetrieveResponse.callbackUrl())
            .contains("https://api.yourapp.com/webhooks/cas-email")
        assertThat(inboundEmailRetrieveResponse.createdAt())
            .contains(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
        assertThat(inboundEmailRetrieveResponse.email())
            .contains("ie_a1b2c3d4e5f6@import.casparser.in")
        assertThat(inboundEmailRetrieveResponse.inboundEmailId()).contains("ie_a1b2c3d4e5f6")
        assertThat(inboundEmailRetrieveResponse.metadata())
            .contains(
                InboundEmailRetrieveResponse.Metadata.builder()
                    .putAdditionalProperty("plan", JsonValue.from("premium"))
                    .build()
            )
        assertThat(inboundEmailRetrieveResponse.reference()).contains("user_12345")
        assertThat(inboundEmailRetrieveResponse.status())
            .contains(InboundEmailRetrieveResponse.Status.ACTIVE)
        assertThat(inboundEmailRetrieveResponse.updatedAt())
            .contains(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundEmailRetrieveResponse =
            InboundEmailRetrieveResponse.builder()
                .addAllowedSource(InboundEmailRetrieveResponse.AllowedSource.CDSL)
                .addAllowedSource(InboundEmailRetrieveResponse.AllowedSource.NSDL)
                .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                .createdAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .email("ie_a1b2c3d4e5f6@import.casparser.in")
                .inboundEmailId("ie_a1b2c3d4e5f6")
                .metadata(
                    InboundEmailRetrieveResponse.Metadata.builder()
                        .putAdditionalProperty("plan", JsonValue.from("premium"))
                        .build()
                )
                .reference("user_12345")
                .status(InboundEmailRetrieveResponse.Status.ACTIVE)
                .updatedAt(OffsetDateTime.parse("2025-02-21T10:30:00Z"))
                .build()

        val roundtrippedInboundEmailRetrieveResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundEmailRetrieveResponse),
                jacksonTypeRef<InboundEmailRetrieveResponse>(),
            )

        assertThat(roundtrippedInboundEmailRetrieveResponse).isEqualTo(inboundEmailRetrieveResponse)
    }
}
