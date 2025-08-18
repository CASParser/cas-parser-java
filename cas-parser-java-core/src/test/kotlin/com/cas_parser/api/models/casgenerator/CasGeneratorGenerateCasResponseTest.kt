// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casgenerator

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CasGeneratorGenerateCasResponseTest {

    @Test
    fun create() {
        val casGeneratorGenerateCasResponse =
            CasGeneratorGenerateCasResponse.builder()
                .msg(
                    "CAS generation request submitted successfully. The investor will receive the CAS file via email shortly."
                )
                .status("success")
                .build()

        assertThat(casGeneratorGenerateCasResponse.msg())
            .contains(
                "CAS generation request submitted successfully. The investor will receive the CAS file via email shortly."
            )
        assertThat(casGeneratorGenerateCasResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val casGeneratorGenerateCasResponse =
            CasGeneratorGenerateCasResponse.builder()
                .msg(
                    "CAS generation request submitted successfully. The investor will receive the CAS file via email shortly."
                )
                .status("success")
                .build()

        val roundtrippedCasGeneratorGenerateCasResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(casGeneratorGenerateCasResponse),
                jacksonTypeRef<CasGeneratorGenerateCasResponse>(),
            )

        assertThat(roundtrippedCasGeneratorGenerateCasResponse)
            .isEqualTo(casGeneratorGenerateCasResponse)
    }
}
