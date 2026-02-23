// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services.blocking

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.models.inbox.InboxCheckConnectionStatusParams
import com.cas_parser.api.models.inbox.InboxConnectEmailParams
import com.cas_parser.api.models.inbox.InboxDisconnectEmailParams
import com.cas_parser.api.models.inbox.InboxListCasFilesParams
import java.time.LocalDate
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class InboxServiceTest {

    @Disabled("Mock server tests are disabled")
    @Test
    fun checkConnectionStatus() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboxService = client.inbox()

        val response =
            inboxService.checkConnectionStatus(
                InboxCheckConnectionStatusParams.builder().xInboxToken("x-inbox-token").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun connectEmail() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboxService = client.inbox()

        val response =
            inboxService.connectEmail(
                InboxConnectEmailParams.builder()
                    .redirectUri("https://yourapp.com/oauth-callback")
                    .state("abc123")
                    .build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun disconnectEmail() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboxService = client.inbox()

        val response =
            inboxService.disconnectEmail(
                InboxDisconnectEmailParams.builder().xInboxToken("x-inbox-token").build()
            )

        response.validate()
    }

    @Disabled("Mock server tests are disabled")
    @Test
    fun listCasFiles() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()
        val inboxService = client.inbox()

        val response =
            inboxService.listCasFiles(
                InboxListCasFilesParams.builder()
                    .xInboxToken("x-inbox-token")
                    .addCasType(InboxListCasFilesParams.CasType.CDSL)
                    .addCasType(InboxListCasFilesParams.CasType.NSDL)
                    .endDate(LocalDate.parse("2025-12-31"))
                    .startDate(LocalDate.parse("2025-12-01"))
                    .build()
            )

        response.validate()
    }
}
