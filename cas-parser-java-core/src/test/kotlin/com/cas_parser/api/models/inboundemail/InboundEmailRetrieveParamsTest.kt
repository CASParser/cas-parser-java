// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailRetrieveParamsTest {

    @Test
    fun create() {
        InboundEmailRetrieveParams.builder().inboundEmailId("inbound_email_id").build()
    }

    @Test
    fun pathParams() {
        val params = InboundEmailRetrieveParams.builder().inboundEmailId("inbound_email_id").build()

        assertThat(params._pathParam(0)).isEqualTo("inbound_email_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
