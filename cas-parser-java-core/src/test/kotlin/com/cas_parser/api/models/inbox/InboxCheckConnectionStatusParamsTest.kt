// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import com.cas_parser.api.core.http.Headers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxCheckConnectionStatusParamsTest {

    @Test
    fun create() {
        InboxCheckConnectionStatusParams.builder().xInboxToken("x-inbox-token").build()
    }

    @Test
    fun headers() {
        val params = InboxCheckConnectionStatusParams.builder().xInboxToken("x-inbox-token").build()

        val headers = params._headers()

        assertThat(headers)
            .isEqualTo(Headers.builder().put("x-inbox-token", "x-inbox-token").build())
    }
}
