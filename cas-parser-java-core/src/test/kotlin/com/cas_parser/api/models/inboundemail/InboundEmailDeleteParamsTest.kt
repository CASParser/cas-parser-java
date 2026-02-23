// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailDeleteParamsTest {

    @Test
    fun create() {
        InboundEmailDeleteParams.builder().inboundEmailId("inbound_email_id").build()
    }

    @Test
    fun pathParams() {
        val params = InboundEmailDeleteParams.builder().inboundEmailId("inbound_email_id").build()

        assertThat(params._pathParam(0)).isEqualTo("inbound_email_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
