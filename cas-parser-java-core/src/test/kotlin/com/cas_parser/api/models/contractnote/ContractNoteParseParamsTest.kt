// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.contractnote

import com.cas_parser.api.core.MultipartField
import java.io.InputStream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContractNoteParseParamsTest {

    @Test
    fun create() {
        ContractNoteParseParams.builder()
            .brokerType(ContractNoteParseParams.BrokerType.ZERODHA)
            .password("FAXAK2545F")
            .pdfFile("JVBERi0xLjQKMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwo...")
            .pdfUrl("https://example.com/contract_note.pdf")
            .build()
    }

    @Test
    fun body() {
        val params =
            ContractNoteParseParams.builder()
                .brokerType(ContractNoteParseParams.BrokerType.ZERODHA)
                .password("FAXAK2545F")
                .pdfFile("JVBERi0xLjQKMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwo...")
                .pdfUrl("https://example.com/contract_note.pdf")
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
                        "broker_type" to
                            MultipartField.of(ContractNoteParseParams.BrokerType.ZERODHA),
                        "password" to MultipartField.of("FAXAK2545F"),
                        "pdf_file" to
                            MultipartField.of("JVBERi0xLjQKMSAwIG9iago8PAovVHlwZSAvQ2F0YWxvZwo..."),
                        "pdf_url" to MultipartField.of("https://example.com/contract_note.pdf"),
                    )
                    .mapValues { (_, field) ->
                        field.map { (it as? ByteArray)?.inputStream() ?: it }
                    }
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContractNoteParseParams.builder().build()

        val body = params._body()

        assertThat(body.filterValues { !it.value.isNull() }).isEmpty()
    }
}
