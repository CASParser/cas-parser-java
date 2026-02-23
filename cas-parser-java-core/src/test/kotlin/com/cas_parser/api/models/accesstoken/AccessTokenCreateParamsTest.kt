// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.accesstoken

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccessTokenCreateParamsTest {

    @Test
    fun create() {
        AccessTokenCreateParams.builder().expiryMinutes(60L).build()
    }

    @Test
    fun body() {
        val params = AccessTokenCreateParams.builder().expiryMinutes(60L).build()

        val body = params._body()

        assertThat(body.expiryMinutes()).contains(60L)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = AccessTokenCreateParams.builder().build()

        val body = params._body()
    }
}
