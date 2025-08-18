// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casgenerator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CasGeneratorGenerateCasParamsTest {

    @Test
    fun create() {
        CasGeneratorGenerateCasParams.builder()
            .email("user@example.com")
            .fromDate("2023-01-01")
            .password("Abcdefghi12\$")
            .toDate("2023-12-31")
            .casAuthority(CasGeneratorGenerateCasParams.CasAuthority.KFINTECH)
            .panNo("ABCDE1234F")
            .build()
    }

    @Test
    fun body() {
        val params =
            CasGeneratorGenerateCasParams.builder()
                .email("user@example.com")
                .fromDate("2023-01-01")
                .password("Abcdefghi12\$")
                .toDate("2023-12-31")
                .casAuthority(CasGeneratorGenerateCasParams.CasAuthority.KFINTECH)
                .panNo("ABCDE1234F")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("user@example.com")
        assertThat(body.fromDate()).isEqualTo("2023-01-01")
        assertThat(body.password()).isEqualTo("Abcdefghi12\$")
        assertThat(body.toDate()).isEqualTo("2023-12-31")
        assertThat(body.casAuthority())
            .contains(CasGeneratorGenerateCasParams.CasAuthority.KFINTECH)
        assertThat(body.panNo()).contains("ABCDE1234F")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            CasGeneratorGenerateCasParams.builder()
                .email("user@example.com")
                .fromDate("2023-01-01")
                .password("Abcdefghi12\$")
                .toDate("2023-12-31")
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("user@example.com")
        assertThat(body.fromDate()).isEqualTo("2023-01-01")
        assertThat(body.password()).isEqualTo("Abcdefghi12\$")
        assertThat(body.toDate()).isEqualTo("2023-12-31")
    }
}
