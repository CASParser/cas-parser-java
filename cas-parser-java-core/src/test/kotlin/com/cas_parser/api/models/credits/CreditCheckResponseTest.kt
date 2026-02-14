// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.credits

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CreditCheckResponseTest {

    @Test
    fun create() {
        val creditCheckResponse =
            CreditCheckResponse.builder()
                .enabledFeatures(
                    listOf("cams_kfintech_cas_parser", "cdsl_cas_parser", "nsdl_cas_parser")
                )
                .isUnlimited(false)
                .limit(50L)
                .remaining(35.0)
                .resetsAt(OffsetDateTime.parse("2026-02-15T00:00:00Z"))
                .used(15.0)
                .build()

        assertThat(creditCheckResponse.enabledFeatures().getOrNull())
            .containsExactly("cams_kfintech_cas_parser", "cdsl_cas_parser", "nsdl_cas_parser")
        assertThat(creditCheckResponse.isUnlimited()).contains(false)
        assertThat(creditCheckResponse.limit()).contains(50L)
        assertThat(creditCheckResponse.remaining()).contains(35.0)
        assertThat(creditCheckResponse.resetsAt())
            .contains(OffsetDateTime.parse("2026-02-15T00:00:00Z"))
        assertThat(creditCheckResponse.used()).contains(15.0)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val creditCheckResponse =
            CreditCheckResponse.builder()
                .enabledFeatures(
                    listOf("cams_kfintech_cas_parser", "cdsl_cas_parser", "nsdl_cas_parser")
                )
                .isUnlimited(false)
                .limit(50L)
                .remaining(35.0)
                .resetsAt(OffsetDateTime.parse("2026-02-15T00:00:00Z"))
                .used(15.0)
                .build()

        val roundtrippedCreditCheckResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(creditCheckResponse),
                jacksonTypeRef<CreditCheckResponse>(),
            )

        assertThat(roundtrippedCreditCheckResponse).isEqualTo(creditCheckResponse)
    }
}
