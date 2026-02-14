// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.smart

import com.cas_parser.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SmartParseCasPdfParamsTest {

    @Test
    fun create() {
        SmartParseCasPdfParams.builder()
            .password("password")
            .pdfFile("pdf_file")
            .pdfUrl("https://example.com")
            .build()
    }

    @Test
    fun body() {
        val params =
            SmartParseCasPdfParams.builder()
                .password("password")
                .pdfFile("pdf_file")
                .pdfUrl("https://example.com")
                .build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() })
            .usingRecursiveComparison()
            // TODO(AssertJ): Replace this and the `mapValues` below with:
            // https://github.com/assertj/assertj/issues/3165
            .withEqualsForType(
                { a, b -> a.readBytes() contentEquals b.readBytes() },
                InputStream::class.java,
            )
            .isEqualTo(
                mapOf(
                        "password" to MultipartField.of("password"),
                        "pdf_file" to MultipartField.of("pdf_file"),
                        "pdf_url" to MultipartField.of("https://example.com"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = SmartParseCasPdfParams.builder().build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
