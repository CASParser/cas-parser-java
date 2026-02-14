// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.verifytoken

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VerifyTokenVerifyResponseTest {

    @Test
    fun create() {
        val verifyTokenVerifyResponse =
            VerifyTokenVerifyResponse.builder()
                .error("Token has expired")
                .maskedApiKey("abc1****ef23")
                .valid(true)
                .build()

        assertThat(verifyTokenVerifyResponse.error()).contains("Token has expired")
        assertThat(verifyTokenVerifyResponse.maskedApiKey()).contains("abc1****ef23")
        assertThat(verifyTokenVerifyResponse.valid()).contains(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val verifyTokenVerifyResponse =
            VerifyTokenVerifyResponse.builder()
                .error("Token has expired")
                .maskedApiKey("abc1****ef23")
                .valid(true)
                .build()

        val roundtrippedVerifyTokenVerifyResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(verifyTokenVerifyResponse),
                jacksonTypeRef<VerifyTokenVerifyResponse>(),
            )

        assertThat(roundtrippedVerifyTokenVerifyResponse).isEqualTo(verifyTokenVerifyResponse)
    }
}
