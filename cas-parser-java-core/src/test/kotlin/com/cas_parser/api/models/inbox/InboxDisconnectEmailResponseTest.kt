// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxDisconnectEmailResponseTest {

    @Test
    fun create() {
        val inboxDisconnectEmailResponse =
            InboxDisconnectEmailResponse.builder()
                .msg("Email disconnected successfully")
                .status("success")
                .build()

        assertThat(inboxDisconnectEmailResponse.msg()).contains("Email disconnected successfully")
        assertThat(inboxDisconnectEmailResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxDisconnectEmailResponse =
            InboxDisconnectEmailResponse.builder()
                .msg("Email disconnected successfully")
                .status("success")
                .build()

        val roundtrippedInboxDisconnectEmailResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxDisconnectEmailResponse),
                jacksonTypeRef<InboxDisconnectEmailResponse>(),
            )

        assertThat(roundtrippedInboxDisconnectEmailResponse).isEqualTo(inboxDisconnectEmailResponse)
    }
}
