// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailDeleteResponseTest {

    @Test
    fun create() {
        val inboundEmailDeleteResponse =
            InboundEmailDeleteResponse.builder()
                .msg("Mailbox deleted successfully")
                .status("success")
                .build()

        assertThat(inboundEmailDeleteResponse.msg()).contains("Mailbox deleted successfully")
        assertThat(inboundEmailDeleteResponse.status()).contains("success")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inboundEmailDeleteResponse =
            InboundEmailDeleteResponse.builder()
                .msg("Mailbox deleted successfully")
                .status("success")
                .build()

        val roundtrippedInboundEmailDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inboundEmailDeleteResponse),
                jacksonTypeRef<InboundEmailDeleteResponse>(),
            )

        assertThat(roundtrippedInboundEmailDeleteResponse).isEqualTo(inboundEmailDeleteResponse)
    }
}
