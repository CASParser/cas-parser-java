// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxConnectEmailResponseTest {

    @Test
    fun create() {
        val inboxConnectEmailResponse =
            InboxConnectEmailResponse.builder()
                .expiresIn(600L)
                .oauthUrl("https://accounts.google.com/o/oauth2/v2/auth?client_id=...")
                .status("success")
                .build()

        assertThat(inboxConnectEmailResponse.expiresIn()).contains(600L)
        assertThat(inboxConnectEmailResponse.oauthUrl())
            .contains("https://accounts.google.com/o/oauth2/v2/auth?client_id=...")
        assertThat(inboxConnectEmailResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxConnectEmailResponse =
            InboxConnectEmailResponse.builder()
                .expiresIn(600L)
                .oauthUrl("https://accounts.google.com/o/oauth2/v2/auth?client_id=...")
                .status("success")
                .build()

        val roundtrippedInboxConnectEmailResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxConnectEmailResponse),
                jacksonTypeRef<InboxConnectEmailResponse>(),
            )

        assertThat(roundtrippedInboxConnectEmailResponse).isEqualTo(inboxConnectEmailResponse)
    }
}
