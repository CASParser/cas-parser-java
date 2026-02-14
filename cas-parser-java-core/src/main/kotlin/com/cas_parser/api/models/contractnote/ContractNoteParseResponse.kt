// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.contractnote

import com.cas_parser.api.core.Enum
import com.cas_parser.api.core.ExcludeMissing
import com.cas_parser.api.core.JsonField
import com.cas_parser.api.core.JsonMissing
import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.checkKnown
import com.cas_parser.api.core.toImmutable
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

class ContractNoteParseResponse
@JsonCreator(mode = JsonCreator.Mode.DISABLED)
private constructor(
    private val data: JsonField<Data>,
    private val msg: JsonField<String>,
    private val status: JsonField<String>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("data") @ExcludeMissing data: JsonField<Data> = JsonMissing.of(),
        @JsonProperty("msg") @ExcludeMissing msg: JsonField<String> = JsonMissing.of(),
        @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
    ) : this(data, msg, status, mutableMapOf())

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun data(): Optional<Data> = data.getOptional("data")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun msg(): Optional<String> = msg.getOptional("msg")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun status(): Optional<String> = status.getOptional("status")

    /**
     * Returns the raw JSON value of [data].
     *
     * Unlike [data], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("data") @ExcludeMissing fun _data(): JsonField<Data> = data

    /**
     * Returns the raw JSON value of [msg].
     *
     * Unlike [msg], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("msg") @ExcludeMissing fun _msg(): JsonField<String> = msg

    /**
     * Returns the raw JSON value of [status].
     *
     * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

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

        /**
         * Returns a mutable builder for constructing an instance of [ContractNoteParseResponse].
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [ContractNoteParseResponse]. */
    class Builder internal constructor() {

        private var data: JsonField<Data> = JsonMissing.of()
        private var msg: JsonField<String> = JsonMissing.of()
        private var status: JsonField<String> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(contractNoteParseResponse: ContractNoteParseResponse) = apply {
            data = contractNoteParseResponse.data
            msg = contractNoteParseResponse.msg
            status = contractNoteParseResponse.status
            additionalProperties = contractNoteParseResponse.additionalProperties.toMutableMap()
        }

        fun data(data: Data) = data(JsonField.of(data))

        /**
         * Sets [Builder.data] to an arbitrary JSON value.
         *
         * You should usually call [Builder.data] with a well-typed [Data] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun data(data: JsonField<Data>) = apply { this.data = data }

        fun msg(msg: String) = msg(JsonField.of(msg))

        /**
         * Sets [Builder.msg] to an arbitrary JSON value.
         *
         * You should usually call [Builder.msg] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun msg(msg: JsonField<String>) = apply { this.msg = msg }

        fun status(status: String) = status(JsonField.of(status))

        /**
         * Sets [Builder.status] to an arbitrary JSON value.
         *
         * You should usually call [Builder.status] with a well-typed [String] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun status(status: JsonField<String>) = apply { this.status = status }

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
         * Returns an immutable instance of [ContractNoteParseResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): ContractNoteParseResponse =
            ContractNoteParseResponse(data, msg, status, additionalProperties.toMutableMap())
    }

    private var validated: Boolean = false

    fun validate(): ContractNoteParseResponse = apply {
        if (validated) {
            return@apply
        }

        data().ifPresent { it.validate() }
        msg()
        status()
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
        (data.asKnown().getOrNull()?.validity() ?: 0) +
            (if (msg.asKnown().isPresent) 1 else 0) +
            (if (status.asKnown().isPresent) 1 else 0)

    class Data
    @JsonCreator(mode = JsonCreator.Mode.DISABLED)
    private constructor(
        private val brokerInfo: JsonField<BrokerInfo>,
        private val chargesSummary: JsonField<ChargesSummary>,
        private val clientInfo: JsonField<ClientInfo>,
        private val contractNoteInfo: JsonField<ContractNoteInfo>,
        private val derivativesTransactions: JsonField<List<DerivativesTransaction>>,
        private val detailedTrades: JsonField<List<DetailedTrade>>,
        private val equityTransactions: JsonField<List<EquityTransaction>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("broker_info")
            @ExcludeMissing
            brokerInfo: JsonField<BrokerInfo> = JsonMissing.of(),
            @JsonProperty("charges_summary")
            @ExcludeMissing
            chargesSummary: JsonField<ChargesSummary> = JsonMissing.of(),
            @JsonProperty("client_info")
            @ExcludeMissing
            clientInfo: JsonField<ClientInfo> = JsonMissing.of(),
            @JsonProperty("contract_note_info")
            @ExcludeMissing
            contractNoteInfo: JsonField<ContractNoteInfo> = JsonMissing.of(),
            @JsonProperty("derivatives_transactions")
            @ExcludeMissing
            derivativesTransactions: JsonField<List<DerivativesTransaction>> = JsonMissing.of(),
            @JsonProperty("detailed_trades")
            @ExcludeMissing
            detailedTrades: JsonField<List<DetailedTrade>> = JsonMissing.of(),
            @JsonProperty("equity_transactions")
            @ExcludeMissing
            equityTransactions: JsonField<List<EquityTransaction>> = JsonMissing.of(),
        ) : this(
            brokerInfo,
            chargesSummary,
            clientInfo,
            contractNoteInfo,
            derivativesTransactions,
            detailedTrades,
            equityTransactions,
            mutableMapOf(),
        )

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun brokerInfo(): Optional<BrokerInfo> = brokerInfo.getOptional("broker_info")

        /**
         * Breakdown of various charges and fees
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun chargesSummary(): Optional<ChargesSummary> =
            chargesSummary.getOptional("charges_summary")

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clientInfo(): Optional<ClientInfo> = clientInfo.getOptional("client_info")

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun contractNoteInfo(): Optional<ContractNoteInfo> =
            contractNoteInfo.getOptional("contract_note_info")

        /**
         * Summary of derivatives transactions
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun derivativesTransactions(): Optional<List<DerivativesTransaction>> =
            derivativesTransactions.getOptional("derivatives_transactions")

        /**
         * Detailed breakdown of all individual trades
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun detailedTrades(): Optional<List<DetailedTrade>> =
            detailedTrades.getOptional("detailed_trades")

        /**
         * Summary of equity transactions grouped by security
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun equityTransactions(): Optional<List<EquityTransaction>> =
            equityTransactions.getOptional("equity_transactions")

        /**
         * Returns the raw JSON value of [brokerInfo].
         *
         * Unlike [brokerInfo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("broker_info")
        @ExcludeMissing
        fun _brokerInfo(): JsonField<BrokerInfo> = brokerInfo

        /**
         * Returns the raw JSON value of [chargesSummary].
         *
         * Unlike [chargesSummary], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("charges_summary")
        @ExcludeMissing
        fun _chargesSummary(): JsonField<ChargesSummary> = chargesSummary

        /**
         * Returns the raw JSON value of [clientInfo].
         *
         * Unlike [clientInfo], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("client_info")
        @ExcludeMissing
        fun _clientInfo(): JsonField<ClientInfo> = clientInfo

        /**
         * Returns the raw JSON value of [contractNoteInfo].
         *
         * Unlike [contractNoteInfo], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("contract_note_info")
        @ExcludeMissing
        fun _contractNoteInfo(): JsonField<ContractNoteInfo> = contractNoteInfo

        /**
         * Returns the raw JSON value of [derivativesTransactions].
         *
         * Unlike [derivativesTransactions], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("derivatives_transactions")
        @ExcludeMissing
        fun _derivativesTransactions(): JsonField<List<DerivativesTransaction>> =
            derivativesTransactions

        /**
         * Returns the raw JSON value of [detailedTrades].
         *
         * Unlike [detailedTrades], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("detailed_trades")
        @ExcludeMissing
        fun _detailedTrades(): JsonField<List<DetailedTrade>> = detailedTrades

        /**
         * Returns the raw JSON value of [equityTransactions].
         *
         * Unlike [equityTransactions], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("equity_transactions")
        @ExcludeMissing
        fun _equityTransactions(): JsonField<List<EquityTransaction>> = equityTransactions

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

            /** Returns a mutable builder for constructing an instance of [Data]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Data]. */
        class Builder internal constructor() {

            private var brokerInfo: JsonField<BrokerInfo> = JsonMissing.of()
            private var chargesSummary: JsonField<ChargesSummary> = JsonMissing.of()
            private var clientInfo: JsonField<ClientInfo> = JsonMissing.of()
            private var contractNoteInfo: JsonField<ContractNoteInfo> = JsonMissing.of()
            private var derivativesTransactions: JsonField<MutableList<DerivativesTransaction>>? =
                null
            private var detailedTrades: JsonField<MutableList<DetailedTrade>>? = null
            private var equityTransactions: JsonField<MutableList<EquityTransaction>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(data: Data) = apply {
                brokerInfo = data.brokerInfo
                chargesSummary = data.chargesSummary
                clientInfo = data.clientInfo
                contractNoteInfo = data.contractNoteInfo
                derivativesTransactions = data.derivativesTransactions.map { it.toMutableList() }
                detailedTrades = data.detailedTrades.map { it.toMutableList() }
                equityTransactions = data.equityTransactions.map { it.toMutableList() }
                additionalProperties = data.additionalProperties.toMutableMap()
            }

            fun brokerInfo(brokerInfo: BrokerInfo) = brokerInfo(JsonField.of(brokerInfo))

            /**
             * Sets [Builder.brokerInfo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.brokerInfo] with a well-typed [BrokerInfo] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun brokerInfo(brokerInfo: JsonField<BrokerInfo>) = apply {
                this.brokerInfo = brokerInfo
            }

            /** Breakdown of various charges and fees */
            fun chargesSummary(chargesSummary: ChargesSummary) =
                chargesSummary(JsonField.of(chargesSummary))

            /**
             * Sets [Builder.chargesSummary] to an arbitrary JSON value.
             *
             * You should usually call [Builder.chargesSummary] with a well-typed [ChargesSummary]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun chargesSummary(chargesSummary: JsonField<ChargesSummary>) = apply {
                this.chargesSummary = chargesSummary
            }

            fun clientInfo(clientInfo: ClientInfo) = clientInfo(JsonField.of(clientInfo))

            /**
             * Sets [Builder.clientInfo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientInfo] with a well-typed [ClientInfo] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientInfo(clientInfo: JsonField<ClientInfo>) = apply {
                this.clientInfo = clientInfo
            }

            fun contractNoteInfo(contractNoteInfo: ContractNoteInfo) =
                contractNoteInfo(JsonField.of(contractNoteInfo))

            /**
             * Sets [Builder.contractNoteInfo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.contractNoteInfo] with a well-typed
             * [ContractNoteInfo] value instead. This method is primarily for setting the field to
             * an undocumented or not yet supported value.
             */
            fun contractNoteInfo(contractNoteInfo: JsonField<ContractNoteInfo>) = apply {
                this.contractNoteInfo = contractNoteInfo
            }

            /** Summary of derivatives transactions */
            fun derivativesTransactions(derivativesTransactions: List<DerivativesTransaction>) =
                derivativesTransactions(JsonField.of(derivativesTransactions))

            /**
             * Sets [Builder.derivativesTransactions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.derivativesTransactions] with a well-typed
             * `List<DerivativesTransaction>` value instead. This method is primarily for setting
             * the field to an undocumented or not yet supported value.
             */
            fun derivativesTransactions(
                derivativesTransactions: JsonField<List<DerivativesTransaction>>
            ) = apply {
                this.derivativesTransactions = derivativesTransactions.map { it.toMutableList() }
            }

            /**
             * Adds a single [DerivativesTransaction] to [derivativesTransactions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDerivativesTransaction(derivativesTransaction: DerivativesTransaction) = apply {
                derivativesTransactions =
                    (derivativesTransactions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("derivativesTransactions", it).add(derivativesTransaction)
                    }
            }

            /** Detailed breakdown of all individual trades */
            fun detailedTrades(detailedTrades: List<DetailedTrade>) =
                detailedTrades(JsonField.of(detailedTrades))

            /**
             * Sets [Builder.detailedTrades] to an arbitrary JSON value.
             *
             * You should usually call [Builder.detailedTrades] with a well-typed
             * `List<DetailedTrade>` value instead. This method is primarily for setting the field
             * to an undocumented or not yet supported value.
             */
            fun detailedTrades(detailedTrades: JsonField<List<DetailedTrade>>) = apply {
                this.detailedTrades = detailedTrades.map { it.toMutableList() }
            }

            /**
             * Adds a single [DetailedTrade] to [detailedTrades].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addDetailedTrade(detailedTrade: DetailedTrade) = apply {
                detailedTrades =
                    (detailedTrades ?: JsonField.of(mutableListOf())).also {
                        checkKnown("detailedTrades", it).add(detailedTrade)
                    }
            }

            /** Summary of equity transactions grouped by security */
            fun equityTransactions(equityTransactions: List<EquityTransaction>) =
                equityTransactions(JsonField.of(equityTransactions))

            /**
             * Sets [Builder.equityTransactions] to an arbitrary JSON value.
             *
             * You should usually call [Builder.equityTransactions] with a well-typed
             * `List<EquityTransaction>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun equityTransactions(equityTransactions: JsonField<List<EquityTransaction>>) = apply {
                this.equityTransactions = equityTransactions.map { it.toMutableList() }
            }

            /**
             * Adds a single [EquityTransaction] to [equityTransactions].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addEquityTransaction(equityTransaction: EquityTransaction) = apply {
                equityTransactions =
                    (equityTransactions ?: JsonField.of(mutableListOf())).also {
                        checkKnown("equityTransactions", it).add(equityTransaction)
                    }
            }

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
             * Returns an immutable instance of [Data].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Data =
                Data(
                    brokerInfo,
                    chargesSummary,
                    clientInfo,
                    contractNoteInfo,
                    (derivativesTransactions ?: JsonMissing.of()).map { it.toImmutable() },
                    (detailedTrades ?: JsonMissing.of()).map { it.toImmutable() },
                    (equityTransactions ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Data = apply {
            if (validated) {
                return@apply
            }

            brokerInfo().ifPresent { it.validate() }
            chargesSummary().ifPresent { it.validate() }
            clientInfo().ifPresent { it.validate() }
            contractNoteInfo().ifPresent { it.validate() }
            derivativesTransactions().ifPresent { it.forEach { it.validate() } }
            detailedTrades().ifPresent { it.forEach { it.validate() } }
            equityTransactions().ifPresent { it.forEach { it.validate() } }
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
            (brokerInfo.asKnown().getOrNull()?.validity() ?: 0) +
                (chargesSummary.asKnown().getOrNull()?.validity() ?: 0) +
                (clientInfo.asKnown().getOrNull()?.validity() ?: 0) +
                (contractNoteInfo.asKnown().getOrNull()?.validity() ?: 0) +
                (derivativesTransactions.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                    ?: 0) +
                (detailedTrades.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (equityTransactions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class BrokerInfo
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val brokerType: JsonField<BrokerType>,
            private val name: JsonField<String>,
            private val sebiRegistration: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("broker_type")
                @ExcludeMissing
                brokerType: JsonField<BrokerType> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sebi_registration")
                @ExcludeMissing
                sebiRegistration: JsonField<String> = JsonMissing.of(),
            ) : this(brokerType, name, sebiRegistration, mutableMapOf())

            /**
             * Auto-detected or specified broker type
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun brokerType(): Optional<BrokerType> = brokerType.getOptional("broker_type")

            /**
             * Broker company name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * SEBI registration number of the broker
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sebiRegistration(): Optional<String> =
                sebiRegistration.getOptional("sebi_registration")

            /**
             * Returns the raw JSON value of [brokerType].
             *
             * Unlike [brokerType], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("broker_type")
            @ExcludeMissing
            fun _brokerType(): JsonField<BrokerType> = brokerType

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [sebiRegistration].
             *
             * Unlike [sebiRegistration], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sebi_registration")
            @ExcludeMissing
            fun _sebiRegistration(): JsonField<String> = sebiRegistration

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

                /** Returns a mutable builder for constructing an instance of [BrokerInfo]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [BrokerInfo]. */
            class Builder internal constructor() {

                private var brokerType: JsonField<BrokerType> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var sebiRegistration: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(brokerInfo: BrokerInfo) = apply {
                    brokerType = brokerInfo.brokerType
                    name = brokerInfo.name
                    sebiRegistration = brokerInfo.sebiRegistration
                    additionalProperties = brokerInfo.additionalProperties.toMutableMap()
                }

                /** Auto-detected or specified broker type */
                fun brokerType(brokerType: BrokerType) = brokerType(JsonField.of(brokerType))

                /**
                 * Sets [Builder.brokerType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.brokerType] with a well-typed [BrokerType] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun brokerType(brokerType: JsonField<BrokerType>) = apply {
                    this.brokerType = brokerType
                }

                /** Broker company name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** SEBI registration number of the broker */
                fun sebiRegistration(sebiRegistration: String) =
                    sebiRegistration(JsonField.of(sebiRegistration))

                /**
                 * Sets [Builder.sebiRegistration] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sebiRegistration] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun sebiRegistration(sebiRegistration: JsonField<String>) = apply {
                    this.sebiRegistration = sebiRegistration
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [BrokerInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): BrokerInfo =
                    BrokerInfo(
                        brokerType,
                        name,
                        sebiRegistration,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): BrokerInfo = apply {
                if (validated) {
                    return@apply
                }

                brokerType().ifPresent { it.validate() }
                name()
                sebiRegistration()
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
                (brokerType.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (sebiRegistration.asKnown().isPresent) 1 else 0)

            /** Auto-detected or specified broker type */
            class BrokerType
            @JsonCreator
            private constructor(private val value: JsonField<String>) : Enum {

                /**
                 * Returns this class instance's raw value.
                 *
                 * This is usually only useful if this instance was deserialized from data that
                 * doesn't match any known member, and you want to know that value. For example, if
                 * the SDK is on an older version than the API, then the API may respond with new
                 * members that the SDK is unaware of.
                 */
                @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

                companion object {

                    @JvmField val ZERODHA = of("zerodha")

                    @JvmField val GROWW = of("groww")

                    @JvmField val UPSTOX = of("upstox")

                    @JvmField val ICICI = of("icici")

                    @JvmField val UNKNOWN = of("unknown")

                    @JvmStatic fun of(value: String) = BrokerType(JsonField.of(value))
                }

                /** An enum containing [BrokerType]'s known values. */
                enum class Known {
                    ZERODHA,
                    GROWW,
                    UPSTOX,
                    ICICI,
                    UNKNOWN,
                }

                /**
                 * An enum containing [BrokerType]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [BrokerType] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    ZERODHA,
                    GROWW,
                    UPSTOX,
                    ICICI,
                    UNKNOWN,
                    /**
                     * An enum member indicating that [BrokerType] was instantiated with an unknown
                     * value.
                     */
                    _UNKNOWN,
                }

                /**
                 * Returns an enum member corresponding to this class instance's value, or
                 * [Value._UNKNOWN] if the class was instantiated with an unknown value.
                 *
                 * Use the [known] method instead if you're certain the value is always known or if
                 * you want to throw for the unknown case.
                 */
                fun value(): Value =
                    when (this) {
                        ZERODHA -> Value.ZERODHA
                        GROWW -> Value.GROWW
                        UPSTOX -> Value.UPSTOX
                        ICICI -> Value.ICICI
                        UNKNOWN -> Value.UNKNOWN
                        else -> Value._UNKNOWN
                    }

                /**
                 * Returns an enum member corresponding to this class instance's value.
                 *
                 * Use the [value] method instead if you're uncertain the value is always known and
                 * don't want to throw for the unknown case.
                 *
                 * @throws CasParserInvalidDataException if this class instance's value is a not a
                 *   known member.
                 */
                fun known(): Known =
                    when (this) {
                        ZERODHA -> Known.ZERODHA
                        GROWW -> Known.GROWW
                        UPSTOX -> Known.UPSTOX
                        ICICI -> Known.ICICI
                        UNKNOWN -> Known.UNKNOWN
                        else -> throw CasParserInvalidDataException("Unknown BrokerType: $value")
                    }

                /**
                 * Returns this class instance's primitive wire representation.
                 *
                 * This differs from the [toString] method because that method is primarily for
                 * debugging and generally doesn't throw.
                 *
                 * @throws CasParserInvalidDataException if this class instance's value does not
                 *   have the expected primitive type.
                 */
                fun asString(): String =
                    _value().asString().orElseThrow {
                        CasParserInvalidDataException("Value is not a String")
                    }

                private var validated: Boolean = false

                fun validate(): BrokerType = apply {
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

                    return other is BrokerType && value == other.value
                }

                override fun hashCode() = value.hashCode()

                override fun toString() = value.toString()
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is BrokerInfo &&
                    brokerType == other.brokerType &&
                    name == other.name &&
                    sebiRegistration == other.sebiRegistration &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(brokerType, name, sebiRegistration, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "BrokerInfo{brokerType=$brokerType, name=$name, sebiRegistration=$sebiRegistration, additionalProperties=$additionalProperties}"
        }

        /** Breakdown of various charges and fees */
        class ChargesSummary
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val cgst: JsonField<Float>,
            private val exchangeTransactionCharges: JsonField<Float>,
            private val igst: JsonField<Float>,
            private val netAmountReceivablePayable: JsonField<Float>,
            private val payInPayOutObligation: JsonField<Float>,
            private val sebiTurnoverFees: JsonField<Float>,
            private val securitiesTransactionTax: JsonField<Float>,
            private val sgst: JsonField<Float>,
            private val stampDuty: JsonField<Float>,
            private val taxableValueBrokerage: JsonField<Float>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("cgst") @ExcludeMissing cgst: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("exchange_transaction_charges")
                @ExcludeMissing
                exchangeTransactionCharges: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("igst") @ExcludeMissing igst: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("net_amount_receivable_payable")
                @ExcludeMissing
                netAmountReceivablePayable: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("pay_in_pay_out_obligation")
                @ExcludeMissing
                payInPayOutObligation: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("sebi_turnover_fees")
                @ExcludeMissing
                sebiTurnoverFees: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("securities_transaction_tax")
                @ExcludeMissing
                securitiesTransactionTax: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("sgst") @ExcludeMissing sgst: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("stamp_duty")
                @ExcludeMissing
                stampDuty: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("taxable_value_brokerage")
                @ExcludeMissing
                taxableValueBrokerage: JsonField<Float> = JsonMissing.of(),
            ) : this(
                cgst,
                exchangeTransactionCharges,
                igst,
                netAmountReceivablePayable,
                payInPayOutObligation,
                sebiTurnoverFees,
                securitiesTransactionTax,
                sgst,
                stampDuty,
                taxableValueBrokerage,
                mutableMapOf(),
            )

            /**
             * Central GST amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun cgst(): Optional<Float> = cgst.getOptional("cgst")

            /**
             * Exchange transaction charges
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun exchangeTransactionCharges(): Optional<Float> =
                exchangeTransactionCharges.getOptional("exchange_transaction_charges")

            /**
             * Integrated GST amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun igst(): Optional<Float> = igst.getOptional("igst")

            /**
             * Final net amount receivable or payable
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun netAmountReceivablePayable(): Optional<Float> =
                netAmountReceivablePayable.getOptional("net_amount_receivable_payable")

            /**
             * Net pay-in/pay-out obligation
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun payInPayOutObligation(): Optional<Float> =
                payInPayOutObligation.getOptional("pay_in_pay_out_obligation")

            /**
             * SEBI turnover fees
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sebiTurnoverFees(): Optional<Float> =
                sebiTurnoverFees.getOptional("sebi_turnover_fees")

            /**
             * Securities Transaction Tax
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun securitiesTransactionTax(): Optional<Float> =
                securitiesTransactionTax.getOptional("securities_transaction_tax")

            /**
             * State GST amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sgst(): Optional<Float> = sgst.getOptional("sgst")

            /**
             * Stamp duty charges
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun stampDuty(): Optional<Float> = stampDuty.getOptional("stamp_duty")

            /**
             * Taxable brokerage amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun taxableValueBrokerage(): Optional<Float> =
                taxableValueBrokerage.getOptional("taxable_value_brokerage")

            /**
             * Returns the raw JSON value of [cgst].
             *
             * Unlike [cgst], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cgst") @ExcludeMissing fun _cgst(): JsonField<Float> = cgst

            /**
             * Returns the raw JSON value of [exchangeTransactionCharges].
             *
             * Unlike [exchangeTransactionCharges], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("exchange_transaction_charges")
            @ExcludeMissing
            fun _exchangeTransactionCharges(): JsonField<Float> = exchangeTransactionCharges

            /**
             * Returns the raw JSON value of [igst].
             *
             * Unlike [igst], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("igst") @ExcludeMissing fun _igst(): JsonField<Float> = igst

            /**
             * Returns the raw JSON value of [netAmountReceivablePayable].
             *
             * Unlike [netAmountReceivablePayable], this method doesn't throw if the JSON field has
             * an unexpected type.
             */
            @JsonProperty("net_amount_receivable_payable")
            @ExcludeMissing
            fun _netAmountReceivablePayable(): JsonField<Float> = netAmountReceivablePayable

            /**
             * Returns the raw JSON value of [payInPayOutObligation].
             *
             * Unlike [payInPayOutObligation], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("pay_in_pay_out_obligation")
            @ExcludeMissing
            fun _payInPayOutObligation(): JsonField<Float> = payInPayOutObligation

            /**
             * Returns the raw JSON value of [sebiTurnoverFees].
             *
             * Unlike [sebiTurnoverFees], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sebi_turnover_fees")
            @ExcludeMissing
            fun _sebiTurnoverFees(): JsonField<Float> = sebiTurnoverFees

            /**
             * Returns the raw JSON value of [securitiesTransactionTax].
             *
             * Unlike [securitiesTransactionTax], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("securities_transaction_tax")
            @ExcludeMissing
            fun _securitiesTransactionTax(): JsonField<Float> = securitiesTransactionTax

            /**
             * Returns the raw JSON value of [sgst].
             *
             * Unlike [sgst], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sgst") @ExcludeMissing fun _sgst(): JsonField<Float> = sgst

            /**
             * Returns the raw JSON value of [stampDuty].
             *
             * Unlike [stampDuty], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("stamp_duty")
            @ExcludeMissing
            fun _stampDuty(): JsonField<Float> = stampDuty

            /**
             * Returns the raw JSON value of [taxableValueBrokerage].
             *
             * Unlike [taxableValueBrokerage], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("taxable_value_brokerage")
            @ExcludeMissing
            fun _taxableValueBrokerage(): JsonField<Float> = taxableValueBrokerage

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

                /** Returns a mutable builder for constructing an instance of [ChargesSummary]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ChargesSummary]. */
            class Builder internal constructor() {

                private var cgst: JsonField<Float> = JsonMissing.of()
                private var exchangeTransactionCharges: JsonField<Float> = JsonMissing.of()
                private var igst: JsonField<Float> = JsonMissing.of()
                private var netAmountReceivablePayable: JsonField<Float> = JsonMissing.of()
                private var payInPayOutObligation: JsonField<Float> = JsonMissing.of()
                private var sebiTurnoverFees: JsonField<Float> = JsonMissing.of()
                private var securitiesTransactionTax: JsonField<Float> = JsonMissing.of()
                private var sgst: JsonField<Float> = JsonMissing.of()
                private var stampDuty: JsonField<Float> = JsonMissing.of()
                private var taxableValueBrokerage: JsonField<Float> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(chargesSummary: ChargesSummary) = apply {
                    cgst = chargesSummary.cgst
                    exchangeTransactionCharges = chargesSummary.exchangeTransactionCharges
                    igst = chargesSummary.igst
                    netAmountReceivablePayable = chargesSummary.netAmountReceivablePayable
                    payInPayOutObligation = chargesSummary.payInPayOutObligation
                    sebiTurnoverFees = chargesSummary.sebiTurnoverFees
                    securitiesTransactionTax = chargesSummary.securitiesTransactionTax
                    sgst = chargesSummary.sgst
                    stampDuty = chargesSummary.stampDuty
                    taxableValueBrokerage = chargesSummary.taxableValueBrokerage
                    additionalProperties = chargesSummary.additionalProperties.toMutableMap()
                }

                /** Central GST amount */
                fun cgst(cgst: Float) = cgst(JsonField.of(cgst))

                /**
                 * Sets [Builder.cgst] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cgst] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cgst(cgst: JsonField<Float>) = apply { this.cgst = cgst }

                /** Exchange transaction charges */
                fun exchangeTransactionCharges(exchangeTransactionCharges: Float) =
                    exchangeTransactionCharges(JsonField.of(exchangeTransactionCharges))

                /**
                 * Sets [Builder.exchangeTransactionCharges] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.exchangeTransactionCharges] with a well-typed
                 * [Float] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun exchangeTransactionCharges(exchangeTransactionCharges: JsonField<Float>) =
                    apply {
                        this.exchangeTransactionCharges = exchangeTransactionCharges
                    }

                /** Integrated GST amount */
                fun igst(igst: Float) = igst(JsonField.of(igst))

                /**
                 * Sets [Builder.igst] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.igst] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun igst(igst: JsonField<Float>) = apply { this.igst = igst }

                /** Final net amount receivable or payable */
                fun netAmountReceivablePayable(netAmountReceivablePayable: Float) =
                    netAmountReceivablePayable(JsonField.of(netAmountReceivablePayable))

                /**
                 * Sets [Builder.netAmountReceivablePayable] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.netAmountReceivablePayable] with a well-typed
                 * [Float] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun netAmountReceivablePayable(netAmountReceivablePayable: JsonField<Float>) =
                    apply {
                        this.netAmountReceivablePayable = netAmountReceivablePayable
                    }

                /** Net pay-in/pay-out obligation */
                fun payInPayOutObligation(payInPayOutObligation: Float) =
                    payInPayOutObligation(JsonField.of(payInPayOutObligation))

                /**
                 * Sets [Builder.payInPayOutObligation] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.payInPayOutObligation] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun payInPayOutObligation(payInPayOutObligation: JsonField<Float>) = apply {
                    this.payInPayOutObligation = payInPayOutObligation
                }

                /** SEBI turnover fees */
                fun sebiTurnoverFees(sebiTurnoverFees: Float) =
                    sebiTurnoverFees(JsonField.of(sebiTurnoverFees))

                /**
                 * Sets [Builder.sebiTurnoverFees] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sebiTurnoverFees] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun sebiTurnoverFees(sebiTurnoverFees: JsonField<Float>) = apply {
                    this.sebiTurnoverFees = sebiTurnoverFees
                }

                /** Securities Transaction Tax */
                fun securitiesTransactionTax(securitiesTransactionTax: Float) =
                    securitiesTransactionTax(JsonField.of(securitiesTransactionTax))

                /**
                 * Sets [Builder.securitiesTransactionTax] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.securitiesTransactionTax] with a well-typed
                 * [Float] value instead. This method is primarily for setting the field to an
                 * undocumented or not yet supported value.
                 */
                fun securitiesTransactionTax(securitiesTransactionTax: JsonField<Float>) = apply {
                    this.securitiesTransactionTax = securitiesTransactionTax
                }

                /** State GST amount */
                fun sgst(sgst: Float) = sgst(JsonField.of(sgst))

                /**
                 * Sets [Builder.sgst] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sgst] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun sgst(sgst: JsonField<Float>) = apply { this.sgst = sgst }

                /** Stamp duty charges */
                fun stampDuty(stampDuty: Float) = stampDuty(JsonField.of(stampDuty))

                /**
                 * Sets [Builder.stampDuty] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.stampDuty] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun stampDuty(stampDuty: JsonField<Float>) = apply { this.stampDuty = stampDuty }

                /** Taxable brokerage amount */
                fun taxableValueBrokerage(taxableValueBrokerage: Float) =
                    taxableValueBrokerage(JsonField.of(taxableValueBrokerage))

                /**
                 * Sets [Builder.taxableValueBrokerage] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.taxableValueBrokerage] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun taxableValueBrokerage(taxableValueBrokerage: JsonField<Float>) = apply {
                    this.taxableValueBrokerage = taxableValueBrokerage
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ChargesSummary].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ChargesSummary =
                    ChargesSummary(
                        cgst,
                        exchangeTransactionCharges,
                        igst,
                        netAmountReceivablePayable,
                        payInPayOutObligation,
                        sebiTurnoverFees,
                        securitiesTransactionTax,
                        sgst,
                        stampDuty,
                        taxableValueBrokerage,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ChargesSummary = apply {
                if (validated) {
                    return@apply
                }

                cgst()
                exchangeTransactionCharges()
                igst()
                netAmountReceivablePayable()
                payInPayOutObligation()
                sebiTurnoverFees()
                securitiesTransactionTax()
                sgst()
                stampDuty()
                taxableValueBrokerage()
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
                (if (cgst.asKnown().isPresent) 1 else 0) +
                    (if (exchangeTransactionCharges.asKnown().isPresent) 1 else 0) +
                    (if (igst.asKnown().isPresent) 1 else 0) +
                    (if (netAmountReceivablePayable.asKnown().isPresent) 1 else 0) +
                    (if (payInPayOutObligation.asKnown().isPresent) 1 else 0) +
                    (if (sebiTurnoverFees.asKnown().isPresent) 1 else 0) +
                    (if (securitiesTransactionTax.asKnown().isPresent) 1 else 0) +
                    (if (sgst.asKnown().isPresent) 1 else 0) +
                    (if (stampDuty.asKnown().isPresent) 1 else 0) +
                    (if (taxableValueBrokerage.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ChargesSummary &&
                    cgst == other.cgst &&
                    exchangeTransactionCharges == other.exchangeTransactionCharges &&
                    igst == other.igst &&
                    netAmountReceivablePayable == other.netAmountReceivablePayable &&
                    payInPayOutObligation == other.payInPayOutObligation &&
                    sebiTurnoverFees == other.sebiTurnoverFees &&
                    securitiesTransactionTax == other.securitiesTransactionTax &&
                    sgst == other.sgst &&
                    stampDuty == other.stampDuty &&
                    taxableValueBrokerage == other.taxableValueBrokerage &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    cgst,
                    exchangeTransactionCharges,
                    igst,
                    netAmountReceivablePayable,
                    payInPayOutObligation,
                    sebiTurnoverFees,
                    securitiesTransactionTax,
                    sgst,
                    stampDuty,
                    taxableValueBrokerage,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ChargesSummary{cgst=$cgst, exchangeTransactionCharges=$exchangeTransactionCharges, igst=$igst, netAmountReceivablePayable=$netAmountReceivablePayable, payInPayOutObligation=$payInPayOutObligation, sebiTurnoverFees=$sebiTurnoverFees, securitiesTransactionTax=$securitiesTransactionTax, sgst=$sgst, stampDuty=$stampDuty, taxableValueBrokerage=$taxableValueBrokerage, additionalProperties=$additionalProperties}"
        }

        class ClientInfo
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val address: JsonField<String>,
            private val gstStateCode: JsonField<String>,
            private val name: JsonField<String>,
            private val pan: JsonField<String>,
            private val placeOfSupply: JsonField<String>,
            private val ucc: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("address")
                @ExcludeMissing
                address: JsonField<String> = JsonMissing.of(),
                @JsonProperty("gst_state_code")
                @ExcludeMissing
                gstStateCode: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pan") @ExcludeMissing pan: JsonField<String> = JsonMissing.of(),
                @JsonProperty("place_of_supply")
                @ExcludeMissing
                placeOfSupply: JsonField<String> = JsonMissing.of(),
                @JsonProperty("ucc") @ExcludeMissing ucc: JsonField<String> = JsonMissing.of(),
            ) : this(address, gstStateCode, name, pan, placeOfSupply, ucc, mutableMapOf())

            /**
             * Client address
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun address(): Optional<String> = address.getOptional("address")

            /**
             * GST state code
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun gstStateCode(): Optional<String> = gstStateCode.getOptional("gst_state_code")

            /**
             * Client name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Client PAN number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun pan(): Optional<String> = pan.getOptional("pan")

            /**
             * GST place of supply
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun placeOfSupply(): Optional<String> = placeOfSupply.getOptional("place_of_supply")

            /**
             * Unique Client Code
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun ucc(): Optional<String> = ucc.getOptional("ucc")

            /**
             * Returns the raw JSON value of [address].
             *
             * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

            /**
             * Returns the raw JSON value of [gstStateCode].
             *
             * Unlike [gstStateCode], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("gst_state_code")
            @ExcludeMissing
            fun _gstStateCode(): JsonField<String> = gstStateCode

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [pan].
             *
             * Unlike [pan], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("pan") @ExcludeMissing fun _pan(): JsonField<String> = pan

            /**
             * Returns the raw JSON value of [placeOfSupply].
             *
             * Unlike [placeOfSupply], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("place_of_supply")
            @ExcludeMissing
            fun _placeOfSupply(): JsonField<String> = placeOfSupply

            /**
             * Returns the raw JSON value of [ucc].
             *
             * Unlike [ucc], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("ucc") @ExcludeMissing fun _ucc(): JsonField<String> = ucc

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

                /** Returns a mutable builder for constructing an instance of [ClientInfo]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ClientInfo]. */
            class Builder internal constructor() {

                private var address: JsonField<String> = JsonMissing.of()
                private var gstStateCode: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var pan: JsonField<String> = JsonMissing.of()
                private var placeOfSupply: JsonField<String> = JsonMissing.of()
                private var ucc: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(clientInfo: ClientInfo) = apply {
                    address = clientInfo.address
                    gstStateCode = clientInfo.gstStateCode
                    name = clientInfo.name
                    pan = clientInfo.pan
                    placeOfSupply = clientInfo.placeOfSupply
                    ucc = clientInfo.ucc
                    additionalProperties = clientInfo.additionalProperties.toMutableMap()
                }

                /** Client address */
                fun address(address: String) = address(JsonField.of(address))

                /**
                 * Sets [Builder.address] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.address] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun address(address: JsonField<String>) = apply { this.address = address }

                /** GST state code */
                fun gstStateCode(gstStateCode: String) = gstStateCode(JsonField.of(gstStateCode))

                /**
                 * Sets [Builder.gstStateCode] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.gstStateCode] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun gstStateCode(gstStateCode: JsonField<String>) = apply {
                    this.gstStateCode = gstStateCode
                }

                /** Client name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Client PAN number */
                fun pan(pan: String) = pan(JsonField.of(pan))

                /**
                 * Sets [Builder.pan] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pan] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun pan(pan: JsonField<String>) = apply { this.pan = pan }

                /** GST place of supply */
                fun placeOfSupply(placeOfSupply: String) =
                    placeOfSupply(JsonField.of(placeOfSupply))

                /**
                 * Sets [Builder.placeOfSupply] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.placeOfSupply] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun placeOfSupply(placeOfSupply: JsonField<String>) = apply {
                    this.placeOfSupply = placeOfSupply
                }

                /** Unique Client Code */
                fun ucc(ucc: String) = ucc(JsonField.of(ucc))

                /**
                 * Sets [Builder.ucc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.ucc] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun ucc(ucc: JsonField<String>) = apply { this.ucc = ucc }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ClientInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ClientInfo =
                    ClientInfo(
                        address,
                        gstStateCode,
                        name,
                        pan,
                        placeOfSupply,
                        ucc,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ClientInfo = apply {
                if (validated) {
                    return@apply
                }

                address()
                gstStateCode()
                name()
                pan()
                placeOfSupply()
                ucc()
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
                (if (address.asKnown().isPresent) 1 else 0) +
                    (if (gstStateCode.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (pan.asKnown().isPresent) 1 else 0) +
                    (if (placeOfSupply.asKnown().isPresent) 1 else 0) +
                    (if (ucc.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ClientInfo &&
                    address == other.address &&
                    gstStateCode == other.gstStateCode &&
                    name == other.name &&
                    pan == other.pan &&
                    placeOfSupply == other.placeOfSupply &&
                    ucc == other.ucc &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    address,
                    gstStateCode,
                    name,
                    pan,
                    placeOfSupply,
                    ucc,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ClientInfo{address=$address, gstStateCode=$gstStateCode, name=$name, pan=$pan, placeOfSupply=$placeOfSupply, ucc=$ucc, additionalProperties=$additionalProperties}"
        }

        class ContractNoteInfo
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val contractNoteNumber: JsonField<String>,
            private val settlementDate: JsonField<LocalDate>,
            private val settlementNumber: JsonField<String>,
            private val tradeDate: JsonField<LocalDate>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("contract_note_number")
                @ExcludeMissing
                contractNoteNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("settlement_date")
                @ExcludeMissing
                settlementDate: JsonField<LocalDate> = JsonMissing.of(),
                @JsonProperty("settlement_number")
                @ExcludeMissing
                settlementNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("trade_date")
                @ExcludeMissing
                tradeDate: JsonField<LocalDate> = JsonMissing.of(),
            ) : this(
                contractNoteNumber,
                settlementDate,
                settlementNumber,
                tradeDate,
                mutableMapOf(),
            )

            /**
             * Contract note reference number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun contractNoteNumber(): Optional<String> =
                contractNoteNumber.getOptional("contract_note_number")

            /**
             * Settlement date for the trades
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun settlementDate(): Optional<LocalDate> =
                settlementDate.getOptional("settlement_date")

            /**
             * Settlement reference number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun settlementNumber(): Optional<String> =
                settlementNumber.getOptional("settlement_number")

            /**
             * Date when trades were executed
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun tradeDate(): Optional<LocalDate> = tradeDate.getOptional("trade_date")

            /**
             * Returns the raw JSON value of [contractNoteNumber].
             *
             * Unlike [contractNoteNumber], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("contract_note_number")
            @ExcludeMissing
            fun _contractNoteNumber(): JsonField<String> = contractNoteNumber

            /**
             * Returns the raw JSON value of [settlementDate].
             *
             * Unlike [settlementDate], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("settlement_date")
            @ExcludeMissing
            fun _settlementDate(): JsonField<LocalDate> = settlementDate

            /**
             * Returns the raw JSON value of [settlementNumber].
             *
             * Unlike [settlementNumber], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("settlement_number")
            @ExcludeMissing
            fun _settlementNumber(): JsonField<String> = settlementNumber

            /**
             * Returns the raw JSON value of [tradeDate].
             *
             * Unlike [tradeDate], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("trade_date")
            @ExcludeMissing
            fun _tradeDate(): JsonField<LocalDate> = tradeDate

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

                /** Returns a mutable builder for constructing an instance of [ContractNoteInfo]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [ContractNoteInfo]. */
            class Builder internal constructor() {

                private var contractNoteNumber: JsonField<String> = JsonMissing.of()
                private var settlementDate: JsonField<LocalDate> = JsonMissing.of()
                private var settlementNumber: JsonField<String> = JsonMissing.of()
                private var tradeDate: JsonField<LocalDate> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(contractNoteInfo: ContractNoteInfo) = apply {
                    contractNoteNumber = contractNoteInfo.contractNoteNumber
                    settlementDate = contractNoteInfo.settlementDate
                    settlementNumber = contractNoteInfo.settlementNumber
                    tradeDate = contractNoteInfo.tradeDate
                    additionalProperties = contractNoteInfo.additionalProperties.toMutableMap()
                }

                /** Contract note reference number */
                fun contractNoteNumber(contractNoteNumber: String) =
                    contractNoteNumber(JsonField.of(contractNoteNumber))

                /**
                 * Sets [Builder.contractNoteNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.contractNoteNumber] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun contractNoteNumber(contractNoteNumber: JsonField<String>) = apply {
                    this.contractNoteNumber = contractNoteNumber
                }

                /** Settlement date for the trades */
                fun settlementDate(settlementDate: LocalDate) =
                    settlementDate(JsonField.of(settlementDate))

                /**
                 * Sets [Builder.settlementDate] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.settlementDate] with a well-typed [LocalDate]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun settlementDate(settlementDate: JsonField<LocalDate>) = apply {
                    this.settlementDate = settlementDate
                }

                /** Settlement reference number */
                fun settlementNumber(settlementNumber: String) =
                    settlementNumber(JsonField.of(settlementNumber))

                /**
                 * Sets [Builder.settlementNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.settlementNumber] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun settlementNumber(settlementNumber: JsonField<String>) = apply {
                    this.settlementNumber = settlementNumber
                }

                /** Date when trades were executed */
                fun tradeDate(tradeDate: LocalDate) = tradeDate(JsonField.of(tradeDate))

                /**
                 * Sets [Builder.tradeDate] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tradeDate] with a well-typed [LocalDate] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tradeDate(tradeDate: JsonField<LocalDate>) = apply {
                    this.tradeDate = tradeDate
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [ContractNoteInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): ContractNoteInfo =
                    ContractNoteInfo(
                        contractNoteNumber,
                        settlementDate,
                        settlementNumber,
                        tradeDate,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): ContractNoteInfo = apply {
                if (validated) {
                    return@apply
                }

                contractNoteNumber()
                settlementDate()
                settlementNumber()
                tradeDate()
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
                (if (contractNoteNumber.asKnown().isPresent) 1 else 0) +
                    (if (settlementDate.asKnown().isPresent) 1 else 0) +
                    (if (settlementNumber.asKnown().isPresent) 1 else 0) +
                    (if (tradeDate.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is ContractNoteInfo &&
                    contractNoteNumber == other.contractNoteNumber &&
                    settlementDate == other.settlementDate &&
                    settlementNumber == other.settlementNumber &&
                    tradeDate == other.tradeDate &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    contractNoteNumber,
                    settlementDate,
                    settlementNumber,
                    tradeDate,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "ContractNoteInfo{contractNoteNumber=$contractNoteNumber, settlementDate=$settlementDate, settlementNumber=$settlementNumber, tradeDate=$tradeDate, additionalProperties=$additionalProperties}"
        }

        class DerivativesTransaction
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val brokeragePerUnit: JsonField<Float>,
            private val buySellBfCf: JsonField<String>,
            private val closingRatePerUnit: JsonField<Float>,
            private val contractDescription: JsonField<String>,
            private val netTotal: JsonField<Float>,
            private val quantity: JsonField<Float>,
            private val wapPerUnit: JsonField<Float>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("brokerage_per_unit")
                @ExcludeMissing
                brokeragePerUnit: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("buy_sell_bf_cf")
                @ExcludeMissing
                buySellBfCf: JsonField<String> = JsonMissing.of(),
                @JsonProperty("closing_rate_per_unit")
                @ExcludeMissing
                closingRatePerUnit: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("contract_description")
                @ExcludeMissing
                contractDescription: JsonField<String> = JsonMissing.of(),
                @JsonProperty("net_total")
                @ExcludeMissing
                netTotal: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("quantity")
                @ExcludeMissing
                quantity: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("wap_per_unit")
                @ExcludeMissing
                wapPerUnit: JsonField<Float> = JsonMissing.of(),
            ) : this(
                brokeragePerUnit,
                buySellBfCf,
                closingRatePerUnit,
                contractDescription,
                netTotal,
                quantity,
                wapPerUnit,
                mutableMapOf(),
            )

            /**
             * Brokerage charged per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun brokeragePerUnit(): Optional<Float> =
                brokeragePerUnit.getOptional("brokerage_per_unit")

            /**
             * Transaction type (Buy/Sell/Bring Forward/Carry Forward)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun buySellBfCf(): Optional<String> = buySellBfCf.getOptional("buy_sell_bf_cf")

            /**
             * Closing rate per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun closingRatePerUnit(): Optional<Float> =
                closingRatePerUnit.getOptional("closing_rate_per_unit")

            /**
             * Derivatives contract description
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun contractDescription(): Optional<String> =
                contractDescription.getOptional("contract_description")

            /**
             * Net total amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun netTotal(): Optional<Float> = netTotal.getOptional("net_total")

            /**
             * Quantity traded
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun quantity(): Optional<Float> = quantity.getOptional("quantity")

            /**
             * Weighted Average Price per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun wapPerUnit(): Optional<Float> = wapPerUnit.getOptional("wap_per_unit")

            /**
             * Returns the raw JSON value of [brokeragePerUnit].
             *
             * Unlike [brokeragePerUnit], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("brokerage_per_unit")
            @ExcludeMissing
            fun _brokeragePerUnit(): JsonField<Float> = brokeragePerUnit

            /**
             * Returns the raw JSON value of [buySellBfCf].
             *
             * Unlike [buySellBfCf], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("buy_sell_bf_cf")
            @ExcludeMissing
            fun _buySellBfCf(): JsonField<String> = buySellBfCf

            /**
             * Returns the raw JSON value of [closingRatePerUnit].
             *
             * Unlike [closingRatePerUnit], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("closing_rate_per_unit")
            @ExcludeMissing
            fun _closingRatePerUnit(): JsonField<Float> = closingRatePerUnit

            /**
             * Returns the raw JSON value of [contractDescription].
             *
             * Unlike [contractDescription], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("contract_description")
            @ExcludeMissing
            fun _contractDescription(): JsonField<String> = contractDescription

            /**
             * Returns the raw JSON value of [netTotal].
             *
             * Unlike [netTotal], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("net_total") @ExcludeMissing fun _netTotal(): JsonField<Float> = netTotal

            /**
             * Returns the raw JSON value of [quantity].
             *
             * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Float> = quantity

            /**
             * Returns the raw JSON value of [wapPerUnit].
             *
             * Unlike [wapPerUnit], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("wap_per_unit")
            @ExcludeMissing
            fun _wapPerUnit(): JsonField<Float> = wapPerUnit

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

                /**
                 * Returns a mutable builder for constructing an instance of
                 * [DerivativesTransaction].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DerivativesTransaction]. */
            class Builder internal constructor() {

                private var brokeragePerUnit: JsonField<Float> = JsonMissing.of()
                private var buySellBfCf: JsonField<String> = JsonMissing.of()
                private var closingRatePerUnit: JsonField<Float> = JsonMissing.of()
                private var contractDescription: JsonField<String> = JsonMissing.of()
                private var netTotal: JsonField<Float> = JsonMissing.of()
                private var quantity: JsonField<Float> = JsonMissing.of()
                private var wapPerUnit: JsonField<Float> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(derivativesTransaction: DerivativesTransaction) = apply {
                    brokeragePerUnit = derivativesTransaction.brokeragePerUnit
                    buySellBfCf = derivativesTransaction.buySellBfCf
                    closingRatePerUnit = derivativesTransaction.closingRatePerUnit
                    contractDescription = derivativesTransaction.contractDescription
                    netTotal = derivativesTransaction.netTotal
                    quantity = derivativesTransaction.quantity
                    wapPerUnit = derivativesTransaction.wapPerUnit
                    additionalProperties =
                        derivativesTransaction.additionalProperties.toMutableMap()
                }

                /** Brokerage charged per unit */
                fun brokeragePerUnit(brokeragePerUnit: Float) =
                    brokeragePerUnit(JsonField.of(brokeragePerUnit))

                /**
                 * Sets [Builder.brokeragePerUnit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.brokeragePerUnit] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun brokeragePerUnit(brokeragePerUnit: JsonField<Float>) = apply {
                    this.brokeragePerUnit = brokeragePerUnit
                }

                /** Transaction type (Buy/Sell/Bring Forward/Carry Forward) */
                fun buySellBfCf(buySellBfCf: String) = buySellBfCf(JsonField.of(buySellBfCf))

                /**
                 * Sets [Builder.buySellBfCf] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buySellBfCf] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun buySellBfCf(buySellBfCf: JsonField<String>) = apply {
                    this.buySellBfCf = buySellBfCf
                }

                /** Closing rate per unit */
                fun closingRatePerUnit(closingRatePerUnit: Float) =
                    closingRatePerUnit(JsonField.of(closingRatePerUnit))

                /**
                 * Sets [Builder.closingRatePerUnit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.closingRatePerUnit] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun closingRatePerUnit(closingRatePerUnit: JsonField<Float>) = apply {
                    this.closingRatePerUnit = closingRatePerUnit
                }

                /** Derivatives contract description */
                fun contractDescription(contractDescription: String) =
                    contractDescription(JsonField.of(contractDescription))

                /**
                 * Sets [Builder.contractDescription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.contractDescription] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun contractDescription(contractDescription: JsonField<String>) = apply {
                    this.contractDescription = contractDescription
                }

                /** Net total amount */
                fun netTotal(netTotal: Float) = netTotal(JsonField.of(netTotal))

                /**
                 * Sets [Builder.netTotal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.netTotal] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun netTotal(netTotal: JsonField<Float>) = apply { this.netTotal = netTotal }

                /** Quantity traded */
                fun quantity(quantity: Float) = quantity(JsonField.of(quantity))

                /**
                 * Sets [Builder.quantity] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.quantity] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun quantity(quantity: JsonField<Float>) = apply { this.quantity = quantity }

                /** Weighted Average Price per unit */
                fun wapPerUnit(wapPerUnit: Float) = wapPerUnit(JsonField.of(wapPerUnit))

                /**
                 * Sets [Builder.wapPerUnit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.wapPerUnit] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun wapPerUnit(wapPerUnit: JsonField<Float>) = apply {
                    this.wapPerUnit = wapPerUnit
                }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [DerivativesTransaction].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): DerivativesTransaction =
                    DerivativesTransaction(
                        brokeragePerUnit,
                        buySellBfCf,
                        closingRatePerUnit,
                        contractDescription,
                        netTotal,
                        quantity,
                        wapPerUnit,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): DerivativesTransaction = apply {
                if (validated) {
                    return@apply
                }

                brokeragePerUnit()
                buySellBfCf()
                closingRatePerUnit()
                contractDescription()
                netTotal()
                quantity()
                wapPerUnit()
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
                (if (brokeragePerUnit.asKnown().isPresent) 1 else 0) +
                    (if (buySellBfCf.asKnown().isPresent) 1 else 0) +
                    (if (closingRatePerUnit.asKnown().isPresent) 1 else 0) +
                    (if (contractDescription.asKnown().isPresent) 1 else 0) +
                    (if (netTotal.asKnown().isPresent) 1 else 0) +
                    (if (quantity.asKnown().isPresent) 1 else 0) +
                    (if (wapPerUnit.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DerivativesTransaction &&
                    brokeragePerUnit == other.brokeragePerUnit &&
                    buySellBfCf == other.buySellBfCf &&
                    closingRatePerUnit == other.closingRatePerUnit &&
                    contractDescription == other.contractDescription &&
                    netTotal == other.netTotal &&
                    quantity == other.quantity &&
                    wapPerUnit == other.wapPerUnit &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    brokeragePerUnit,
                    buySellBfCf,
                    closingRatePerUnit,
                    contractDescription,
                    netTotal,
                    quantity,
                    wapPerUnit,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DerivativesTransaction{brokeragePerUnit=$brokeragePerUnit, buySellBfCf=$buySellBfCf, closingRatePerUnit=$closingRatePerUnit, contractDescription=$contractDescription, netTotal=$netTotal, quantity=$quantity, wapPerUnit=$wapPerUnit, additionalProperties=$additionalProperties}"
        }

        class DetailedTrade
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val brokerage: JsonField<Float>,
            private val buySell: JsonField<String>,
            private val closingRatePerUnit: JsonField<Float>,
            private val exchange: JsonField<String>,
            private val netRatePerUnit: JsonField<Float>,
            private val netTotal: JsonField<Float>,
            private val orderNumber: JsonField<String>,
            private val orderTime: JsonField<String>,
            private val quantity: JsonField<Float>,
            private val remarks: JsonField<String>,
            private val securityDescription: JsonField<String>,
            private val tradeNumber: JsonField<String>,
            private val tradeTime: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("brokerage")
                @ExcludeMissing
                brokerage: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("buy_sell")
                @ExcludeMissing
                buySell: JsonField<String> = JsonMissing.of(),
                @JsonProperty("closing_rate_per_unit")
                @ExcludeMissing
                closingRatePerUnit: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("exchange")
                @ExcludeMissing
                exchange: JsonField<String> = JsonMissing.of(),
                @JsonProperty("net_rate_per_unit")
                @ExcludeMissing
                netRatePerUnit: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("net_total")
                @ExcludeMissing
                netTotal: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("order_number")
                @ExcludeMissing
                orderNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("order_time")
                @ExcludeMissing
                orderTime: JsonField<String> = JsonMissing.of(),
                @JsonProperty("quantity")
                @ExcludeMissing
                quantity: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("remarks")
                @ExcludeMissing
                remarks: JsonField<String> = JsonMissing.of(),
                @JsonProperty("security_description")
                @ExcludeMissing
                securityDescription: JsonField<String> = JsonMissing.of(),
                @JsonProperty("trade_number")
                @ExcludeMissing
                tradeNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("trade_time")
                @ExcludeMissing
                tradeTime: JsonField<String> = JsonMissing.of(),
            ) : this(
                brokerage,
                buySell,
                closingRatePerUnit,
                exchange,
                netRatePerUnit,
                netTotal,
                orderNumber,
                orderTime,
                quantity,
                remarks,
                securityDescription,
                tradeNumber,
                tradeTime,
                mutableMapOf(),
            )

            /**
             * Brokerage charged for this trade
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun brokerage(): Optional<Float> = brokerage.getOptional("brokerage")

            /**
             * Transaction type (B for Buy, S for Sell)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun buySell(): Optional<String> = buySell.getOptional("buy_sell")

            /**
             * Closing rate per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun closingRatePerUnit(): Optional<Float> =
                closingRatePerUnit.getOptional("closing_rate_per_unit")

            /**
             * Exchange name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun exchange(): Optional<String> = exchange.getOptional("exchange")

            /**
             * Net rate per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun netRatePerUnit(): Optional<Float> = netRatePerUnit.getOptional("net_rate_per_unit")

            /**
             * Net total for this trade
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun netTotal(): Optional<Float> = netTotal.getOptional("net_total")

            /**
             * Order reference number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun orderNumber(): Optional<String> = orderNumber.getOptional("order_number")

            /**
             * Time when order was placed
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun orderTime(): Optional<String> = orderTime.getOptional("order_time")

            /**
             * Quantity traded
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun quantity(): Optional<Float> = quantity.getOptional("quantity")

            /**
             * Additional remarks or notes
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun remarks(): Optional<String> = remarks.getOptional("remarks")

            /**
             * Security name with exchange and ISIN
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun securityDescription(): Optional<String> =
                securityDescription.getOptional("security_description")

            /**
             * Trade reference number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun tradeNumber(): Optional<String> = tradeNumber.getOptional("trade_number")

            /**
             * Time when trade was executed
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun tradeTime(): Optional<String> = tradeTime.getOptional("trade_time")

            /**
             * Returns the raw JSON value of [brokerage].
             *
             * Unlike [brokerage], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("brokerage")
            @ExcludeMissing
            fun _brokerage(): JsonField<Float> = brokerage

            /**
             * Returns the raw JSON value of [buySell].
             *
             * Unlike [buySell], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("buy_sell") @ExcludeMissing fun _buySell(): JsonField<String> = buySell

            /**
             * Returns the raw JSON value of [closingRatePerUnit].
             *
             * Unlike [closingRatePerUnit], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("closing_rate_per_unit")
            @ExcludeMissing
            fun _closingRatePerUnit(): JsonField<Float> = closingRatePerUnit

            /**
             * Returns the raw JSON value of [exchange].
             *
             * Unlike [exchange], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("exchange") @ExcludeMissing fun _exchange(): JsonField<String> = exchange

            /**
             * Returns the raw JSON value of [netRatePerUnit].
             *
             * Unlike [netRatePerUnit], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("net_rate_per_unit")
            @ExcludeMissing
            fun _netRatePerUnit(): JsonField<Float> = netRatePerUnit

            /**
             * Returns the raw JSON value of [netTotal].
             *
             * Unlike [netTotal], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("net_total") @ExcludeMissing fun _netTotal(): JsonField<Float> = netTotal

            /**
             * Returns the raw JSON value of [orderNumber].
             *
             * Unlike [orderNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("order_number")
            @ExcludeMissing
            fun _orderNumber(): JsonField<String> = orderNumber

            /**
             * Returns the raw JSON value of [orderTime].
             *
             * Unlike [orderTime], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("order_time")
            @ExcludeMissing
            fun _orderTime(): JsonField<String> = orderTime

            /**
             * Returns the raw JSON value of [quantity].
             *
             * Unlike [quantity], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("quantity") @ExcludeMissing fun _quantity(): JsonField<Float> = quantity

            /**
             * Returns the raw JSON value of [remarks].
             *
             * Unlike [remarks], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("remarks") @ExcludeMissing fun _remarks(): JsonField<String> = remarks

            /**
             * Returns the raw JSON value of [securityDescription].
             *
             * Unlike [securityDescription], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("security_description")
            @ExcludeMissing
            fun _securityDescription(): JsonField<String> = securityDescription

            /**
             * Returns the raw JSON value of [tradeNumber].
             *
             * Unlike [tradeNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("trade_number")
            @ExcludeMissing
            fun _tradeNumber(): JsonField<String> = tradeNumber

            /**
             * Returns the raw JSON value of [tradeTime].
             *
             * Unlike [tradeTime], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("trade_time")
            @ExcludeMissing
            fun _tradeTime(): JsonField<String> = tradeTime

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

                /** Returns a mutable builder for constructing an instance of [DetailedTrade]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [DetailedTrade]. */
            class Builder internal constructor() {

                private var brokerage: JsonField<Float> = JsonMissing.of()
                private var buySell: JsonField<String> = JsonMissing.of()
                private var closingRatePerUnit: JsonField<Float> = JsonMissing.of()
                private var exchange: JsonField<String> = JsonMissing.of()
                private var netRatePerUnit: JsonField<Float> = JsonMissing.of()
                private var netTotal: JsonField<Float> = JsonMissing.of()
                private var orderNumber: JsonField<String> = JsonMissing.of()
                private var orderTime: JsonField<String> = JsonMissing.of()
                private var quantity: JsonField<Float> = JsonMissing.of()
                private var remarks: JsonField<String> = JsonMissing.of()
                private var securityDescription: JsonField<String> = JsonMissing.of()
                private var tradeNumber: JsonField<String> = JsonMissing.of()
                private var tradeTime: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(detailedTrade: DetailedTrade) = apply {
                    brokerage = detailedTrade.brokerage
                    buySell = detailedTrade.buySell
                    closingRatePerUnit = detailedTrade.closingRatePerUnit
                    exchange = detailedTrade.exchange
                    netRatePerUnit = detailedTrade.netRatePerUnit
                    netTotal = detailedTrade.netTotal
                    orderNumber = detailedTrade.orderNumber
                    orderTime = detailedTrade.orderTime
                    quantity = detailedTrade.quantity
                    remarks = detailedTrade.remarks
                    securityDescription = detailedTrade.securityDescription
                    tradeNumber = detailedTrade.tradeNumber
                    tradeTime = detailedTrade.tradeTime
                    additionalProperties = detailedTrade.additionalProperties.toMutableMap()
                }

                /** Brokerage charged for this trade */
                fun brokerage(brokerage: Float) = brokerage(JsonField.of(brokerage))

                /**
                 * Sets [Builder.brokerage] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.brokerage] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun brokerage(brokerage: JsonField<Float>) = apply { this.brokerage = brokerage }

                /** Transaction type (B for Buy, S for Sell) */
                fun buySell(buySell: String) = buySell(JsonField.of(buySell))

                /**
                 * Sets [Builder.buySell] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buySell] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun buySell(buySell: JsonField<String>) = apply { this.buySell = buySell }

                /** Closing rate per unit */
                fun closingRatePerUnit(closingRatePerUnit: Float) =
                    closingRatePerUnit(JsonField.of(closingRatePerUnit))

                /**
                 * Sets [Builder.closingRatePerUnit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.closingRatePerUnit] with a well-typed [Float]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun closingRatePerUnit(closingRatePerUnit: JsonField<Float>) = apply {
                    this.closingRatePerUnit = closingRatePerUnit
                }

                /** Exchange name */
                fun exchange(exchange: String) = exchange(JsonField.of(exchange))

                /**
                 * Sets [Builder.exchange] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.exchange] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun exchange(exchange: JsonField<String>) = apply { this.exchange = exchange }

                /** Net rate per unit */
                fun netRatePerUnit(netRatePerUnit: Float) =
                    netRatePerUnit(JsonField.of(netRatePerUnit))

                /**
                 * Sets [Builder.netRatePerUnit] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.netRatePerUnit] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun netRatePerUnit(netRatePerUnit: JsonField<Float>) = apply {
                    this.netRatePerUnit = netRatePerUnit
                }

                /** Net total for this trade */
                fun netTotal(netTotal: Float) = netTotal(JsonField.of(netTotal))

                /**
                 * Sets [Builder.netTotal] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.netTotal] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun netTotal(netTotal: JsonField<Float>) = apply { this.netTotal = netTotal }

                /** Order reference number */
                fun orderNumber(orderNumber: String) = orderNumber(JsonField.of(orderNumber))

                /**
                 * Sets [Builder.orderNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.orderNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun orderNumber(orderNumber: JsonField<String>) = apply {
                    this.orderNumber = orderNumber
                }

                /** Time when order was placed */
                fun orderTime(orderTime: String) = orderTime(JsonField.of(orderTime))

                /**
                 * Sets [Builder.orderTime] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.orderTime] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun orderTime(orderTime: JsonField<String>) = apply { this.orderTime = orderTime }

                /** Quantity traded */
                fun quantity(quantity: Float) = quantity(JsonField.of(quantity))

                /**
                 * Sets [Builder.quantity] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.quantity] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun quantity(quantity: JsonField<Float>) = apply { this.quantity = quantity }

                /** Additional remarks or notes */
                fun remarks(remarks: String) = remarks(JsonField.of(remarks))

                /**
                 * Sets [Builder.remarks] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.remarks] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun remarks(remarks: JsonField<String>) = apply { this.remarks = remarks }

                /** Security name with exchange and ISIN */
                fun securityDescription(securityDescription: String) =
                    securityDescription(JsonField.of(securityDescription))

                /**
                 * Sets [Builder.securityDescription] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.securityDescription] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun securityDescription(securityDescription: JsonField<String>) = apply {
                    this.securityDescription = securityDescription
                }

                /** Trade reference number */
                fun tradeNumber(tradeNumber: String) = tradeNumber(JsonField.of(tradeNumber))

                /**
                 * Sets [Builder.tradeNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tradeNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tradeNumber(tradeNumber: JsonField<String>) = apply {
                    this.tradeNumber = tradeNumber
                }

                /** Time when trade was executed */
                fun tradeTime(tradeTime: String) = tradeTime(JsonField.of(tradeTime))

                /**
                 * Sets [Builder.tradeTime] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.tradeTime] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun tradeTime(tradeTime: JsonField<String>) = apply { this.tradeTime = tradeTime }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [DetailedTrade].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): DetailedTrade =
                    DetailedTrade(
                        brokerage,
                        buySell,
                        closingRatePerUnit,
                        exchange,
                        netRatePerUnit,
                        netTotal,
                        orderNumber,
                        orderTime,
                        quantity,
                        remarks,
                        securityDescription,
                        tradeNumber,
                        tradeTime,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): DetailedTrade = apply {
                if (validated) {
                    return@apply
                }

                brokerage()
                buySell()
                closingRatePerUnit()
                exchange()
                netRatePerUnit()
                netTotal()
                orderNumber()
                orderTime()
                quantity()
                remarks()
                securityDescription()
                tradeNumber()
                tradeTime()
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
                (if (brokerage.asKnown().isPresent) 1 else 0) +
                    (if (buySell.asKnown().isPresent) 1 else 0) +
                    (if (closingRatePerUnit.asKnown().isPresent) 1 else 0) +
                    (if (exchange.asKnown().isPresent) 1 else 0) +
                    (if (netRatePerUnit.asKnown().isPresent) 1 else 0) +
                    (if (netTotal.asKnown().isPresent) 1 else 0) +
                    (if (orderNumber.asKnown().isPresent) 1 else 0) +
                    (if (orderTime.asKnown().isPresent) 1 else 0) +
                    (if (quantity.asKnown().isPresent) 1 else 0) +
                    (if (remarks.asKnown().isPresent) 1 else 0) +
                    (if (securityDescription.asKnown().isPresent) 1 else 0) +
                    (if (tradeNumber.asKnown().isPresent) 1 else 0) +
                    (if (tradeTime.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is DetailedTrade &&
                    brokerage == other.brokerage &&
                    buySell == other.buySell &&
                    closingRatePerUnit == other.closingRatePerUnit &&
                    exchange == other.exchange &&
                    netRatePerUnit == other.netRatePerUnit &&
                    netTotal == other.netTotal &&
                    orderNumber == other.orderNumber &&
                    orderTime == other.orderTime &&
                    quantity == other.quantity &&
                    remarks == other.remarks &&
                    securityDescription == other.securityDescription &&
                    tradeNumber == other.tradeNumber &&
                    tradeTime == other.tradeTime &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    brokerage,
                    buySell,
                    closingRatePerUnit,
                    exchange,
                    netRatePerUnit,
                    netTotal,
                    orderNumber,
                    orderTime,
                    quantity,
                    remarks,
                    securityDescription,
                    tradeNumber,
                    tradeTime,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "DetailedTrade{brokerage=$brokerage, buySell=$buySell, closingRatePerUnit=$closingRatePerUnit, exchange=$exchange, netRatePerUnit=$netRatePerUnit, netTotal=$netTotal, orderNumber=$orderNumber, orderTime=$orderTime, quantity=$quantity, remarks=$remarks, securityDescription=$securityDescription, tradeNumber=$tradeNumber, tradeTime=$tradeTime, additionalProperties=$additionalProperties}"
        }

        class EquityTransaction
        @JsonCreator(mode = JsonCreator.Mode.DISABLED)
        private constructor(
            private val buyQuantity: JsonField<Float>,
            private val buyTotalValue: JsonField<Float>,
            private val buyWap: JsonField<Float>,
            private val isin: JsonField<String>,
            private val netObligation: JsonField<Float>,
            private val securityName: JsonField<String>,
            private val securitySymbol: JsonField<String>,
            private val sellQuantity: JsonField<Float>,
            private val sellTotalValue: JsonField<Float>,
            private val sellWap: JsonField<Float>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("buy_quantity")
                @ExcludeMissing
                buyQuantity: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("buy_total_value")
                @ExcludeMissing
                buyTotalValue: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("buy_wap")
                @ExcludeMissing
                buyWap: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("isin") @ExcludeMissing isin: JsonField<String> = JsonMissing.of(),
                @JsonProperty("net_obligation")
                @ExcludeMissing
                netObligation: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("security_name")
                @ExcludeMissing
                securityName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("security_symbol")
                @ExcludeMissing
                securitySymbol: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sell_quantity")
                @ExcludeMissing
                sellQuantity: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("sell_total_value")
                @ExcludeMissing
                sellTotalValue: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("sell_wap")
                @ExcludeMissing
                sellWap: JsonField<Float> = JsonMissing.of(),
            ) : this(
                buyQuantity,
                buyTotalValue,
                buyWap,
                isin,
                netObligation,
                securityName,
                securitySymbol,
                sellQuantity,
                sellTotalValue,
                sellWap,
                mutableMapOf(),
            )

            /**
             * Total quantity purchased
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun buyQuantity(): Optional<Float> = buyQuantity.getOptional("buy_quantity")

            /**
             * Total value of buy transactions
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun buyTotalValue(): Optional<Float> = buyTotalValue.getOptional("buy_total_value")

            /**
             * Weighted Average Price for buy transactions
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun buyWap(): Optional<Float> = buyWap.getOptional("buy_wap")

            /**
             * ISIN code of the security
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isin(): Optional<String> = isin.getOptional("isin")

            /**
             * Net amount payable/receivable for this security
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun netObligation(): Optional<Float> = netObligation.getOptional("net_obligation")

            /**
             * Name of the security
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun securityName(): Optional<String> = securityName.getOptional("security_name")

            /**
             * Trading symbol
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun securitySymbol(): Optional<String> = securitySymbol.getOptional("security_symbol")

            /**
             * Total quantity sold
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sellQuantity(): Optional<Float> = sellQuantity.getOptional("sell_quantity")

            /**
             * Total value of sell transactions
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sellTotalValue(): Optional<Float> = sellTotalValue.getOptional("sell_total_value")

            /**
             * Weighted Average Price for sell transactions
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sellWap(): Optional<Float> = sellWap.getOptional("sell_wap")

            /**
             * Returns the raw JSON value of [buyQuantity].
             *
             * Unlike [buyQuantity], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("buy_quantity")
            @ExcludeMissing
            fun _buyQuantity(): JsonField<Float> = buyQuantity

            /**
             * Returns the raw JSON value of [buyTotalValue].
             *
             * Unlike [buyTotalValue], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("buy_total_value")
            @ExcludeMissing
            fun _buyTotalValue(): JsonField<Float> = buyTotalValue

            /**
             * Returns the raw JSON value of [buyWap].
             *
             * Unlike [buyWap], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("buy_wap") @ExcludeMissing fun _buyWap(): JsonField<Float> = buyWap

            /**
             * Returns the raw JSON value of [isin].
             *
             * Unlike [isin], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

            /**
             * Returns the raw JSON value of [netObligation].
             *
             * Unlike [netObligation], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("net_obligation")
            @ExcludeMissing
            fun _netObligation(): JsonField<Float> = netObligation

            /**
             * Returns the raw JSON value of [securityName].
             *
             * Unlike [securityName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("security_name")
            @ExcludeMissing
            fun _securityName(): JsonField<String> = securityName

            /**
             * Returns the raw JSON value of [securitySymbol].
             *
             * Unlike [securitySymbol], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("security_symbol")
            @ExcludeMissing
            fun _securitySymbol(): JsonField<String> = securitySymbol

            /**
             * Returns the raw JSON value of [sellQuantity].
             *
             * Unlike [sellQuantity], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("sell_quantity")
            @ExcludeMissing
            fun _sellQuantity(): JsonField<Float> = sellQuantity

            /**
             * Returns the raw JSON value of [sellTotalValue].
             *
             * Unlike [sellTotalValue], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("sell_total_value")
            @ExcludeMissing
            fun _sellTotalValue(): JsonField<Float> = sellTotalValue

            /**
             * Returns the raw JSON value of [sellWap].
             *
             * Unlike [sellWap], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("sell_wap") @ExcludeMissing fun _sellWap(): JsonField<Float> = sellWap

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

                /**
                 * Returns a mutable builder for constructing an instance of [EquityTransaction].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [EquityTransaction]. */
            class Builder internal constructor() {

                private var buyQuantity: JsonField<Float> = JsonMissing.of()
                private var buyTotalValue: JsonField<Float> = JsonMissing.of()
                private var buyWap: JsonField<Float> = JsonMissing.of()
                private var isin: JsonField<String> = JsonMissing.of()
                private var netObligation: JsonField<Float> = JsonMissing.of()
                private var securityName: JsonField<String> = JsonMissing.of()
                private var securitySymbol: JsonField<String> = JsonMissing.of()
                private var sellQuantity: JsonField<Float> = JsonMissing.of()
                private var sellTotalValue: JsonField<Float> = JsonMissing.of()
                private var sellWap: JsonField<Float> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(equityTransaction: EquityTransaction) = apply {
                    buyQuantity = equityTransaction.buyQuantity
                    buyTotalValue = equityTransaction.buyTotalValue
                    buyWap = equityTransaction.buyWap
                    isin = equityTransaction.isin
                    netObligation = equityTransaction.netObligation
                    securityName = equityTransaction.securityName
                    securitySymbol = equityTransaction.securitySymbol
                    sellQuantity = equityTransaction.sellQuantity
                    sellTotalValue = equityTransaction.sellTotalValue
                    sellWap = equityTransaction.sellWap
                    additionalProperties = equityTransaction.additionalProperties.toMutableMap()
                }

                /** Total quantity purchased */
                fun buyQuantity(buyQuantity: Float) = buyQuantity(JsonField.of(buyQuantity))

                /**
                 * Sets [Builder.buyQuantity] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buyQuantity] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun buyQuantity(buyQuantity: JsonField<Float>) = apply {
                    this.buyQuantity = buyQuantity
                }

                /** Total value of buy transactions */
                fun buyTotalValue(buyTotalValue: Float) = buyTotalValue(JsonField.of(buyTotalValue))

                /**
                 * Sets [Builder.buyTotalValue] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buyTotalValue] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun buyTotalValue(buyTotalValue: JsonField<Float>) = apply {
                    this.buyTotalValue = buyTotalValue
                }

                /** Weighted Average Price for buy transactions */
                fun buyWap(buyWap: Float) = buyWap(JsonField.of(buyWap))

                /**
                 * Sets [Builder.buyWap] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.buyWap] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun buyWap(buyWap: JsonField<Float>) = apply { this.buyWap = buyWap }

                /** ISIN code of the security */
                fun isin(isin: String) = isin(JsonField.of(isin))

                /**
                 * Sets [Builder.isin] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isin] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                /** Net amount payable/receivable for this security */
                fun netObligation(netObligation: Float) = netObligation(JsonField.of(netObligation))

                /**
                 * Sets [Builder.netObligation] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.netObligation] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun netObligation(netObligation: JsonField<Float>) = apply {
                    this.netObligation = netObligation
                }

                /** Name of the security */
                fun securityName(securityName: String) = securityName(JsonField.of(securityName))

                /**
                 * Sets [Builder.securityName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.securityName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun securityName(securityName: JsonField<String>) = apply {
                    this.securityName = securityName
                }

                /** Trading symbol */
                fun securitySymbol(securitySymbol: String) =
                    securitySymbol(JsonField.of(securitySymbol))

                /**
                 * Sets [Builder.securitySymbol] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.securitySymbol] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun securitySymbol(securitySymbol: JsonField<String>) = apply {
                    this.securitySymbol = securitySymbol
                }

                /** Total quantity sold */
                fun sellQuantity(sellQuantity: Float) = sellQuantity(JsonField.of(sellQuantity))

                /**
                 * Sets [Builder.sellQuantity] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sellQuantity] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sellQuantity(sellQuantity: JsonField<Float>) = apply {
                    this.sellQuantity = sellQuantity
                }

                /** Total value of sell transactions */
                fun sellTotalValue(sellTotalValue: Float) =
                    sellTotalValue(JsonField.of(sellTotalValue))

                /**
                 * Sets [Builder.sellTotalValue] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sellTotalValue] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sellTotalValue(sellTotalValue: JsonField<Float>) = apply {
                    this.sellTotalValue = sellTotalValue
                }

                /** Weighted Average Price for sell transactions */
                fun sellWap(sellWap: Float) = sellWap(JsonField.of(sellWap))

                /**
                 * Sets [Builder.sellWap] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sellWap] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sellWap(sellWap: JsonField<Float>) = apply { this.sellWap = sellWap }

                fun additionalProperties(additionalProperties: Map<String, JsonValue>) = apply {
                    this.additionalProperties.clear()
                    putAllAdditionalProperties(additionalProperties)
                }

                fun putAdditionalProperty(key: String, value: JsonValue) = apply {
                    additionalProperties.put(key, value)
                }

                fun putAllAdditionalProperties(additionalProperties: Map<String, JsonValue>) =
                    apply {
                        this.additionalProperties.putAll(additionalProperties)
                    }

                fun removeAdditionalProperty(key: String) = apply {
                    additionalProperties.remove(key)
                }

                fun removeAllAdditionalProperties(keys: Set<String>) = apply {
                    keys.forEach(::removeAdditionalProperty)
                }

                /**
                 * Returns an immutable instance of [EquityTransaction].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): EquityTransaction =
                    EquityTransaction(
                        buyQuantity,
                        buyTotalValue,
                        buyWap,
                        isin,
                        netObligation,
                        securityName,
                        securitySymbol,
                        sellQuantity,
                        sellTotalValue,
                        sellWap,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): EquityTransaction = apply {
                if (validated) {
                    return@apply
                }

                buyQuantity()
                buyTotalValue()
                buyWap()
                isin()
                netObligation()
                securityName()
                securitySymbol()
                sellQuantity()
                sellTotalValue()
                sellWap()
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
                (if (buyQuantity.asKnown().isPresent) 1 else 0) +
                    (if (buyTotalValue.asKnown().isPresent) 1 else 0) +
                    (if (buyWap.asKnown().isPresent) 1 else 0) +
                    (if (isin.asKnown().isPresent) 1 else 0) +
                    (if (netObligation.asKnown().isPresent) 1 else 0) +
                    (if (securityName.asKnown().isPresent) 1 else 0) +
                    (if (securitySymbol.asKnown().isPresent) 1 else 0) +
                    (if (sellQuantity.asKnown().isPresent) 1 else 0) +
                    (if (sellTotalValue.asKnown().isPresent) 1 else 0) +
                    (if (sellWap.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is EquityTransaction &&
                    buyQuantity == other.buyQuantity &&
                    buyTotalValue == other.buyTotalValue &&
                    buyWap == other.buyWap &&
                    isin == other.isin &&
                    netObligation == other.netObligation &&
                    securityName == other.securityName &&
                    securitySymbol == other.securitySymbol &&
                    sellQuantity == other.sellQuantity &&
                    sellTotalValue == other.sellTotalValue &&
                    sellWap == other.sellWap &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    buyQuantity,
                    buyTotalValue,
                    buyWap,
                    isin,
                    netObligation,
                    securityName,
                    securitySymbol,
                    sellQuantity,
                    sellTotalValue,
                    sellWap,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "EquityTransaction{buyQuantity=$buyQuantity, buyTotalValue=$buyTotalValue, buyWap=$buyWap, isin=$isin, netObligation=$netObligation, securityName=$securityName, securitySymbol=$securitySymbol, sellQuantity=$sellQuantity, sellTotalValue=$sellTotalValue, sellWap=$sellWap, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Data &&
                brokerInfo == other.brokerInfo &&
                chargesSummary == other.chargesSummary &&
                clientInfo == other.clientInfo &&
                contractNoteInfo == other.contractNoteInfo &&
                derivativesTransactions == other.derivativesTransactions &&
                detailedTrades == other.detailedTrades &&
                equityTransactions == other.equityTransactions &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                brokerInfo,
                chargesSummary,
                clientInfo,
                contractNoteInfo,
                derivativesTransactions,
                detailedTrades,
                equityTransactions,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Data{brokerInfo=$brokerInfo, chargesSummary=$chargesSummary, clientInfo=$clientInfo, contractNoteInfo=$contractNoteInfo, derivativesTransactions=$derivativesTransactions, detailedTrades=$detailedTrades, equityTransactions=$equityTransactions, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ContractNoteParseResponse &&
            data == other.data &&
            msg == other.msg &&
            status == other.status &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy { Objects.hash(data, msg, status, additionalProperties) }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "ContractNoteParseResponse{data=$data, msg=$msg, status=$status, additionalProperties=$additionalProperties}"
}
