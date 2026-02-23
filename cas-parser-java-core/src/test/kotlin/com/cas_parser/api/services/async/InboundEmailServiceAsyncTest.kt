// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.models.inboundemail.InboundEmailCreateParams
import com.cas_parser.api.models.inboundemail.InboundEmailListParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InboundEmailServiceAsyncTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun create() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val inboundEmailServiceAsync = client.inboundEmail()

        val inboundEmailFuture =
            inboundEmailServiceAsync.create(
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

        val inboundEmail = inboundEmailFuture.get()
        inboundEmail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun retrieve() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val inboundEmailServiceAsync = client.inboundEmail()

        val inboundEmailFuture = inboundEmailServiceAsync.retrieve("ie_a1b2c3d4e5f6")

        val inboundEmail = inboundEmailFuture.get()
        inboundEmail.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun list() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val inboundEmailServiceAsync = client.inboundEmail()

        val inboundEmailsFuture =
            inboundEmailServiceAsync.list(
                InboundEmailListParams.builder()
                    .limit(1L)
                    .offset(0L)
                    .status(InboundEmailListParams.Status.ACTIVE)
                    .build()
            )

        val inboundEmails = inboundEmailsFuture.get()
        inboundEmails.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun delete() {
        val client = CasParserOkHttpClientAsync.builder().apiKey("My API Key").build()
        val inboundEmailServiceAsync = client.inboundEmail()

        val inboundEmailFuture = inboundEmailServiceAsync.delete("inbound_email_id")

        val inboundEmail = inboundEmailFuture.get()
        inboundEmail.validate()
    }
}
