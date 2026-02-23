// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.accesstoken

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class AccessTokenCreateResponseTest {

    @Test
    fun create() {
        val accessTokenCreateResponse =
            AccessTokenCreateResponse.builder()
                .accessToken("at_eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
                .expiresIn(3600L)
                .tokenType("api_key")
                .build()

        assertThat(accessTokenCreateResponse.accessToken())
            .contains("at_eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
        assertThat(accessTokenCreateResponse.expiresIn()).contains(3600L)
        assertThat(accessTokenCreateResponse.tokenType()).contains("api_key")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val accessTokenCreateResponse =
            AccessTokenCreateResponse.builder()
                .accessToken("at_eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
                .expiresIn(3600L)
                .tokenType("api_key")
                .build()

        val roundtrippedAccessTokenCreateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(accessTokenCreateResponse),
                jacksonTypeRef<AccessTokenCreateResponse>(),
            )

        assertThat(roundtrippedAccessTokenCreateResponse).isEqualTo(accessTokenCreateResponse)
    }
}
