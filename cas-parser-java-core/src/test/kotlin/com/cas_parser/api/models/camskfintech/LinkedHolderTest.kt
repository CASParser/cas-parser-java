// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.camskfintech

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LinkedHolderTest {

    @Test
    fun create() {
        val linkedHolder = LinkedHolder.builder().name("name").pan("pan").build()

        assertThat(linkedHolder.name()).contains("name")
        assertThat(linkedHolder.pan()).contains("pan")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val linkedHolder = LinkedHolder.builder().name("name").pan("pan").build()

        val roundtrippedLinkedHolder =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(linkedHolder),
                jacksonTypeRef<LinkedHolder>(),
            )

        assertThat(roundtrippedLinkedHolder).isEqualTo(linkedHolder)
    }
}
