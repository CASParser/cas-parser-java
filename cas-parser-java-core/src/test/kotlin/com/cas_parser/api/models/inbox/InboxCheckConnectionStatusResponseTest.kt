// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxCheckConnectionStatusResponseTest {

    @Test
    fun create() {
        val inboxCheckConnectionStatusResponse =
            InboxCheckConnectionStatusResponse.builder()
                .connected(true)
                .email("user@gmail.com")
                .provider("gmail")
                .status("success")
                .build()

        assertThat(inboxCheckConnectionStatusResponse.connected()).contains(true)
        assertThat(inboxCheckConnectionStatusResponse.email()).contains("user@gmail.com")
        assertThat(inboxCheckConnectionStatusResponse.provider()).contains("gmail")
        assertThat(inboxCheckConnectionStatusResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboxCheckConnectionStatusResponse =
            InboxCheckConnectionStatusResponse.builder()
                .connected(true)
                .email("user@gmail.com")
                .provider("gmail")
                .status("success")
                .build()

        val roundtrippedInboxCheckConnectionStatusResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboxCheckConnectionStatusResponse),
                jacksonTypeRef<InboxCheckConnectionStatusResponse>(),
            )

        assertThat(roundtrippedInboxCheckConnectionStatusResponse)
            .isEqualTo(inboxCheckConnectionStatusResponse)
    }
}
