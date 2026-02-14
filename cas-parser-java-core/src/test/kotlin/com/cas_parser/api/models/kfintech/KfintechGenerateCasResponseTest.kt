// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.kfintech

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class KfintechGenerateCasResponseTest {

    @Test
    fun create() {
        val kfintechGenerateCasResponse =
            KfintechGenerateCasResponse.builder()
                .msg("CAS request submitted. Check email shortly.")
                .status("success")
                .build()

        assertThat(kfintechGenerateCasResponse.msg())
            .contains("CAS request submitted. Check email shortly.")
        assertThat(kfintechGenerateCasResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val kfintechGenerateCasResponse =
            KfintechGenerateCasResponse.builder()
                .msg("CAS request submitted. Check email shortly.")
                .status("success")
                .build()

        val roundtrippedKfintechGenerateCasResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(kfintechGenerateCasResponse),
                jacksonTypeRef<KfintechGenerateCasResponse>(),
            )

        assertThat(roundtrippedKfintechGenerateCasResponse).isEqualTo(kfintechGenerateCasResponse)
    }
}
