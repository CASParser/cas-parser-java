// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.services

import com.cas_parser.api.client.CasParserClient
import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.http.Headers
import com.cas_parser.api.core.jsonMapper
import com.cas_parser.api.errors.BadRequestException
import com.cas_parser.api.errors.CasParserException
import com.cas_parser.api.errors.InternalServerException
import com.cas_parser.api.errors.NotFoundException
import com.cas_parser.api.errors.PermissionDeniedException
import com.cas_parser.api.errors.RateLimitException
import com.cas_parser.api.errors.UnauthorizedException
import com.cas_parser.api.errors.UnexpectedStatusCodeException
import com.cas_parser.api.errors.UnprocessableEntityException
import com.cas_parser.api.models.casparser.CasParserSmartParseParams
import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.status
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.entry
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock

@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ErrorHandlingTest {

    companion object {

        private val ERROR_JSON: JsonValue = JsonValue.from(mapOf("errorProperty" to "42"))

        private val ERROR_JSON_BYTES: ByteArray = jsonMapper().writeValueAsBytes(ERROR_JSON)

        private const val HEADER_NAME: String = "Error-Header"

        private const val HEADER_VALUE: String = "42"

        private const val NOT_JSON: String = "Not JSON"
    }

    private lateinit var client: CasParserClient

    @BeforeEach
    fun beforeEach(wmRuntimeInfo: WireMockRuntimeInfo) {
        client =
            CasParserOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
    }

    @Test
    fun casParserSmartParse400() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse400WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(400).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<BadRequestException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(400)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse401() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse401WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(401).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnauthorizedException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(401)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse403() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse403WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(403).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<PermissionDeniedException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(403)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse404() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse404WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(404).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<NotFoundException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(404)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse422() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse422WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(422).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnprocessableEntityException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(422)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse429() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse429WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(429).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<RateLimitException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(429)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse500() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse500WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(500).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<InternalServerException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(500)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse999() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParse999WithRawResponse() {
        val casParserService = client.casParser().withRawResponse()
        stubFor(
            post(anyUrl())
                .willReturn(
                    status(999).withHeader(HEADER_NAME, HEADER_VALUE).withBody(ERROR_JSON_BYTES)
                )
        )

        val e =
            assertThrows<UnexpectedStatusCodeException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e.statusCode()).isEqualTo(999)
        assertThat(e.headers().toMap()).contains(entry(HEADER_NAME, listOf(HEADER_VALUE)))
        assertThat(e.body()).isEqualTo(ERROR_JSON)
    }

    @Test
    fun casParserSmartParseInvalidJsonBody() {
        val casParserService = client.casParser()
        stubFor(
            post(anyUrl())
                .willReturn(status(200).withHeader(HEADER_NAME, HEADER_VALUE).withBody(NOT_JSON))
        )

        val e =
            assertThrows<CasParserException> {
                casParserService.smartParse(
                    CasParserSmartParseParams.builder()
                        .password("password")
                        .pdfFile("pdf_file")
                        .pdfUrl("https://example.com")
                        .build()
                )
            }

        assertThat(e).hasMessage("Error reading response")
    }

    private fun Headers.toMap(): Map<String, List<String>> =
        mutableMapOf<String, List<String>>().also { map ->
            names().forEach { map[it] = values(it) }
        }
}
