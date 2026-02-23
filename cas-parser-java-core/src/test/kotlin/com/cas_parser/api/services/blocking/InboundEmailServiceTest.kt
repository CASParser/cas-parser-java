// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.models.inboundemail.InboundEmailCreateParams
import com.cas_parser.api.models.inboundemail.InboundEmailListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InboundEmailServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboundEmailService = client.inboundEmail()

        val inboundEmail =
            inboundEmailService.create(
                InboundEmailCreateParams.builder()
                    .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                    .alias("john-portfolio")
                    .addAllowedSource(InboundEmailCreateParams.AllowedSource.CDSL)
                    .addAllowedSource(InboundEmailCreateParams.AllowedSource.NSDL)
                    .metadata(
                        InboundEmailCreateParams.Metadata.builder()
                            .putAdditionalProperty("plan", JsonValue.from("premium"))
                            .putAdditionalProperty("source", JsonValue.from("onboarding"))
                            .build()
                    )
                    .reference("user_12345")
                    .build()
            )

        inboundEmail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboundEmailService = client.inboundEmail()

        val inboundEmail = inboundEmailService.retrieve("ie_a1b2c3d4e5f6")

        inboundEmail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboundEmailService = client.inboundEmail()

        val inboundEmails =
            inboundEmailService.list(
                InboundEmailListParams.builder()
                    .limit(1L)
                    .offset(0L)
                    .status(InboundEmailListParams.Status.ACTIVE)
                    .build()
            )

        inboundEmails.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboundEmailService = client.inboundEmail()

        val inboundEmail = inboundEmailService.delete("inbound_email_id")

        inboundEmail.validate()
    }
}
