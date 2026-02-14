// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.camskfintech

import com.cas_parser.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.LocalDate
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TransactionTest {

    @Test
    fun create() {
        val transaction =
            Transaction.builder()
                .additionalInfo(
                    Transaction.AdditionalInfo.builder()
                        .capitalWithdrawal(0.0f)
                        .credit(0.0f)
                        .debit(0.0f)
                        .incomeDistribution(0.0f)
                        .orderNo("order_no")
                        .price(0.0f)
                        .stampDuty(0.0f)
                        .build()
                )
                .amount(0.0f)
                .balance(0.0f)
                .date(LocalDate.parse("2019-12-27"))
                .description("description")
                .dividendRate(0.0f)
                .nav(0.0f)
                .type(Transaction.Type.PURCHASE)
                .units(0.0f)
                .build()

        assertThat(transaction.additionalInfo())
            .contains(
                Transaction.AdditionalInfo.builder()
                    .capitalWithdrawal(0.0f)
                    .credit(0.0f)
                    .debit(0.0f)
                    .incomeDistribution(0.0f)
                    .orderNo("order_no")
                    .price(0.0f)
                    .stampDuty(0.0f)
                    .build()
            )
        assertThat(transaction.amount()).contains(0.0f)
        assertThat(transaction.balance()).contains(0.0f)
        assertThat(transaction.date()).contains(LocalDate.parse("2019-12-27"))
        assertThat(transaction.description()).contains("description")
        assertThat(transaction.dividendRate()).contains(0.0f)
        assertThat(transaction.nav()).contains(0.0f)
        assertThat(transaction.type()).contains(Transaction.Type.PURCHASE)
        assertThat(transaction.units()).contains(0.0f)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val transaction =
            Transaction.builder()
                .additionalInfo(
                    Transaction.AdditionalInfo.builder()
                        .capitalWithdrawal(0.0f)
                        .credit(0.0f)
                        .debit(0.0f)
                        .incomeDistribution(0.0f)
                        .orderNo("order_no")
                        .price(0.0f)
                        .stampDuty(0.0f)
                        .build()
                )
                .amount(0.0f)
                .balance(0.0f)
                .date(LocalDate.parse("2019-12-27"))
                .description("description")
                .dividendRate(0.0f)
                .nav(0.0f)
                .type(Transaction.Type.PURCHASE)
                .units(0.0f)
                .build()

        val roundtrippedTransaction =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(transaction),
                jacksonTypeRef<Transaction>(),
            )

        assertThat(roundtrippedTransaction).isEqualTo(transaction)
    }
}
