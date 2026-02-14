// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.cdsl.fetch

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FetchRequestOtpParamsTest {

    @Test
    fun create() {
        FetchRequestOtpParams.builder()
            .boId("1234567890123456")
            .dob("1990-01-15")
            .pan("ABCDE1234F")
            .build()
    }

    @Test
    fun body() {
        val params =
            FetchRequestOtpParams.builder()
                .boId("1234567890123456")
                .dob("1990-01-15")
                .pan("ABCDE1234F")
                .build()

        val body = params._body()

        assertThat(body.boId()).isEqualTo("1234567890123456")
        assertThat(body.dob()).isEqualTo("1990-01-15")
        assertThat(body.pan()).isEqualTo("ABCDE1234F")
    }
}
