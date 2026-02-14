// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.async

import com.cas_parser.api.TestServerExtension
import com.cas_parser.api.client.okhttp.CasParserOkHttpClientAsync
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusParams
import com.cas_parser.api.models.inbox.InboxConnectEmailParams
import com.cas_parser.api.models.inbox.InboxDisconnectEmailParams
import com.cas_parser.api.models.inbox.InboxListCasFilesParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InboxServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun checkConnectionStatus() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inbox()

        val responseFuture =
            inboxServiceAsync.checkConnectionStatus(
                InboxCheckConnectionStatusParams.builder().xInboxToken("x-inbox-token").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun connectEmail() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inbox()

        val responseFuture =
            inboxServiceAsync.connectEmail(
                InboxConnectEmailParams.builder()
                    .redirectUri("https://yourapp.com/oauth-callback")
                    .state("abc123")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun disconnectEmail() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inbox()

        val responseFuture =
            inboxServiceAsync.disconnectEmail(
                InboxDisconnectEmailParams.builder().xInboxToken("x-inbox-token").build()
            )

        val response = responseFuture.get()
        response.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun listCasFiles() {
        val client =
            CasParserOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val inboxServiceAsync = client.inbox()

        val responseFuture =
            inboxServiceAsync.listCasFiles(
                InboxListCasFilesParams.builder()
                    .xInboxToken("x-inbox-token")
                    .addCasType(InboxListCasFilesParams.CasType.CDSL)
                    .addCasType(InboxListCasFilesParams.CasType.NSDL)
                    .endDate(LocalDate.parse("2025-12-31"))
                    .startDate(LocalDate.parse("2025-12-01"))
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
