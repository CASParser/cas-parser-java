// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.inboundemail

import com.cas_parser.api.core.JsonValue
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InboundEmailCreateParamsTest {

    @Test
    fun create() {
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
    }

    @Test
    fun body() {
        val params =
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

        val body = params._body()

        assertThat(body.callbackUrl()).isEqualTo("https://api.yourapp.com/webhooks/cas-email")
        assertThat(body.alias()).contains("john-portfolio")
        assertThat(body.allowedSources().getOrNull())
            .containsExactly(
                InboundEmailCreateParams.AllowedSource.CDSL,
                InboundEmailCreateParams.AllowedSource.NSDL,
            )
        assertThat(body.metadata())
            .contains(
                InboundEmailCreateParams.Metadata.builder()
                    .putAdditionalProperty("plan", JsonValue.from("premium"))
                    .putAdditionalProperty("source", JsonValue.from("onboarding"))
                    .build()
            )
        assertThat(body.reference()).contains("user_12345")
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            InboundEmailCreateParams.builder()
                .callbackUrl("https://api.yourapp.com/webhooks/cas-email")
                .build()

        val body = params._body()

        assertThat(body.callbackUrl()).isEqualTo("https://api.yourapp.com/webhooks/cas-email")
    }
}
