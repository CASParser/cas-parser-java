// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.proguard

import com.cas_parser.api.client.okhttp.CasParserOkHttpClient
import com.cas_parser.api.core.jsonMapper
import com.cas_parser.api.models.camskfintech.LinkedHolder
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream("META-INF/proguard/cas-parser-java-core.pro")

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = CasParserOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.credits()).isNotNull()
        assertThat(client.logs()).isNotNull()
        assertThat(client.accessToken()).isNotNull()
        assertThat(client.verifyToken()).isNotNull()
        assertThat(client.camsKfintech()).isNotNull()
        assertThat(client.cdsl()).isNotNull()
        assertThat(client.contractNote()).isNotNull()
        assertThat(client.inbox()).isNotNull()
        assertThat(client.kfintech()).isNotNull()
        assertThat(client.nsdl()).isNotNull()
        assertThat(client.smart()).isNotNull()
    }

    @Test
    fun linkedHolderRoundtrip() {
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
