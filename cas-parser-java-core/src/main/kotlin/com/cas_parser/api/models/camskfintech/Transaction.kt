// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.camskfintech

import com.cas_parser.api.core.Enum
import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.errors.CasParserInvalidDataException
import com.fasterxml.jackson.annotation.JsonAnyGetter
import com.fasterxml.jackson.annotation.JsonAnySetter
import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDate
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** Unified transaction schema for all holding types (MF folios, equities, bonds, etc.) */
class Transaction
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val additionalInfo: JsonField<AdditionalInfo>,
    private val amount: JsonField<Float>,
    private val balance: JsonField<Float>,
    private val date: JsonField<LocalDate>,
    private val description: JsonField<String>,
    private val dividendRate: JsonField<Float>,
    private val nav: JsonField<Float>,
    private val type: JsonField<Type>,
    private val units: JsonField<Float>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("additional_info")
        @ExcludeMissing
        additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of(),
        @JsonProperty("amount") @ExcludeMissing amount: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("balance") @ExcludeMissing balance: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("date") @ExcludeMissing date: JsonField<LocalDate> = JsonMissing.of(),
        @JsonProperty("description")
        @ExcludeMissing
        description: JsonField<String> = JsonMissing.of(),
        @JsonProperty("dividend_rate")
        @ExcludeMissing
        dividendRate: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("nav") @ExcludeMissing nav: JsonField<Float> = JsonMissing.of(),
        @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
        @JsonProperty("units") @ExcludeMissing units: JsonField<Float> = JsonMissing.of(),
    ) : this(
        additionalInfo,
        amount,
        balance,
        date,
        description,
        dividendRate,
        nav,
        type,
        units,
        mutableMapOf(),
    )

    /**
     * Additional transaction-specific fields that vary by source
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun additionalInfo(): Optional<AdditionalInfo> = additionalInfo.getOptional("additional_info")

    /**
     * Transaction amount in currency (computed from units × price/NAV)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun amount(): Optional<Float> = amount.getOptional("amount")

    /**
     * Balance units after transaction
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun balance(): Optional<Float> = balance.getOptional("balance")

    /**
     * Transaction date (YYYY-MM-DD)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun date(): Optional<LocalDate> = date.getOptional("date")

    /**
     * Transaction description/particulars
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun description(): Optional<String> = description.getOptional("description")

    /**
     * Dividend rate (for DIVIDEND_PAYOUT transactions)
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dividendRate(): Optional<Float> = dividendRate.getOptional("dividend_rate")

    /**
     * NAV/price per unit on transaction date
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun nav(): Optional<Float> = nav.getOptional("nav")

    /**
     * Transaction type. Possible values are PURCHASE, PURCHASE_SIP, REDEMPTION, SWITCH_IN,
     * SWITCH_IN_MERGER, SWITCH_OUT, SWITCH_OUT_MERGER, DIVIDEND_PAYOUT, DIVIDEND_REINVEST,
     * SEGREGATION, STAMP_DUTY_TAX, TDS_TAX, STT_TAX, MISC, REVERSAL, UNKNOWN.
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun type(): Optional<Type> = type.getOptional("type")

    /**
     * Number of units involved in transaction
     *
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun units(): Optional<Float> = units.getOptional("units")

    /**
     * Returns the raw JSON value of [additionalInfo].
     *
     * Unlike [additionalInfo], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("additional_info")
    @ExcludeMissing
    fun _additionalInfo(): JsonField<AdditionalInfo> = additionalInfo

    /**
     * Returns the raw JSON value of [amount].
     *
     * Unlike [amount], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Float> = amount

    /**
     * Returns the raw JSON value of [balance].
     *
     * Unlike [balance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<Float> = balance

    /**
     * Returns the raw JSON value of [date].
     *
     * Unlike [date], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("date") @ExcludeMissing fun _date(): JsonField<LocalDate> = date

    /**
     * Returns the raw JSON value of [description].
     *
     * Unlike [description], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("description") @ExcludeMissing fun _description(): JsonField<String> = description

    /**
     * Returns the raw JSON value of [dividendRate].
     *
     * Unlike [dividendRate], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("dividend_rate")
    @ExcludeMissing
    fun _dividendRate(): JsonField<Float> = dividendRate

    /**
     * Returns the raw JSON value of [nav].
     *
     * Unlike [nav], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("nav") @ExcludeMissing fun _nav(): JsonField<Float> = nav

    /**
     * Returns the raw JSON value of [type].
     *
     * Unlike [type], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<Type> = type

    /**
     * Returns the raw JSON value of [units].
     *
     * Unlike [units], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

    @JsonAnySetter
    private fun putAdditionalProperty(key: String, value: JsonValue) {
        additionalProperties.put(key, value)
    }

    @JsonAnyGetter
    @ExcludeMissing
    fun _additionalProperties(): Map<String, JsonValue> =
        Collections.unmodifiableMap(additionalProperties)

    fun toBuilder() = Builder().from(this)

    companion object {

        /** Returns a mutable builder for constructing an instance of [Transaction]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [Transaction]. */
    class Builder internal constructor() {

        private var additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of()
        private var amount: JsonField<Float> = JsonMissing.of()
        private var balance: JsonField<Float> = JsonMissing.of()
        private var date: JsonField<LocalDate> = JsonMissing.of()
        private var description: JsonField<String> = JsonMissing.of()
        private var dividendRate: JsonField<Float> = JsonMissing.of()
        private var nav: JsonField<Float> = JsonMissing.of()
        private var type: JsonField<Type> = JsonMissing.of()
        private var units: JsonField<Float> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(transaction: Transaction) = apply {
            additionalInfo = transaction.additionalInfo
            amount = transaction.amount
            balance = transaction.balance
            date = transaction.date
            description = transaction.description
            dividendRate = transaction.dividendRate
            nav = transaction.nav
            type = transaction.type
            units = transaction.units
            additionalProperties = transaction.additionalProperties.toMutableMap()
        }

        /** Additional transaction-specific fields that vary by source */
        fun additionalInfo(additionalInfo: AdditionalInfo) =
            additionalInfo(JsonField.of(additionalInfo))

        /**
         * Sets [Builder.additionalInfo] to an arbitrary JSON value.
         *
         * You should usually call [Builder.additionalInfo] with a well-typed [AdditionalInfo] value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun additionalInfo(additionalInfo: JsonField<AdditionalInfo>) = apply {
            this.additionalInfo = additionalInfo
        }

        /** Transaction amount in currency (computed from units × price/NAV) */
        fun amount(amount: Float?) = amount(JsonField.ofNullable(amount))

        /**
         * Alias for [Builder.amount].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun amount(amount: Float) = amount(amount as Float?)

        /** Alias for calling [Builder.amount] with `amount.orElse(null)`. */
        fun amount(amount: Optional<Float>) = amount(amount.getOrNull())

        /**
         * Sets [Builder.amount] to an arbitrary JSON value.
         *
         * You should usually call [Builder.amount] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun amount(amount: JsonField<Float>) = apply { this.amount = amount }

        /** Balance units after transaction */
        fun balance(balance: Float) = balance(JsonField.of(balance))

        /**
         * Sets [Builder.balance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.balance] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun balance(balance: JsonField<Float>) = apply { this.balance = balance }

        /** Transaction date (YYYY-MM-DD) */
        fun date(date: LocalDate) = date(JsonField.of(date))

        /**
         * Sets [Builder.date] to an arbitrary JSON value.
         *
         * You should usually call [Builder.date] with a well-typed [LocalDate] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun date(date: JsonField<LocalDate>) = apply { this.date = date }

        /** Transaction description/particulars */
        fun description(description: String) = description(JsonField.of(description))

        /**
         * Sets [Builder.description] to an arbitrary JSON value.
         *
         * You should usually call [Builder.description] with a well-typed [String] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun description(description: JsonField<String>) = apply { this.description = description }

        /** Dividend rate (for DIVIDEND_PAYOUT transactions) */
        fun dividendRate(dividendRate: Float?) = dividendRate(JsonField.ofNullable(dividendRate))

        /**
         * Alias for [Builder.dividendRate].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun dividendRate(dividendRate: Float) = dividendRate(dividendRate as Float?)

        /** Alias for calling [Builder.dividendRate] with `dividendRate.orElse(null)`. */
        fun dividendRate(dividendRate: Optional<Float>) = dividendRate(dividendRate.getOrNull())

        /**
         * Sets [Builder.dividendRate] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dividendRate] with a well-typed [Float] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun dividendRate(dividendRate: JsonField<Float>) = apply {
            this.dividendRate = dividendRate
        }

        /** NAV/price per unit on transaction date */
        fun nav(nav: Float?) = nav(JsonField.ofNullable(nav))

        /**
         * Alias for [Builder.nav].
         *
         * This unboxed primitive overload exists for backwards compatibility.
         */
        fun nav(nav: Float) = nav(nav as Float?)

        /** Alias for calling [Builder.nav] with `nav.orElse(null)`. */
        fun nav(nav: Optional<Float>) = nav(nav.getOrNull())

        /**
         * Sets [Builder.nav] to an arbitrary JSON value.
         *
         * You should usually call [Builder.nav] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun nav(nav: JsonField<Float>) = apply { this.nav = nav }

        /**
         * Transaction type. Possible values are PURCHASE, PURCHASE_SIP, REDEMPTION, SWITCH_IN,
         * SWITCH_IN_MERGER, SWITCH_OUT, SWITCH_OUT_MERGER, DIVIDEND_PAYOUT, DIVIDEND_REINVEST,
         * SEGREGATION, STAMP_DUTY_TAX, TDS_TAX, STT_TAX, MISC, REVERSAL, UNKNOWN.
         */
        fun type(type: Type) = type(JsonField.of(type))

        /**
         * Sets [Builder.type] to an arbitrary JSON value.
         *
         * You should usually call [Builder.type] with a well-typed [Type] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun type(type: JsonField<Type>) = apply { this.type = type }

        /** Number of units involved in transaction */
        fun units(units: Float) = units(JsonField.of(units))

        /**
         * Sets [Builder.units] to an arbitrary JSON value.
         *
         * You should usually call [Builder.units] with a well-typed [Float] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun units(units: JsonField<Float>) = apply { this.units = units }

        fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.clear()
            putAllAdditionalProperties(additionalProperties)
        }

        fun putAdditionalProperty(key: String, value: JsonValue) = apply {
            additionalProperties.put(key, value)
        }

        fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
            this.additionalProperties.putAll(additionalProperties)
        }

        fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

        fun removeAllAdditionalProperties(keys: Set<String>) = apply {
            keys.forEach(::removeAdditionalProperty)
        }

        /**
         * Returns an immutable instance of [Transaction].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): Transaction =
            Transaction(
                additionalInfo,
                amount,
                balance,
                date,
                description,
                dividendRate,
                nav,
                type,
                units,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): Transaction = apply {
        if (validated) {
            return@apply
        }

        additionalInfo().ifPresent { it.validate() }
        amount()
        balance()
        date()
        description()
        dividendRate()
        nav()
        type().ifPresent { it.validate() }
        units()
        validated = true
    }

    fun isValid(): Boolean =
        try {
            validate()
            true
        } catch (e: CasParserInvalidDataException) {
            false
        }

    /**
     * Returns a score indicating how many valid values are contained in this object recursively.
     *
     * Used for best match union deserialization.
     */
    @JvmSynthetic
    internal fun validity(): Int =
        (additionalInfo.asKnown().getOrNull()?.validity() ?: 0) +
            (if (amount.asKnown().isPresent) 1 else 0) +
            (if (balance.asKnown().isPresent) 1 else 0) +
            (if (date.asKnown().isPresent) 1 else 0) +
            (if (description.asKnown().isPresent) 1 else 0) +
            (if (dividendRate.asKnown().isPresent) 1 else 0) +
            (if (nav.asKnown().isPresent) 1 else 0) +
            (type.asKnown().getOrNull()?.validity() ?: 0) +
            (if (units.asKnown().isPresent) 1 else 0)

    /** Additional transaction-specific fields that vary by source */
    class AdditionalInfo
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val capitalWithdrawal: JsonField<Float>,
        private val credit: JsonField<Float>,
        private val debit: JsonField<Float>,
        private val incomeDistribution: JsonField<Float>,
        private val orderNo: JsonField<String>,
        private val price: JsonField<Float>,
        private val stampDuty: JsonField<Float>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("capital_withdrawal")
            @ExcludeMissing
            capitalWithdrawal: JsonField<Float> = JsonMissing.of(),
            @JsonProperty("credit") @ExcludeMissing credit: JsonField<Float> = JsonMissing.of(),
            @JsonProperty("debit") @ExcludeMissing debit: JsonField<Float> = JsonMissing.of(),
            @JsonProperty("income_distribution")
            @ExcludeMissing
            incomeDistribution: JsonField<Float> = JsonMissing.of(),
            @JsonProperty("order_no") @ExcludeMissing orderNo: JsonField<String> = JsonMissing.of(),
            @JsonProperty("price") @ExcludeMissing price: JsonField<Float> = JsonMissing.of(),
            @JsonProperty("stamp_duty")
            @ExcludeMissing
            stampDuty: JsonField<Float> = JsonMissing.of(),
        ) : this(
            capitalWithdrawal,
            credit,
            debit,
            incomeDistribution,
            orderNo,
            price,
            stampDuty,
            mutableMapOf(),
        )

        /**
         * Capital withdrawal amount (CDSL MF transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun capitalWithdrawal(): Optional<Float> =
            capitalWithdrawal.getOptional("capital_withdrawal")

        /**
         * Units credited (demat transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun credit(): Optional<Float> = credit.getOptional("credit")

        /**
         * Units debited (demat transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun debit(): Optional<Float> = debit.getOptional("debit")

        /**
         * Income distribution amount (CDSL MF transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun incomeDistribution(): Optional<Float> =
            incomeDistribution.getOptional("income_distribution")

        /**
         * Order/transaction reference number (demat transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun orderNo(): Optional<String> = orderNo.getOptional("order_no")

        /**
         * Price per unit (NSDL/CDSL MF transactions)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun price(): Optional<Float> = price.getOptional("price")

        /**
         * Stamp duty charged
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun stampDuty(): Optional<Float> = stampDuty.getOptional("stamp_duty")

        /**
         * Returns the raw JSON value of [capitalWithdrawal].
         *
         * Unlike [capitalWithdrawal], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("capital_withdrawal")
        @ExcludeMissing
        fun _capitalWithdrawal(): JsonField<Float> = capitalWithdrawal

        /**
         * Returns the raw JSON value of [credit].
         *
         * Unlike [credit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("credit") @ExcludeMissing fun _credit(): JsonField<Float> = credit

        /**
         * Returns the raw JSON value of [debit].
         *
         * Unlike [debit], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("debit") @ExcludeMissing fun _debit(): JsonField<Float> = debit

        /**
         * Returns the raw JSON value of [incomeDistribution].
         *
         * Unlike [incomeDistribution], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("income_distribution")
        @ExcludeMissing
        fun _incomeDistribution(): JsonField<Float> = incomeDistribution

        /**
         * Returns the raw JSON value of [orderNo].
         *
         * Unlike [orderNo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("order_no") @ExcludeMissing fun _orderNo(): JsonField<String> = orderNo

        /**
         * Returns the raw JSON value of [price].
         *
         * Unlike [price], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("price") @ExcludeMissing fun _price(): JsonField<Float> = price

        /**
         * Returns the raw JSON value of [stampDuty].
         *
         * Unlike [stampDuty], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("stamp_duty") @ExcludeMissing fun _stampDuty(): JsonField<Float> = stampDuty

        @JsonAnySetter
        private fun putAdditionalProperty(key: String, value: JsonValue) {
            additionalProperties.put(key, value)
        }

        @JsonAnyGetter
        @ExcludeMissing
        fun _additionalProperties(): Map<String, JsonValue> =
            Collections.unmodifiableMap(additionalProperties)

        fun toBuilder() = Builder().from(this)

        companion object {

            /** Returns a mutable builder for constructing an instance of [AdditionalInfo]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [AdditionalInfo]. */
        class Builder internal constructor() {

            private var capitalWithdrawal: JsonField<Float> = JsonMissing.of()
            private var credit: JsonField<Float> = JsonMissing.of()
            private var debit: JsonField<Float> = JsonMissing.of()
            private var incomeDistribution: JsonField<Float> = JsonMissing.of()
            private var orderNo: JsonField<String> = JsonMissing.of()
            private var price: JsonField<Float> = JsonMissing.of()
            private var stampDuty: JsonField<Float> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(additionalInfo: AdditionalInfo) = apply {
                capitalWithdrawal = additionalInfo.capitalWithdrawal
                credit = additionalInfo.credit
                debit = additionalInfo.debit
                incomeDistribution = additionalInfo.incomeDistribution
                orderNo = additionalInfo.orderNo
                price = additionalInfo.price
                stampDuty = additionalInfo.stampDuty
                additionalProperties = additionalInfo.additionalProperties.toMutableMap()
            }

            /** Capital withdrawal amount (CDSL MF transactions) */
            fun capitalWithdrawal(capitalWithdrawal: Float) =
                capitalWithdrawal(JsonField.of(capitalWithdrawal))

            /**
             * Sets [Builder.capitalWithdrawal] to an arbitrary JSON value.
             *
             * You should usually call [Builder.capitalWithdrawal] with a well-typed [Float] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun capitalWithdrawal(capitalWithdrawal: JsonField<Float>) = apply {
                this.capitalWithdrawal = capitalWithdrawal
            }

            /** Units credited (demat transactions) */
            fun credit(credit: Float) = credit(JsonField.of(credit))

            /**
             * Sets [Builder.credit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.credit] with a well-typed [Float] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun credit(credit: JsonField<Float>) = apply { this.credit = credit }

            /** Units debited (demat transactions) */
            fun debit(debit: Float) = debit(JsonField.of(debit))

            /**
             * Sets [Builder.debit] to an arbitrary JSON value.
             *
             * You should usually call [Builder.debit] with a well-typed [Float] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun debit(debit: JsonField<Float>) = apply { this.debit = debit }

            /** Income distribution amount (CDSL MF transactions) */
            fun incomeDistribution(incomeDistribution: Float) =
                incomeDistribution(JsonField.of(incomeDistribution))

            /**
             * Sets [Builder.incomeDistribution] to an arbitrary JSON value.
             *
             * You should usually call [Builder.incomeDistribution] with a well-typed [Float] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun incomeDistribution(incomeDistribution: JsonField<Float>) = apply {
                this.incomeDistribution = incomeDistribution
            }

            /** Order/transaction reference number (demat transactions) */
            fun orderNo(orderNo: String) = orderNo(JsonField.of(orderNo))

            /**
             * Sets [Builder.orderNo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.orderNo] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun orderNo(orderNo: JsonField<String>) = apply { this.orderNo = orderNo }

            /** Price per unit (NSDL/CDSL MF transactions) */
            fun price(price: Float) = price(JsonField.of(price))

            /**
             * Sets [Builder.price] to an arbitrary JSON value.
             *
             * You should usually call [Builder.price] with a well-typed [Float] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun price(price: JsonField<Float>) = apply { this.price = price }

            /** Stamp duty charged */
            fun stampDuty(stampDuty: Float) = stampDuty(JsonField.of(stampDuty))

            /**
             * Sets [Builder.stampDuty] to an arbitrary JSON value.
             *
             * You should usually call [Builder.stampDuty] with a well-typed [Float] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun stampDuty(stampDuty: JsonField<Float>) = apply { this.stampDuty = stampDuty }

            fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.clear()
                putAllAdditionalProperties(additionalProperties)
            }

            fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                additionalProperties.put(key, value)
            }

            fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                this.additionalProperties.putAll(additionalProperties)
            }

            fun removeAdditionalProperty(key: String) = apply { additionalProperties.remove(key) }

            fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                keys.forEach(::removeAdditionalProperty)
            }

            /**
             * Returns an immutable instance of [AdditionalInfo].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): AdditionalInfo =
                AdditionalInfo(
                    capitalWithdrawal,
                    credit,
                    debit,
                    incomeDistribution,
                    orderNo,
                    price,
                    stampDuty,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): AdditionalInfo = apply {
            if (validated) {
                return@apply
            }

            capitalWithdrawal()
            credit()
            debit()
            incomeDistribution()
            orderNo()
            price()
            stampDuty()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: CasParserInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic
        internal fun validity(): Int =
            (if (capitalWithdrawal.asKnown().isPresent) 1 else 0) +
                (if (credit.asKnown().isPresent) 1 else 0) +
                (if (debit.asKnown().isPresent) 1 else 0) +
                (if (incomeDistribution.asKnown().isPresent) 1 else 0) +
                (if (orderNo.asKnown().isPresent) 1 else 0) +
                (if (price.asKnown().isPresent) 1 else 0) +
                (if (stampDuty.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is AdditionalInfo &&
                capitalWithdrawal == other.capitalWithdrawal &&
                credit == other.credit &&
                debit == other.debit &&
                incomeDistribution == other.incomeDistribution &&
                orderNo == other.orderNo &&
                price == other.price &&
                stampDuty == other.stampDuty &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                capitalWithdrawal,
                credit,
                debit,
                incomeDistribution,
                orderNo,
                price,
                stampDuty,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "AdditionalInfo{capitalWithdrawal=$capitalWithdrawal, credit=$credit, debit=$debit, incomeDistribution=$incomeDistribution, orderNo=$orderNo, price=$price, stampDuty=$stampDuty, additionalProperties=$additionalProperties}"
    }

    /**
     * Transaction type. Possible values are PURCHASE, PURCHASE_SIP, REDEMPTION, SWITCH_IN,
     * SWITCH_IN_MERGER, SWITCH_OUT, SWITCH_OUT_MERGER, DIVIDEND_PAYOUT, DIVIDEND_REINVEST,
     * SEGREGATION, STAMP_DUTY_TAX, TDS_TAX, STT_TAX, MISC, REVERSAL, UNKNOWN.
     */
    class Type @JsonCreator private constructor(private val value: JsonField<String>) : Enum {

        /**
         * Returns this class instance's raw value.
         *
         * This is usually only useful if this instance was deserialized from data that doesn't
         * match any known member, and you want to know that value. For example, if the SDK is on an
         * older version than the API, then the API may respond with new members that the SDK is
         * unaware of.
         */
        @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

        companion object {

            @JvmField val PURCHASE = of("PURCHASE")

            @JvmField val PURCHASE_SIP = of("PURCHASE_SIP")

            @JvmField val REDEMPTION = of("REDEMPTION")

            @JvmField val SWITCH_IN = of("SWITCH_IN")

            @JvmField val SWITCH_IN_MERGER = of("SWITCH_IN_MERGER")

            @JvmField val SWITCH_OUT = of("SWITCH_OUT")

            @JvmField val SWITCH_OUT_MERGER = of("SWITCH_OUT_MERGER")

            @JvmField val DIVIDEND_PAYOUT = of("DIVIDEND_PAYOUT")

            @JvmField val DIVIDEND_REINVEST = of("DIVIDEND_REINVEST")

            @JvmField val SEGREGATION = of("SEGREGATION")

            @JvmField val STAMP_DUTY_TAX = of("STAMP_DUTY_TAX")

            @JvmField val TDS_TAX = of("TDS_TAX")

            @JvmField val STT_TAX = of("STT_TAX")

            @JvmField val MISC = of("MISC")

            @JvmField val REVERSAL = of("REVERSAL")

            @JvmField val UNKNOWN = of("UNKNOWN")

            @JvmStatic fun of(value: String) = Type(JsonField.of(value))
        }

        /** An enum containing [Type]'s known values. */
        enum class Known {
            PURCHASE,
            PURCHASE_SIP,
            REDEMPTION,
            SWITCH_IN,
            SWITCH_IN_MERGER,
            SWITCH_OUT,
            SWITCH_OUT_MERGER,
            DIVIDEND_PAYOUT,
            DIVIDEND_REINVEST,
            SEGREGATION,
            STAMP_DUTY_TAX,
            TDS_TAX,
            STT_TAX,
            MISC,
            REVERSAL,
            UNKNOWN,
        }

        /**
         * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
         *
         * An instance of [Type] can contain an unknown value in a couple of cases:
         * - It was deserialized from data that doesn't match any known member. For example, if the
         *   SDK is on an older version than the API, then the API may respond with new members that
         *   the SDK is unaware of.
         * - It was constructed with an arbitrary value using the [of] method.
         */
        enum class Value {
            PURCHASE,
            PURCHASE_SIP,
            REDEMPTION,
            SWITCH_IN,
            SWITCH_IN_MERGER,
            SWITCH_OUT,
            SWITCH_OUT_MERGER,
            DIVIDEND_PAYOUT,
            DIVIDEND_REINVEST,
            SEGREGATION,
            STAMP_DUTY_TAX,
            TDS_TAX,
            STT_TAX,
            MISC,
            REVERSAL,
            UNKNOWN,
            /** An enum member indicating that [Type] was instantiated with an unknown value. */
            _UNKNOWN,
        }

        /**
         * Returns an enum member corresponding to this class instance's value, or [Value._UNKNOWN]
         * if the class was instantiated with an unknown value.
         *
         * Use the [known] method instead if you're certain the value is always known or if you want
         * to throw for the unknown case.
         */
        fun value(): Value =
            when (this) {
                PURCHASE -> Value.PURCHASE
                PURCHASE_SIP -> Value.PURCHASE_SIP
                REDEMPTION -> Value.REDEMPTION
                SWITCH_IN -> Value.SWITCH_IN
                SWITCH_IN_MERGER -> Value.SWITCH_IN_MERGER
                SWITCH_OUT -> Value.SWITCH_OUT
                SWITCH_OUT_MERGER -> Value.SWITCH_OUT_MERGER
                DIVIDEND_PAYOUT -> Value.DIVIDEND_PAYOUT
                DIVIDEND_REINVEST -> Value.DIVIDEND_REINVEST
                SEGREGATION -> Value.SEGREGATION
                STAMP_DUTY_TAX -> Value.STAMP_DUTY_TAX
                TDS_TAX -> Value.TDS_TAX
                STT_TAX -> Value.STT_TAX
                MISC -> Value.MISC
                REVERSAL -> Value.REVERSAL
                UNKNOWN -> Value.UNKNOWN
                else -> Value._UNKNOWN
            }

        /**
         * Returns an enum member corresponding to this class instance's value.
         *
         * Use the [value] method instead if you're uncertain the value is always known and don't
         * want to throw for the unknown case.
         *
         * @throws CasParserInvalidDataException if this class instance's value is a not a known
         *   member.
         */
        fun known(): Known =
            when (this) {
                PURCHASE -> Known.PURCHASE
                PURCHASE_SIP -> Known.PURCHASE_SIP
                REDEMPTION -> Known.REDEMPTION
                SWITCH_IN -> Known.SWITCH_IN
                SWITCH_IN_MERGER -> Known.SWITCH_IN_MERGER
                SWITCH_OUT -> Known.SWITCH_OUT
                SWITCH_OUT_MERGER -> Known.SWITCH_OUT_MERGER
                DIVIDEND_PAYOUT -> Known.DIVIDEND_PAYOUT
                DIVIDEND_REINVEST -> Known.DIVIDEND_REINVEST
                SEGREGATION -> Known.SEGREGATION
                STAMP_DUTY_TAX -> Known.STAMP_DUTY_TAX
                TDS_TAX -> Known.TDS_TAX
                STT_TAX -> Known.STT_TAX
                MISC -> Known.MISC
                REVERSAL -> Known.REVERSAL
                UNKNOWN -> Known.UNKNOWN
                else -> throw CasParserInvalidDataException("Unknown Type: $value")
            }

        /**
         * Returns this class instance's primitive wire representation.
         *
         * This differs from the [toString] method because that method is primarily for debugging
         * and generally doesn't throw.
         *
         * @throws CasParserInvalidDataException if this class instance's value does not have the
         *   expected primitive type.
         */
        fun asString(): String =
            _value().asString().orElseThrow {
                CasParserInvalidDataException("Value is not a String")
            }

        private var validated: Boolean = false

        fun validate(): Type = apply {
            if (validated) {
                return@apply
            }

            known()
            validated = true
        }

        fun isValid(): Boolean =
            try {
                validate()
                true
            } catch (e: CasParserInvalidDataException) {
                false
            }

        /**
         * Returns a score indicating how many valid values are contained in this object
         * recursively.
         *
         * Used for best match union deserialization.
         */
        @JvmSynthetic internal fun validity(): Int = if (value() == Value._UNKNOWN) 0 else 1

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Type && value == other.value
        }

        override fun hashCode() = value.hashCode()

        override fun toString() = value.toString()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is Transaction &&
            additionalInfo == other.additionalInfo &&
            amount == other.amount &&
            balance == other.balance &&
            date == other.date &&
            description == other.description &&
            dividendRate == other.dividendRate &&
            nav == other.nav &&
            type == other.type &&
            units == other.units &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            additionalInfo,
            amount,
            balance,
            date,
            description,
            dividendRate,
            nav,
            type,
            units,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "Transaction{additionalInfo=$additionalInfo, amount=$amount, balance=$balance, date=$date, description=$description, dividendRate=$dividendRate, nav=$nav, type=$type, units=$units, additionalProperties=$additionalProperties}"
}
