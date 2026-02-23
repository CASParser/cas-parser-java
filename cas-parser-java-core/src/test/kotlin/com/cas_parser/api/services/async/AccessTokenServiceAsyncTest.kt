// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.accesstoken.AccessTokenCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class AccessTokenServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val accessTokenServiceAsync = client.accessToken()

        val accessTokenFuture =
            accessTokenServiceAsync.create(
                AccessTokenCreateParams.builder().expiryMinutes(60L).build()
            )

        val accessToken = accessTokenFuture.get()
        accessToken.validate()
    }
}
