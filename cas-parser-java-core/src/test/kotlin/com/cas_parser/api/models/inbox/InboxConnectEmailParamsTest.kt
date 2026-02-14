// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inbox

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboxConnectEmailParamsTest {

    @Test
    fun create() {
        InboxConnectEmailParams.builder()
            .redirectUri("https://yourapp.com/oauth-callback")
            .state("abc123")
            .build()
    }

    @Test
    fun body() {
        val params =
            InboxConnectEmailParams.builder()
                .redirectUri("https://yourapp.com/oauth-callback")
                .state("abc123")
                .build()

        val body = params._body()

        assertThat(body.redirectUri()).isEqualTo("https://yourapp.com/oauth-callback")
        assertThat(body.state()).contains("abc123")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            InboxConnectEmailParams.builder()
                .redirectUri("https://yourapp.com/oauth-callback")
                .build()

        val body = params._body()

        assertThat(body.redirectUri()).isEqualTo("https://yourapp.com/oauth-callback")
    }
}
