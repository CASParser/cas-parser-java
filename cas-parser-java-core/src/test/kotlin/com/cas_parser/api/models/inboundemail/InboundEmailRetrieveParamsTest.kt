// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailRetrieveParamsTest {

    @Test
    fun create() {
        InboundEmailRetrieveParams.builder().inboundEmailId("ie_a1b2c3d4e5f6").build()
    }

    @Test
    fun pathParams() {
        val params = InboundEmailRetrieveParams.builder().inboundEmailId("ie_a1b2c3d4e5f6").build()

        assertThat(params._pathParam(0)).isEqualTo("ie_a1b2c3d4e5f6")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
