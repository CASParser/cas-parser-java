// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services

import com.cas_parser.api.client.CasParserClient
import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.models.credits.CreditCheckParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.equalTo
import com.github.tomakehurst.wiremock.client.WireMock.matchingJsonPath
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.client.WireMock.verify
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ServiceParamsTest {

    private lateinit var client: CasParserClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            CasParserOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun check() {
        val creditService = client.credits()
        stubFor(post(anyUrl()).willReturn(ok("{}")))

        creditService.check(
            CreditCheckParams.builder()
                .putAdditionalHeader("Secret-Header", "42")
                .putAdditionalQueryParam("secret_query_param", "42")
                .putAdditionalBodyProperty("secretProperty", JsonValue.from("42"))
                .build()
        )

        verify(
            postRequestedFor(anyUrl())
                .withHeader("Secret-Header", equalTo("42"))
                .withQueryParam("secret_query_param", equalTo("42"))
                .withRequestBody(matchingJsonPath("$.secretProperty", equalTo("42")))
        )
    }
}
