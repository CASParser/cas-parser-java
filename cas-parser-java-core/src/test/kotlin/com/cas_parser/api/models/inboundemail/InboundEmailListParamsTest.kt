// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.http.QueryParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailListParamsTest {

    @Test
    fun create() {
        InboundEmailListParams.builder()
            .limit(1L)
            .offset(0L)
            .status(InboundEmailListParams.Status.ACTIVE)
            .build()
    }

    @Test
    fun queryParams() {
        val params =
            InboundEmailListParams.builder()
                .limit(1L)
                .offset(0L)
                .status(InboundEmailListParams.Status.ACTIVE)
                .build()

        val queryParams = params._queryParams()

        assertThat(queryParams)
            .isEqualTo(
                QueryParams.builder()
                    .put("limit", "1")
                    .put("offset", "0")
                    .put("status", "active")
                    .build()
            )
    }

    @Test
    fun queryParamsWithoutOptionalFields() {
        val params = InboundEmailListParams.builder().build()

        val queryParams = params._queryParams()

        assertThat(queryParams).isEqualTo(QueryParams.builder().build())
    }
}
