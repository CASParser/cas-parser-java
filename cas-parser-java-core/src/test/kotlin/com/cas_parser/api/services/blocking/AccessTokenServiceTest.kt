// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.accesstoken.AccessTokenCreateParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class AccessTokenServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            CasParserOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val accessTokenService = client.accessToken()

        val accessToken =
            accessTokenService.create(AccessTokenCreateParams.builder().expiryMinutes(60L).build())

        accessToken.validate()
    }
}
