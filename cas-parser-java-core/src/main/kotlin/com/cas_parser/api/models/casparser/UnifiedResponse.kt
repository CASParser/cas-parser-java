// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.models.casparser

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
import java.time.OffsetDateTime
import java.util.Collections
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

class UnifiedResponse
private constructor(
    private val dematAccounts: JsonField<List<DematAccount>>,
    private val insurance: JsonField<Insurance>,
    private val investor: JsonField<Investor>,
    private val meta: JsonField<Meta>,
    private val mutualFunds: JsonField<List<MutualFund>>,
    private val summary: JsonField<Summary>,
    private val additionalProperties: MutableMap<String, JsonValue>,
) {

    @JsonCreator
    private constructor(
        @JsonProperty("demat_accounts")
        @ExcludeMissing
        dematAccounts: JsonField<List<DematAccount>> = JsonMissing.of(),
        @JsonProperty("insurance")
        @ExcludeMissing
        insurance: JsonField<Insurance> = JsonMissing.of(),
        @JsonProperty("investor") @ExcludeMissing investor: JsonField<Investor> = JsonMissing.of(),
        @JsonProperty("meta") @ExcludeMissing meta: JsonField<Meta> = JsonMissing.of(),
        @JsonProperty("mutual_funds")
        @ExcludeMissing
        mutualFunds: JsonField<List<MutualFund>> = JsonMissing.of(),
        @JsonProperty("summary") @ExcludeMissing summary: JsonField<Summary> = JsonMissing.of(),
    ) : this(dematAccounts, insurance, investor, meta, mutualFunds, summary, mutableMapOf())

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun dematAccounts(): Optional<List<DematAccount>> = dematAccounts.getOptional("demat_accounts")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun insurance(): Optional<Insurance> = insurance.getOptional("insurance")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun investor(): Optional<Investor> = investor.getOptional("investor")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun meta(): Optional<Meta> = meta.getOptional("meta")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun mutualFunds(): Optional<List<MutualFund>> = mutualFunds.getOptional("mutual_funds")

    /**
     * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if the
     *   server responded with an unexpected value).
     */
    fun summary(): Optional<Summary> = summary.getOptional("summary")

    /**
     * Returns the raw JSON value of [dematAccounts].
     *
     * Unlike [dematAccounts], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("demat_accounts")
    @ExcludeMissing
    fun _dematAccounts(): JsonField<List<DematAccount>> = dematAccounts

    /**
     * Returns the raw JSON value of [insurance].
     *
     * Unlike [insurance], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("insurance") @ExcludeMissing fun _insurance(): JsonField<Insurance> = insurance

    /**
     * Returns the raw JSON value of [investor].
     *
     * Unlike [investor], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("investor") @ExcludeMissing fun _investor(): JsonField<Investor> = investor

    /**
     * Returns the raw JSON value of [meta].
     *
     * Unlike [meta], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("meta") @ExcludeMissing fun _meta(): JsonField<Meta> = meta

    /**
     * Returns the raw JSON value of [mutualFunds].
     *
     * Unlike [mutualFunds], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("mutual_funds")
    @ExcludeMissing
    fun _mutualFunds(): JsonField<List<MutualFund>> = mutualFunds

    /**
     * Returns the raw JSON value of [summary].
     *
     * Unlike [summary], this method doesn't throw if the JSON field has an unexpected type.
     */
    @JsonProperty("summary") @ExcludeMissing fun _summary(): JsonField<Summary> = summary

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

        /** Returns a mutable builder for constructing an instance of [UnifiedResponse]. */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [UnifiedResponse]. */
    class Builder internal constructor() {

        private var dematAccounts: JsonField<MutableList<DematAccount>>? = null
        private var insurance: JsonField<Insurance> = JsonMissing.of()
        private var investor: JsonField<Investor> = JsonMissing.of()
        private var meta: JsonField<Meta> = JsonMissing.of()
        private var mutualFunds: JsonField<MutableList<MutualFund>>? = null
        private var summary: JsonField<Summary> = JsonMissing.of()
        private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

        @JvmSynthetic
        internal fun from(unifiedResponse: UnifiedResponse) = apply {
            dematAccounts = unifiedResponse.dematAccounts.map { it.toMutableList() }
            insurance = unifiedResponse.insurance
            investor = unifiedResponse.investor
            meta = unifiedResponse.meta
            mutualFunds = unifiedResponse.mutualFunds.map { it.toMutableList() }
            summary = unifiedResponse.summary
            additionalProperties = unifiedResponse.additionalProperties.toMutableMap()
        }

        fun dematAccounts(dematAccounts: List<DematAccount>) =
            dematAccounts(JsonField.of(dematAccounts))

        /**
         * Sets [Builder.dematAccounts] to an arbitrary JSON value.
         *
         * You should usually call [Builder.dematAccounts] with a well-typed `List<DematAccount>`
         * value instead. This method is primarily for setting the field to an undocumented or not
         * yet supported value.
         */
        fun dematAccounts(dematAccounts: JsonField<List<DematAccount>>) = apply {
            this.dematAccounts = dematAccounts.map { it.toMutableList() }
        }

        /**
         * Adds a single [DematAccount] to [dematAccounts].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addDematAccount(dematAccount: DematAccount) = apply {
            dematAccounts =
                (dematAccounts ?: JsonField.of(mutableListOf())).also {
                    checkKnown("dematAccounts", it).add(dematAccount)
                }
        }

        fun insurance(insurance: Insurance) = insurance(JsonField.of(insurance))

        /**
         * Sets [Builder.insurance] to an arbitrary JSON value.
         *
         * You should usually call [Builder.insurance] with a well-typed [Insurance] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun insurance(insurance: JsonField<Insurance>) = apply { this.insurance = insurance }

        fun investor(investor: Investor) = investor(JsonField.of(investor))

        /**
         * Sets [Builder.investor] to an arbitrary JSON value.
         *
         * You should usually call [Builder.investor] with a well-typed [Investor] value instead.
         * This method is primarily for setting the field to an undocumented or not yet supported
         * value.
         */
        fun investor(investor: JsonField<Investor>) = apply { this.investor = investor }

        fun meta(meta: Meta) = meta(JsonField.of(meta))

        /**
         * Sets [Builder.meta] to an arbitrary JSON value.
         *
         * You should usually call [Builder.meta] with a well-typed [Meta] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun meta(meta: JsonField<Meta>) = apply { this.meta = meta }

        fun mutualFunds(mutualFunds: List<MutualFund>) = mutualFunds(JsonField.of(mutualFunds))

        /**
         * Sets [Builder.mutualFunds] to an arbitrary JSON value.
         *
         * You should usually call [Builder.mutualFunds] with a well-typed `List<MutualFund>` value
         * instead. This method is primarily for setting the field to an undocumented or not yet
         * supported value.
         */
        fun mutualFunds(mutualFunds: JsonField<List<MutualFund>>) = apply {
            this.mutualFunds = mutualFunds.map { it.toMutableList() }
        }

        /**
         * Adds a single [MutualFund] to [mutualFunds].
         *
         * @throws IllegalStateException if the field was previously set to a non-list.
         */
        fun addMutualFund(mutualFund: MutualFund) = apply {
            mutualFunds =
                (mutualFunds ?: JsonField.of(mutableListOf())).also {
                    checkKnown("mutualFunds", it).add(mutualFund)
                }
        }

        fun summary(summary: Summary) = summary(JsonField.of(summary))

        /**
         * Sets [Builder.summary] to an arbitrary JSON value.
         *
         * You should usually call [Builder.summary] with a well-typed [Summary] value instead. This
         * method is primarily for setting the field to an undocumented or not yet supported value.
         */
        fun summary(summary: JsonField<Summary>) = apply { this.summary = summary }

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
         * Returns an immutable instance of [UnifiedResponse].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         */
        fun build(): UnifiedResponse =
            UnifiedResponse(
                (dematAccounts ?: JsonMissing.of()).map { it.toImmutable() },
                insurance,
                investor,
                meta,
                (mutualFunds ?: JsonMissing.of()).map { it.toImmutable() },
                summary,
                additionalProperties.toMutableMap(),
            )
    }

    private var validated: Boolean = false

    fun validate(): UnifiedResponse = apply {
        if (validated) {
            return@apply
        }

        dematAccounts().ifPresent { it.forEach { it.validate() } }
        insurance().ifPresent { it.validate() }
        investor().ifPresent { it.validate() }
        meta().ifPresent { it.validate() }
        mutualFunds().ifPresent { it.forEach { it.validate() } }
        summary().ifPresent { it.validate() }
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
        (dematAccounts.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (insurance.asKnown().getOrNull()?.validity() ?: 0) +
            (investor.asKnown().getOrNull()?.validity() ?: 0) +
            (meta.asKnown().getOrNull()?.validity() ?: 0) +
            (mutualFunds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
            (summary.asKnown().getOrNull()?.validity() ?: 0)

    class DematAccount
    private constructor(
        private val additionalInfo: JsonField<AdditionalInfo>,
        private val boId: JsonField<String>,
        private val clientId: JsonField<String>,
        private val dematType: JsonField<DematType>,
        private val dpId: JsonField<String>,
        private val dpName: JsonField<String>,
        private val holdings: JsonField<Holdings>,
        private val value: JsonField<Float>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("additional_info")
            @ExcludeMissing
            additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of(),
            @JsonProperty("bo_id") @ExcludeMissing boId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("client_id")
            @ExcludeMissing
            clientId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("demat_type")
            @ExcludeMissing
            dematType: JsonField<DematType> = JsonMissing.of(),
            @JsonProperty("dp_id") @ExcludeMissing dpId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("dp_name") @ExcludeMissing dpName: JsonField<String> = JsonMissing.of(),
            @JsonProperty("holdings")
            @ExcludeMissing
            holdings: JsonField<Holdings> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<Float> = JsonMissing.of(),
        ) : this(
            additionalInfo,
            boId,
            clientId,
            dematType,
            dpId,
            dpName,
            holdings,
            value,
            mutableMapOf(),
        )

        /**
         * Additional information specific to the demat account type
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun additionalInfo(): Optional<AdditionalInfo> =
            additionalInfo.getOptional("additional_info")

        /**
         * Beneficiary Owner ID (primarily for CDSL)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun boId(): Optional<String> = boId.getOptional("bo_id")

        /**
         * Client ID
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun clientId(): Optional<String> = clientId.getOptional("client_id")

        /**
         * Type of demat account
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dematType(): Optional<DematType> = dematType.getOptional("demat_type")

        /**
         * Depository Participant ID
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dpId(): Optional<String> = dpId.getOptional("dp_id")

        /**
         * Depository Participant name
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun dpName(): Optional<String> = dpName.getOptional("dp_name")

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun holdings(): Optional<Holdings> = holdings.getOptional("holdings")

        /**
         * Total value of the demat account
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun value(): Optional<Float> = value.getOptional("value")

        /**
         * Returns the raw JSON value of [additionalInfo].
         *
         * Unlike [additionalInfo], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("additional_info")
        @ExcludeMissing
        fun _additionalInfo(): JsonField<AdditionalInfo> = additionalInfo

        /**
         * Returns the raw JSON value of [boId].
         *
         * Unlike [boId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("bo_id") @ExcludeMissing fun _boId(): JsonField<String> = boId

        /**
         * Returns the raw JSON value of [clientId].
         *
         * Unlike [clientId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("client_id") @ExcludeMissing fun _clientId(): JsonField<String> = clientId

        /**
         * Returns the raw JSON value of [dematType].
         *
         * Unlike [dematType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("demat_type")
        @ExcludeMissing
        fun _dematType(): JsonField<DematType> = dematType

        /**
         * Returns the raw JSON value of [dpId].
         *
         * Unlike [dpId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dp_id") @ExcludeMissing fun _dpId(): JsonField<String> = dpId

        /**
         * Returns the raw JSON value of [dpName].
         *
         * Unlike [dpName], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("dp_name") @ExcludeMissing fun _dpName(): JsonField<String> = dpName

        /**
         * Returns the raw JSON value of [holdings].
         *
         * Unlike [holdings], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("holdings") @ExcludeMissing fun _holdings(): JsonField<Holdings> = holdings

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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

            /** Returns a mutable builder for constructing an instance of [DematAccount]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [DematAccount]. */
        class Builder internal constructor() {

            private var additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of()
            private var boId: JsonField<String> = JsonMissing.of()
            private var clientId: JsonField<String> = JsonMissing.of()
            private var dematType: JsonField<DematType> = JsonMissing.of()
            private var dpId: JsonField<String> = JsonMissing.of()
            private var dpName: JsonField<String> = JsonMissing.of()
            private var holdings: JsonField<Holdings> = JsonMissing.of()
            private var value: JsonField<Float> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(dematAccount: DematAccount) = apply {
                additionalInfo = dematAccount.additionalInfo
                boId = dematAccount.boId
                clientId = dematAccount.clientId
                dematType = dematAccount.dematType
                dpId = dematAccount.dpId
                dpName = dematAccount.dpName
                holdings = dematAccount.holdings
                value = dematAccount.value
                additionalProperties = dematAccount.additionalProperties.toMutableMap()
            }

            /** Additional information specific to the demat account type */
            fun additionalInfo(additionalInfo: AdditionalInfo) =
                additionalInfo(JsonField.of(additionalInfo))

            /**
             * Sets [Builder.additionalInfo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.additionalInfo] with a well-typed [AdditionalInfo]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun additionalInfo(additionalInfo: JsonField<AdditionalInfo>) = apply {
                this.additionalInfo = additionalInfo
            }

            /** Beneficiary Owner ID (primarily for CDSL) */
            fun boId(boId: String) = boId(JsonField.of(boId))

            /**
             * Sets [Builder.boId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.boId] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun boId(boId: JsonField<String>) = apply { this.boId = boId }

            /** Client ID */
            fun clientId(clientId: String) = clientId(JsonField.of(clientId))

            /**
             * Sets [Builder.clientId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.clientId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun clientId(clientId: JsonField<String>) = apply { this.clientId = clientId }

            /** Type of demat account */
            fun dematType(dematType: DematType) = dematType(JsonField.of(dematType))

            /**
             * Sets [Builder.dematType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dematType] with a well-typed [DematType] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dematType(dematType: JsonField<DematType>) = apply { this.dematType = dematType }

            /** Depository Participant ID */
            fun dpId(dpId: String) = dpId(JsonField.of(dpId))

            /**
             * Sets [Builder.dpId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dpId] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun dpId(dpId: JsonField<String>) = apply { this.dpId = dpId }

            /** Depository Participant name */
            fun dpName(dpName: String) = dpName(JsonField.of(dpName))

            /**
             * Sets [Builder.dpName] to an arbitrary JSON value.
             *
             * You should usually call [Builder.dpName] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun dpName(dpName: JsonField<String>) = apply { this.dpName = dpName }

            fun holdings(holdings: Holdings) = holdings(JsonField.of(holdings))

            /**
             * Sets [Builder.holdings] to an arbitrary JSON value.
             *
             * You should usually call [Builder.holdings] with a well-typed [Holdings] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun holdings(holdings: JsonField<Holdings>) = apply { this.holdings = holdings }

            /** Total value of the demat account */
            fun value(value: Float) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [Float] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun value(value: JsonField<Float>) = apply { this.value = value }

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
             * Returns an immutable instance of [DematAccount].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): DematAccount =
                DematAccount(
                    additionalInfo,
                    boId,
                    clientId,
                    dematType,
                    dpId,
                    dpName,
                    holdings,
                    value,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): DematAccount = apply {
            if (validated) {
                return@apply
            }

            additionalInfo().ifPresent { it.validate() }
            boId()
            clientId()
            dematType().ifPresent { it.validate() }
            dpId()
            dpName()
            holdings().ifPresent { it.validate() }
            value()
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
            (additionalInfo.asKnown().getOrNull()?.validity() ?: 0) +
                (if (boId.asKnown().isPresent) 1 else 0) +
                (if (clientId.asKnown().isPresent) 1 else 0) +
                (dematType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (dpId.asKnown().isPresent) 1 else 0) +
                (if (dpName.asKnown().isPresent) 1 else 0) +
                (holdings.asKnown().getOrNull()?.validity() ?: 0) +
                (if (value.asKnown().isPresent) 1 else 0)

        /** Additional information specific to the demat account type */
        class AdditionalInfo
        private constructor(
            private val boStatus: JsonField<String>,
            private val boSubStatus: JsonField<String>,
            private val boType: JsonField<String>,
            private val bsda: JsonField<String>,
            private val email: JsonField<String>,
            private val linkedPans: JsonField<List<String>>,
            private val nominee: JsonField<String>,
            private val status: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("bo_status")
                @ExcludeMissing
                boStatus: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bo_sub_status")
                @ExcludeMissing
                boSubStatus: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bo_type")
                @ExcludeMissing
                boType: JsonField<String> = JsonMissing.of(),
                @JsonProperty("bsda") @ExcludeMissing bsda: JsonField<String> = JsonMissing.of(),
                @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
                @JsonProperty("linked_pans")
                @ExcludeMissing
                linkedPans: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("nominee")
                @ExcludeMissing
                nominee: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status") @ExcludeMissing status: JsonField<String> = JsonMissing.of(),
            ) : this(
                boStatus,
                boSubStatus,
                boType,
                bsda,
                email,
                linkedPans,
                nominee,
                status,
                mutableMapOf(),
            )

            /**
             * Beneficiary Owner status (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun boStatus(): Optional<String> = boStatus.getOptional("bo_status")

            /**
             * Beneficiary Owner sub-status (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun boSubStatus(): Optional<String> = boSubStatus.getOptional("bo_sub_status")

            /**
             * Beneficiary Owner type (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun boType(): Optional<String> = boType.getOptional("bo_type")

            /**
             * Basic Services Demat Account status (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun bsda(): Optional<String> = bsda.getOptional("bsda")

            /**
             * Email associated with the demat account (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun email(): Optional<String> = email.getOptional("email")

            /**
             * List of linked PAN numbers (NSDL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun linkedPans(): Optional<List<String>> = linkedPans.getOptional("linked_pans")

            /**
             * Nominee details (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun nominee(): Optional<String> = nominee.getOptional("nominee")

            /**
             * Account status (CDSL)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * Returns the raw JSON value of [boStatus].
             *
             * Unlike [boStatus], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("bo_status") @ExcludeMissing fun _boStatus(): JsonField<String> = boStatus

            /**
             * Returns the raw JSON value of [boSubStatus].
             *
             * Unlike [boSubStatus], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("bo_sub_status")
            @ExcludeMissing
            fun _boSubStatus(): JsonField<String> = boSubStatus

            /**
             * Returns the raw JSON value of [boType].
             *
             * Unlike [boType], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bo_type") @ExcludeMissing fun _boType(): JsonField<String> = boType

            /**
             * Returns the raw JSON value of [bsda].
             *
             * Unlike [bsda], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("bsda") @ExcludeMissing fun _bsda(): JsonField<String> = bsda

            /**
             * Returns the raw JSON value of [email].
             *
             * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

            /**
             * Returns the raw JSON value of [linkedPans].
             *
             * Unlike [linkedPans], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("linked_pans")
            @ExcludeMissing
            fun _linkedPans(): JsonField<List<String>> = linkedPans

            /**
             * Returns the raw JSON value of [nominee].
             *
             * Unlike [nominee], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("nominee") @ExcludeMissing fun _nominee(): JsonField<String> = nominee

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

                /** Returns a mutable builder for constructing an instance of [AdditionalInfo]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [AdditionalInfo]. */
            class Builder internal constructor() {

                private var boStatus: JsonField<String> = JsonMissing.of()
                private var boSubStatus: JsonField<String> = JsonMissing.of()
                private var boType: JsonField<String> = JsonMissing.of()
                private var bsda: JsonField<String> = JsonMissing.of()
                private var email: JsonField<String> = JsonMissing.of()
                private var linkedPans: JsonField<MutableList<String>>? = null
                private var nominee: JsonField<String> = JsonMissing.of()
                private var status: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(additionalInfo: AdditionalInfo) = apply {
                    boStatus = additionalInfo.boStatus
                    boSubStatus = additionalInfo.boSubStatus
                    boType = additionalInfo.boType
                    bsda = additionalInfo.bsda
                    email = additionalInfo.email
                    linkedPans = additionalInfo.linkedPans.map { it.toMutableList() }
                    nominee = additionalInfo.nominee
                    status = additionalInfo.status
                    additionalProperties = additionalInfo.additionalProperties.toMutableMap()
                }

                /** Beneficiary Owner status (CDSL) */
                fun boStatus(boStatus: String) = boStatus(JsonField.of(boStatus))

                /**
                 * Sets [Builder.boStatus] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.boStatus] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun boStatus(boStatus: JsonField<String>) = apply { this.boStatus = boStatus }

                /** Beneficiary Owner sub-status (CDSL) */
                fun boSubStatus(boSubStatus: String) = boSubStatus(JsonField.of(boSubStatus))

                /**
                 * Sets [Builder.boSubStatus] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.boSubStatus] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun boSubStatus(boSubStatus: JsonField<String>) = apply {
                    this.boSubStatus = boSubStatus
                }

                /** Beneficiary Owner type (CDSL) */
                fun boType(boType: String) = boType(JsonField.of(boType))

                /**
                 * Sets [Builder.boType] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.boType] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun boType(boType: JsonField<String>) = apply { this.boType = boType }

                /** Basic Services Demat Account status (CDSL) */
                fun bsda(bsda: String) = bsda(JsonField.of(bsda))

                /**
                 * Sets [Builder.bsda] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.bsda] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun bsda(bsda: JsonField<String>) = apply { this.bsda = bsda }

                /** Email associated with the demat account (CDSL) */
                fun email(email: String) = email(JsonField.of(email))

                /**
                 * Sets [Builder.email] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.email] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun email(email: JsonField<String>) = apply { this.email = email }

                /** List of linked PAN numbers (NSDL) */
                fun linkedPans(linkedPans: List<String>) = linkedPans(JsonField.of(linkedPans))

                /**
                 * Sets [Builder.linkedPans] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.linkedPans] with a well-typed `List<String>`
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun linkedPans(linkedPans: JsonField<List<String>>) = apply {
                    this.linkedPans = linkedPans.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [linkedPans].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addLinkedPan(linkedPan: String) = apply {
                    linkedPans =
                        (linkedPans ?: JsonField.of(mutableListOf())).also {
                            checkKnown("linkedPans", it).add(linkedPan)
                        }
                }

                /** Nominee details (CDSL) */
                fun nominee(nominee: String) = nominee(JsonField.of(nominee))

                /**
                 * Sets [Builder.nominee] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.nominee] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun nominee(nominee: JsonField<String>) = apply { this.nominee = nominee }

                /** Account status (CDSL) */
                fun status(status: String) = status(JsonField.of(status))

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

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
                 * Returns an immutable instance of [AdditionalInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): AdditionalInfo =
                    AdditionalInfo(
                        boStatus,
                        boSubStatus,
                        boType,
                        bsda,
                        email,
                        (linkedPans ?: JsonMissing.of()).map { it.toImmutable() },
                        nominee,
                        status,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): AdditionalInfo = apply {
                if (validated) {
                    return@apply
                }

                boStatus()
                boSubStatus()
                boType()
                bsda()
                email()
                linkedPans()
                nominee()
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
             * Returns a score indicating how many valid values are contained in this object
             * recursively.
             *
             * Used for best match union deserialization.
             */
            @JvmSynthetic
            internal fun validity(): Int =
                (if (boStatus.asKnown().isPresent) 1 else 0) +
                    (if (boSubStatus.asKnown().isPresent) 1 else 0) +
                    (if (boType.asKnown().isPresent) 1 else 0) +
                    (if (bsda.asKnown().isPresent) 1 else 0) +
                    (if (email.asKnown().isPresent) 1 else 0) +
                    (linkedPans.asKnown().getOrNull()?.size ?: 0) +
                    (if (nominee.asKnown().isPresent) 1 else 0) +
                    (if (status.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AdditionalInfo &&
                    boStatus == other.boStatus &&
                    boSubStatus == other.boSubStatus &&
                    boType == other.boType &&
                    bsda == other.bsda &&
                    email == other.email &&
                    linkedPans == other.linkedPans &&
                    nominee == other.nominee &&
                    status == other.status &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    boStatus,
                    boSubStatus,
                    boType,
                    bsda,
                    email,
                    linkedPans,
                    nominee,
                    status,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AdditionalInfo{boStatus=$boStatus, boSubStatus=$boSubStatus, boType=$boType, bsda=$bsda, email=$email, linkedPans=$linkedPans, nominee=$nominee, status=$status, additionalProperties=$additionalProperties}"
        }

        /** Type of demat account */
        class DematType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NSDL = of("NSDL")

                @JvmField val CDSL = of("CDSL")

                @JvmStatic fun of(value: String) = DematType(JsonField.of(value))
            }

            /** An enum containing [DematType]'s known values. */
            enum class Known {
                NSDL,
                CDSL,
            }

            /**
             * An enum containing [DematType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [DematType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NSDL,
                CDSL,
                /**
                 * An enum member indicating that [DematType] was instantiated with an unknown
                 * value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    NSDL -> Value.NSDL
                    CDSL -> Value.CDSL
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CasParserInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    NSDL -> Known.NSDL
                    CDSL -> Known.CDSL
                    else -> throw CasParserInvalidDataException("Unknown DematType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CasParserInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CasParserInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): DematType = apply {
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

                return other is DematType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class Holdings
        private constructor(
            private val aifs: JsonField<List<Aif>>,
            private val corporateBonds: JsonField<List<CorporateBond>>,
            private val dematMutualFunds: JsonField<List<DematMutualFund>>,
            private val equities: JsonField<List<Equity>>,
            private val governmentSecurities: JsonField<List<GovernmentSecurity>>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("aifs") @ExcludeMissing aifs: JsonField<List<Aif>> = JsonMissing.of(),
                @JsonProperty("corporate_bonds")
                @ExcludeMissing
                corporateBonds: JsonField<List<CorporateBond>> = JsonMissing.of(),
                @JsonProperty("demat_mutual_funds")
                @ExcludeMissing
                dematMutualFunds: JsonField<List<DematMutualFund>> = JsonMissing.of(),
                @JsonProperty("equities")
                @ExcludeMissing
                equities: JsonField<List<Equity>> = JsonMissing.of(),
                @JsonProperty("government_securities")
                @ExcludeMissing
                governmentSecurities: JsonField<List<GovernmentSecurity>> = JsonMissing.of(),
            ) : this(
                aifs,
                corporateBonds,
                dematMutualFunds,
                equities,
                governmentSecurities,
                mutableMapOf(),
            )

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun aifs(): Optional<List<Aif>> = aifs.getOptional("aifs")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun corporateBonds(): Optional<List<CorporateBond>> =
                corporateBonds.getOptional("corporate_bonds")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun dematMutualFunds(): Optional<List<DematMutualFund>> =
                dematMutualFunds.getOptional("demat_mutual_funds")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun equities(): Optional<List<Equity>> = equities.getOptional("equities")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun governmentSecurities(): Optional<List<GovernmentSecurity>> =
                governmentSecurities.getOptional("government_securities")

            /**
             * Returns the raw JSON value of [aifs].
             *
             * Unlike [aifs], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("aifs") @ExcludeMissing fun _aifs(): JsonField<List<Aif>> = aifs

            /**
             * Returns the raw JSON value of [corporateBonds].
             *
             * Unlike [corporateBonds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("corporate_bonds")
            @ExcludeMissing
            fun _corporateBonds(): JsonField<List<CorporateBond>> = corporateBonds

            /**
             * Returns the raw JSON value of [dematMutualFunds].
             *
             * Unlike [dematMutualFunds], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("demat_mutual_funds")
            @ExcludeMissing
            fun _dematMutualFunds(): JsonField<List<DematMutualFund>> = dematMutualFunds

            /**
             * Returns the raw JSON value of [equities].
             *
             * Unlike [equities], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("equities")
            @ExcludeMissing
            fun _equities(): JsonField<List<Equity>> = equities

            /**
             * Returns the raw JSON value of [governmentSecurities].
             *
             * Unlike [governmentSecurities], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("government_securities")
            @ExcludeMissing
            fun _governmentSecurities(): JsonField<List<GovernmentSecurity>> = governmentSecurities

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

                /** Returns a mutable builder for constructing an instance of [Holdings]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Holdings]. */
            class Builder internal constructor() {

                private var aifs: JsonField<MutableList<Aif>>? = null
                private var corporateBonds: JsonField<MutableList<CorporateBond>>? = null
                private var dematMutualFunds: JsonField<MutableList<DematMutualFund>>? = null
                private var equities: JsonField<MutableList<Equity>>? = null
                private var governmentSecurities: JsonField<MutableList<GovernmentSecurity>>? = null
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(holdings: Holdings) = apply {
                    aifs = holdings.aifs.map { it.toMutableList() }
                    corporateBonds = holdings.corporateBonds.map { it.toMutableList() }
                    dematMutualFunds = holdings.dematMutualFunds.map { it.toMutableList() }
                    equities = holdings.equities.map { it.toMutableList() }
                    governmentSecurities = holdings.governmentSecurities.map { it.toMutableList() }
                    additionalProperties = holdings.additionalProperties.toMutableMap()
                }

                fun aifs(aifs: List<Aif>) = aifs(JsonField.of(aifs))

                /**
                 * Sets [Builder.aifs] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.aifs] with a well-typed `List<Aif>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun aifs(aifs: JsonField<List<Aif>>) = apply {
                    this.aifs = aifs.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Aif] to [aifs].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addAif(aif: Aif) = apply {
                    aifs =
                        (aifs ?: JsonField.of(mutableListOf())).also {
                            checkKnown("aifs", it).add(aif)
                        }
                }

                fun corporateBonds(corporateBonds: List<CorporateBond>) =
                    corporateBonds(JsonField.of(corporateBonds))

                /**
                 * Sets [Builder.corporateBonds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.corporateBonds] with a well-typed
                 * `List<CorporateBond>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun corporateBonds(corporateBonds: JsonField<List<CorporateBond>>) = apply {
                    this.corporateBonds = corporateBonds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [CorporateBond] to [corporateBonds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addCorporateBond(corporateBond: CorporateBond) = apply {
                    corporateBonds =
                        (corporateBonds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("corporateBonds", it).add(corporateBond)
                        }
                }

                fun dematMutualFunds(dematMutualFunds: List<DematMutualFund>) =
                    dematMutualFunds(JsonField.of(dematMutualFunds))

                /**
                 * Sets [Builder.dematMutualFunds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.dematMutualFunds] with a well-typed
                 * `List<DematMutualFund>` value instead. This method is primarily for setting the
                 * field to an undocumented or not yet supported value.
                 */
                fun dematMutualFunds(dematMutualFunds: JsonField<List<DematMutualFund>>) = apply {
                    this.dematMutualFunds = dematMutualFunds.map { it.toMutableList() }
                }

                /**
                 * Adds a single [DematMutualFund] to [dematMutualFunds].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addDematMutualFund(dematMutualFund: DematMutualFund) = apply {
                    dematMutualFunds =
                        (dematMutualFunds ?: JsonField.of(mutableListOf())).also {
                            checkKnown("dematMutualFunds", it).add(dematMutualFund)
                        }
                }

                fun equities(equities: List<Equity>) = equities(JsonField.of(equities))

                /**
                 * Sets [Builder.equities] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.equities] with a well-typed `List<Equity>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun equities(equities: JsonField<List<Equity>>) = apply {
                    this.equities = equities.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Equity] to [equities].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addEquity(equity: Equity) = apply {
                    equities =
                        (equities ?: JsonField.of(mutableListOf())).also {
                            checkKnown("equities", it).add(equity)
                        }
                }

                fun governmentSecurities(governmentSecurities: List<GovernmentSecurity>) =
                    governmentSecurities(JsonField.of(governmentSecurities))

                /**
                 * Sets [Builder.governmentSecurities] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.governmentSecurities] with a well-typed
                 * `List<GovernmentSecurity>` value instead. This method is primarily for setting
                 * the field to an undocumented or not yet supported value.
                 */
                fun governmentSecurities(
                    governmentSecurities: JsonField<List<GovernmentSecurity>>
                ) = apply {
                    this.governmentSecurities = governmentSecurities.map { it.toMutableList() }
                }

                /**
                 * Adds a single [GovernmentSecurity] to [governmentSecurities].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addGovernmentSecurity(governmentSecurity: GovernmentSecurity) = apply {
                    governmentSecurities =
                        (governmentSecurities ?: JsonField.of(mutableListOf())).also {
                            checkKnown("governmentSecurities", it).add(governmentSecurity)
                        }
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
                 * Returns an immutable instance of [Holdings].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Holdings =
                    Holdings(
                        (aifs ?: JsonMissing.of()).map { it.toImmutable() },
                        (corporateBonds ?: JsonMissing.of()).map { it.toImmutable() },
                        (dematMutualFunds ?: JsonMissing.of()).map { it.toImmutable() },
                        (equities ?: JsonMissing.of()).map { it.toImmutable() },
                        (governmentSecurities ?: JsonMissing.of()).map { it.toImmutable() },
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Holdings = apply {
                if (validated) {
                    return@apply
                }

                aifs().ifPresent { it.forEach { it.validate() } }
                corporateBonds().ifPresent { it.forEach { it.validate() } }
                dematMutualFunds().ifPresent { it.forEach { it.validate() } }
                equities().ifPresent { it.forEach { it.validate() } }
                governmentSecurities().ifPresent { it.forEach { it.validate() } }
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
                (aifs.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (corporateBonds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (dematMutualFunds.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (equities.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (governmentSecurities.asKnown().getOrNull()?.sumOf { it.validity().toInt() }
                        ?: 0)

            class Aif
            private constructor(
                private val additionalInfo: JsonValue,
                private val isin: JsonField<String>,
                private val name: JsonField<String>,
                private val units: JsonField<Float>,
                private val value: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("additional_info")
                    @ExcludeMissing
                    additionalInfo: JsonValue = JsonMissing.of(),
                    @JsonProperty("isin")
                    @ExcludeMissing
                    isin: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<Float> = JsonMissing.of(),
                ) : this(additionalInfo, isin, name, units, value, mutableMapOf())

                /** Additional information specific to the AIF */
                @JsonProperty("additional_info")
                @ExcludeMissing
                fun _additionalInfo(): JsonValue = additionalInfo

                /**
                 * ISIN code of the AIF
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun isin(): Optional<String> = isin.getOptional("isin")

                /**
                 * Name of the AIF
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Number of units held
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Current market value of the holding
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<Float> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [isin].
                 *
                 * Unlike [isin], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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

                    /** Returns a mutable builder for constructing an instance of [Aif]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Aif]. */
                class Builder internal constructor() {

                    private var additionalInfo: JsonValue = JsonMissing.of()
                    private var isin: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var value: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(aif: Aif) = apply {
                        additionalInfo = aif.additionalInfo
                        isin = aif.isin
                        name = aif.name
                        units = aif.units
                        value = aif.value
                        additionalProperties = aif.additionalProperties.toMutableMap()
                    }

                    /** Additional information specific to the AIF */
                    fun additionalInfo(additionalInfo: JsonValue) = apply {
                        this.additionalInfo = additionalInfo
                    }

                    /** ISIN code of the AIF */
                    fun isin(isin: String) = isin(JsonField.of(isin))

                    /**
                     * Sets [Builder.isin] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isin] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                    /** Name of the AIF */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /** Number of units held */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

                    /** Current market value of the holding */
                    fun value(value: Float) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Float>) = apply { this.value = value }

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
                     * Returns an immutable instance of [Aif].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Aif =
                        Aif(
                            additionalInfo,
                            isin,
                            name,
                            units,
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Aif = apply {
                    if (validated) {
                        return@apply
                    }

                    isin()
                    name()
                    units()
                    value()
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
                    (if (isin.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Aif &&
                        additionalInfo == other.additionalInfo &&
                        isin == other.isin &&
                        name == other.name &&
                        units == other.units &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(additionalInfo, isin, name, units, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Aif{additionalInfo=$additionalInfo, isin=$isin, name=$name, units=$units, value=$value, additionalProperties=$additionalProperties}"
            }

            class CorporateBond
            private constructor(
                private val additionalInfo: JsonValue,
                private val isin: JsonField<String>,
                private val name: JsonField<String>,
                private val units: JsonField<Float>,
                private val value: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("additional_info")
                    @ExcludeMissing
                    additionalInfo: JsonValue = JsonMissing.of(),
                    @JsonProperty("isin")
                    @ExcludeMissing
                    isin: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<Float> = JsonMissing.of(),
                ) : this(additionalInfo, isin, name, units, value, mutableMapOf())

                /** Additional information specific to the corporate bond */
                @JsonProperty("additional_info")
                @ExcludeMissing
                fun _additionalInfo(): JsonValue = additionalInfo

                /**
                 * ISIN code of the corporate bond
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun isin(): Optional<String> = isin.getOptional("isin")

                /**
                 * Name of the corporate bond
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Number of units held
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Current market value of the holding
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<Float> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [isin].
                 *
                 * Unlike [isin], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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
                     * Returns a mutable builder for constructing an instance of [CorporateBond].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [CorporateBond]. */
                class Builder internal constructor() {

                    private var additionalInfo: JsonValue = JsonMissing.of()
                    private var isin: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var value: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(corporateBond: CorporateBond) = apply {
                        additionalInfo = corporateBond.additionalInfo
                        isin = corporateBond.isin
                        name = corporateBond.name
                        units = corporateBond.units
                        value = corporateBond.value
                        additionalProperties = corporateBond.additionalProperties.toMutableMap()
                    }

                    /** Additional information specific to the corporate bond */
                    fun additionalInfo(additionalInfo: JsonValue) = apply {
                        this.additionalInfo = additionalInfo
                    }

                    /** ISIN code of the corporate bond */
                    fun isin(isin: String) = isin(JsonField.of(isin))

                    /**
                     * Sets [Builder.isin] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isin] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                    /** Name of the corporate bond */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /** Number of units held */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

                    /** Current market value of the holding */
                    fun value(value: Float) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Float>) = apply { this.value = value }

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
                     * Returns an immutable instance of [CorporateBond].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): CorporateBond =
                        CorporateBond(
                            additionalInfo,
                            isin,
                            name,
                            units,
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): CorporateBond = apply {
                    if (validated) {
                        return@apply
                    }

                    isin()
                    name()
                    units()
                    value()
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
                    (if (isin.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is CorporateBond &&
                        additionalInfo == other.additionalInfo &&
                        isin == other.isin &&
                        name == other.name &&
                        units == other.units &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(additionalInfo, isin, name, units, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "CorporateBond{additionalInfo=$additionalInfo, isin=$isin, name=$name, units=$units, value=$value, additionalProperties=$additionalProperties}"
            }

            class DematMutualFund
            private constructor(
                private val additionalInfo: JsonValue,
                private val isin: JsonField<String>,
                private val name: JsonField<String>,
                private val units: JsonField<Float>,
                private val value: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("additional_info")
                    @ExcludeMissing
                    additionalInfo: JsonValue = JsonMissing.of(),
                    @JsonProperty("isin")
                    @ExcludeMissing
                    isin: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<Float> = JsonMissing.of(),
                ) : this(additionalInfo, isin, name, units, value, mutableMapOf())

                /** Additional information specific to the mutual fund */
                @JsonProperty("additional_info")
                @ExcludeMissing
                fun _additionalInfo(): JsonValue = additionalInfo

                /**
                 * ISIN code of the mutual fund
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun isin(): Optional<String> = isin.getOptional("isin")

                /**
                 * Name of the mutual fund
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Number of units held
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Current market value of the holding
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<Float> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [isin].
                 *
                 * Unlike [isin], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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
                     * Returns a mutable builder for constructing an instance of [DematMutualFund].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [DematMutualFund]. */
                class Builder internal constructor() {

                    private var additionalInfo: JsonValue = JsonMissing.of()
                    private var isin: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var value: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(dematMutualFund: DematMutualFund) = apply {
                        additionalInfo = dematMutualFund.additionalInfo
                        isin = dematMutualFund.isin
                        name = dematMutualFund.name
                        units = dematMutualFund.units
                        value = dematMutualFund.value
                        additionalProperties = dematMutualFund.additionalProperties.toMutableMap()
                    }

                    /** Additional information specific to the mutual fund */
                    fun additionalInfo(additionalInfo: JsonValue) = apply {
                        this.additionalInfo = additionalInfo
                    }

                    /** ISIN code of the mutual fund */
                    fun isin(isin: String) = isin(JsonField.of(isin))

                    /**
                     * Sets [Builder.isin] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isin] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                    /** Name of the mutual fund */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /** Number of units held */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

                    /** Current market value of the holding */
                    fun value(value: Float) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Float>) = apply { this.value = value }

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
                     * Returns an immutable instance of [DematMutualFund].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): DematMutualFund =
                        DematMutualFund(
                            additionalInfo,
                            isin,
                            name,
                            units,
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): DematMutualFund = apply {
                    if (validated) {
                        return@apply
                    }

                    isin()
                    name()
                    units()
                    value()
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
                    (if (isin.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is DematMutualFund &&
                        additionalInfo == other.additionalInfo &&
                        isin == other.isin &&
                        name == other.name &&
                        units == other.units &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(additionalInfo, isin, name, units, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "DematMutualFund{additionalInfo=$additionalInfo, isin=$isin, name=$name, units=$units, value=$value, additionalProperties=$additionalProperties}"
            }

            class Equity
            private constructor(
                private val additionalInfo: JsonValue,
                private val isin: JsonField<String>,
                private val name: JsonField<String>,
                private val units: JsonField<Float>,
                private val value: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("additional_info")
                    @ExcludeMissing
                    additionalInfo: JsonValue = JsonMissing.of(),
                    @JsonProperty("isin")
                    @ExcludeMissing
                    isin: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<Float> = JsonMissing.of(),
                ) : this(additionalInfo, isin, name, units, value, mutableMapOf())

                /** Additional information specific to the equity */
                @JsonProperty("additional_info")
                @ExcludeMissing
                fun _additionalInfo(): JsonValue = additionalInfo

                /**
                 * ISIN code of the equity
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun isin(): Optional<String> = isin.getOptional("isin")

                /**
                 * Name of the equity
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Number of units held
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Current market value of the holding
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<Float> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [isin].
                 *
                 * Unlike [isin], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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

                    /** Returns a mutable builder for constructing an instance of [Equity]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Equity]. */
                class Builder internal constructor() {

                    private var additionalInfo: JsonValue = JsonMissing.of()
                    private var isin: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var value: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(equity: Equity) = apply {
                        additionalInfo = equity.additionalInfo
                        isin = equity.isin
                        name = equity.name
                        units = equity.units
                        value = equity.value
                        additionalProperties = equity.additionalProperties.toMutableMap()
                    }

                    /** Additional information specific to the equity */
                    fun additionalInfo(additionalInfo: JsonValue) = apply {
                        this.additionalInfo = additionalInfo
                    }

                    /** ISIN code of the equity */
                    fun isin(isin: String) = isin(JsonField.of(isin))

                    /**
                     * Sets [Builder.isin] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isin] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                    /** Name of the equity */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /** Number of units held */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

                    /** Current market value of the holding */
                    fun value(value: Float) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Float>) = apply { this.value = value }

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
                     * Returns an immutable instance of [Equity].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Equity =
                        Equity(
                            additionalInfo,
                            isin,
                            name,
                            units,
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): Equity = apply {
                    if (validated) {
                        return@apply
                    }

                    isin()
                    name()
                    units()
                    value()
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
                    (if (isin.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Equity &&
                        additionalInfo == other.additionalInfo &&
                        isin == other.isin &&
                        name == other.name &&
                        units == other.units &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(additionalInfo, isin, name, units, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Equity{additionalInfo=$additionalInfo, isin=$isin, name=$name, units=$units, value=$value, additionalProperties=$additionalProperties}"
            }

            class GovernmentSecurity
            private constructor(
                private val additionalInfo: JsonValue,
                private val isin: JsonField<String>,
                private val name: JsonField<String>,
                private val units: JsonField<Float>,
                private val value: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("additional_info")
                    @ExcludeMissing
                    additionalInfo: JsonValue = JsonMissing.of(),
                    @JsonProperty("isin")
                    @ExcludeMissing
                    isin: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("name")
                    @ExcludeMissing
                    name: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("value")
                    @ExcludeMissing
                    value: JsonField<Float> = JsonMissing.of(),
                ) : this(additionalInfo, isin, name, units, value, mutableMapOf())

                /** Additional information specific to the government security */
                @JsonProperty("additional_info")
                @ExcludeMissing
                fun _additionalInfo(): JsonValue = additionalInfo

                /**
                 * ISIN code of the government security
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun isin(): Optional<String> = isin.getOptional("isin")

                /**
                 * Name of the government security
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun name(): Optional<String> = name.getOptional("name")

                /**
                 * Number of units held
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Current market value of the holding
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun value(): Optional<Float> = value.getOptional("value")

                /**
                 * Returns the raw JSON value of [isin].
                 *
                 * Unlike [isin], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

                /**
                 * Returns the raw JSON value of [name].
                 *
                 * Unlike [name], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("units") @ExcludeMissing fun _units(): JsonField<Float> = units

                /**
                 * Returns the raw JSON value of [value].
                 *
                 * Unlike [value], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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
                     * [GovernmentSecurity].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [GovernmentSecurity]. */
                class Builder internal constructor() {

                    private var additionalInfo: JsonValue = JsonMissing.of()
                    private var isin: JsonField<String> = JsonMissing.of()
                    private var name: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var value: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(governmentSecurity: GovernmentSecurity) = apply {
                        additionalInfo = governmentSecurity.additionalInfo
                        isin = governmentSecurity.isin
                        name = governmentSecurity.name
                        units = governmentSecurity.units
                        value = governmentSecurity.value
                        additionalProperties =
                            governmentSecurity.additionalProperties.toMutableMap()
                    }

                    /** Additional information specific to the government security */
                    fun additionalInfo(additionalInfo: JsonValue) = apply {
                        this.additionalInfo = additionalInfo
                    }

                    /** ISIN code of the government security */
                    fun isin(isin: String) = isin(JsonField.of(isin))

                    /**
                     * Sets [Builder.isin] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.isin] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                    /** Name of the government security */
                    fun name(name: String) = name(JsonField.of(name))

                    /**
                     * Sets [Builder.name] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.name] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun name(name: JsonField<String>) = apply { this.name = name }

                    /** Number of units held */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

                    /** Current market value of the holding */
                    fun value(value: Float) = value(JsonField.of(value))

                    /**
                     * Sets [Builder.value] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.value] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun value(value: JsonField<Float>) = apply { this.value = value }

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
                     * Returns an immutable instance of [GovernmentSecurity].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): GovernmentSecurity =
                        GovernmentSecurity(
                            additionalInfo,
                            isin,
                            name,
                            units,
                            value,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): GovernmentSecurity = apply {
                    if (validated) {
                        return@apply
                    }

                    isin()
                    name()
                    units()
                    value()
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
                    (if (isin.asKnown().isPresent) 1 else 0) +
                        (if (name.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0) +
                        (if (value.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is GovernmentSecurity &&
                        additionalInfo == other.additionalInfo &&
                        isin == other.isin &&
                        name == other.name &&
                        units == other.units &&
                        value == other.value &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(additionalInfo, isin, name, units, value, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "GovernmentSecurity{additionalInfo=$additionalInfo, isin=$isin, name=$name, units=$units, value=$value, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Holdings &&
                    aifs == other.aifs &&
                    corporateBonds == other.corporateBonds &&
                    dematMutualFunds == other.dematMutualFunds &&
                    equities == other.equities &&
                    governmentSecurities == other.governmentSecurities &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    aifs,
                    corporateBonds,
                    dematMutualFunds,
                    equities,
                    governmentSecurities,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Holdings{aifs=$aifs, corporateBonds=$corporateBonds, dematMutualFunds=$dematMutualFunds, equities=$equities, governmentSecurities=$governmentSecurities, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is DematAccount &&
                additionalInfo == other.additionalInfo &&
                boId == other.boId &&
                clientId == other.clientId &&
                dematType == other.dematType &&
                dpId == other.dpId &&
                dpName == other.dpName &&
                holdings == other.holdings &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                additionalInfo,
                boId,
                clientId,
                dematType,
                dpId,
                dpName,
                holdings,
                value,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "DematAccount{additionalInfo=$additionalInfo, boId=$boId, clientId=$clientId, dematType=$dematType, dpId=$dpId, dpName=$dpName, holdings=$holdings, value=$value, additionalProperties=$additionalProperties}"
    }

    class Insurance
    private constructor(
        private val lifeInsurancePolicies: JsonField<List<LifeInsurancePolicy>>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("life_insurance_policies")
            @ExcludeMissing
            lifeInsurancePolicies: JsonField<List<LifeInsurancePolicy>> = JsonMissing.of()
        ) : this(lifeInsurancePolicies, mutableMapOf())

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun lifeInsurancePolicies(): Optional<List<LifeInsurancePolicy>> =
            lifeInsurancePolicies.getOptional("life_insurance_policies")

        /**
         * Returns the raw JSON value of [lifeInsurancePolicies].
         *
         * Unlike [lifeInsurancePolicies], this method doesn't throw if the JSON field has an
         * unexpected type.
         */
        @JsonProperty("life_insurance_policies")
        @ExcludeMissing
        fun _lifeInsurancePolicies(): JsonField<List<LifeInsurancePolicy>> = lifeInsurancePolicies

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

            /** Returns a mutable builder for constructing an instance of [Insurance]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Insurance]. */
        class Builder internal constructor() {

            private var lifeInsurancePolicies: JsonField<MutableList<LifeInsurancePolicy>>? = null
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(insurance: Insurance) = apply {
                lifeInsurancePolicies = insurance.lifeInsurancePolicies.map { it.toMutableList() }
                additionalProperties = insurance.additionalProperties.toMutableMap()
            }

            fun lifeInsurancePolicies(lifeInsurancePolicies: List<LifeInsurancePolicy>) =
                lifeInsurancePolicies(JsonField.of(lifeInsurancePolicies))

            /**
             * Sets [Builder.lifeInsurancePolicies] to an arbitrary JSON value.
             *
             * You should usually call [Builder.lifeInsurancePolicies] with a well-typed
             * `List<LifeInsurancePolicy>` value instead. This method is primarily for setting the
             * field to an undocumented or not yet supported value.
             */
            fun lifeInsurancePolicies(lifeInsurancePolicies: JsonField<List<LifeInsurancePolicy>>) =
                apply {
                    this.lifeInsurancePolicies = lifeInsurancePolicies.map { it.toMutableList() }
                }

            /**
             * Adds a single [LifeInsurancePolicy] to [lifeInsurancePolicies].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addLifeInsurancePolicy(lifeInsurancePolicy: LifeInsurancePolicy) = apply {
                lifeInsurancePolicies =
                    (lifeInsurancePolicies ?: JsonField.of(mutableListOf())).also {
                        checkKnown("lifeInsurancePolicies", it).add(lifeInsurancePolicy)
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
             * Returns an immutable instance of [Insurance].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Insurance =
                Insurance(
                    (lifeInsurancePolicies ?: JsonMissing.of()).map { it.toImmutable() },
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Insurance = apply {
            if (validated) {
                return@apply
            }

            lifeInsurancePolicies().ifPresent { it.forEach { it.validate() } }
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
            (lifeInsurancePolicies.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0)

        class LifeInsurancePolicy
        private constructor(
            private val additionalInfo: JsonValue,
            private val lifeAssured: JsonField<String>,
            private val policyName: JsonField<String>,
            private val policyNumber: JsonField<String>,
            private val premiumAmount: JsonField<Float>,
            private val premiumFrequency: JsonField<String>,
            private val provider: JsonField<String>,
            private val status: JsonField<String>,
            private val sumAssured: JsonField<Float>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("additional_info")
                @ExcludeMissing
                additionalInfo: JsonValue = JsonMissing.of(),
                @JsonProperty("life_assured")
                @ExcludeMissing
                lifeAssured: JsonField<String> = JsonMissing.of(),
                @JsonProperty("policy_name")
                @ExcludeMissing
                policyName: JsonField<String> = JsonMissing.of(),
                @JsonProperty("policy_number")
                @ExcludeMissing
                policyNumber: JsonField<String> = JsonMissing.of(),
                @JsonProperty("premium_amount")
                @ExcludeMissing
                premiumAmount: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("premium_frequency")
                @ExcludeMissing
                premiumFrequency: JsonField<String> = JsonMissing.of(),
                @JsonProperty("provider")
                @ExcludeMissing
                provider: JsonField<String> = JsonMissing.of(),
                @JsonProperty("status")
                @ExcludeMissing
                status: JsonField<String> = JsonMissing.of(),
                @JsonProperty("sum_assured")
                @ExcludeMissing
                sumAssured: JsonField<Float> = JsonMissing.of(),
            ) : this(
                additionalInfo,
                lifeAssured,
                policyName,
                policyNumber,
                premiumAmount,
                premiumFrequency,
                provider,
                status,
                sumAssured,
                mutableMapOf(),
            )

            /** Additional information specific to the policy */
            @JsonProperty("additional_info")
            @ExcludeMissing
            fun _additionalInfo(): JsonValue = additionalInfo

            /**
             * Name of the life assured
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun lifeAssured(): Optional<String> = lifeAssured.getOptional("life_assured")

            /**
             * Name of the insurance policy
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun policyName(): Optional<String> = policyName.getOptional("policy_name")

            /**
             * Insurance policy number
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun policyNumber(): Optional<String> = policyNumber.getOptional("policy_number")

            /**
             * Premium amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun premiumAmount(): Optional<Float> = premiumAmount.getOptional("premium_amount")

            /**
             * Frequency of premium payment (e.g., Annual, Monthly)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun premiumFrequency(): Optional<String> =
                premiumFrequency.getOptional("premium_frequency")

            /**
             * Insurance company name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun provider(): Optional<String> = provider.getOptional("provider")

            /**
             * Status of the policy (e.g., Active, Lapsed)
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun status(): Optional<String> = status.getOptional("status")

            /**
             * Sum assured amount
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun sumAssured(): Optional<Float> = sumAssured.getOptional("sum_assured")

            /**
             * Returns the raw JSON value of [lifeAssured].
             *
             * Unlike [lifeAssured], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("life_assured")
            @ExcludeMissing
            fun _lifeAssured(): JsonField<String> = lifeAssured

            /**
             * Returns the raw JSON value of [policyName].
             *
             * Unlike [policyName], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("policy_name")
            @ExcludeMissing
            fun _policyName(): JsonField<String> = policyName

            /**
             * Returns the raw JSON value of [policyNumber].
             *
             * Unlike [policyNumber], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("policy_number")
            @ExcludeMissing
            fun _policyNumber(): JsonField<String> = policyNumber

            /**
             * Returns the raw JSON value of [premiumAmount].
             *
             * Unlike [premiumAmount], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("premium_amount")
            @ExcludeMissing
            fun _premiumAmount(): JsonField<Float> = premiumAmount

            /**
             * Returns the raw JSON value of [premiumFrequency].
             *
             * Unlike [premiumFrequency], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("premium_frequency")
            @ExcludeMissing
            fun _premiumFrequency(): JsonField<String> = premiumFrequency

            /**
             * Returns the raw JSON value of [provider].
             *
             * Unlike [provider], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("provider") @ExcludeMissing fun _provider(): JsonField<String> = provider

            /**
             * Returns the raw JSON value of [status].
             *
             * Unlike [status], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("status") @ExcludeMissing fun _status(): JsonField<String> = status

            /**
             * Returns the raw JSON value of [sumAssured].
             *
             * Unlike [sumAssured], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("sum_assured")
            @ExcludeMissing
            fun _sumAssured(): JsonField<Float> = sumAssured

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
                 * Returns a mutable builder for constructing an instance of [LifeInsurancePolicy].
                 */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [LifeInsurancePolicy]. */
            class Builder internal constructor() {

                private var additionalInfo: JsonValue = JsonMissing.of()
                private var lifeAssured: JsonField<String> = JsonMissing.of()
                private var policyName: JsonField<String> = JsonMissing.of()
                private var policyNumber: JsonField<String> = JsonMissing.of()
                private var premiumAmount: JsonField<Float> = JsonMissing.of()
                private var premiumFrequency: JsonField<String> = JsonMissing.of()
                private var provider: JsonField<String> = JsonMissing.of()
                private var status: JsonField<String> = JsonMissing.of()
                private var sumAssured: JsonField<Float> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(lifeInsurancePolicy: LifeInsurancePolicy) = apply {
                    additionalInfo = lifeInsurancePolicy.additionalInfo
                    lifeAssured = lifeInsurancePolicy.lifeAssured
                    policyName = lifeInsurancePolicy.policyName
                    policyNumber = lifeInsurancePolicy.policyNumber
                    premiumAmount = lifeInsurancePolicy.premiumAmount
                    premiumFrequency = lifeInsurancePolicy.premiumFrequency
                    provider = lifeInsurancePolicy.provider
                    status = lifeInsurancePolicy.status
                    sumAssured = lifeInsurancePolicy.sumAssured
                    additionalProperties = lifeInsurancePolicy.additionalProperties.toMutableMap()
                }

                /** Additional information specific to the policy */
                fun additionalInfo(additionalInfo: JsonValue) = apply {
                    this.additionalInfo = additionalInfo
                }

                /** Name of the life assured */
                fun lifeAssured(lifeAssured: String) = lifeAssured(JsonField.of(lifeAssured))

                /**
                 * Sets [Builder.lifeAssured] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.lifeAssured] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun lifeAssured(lifeAssured: JsonField<String>) = apply {
                    this.lifeAssured = lifeAssured
                }

                /** Name of the insurance policy */
                fun policyName(policyName: String) = policyName(JsonField.of(policyName))

                /**
                 * Sets [Builder.policyName] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.policyName] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun policyName(policyName: JsonField<String>) = apply {
                    this.policyName = policyName
                }

                /** Insurance policy number */
                fun policyNumber(policyNumber: String) = policyNumber(JsonField.of(policyNumber))

                /**
                 * Sets [Builder.policyNumber] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.policyNumber] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun policyNumber(policyNumber: JsonField<String>) = apply {
                    this.policyNumber = policyNumber
                }

                /** Premium amount */
                fun premiumAmount(premiumAmount: Float) = premiumAmount(JsonField.of(premiumAmount))

                /**
                 * Sets [Builder.premiumAmount] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.premiumAmount] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun premiumAmount(premiumAmount: JsonField<Float>) = apply {
                    this.premiumAmount = premiumAmount
                }

                /** Frequency of premium payment (e.g., Annual, Monthly) */
                fun premiumFrequency(premiumFrequency: String) =
                    premiumFrequency(JsonField.of(premiumFrequency))

                /**
                 * Sets [Builder.premiumFrequency] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.premiumFrequency] with a well-typed [String]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun premiumFrequency(premiumFrequency: JsonField<String>) = apply {
                    this.premiumFrequency = premiumFrequency
                }

                /** Insurance company name */
                fun provider(provider: String) = provider(JsonField.of(provider))

                /**
                 * Sets [Builder.provider] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.provider] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun provider(provider: JsonField<String>) = apply { this.provider = provider }

                /** Status of the policy (e.g., Active, Lapsed) */
                fun status(status: String) = status(JsonField.of(status))

                /**
                 * Sets [Builder.status] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.status] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun status(status: JsonField<String>) = apply { this.status = status }

                /** Sum assured amount */
                fun sumAssured(sumAssured: Float) = sumAssured(JsonField.of(sumAssured))

                /**
                 * Sets [Builder.sumAssured] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.sumAssured] with a well-typed [Float] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun sumAssured(sumAssured: JsonField<Float>) = apply {
                    this.sumAssured = sumAssured
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
                 * Returns an immutable instance of [LifeInsurancePolicy].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): LifeInsurancePolicy =
                    LifeInsurancePolicy(
                        additionalInfo,
                        lifeAssured,
                        policyName,
                        policyNumber,
                        premiumAmount,
                        premiumFrequency,
                        provider,
                        status,
                        sumAssured,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): LifeInsurancePolicy = apply {
                if (validated) {
                    return@apply
                }

                lifeAssured()
                policyName()
                policyNumber()
                premiumAmount()
                premiumFrequency()
                provider()
                status()
                sumAssured()
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
                (if (lifeAssured.asKnown().isPresent) 1 else 0) +
                    (if (policyName.asKnown().isPresent) 1 else 0) +
                    (if (policyNumber.asKnown().isPresent) 1 else 0) +
                    (if (premiumAmount.asKnown().isPresent) 1 else 0) +
                    (if (premiumFrequency.asKnown().isPresent) 1 else 0) +
                    (if (provider.asKnown().isPresent) 1 else 0) +
                    (if (status.asKnown().isPresent) 1 else 0) +
                    (if (sumAssured.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is LifeInsurancePolicy &&
                    additionalInfo == other.additionalInfo &&
                    lifeAssured == other.lifeAssured &&
                    policyName == other.policyName &&
                    policyNumber == other.policyNumber &&
                    premiumAmount == other.premiumAmount &&
                    premiumFrequency == other.premiumFrequency &&
                    provider == other.provider &&
                    status == other.status &&
                    sumAssured == other.sumAssured &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    additionalInfo,
                    lifeAssured,
                    policyName,
                    policyNumber,
                    premiumAmount,
                    premiumFrequency,
                    provider,
                    status,
                    sumAssured,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "LifeInsurancePolicy{additionalInfo=$additionalInfo, lifeAssured=$lifeAssured, policyName=$policyName, policyNumber=$policyNumber, premiumAmount=$premiumAmount, premiumFrequency=$premiumFrequency, provider=$provider, status=$status, sumAssured=$sumAssured, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Insurance &&
                lifeInsurancePolicies == other.lifeInsurancePolicies &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(lifeInsurancePolicies, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Insurance{lifeInsurancePolicies=$lifeInsurancePolicies, additionalProperties=$additionalProperties}"
    }

    class Investor
    private constructor(
        private val address: JsonField<String>,
        private val casId: JsonField<String>,
        private val email: JsonField<String>,
        private val mobile: JsonField<String>,
        private val name: JsonField<String>,
        private val pan: JsonField<String>,
        private val pincode: JsonField<String>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("address") @ExcludeMissing address: JsonField<String> = JsonMissing.of(),
            @JsonProperty("cas_id") @ExcludeMissing casId: JsonField<String> = JsonMissing.of(),
            @JsonProperty("email") @ExcludeMissing email: JsonField<String> = JsonMissing.of(),
            @JsonProperty("mobile") @ExcludeMissing mobile: JsonField<String> = JsonMissing.of(),
            @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pan") @ExcludeMissing pan: JsonField<String> = JsonMissing.of(),
            @JsonProperty("pincode") @ExcludeMissing pincode: JsonField<String> = JsonMissing.of(),
        ) : this(address, casId, email, mobile, name, pan, pincode, mutableMapOf())

        /**
         * Address of the investor
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun address(): Optional<String> = address.getOptional("address")

        /**
         * CAS ID of the investor (only for NSDL and CDSL)
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun casId(): Optional<String> = casId.getOptional("cas_id")

        /**
         * Email address of the investor
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun email(): Optional<String> = email.getOptional("email")

        /**
         * Mobile number of the investor
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun mobile(): Optional<String> = mobile.getOptional("mobile")

        /**
         * Name of the investor
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun name(): Optional<String> = name.getOptional("name")

        /**
         * PAN (Permanent Account Number) of the investor
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pan(): Optional<String> = pan.getOptional("pan")

        /**
         * Postal code of the investor's address
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun pincode(): Optional<String> = pincode.getOptional("pincode")

        /**
         * Returns the raw JSON value of [address].
         *
         * Unlike [address], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("address") @ExcludeMissing fun _address(): JsonField<String> = address

        /**
         * Returns the raw JSON value of [casId].
         *
         * Unlike [casId], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cas_id") @ExcludeMissing fun _casId(): JsonField<String> = casId

        /**
         * Returns the raw JSON value of [email].
         *
         * Unlike [email], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("email") @ExcludeMissing fun _email(): JsonField<String> = email

        /**
         * Returns the raw JSON value of [mobile].
         *
         * Unlike [mobile], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("mobile") @ExcludeMissing fun _mobile(): JsonField<String> = mobile

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
         * Returns the raw JSON value of [pincode].
         *
         * Unlike [pincode], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("pincode") @ExcludeMissing fun _pincode(): JsonField<String> = pincode

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

            /** Returns a mutable builder for constructing an instance of [Investor]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Investor]. */
        class Builder internal constructor() {

            private var address: JsonField<String> = JsonMissing.of()
            private var casId: JsonField<String> = JsonMissing.of()
            private var email: JsonField<String> = JsonMissing.of()
            private var mobile: JsonField<String> = JsonMissing.of()
            private var name: JsonField<String> = JsonMissing.of()
            private var pan: JsonField<String> = JsonMissing.of()
            private var pincode: JsonField<String> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(investor: Investor) = apply {
                address = investor.address
                casId = investor.casId
                email = investor.email
                mobile = investor.mobile
                name = investor.name
                pan = investor.pan
                pincode = investor.pincode
                additionalProperties = investor.additionalProperties.toMutableMap()
            }

            /** Address of the investor */
            fun address(address: String) = address(JsonField.of(address))

            /**
             * Sets [Builder.address] to an arbitrary JSON value.
             *
             * You should usually call [Builder.address] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun address(address: JsonField<String>) = apply { this.address = address }

            /** CAS ID of the investor (only for NSDL and CDSL) */
            fun casId(casId: String) = casId(JsonField.of(casId))

            /**
             * Sets [Builder.casId] to an arbitrary JSON value.
             *
             * You should usually call [Builder.casId] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun casId(casId: JsonField<String>) = apply { this.casId = casId }

            /** Email address of the investor */
            fun email(email: String) = email(JsonField.of(email))

            /**
             * Sets [Builder.email] to an arbitrary JSON value.
             *
             * You should usually call [Builder.email] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun email(email: JsonField<String>) = apply { this.email = email }

            /** Mobile number of the investor */
            fun mobile(mobile: String) = mobile(JsonField.of(mobile))

            /**
             * Sets [Builder.mobile] to an arbitrary JSON value.
             *
             * You should usually call [Builder.mobile] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun mobile(mobile: JsonField<String>) = apply { this.mobile = mobile }

            /** Name of the investor */
            fun name(name: String) = name(JsonField.of(name))

            /**
             * Sets [Builder.name] to an arbitrary JSON value.
             *
             * You should usually call [Builder.name] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun name(name: JsonField<String>) = apply { this.name = name }

            /** PAN (Permanent Account Number) of the investor */
            fun pan(pan: String) = pan(JsonField.of(pan))

            /**
             * Sets [Builder.pan] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pan] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun pan(pan: JsonField<String>) = apply { this.pan = pan }

            /** Postal code of the investor's address */
            fun pincode(pincode: String) = pincode(JsonField.of(pincode))

            /**
             * Sets [Builder.pincode] to an arbitrary JSON value.
             *
             * You should usually call [Builder.pincode] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun pincode(pincode: JsonField<String>) = apply { this.pincode = pincode }

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
             * Returns an immutable instance of [Investor].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Investor =
                Investor(
                    address,
                    casId,
                    email,
                    mobile,
                    name,
                    pan,
                    pincode,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): Investor = apply {
            if (validated) {
                return@apply
            }

            address()
            casId()
            email()
            mobile()
            name()
            pan()
            pincode()
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
                (if (casId.asKnown().isPresent) 1 else 0) +
                (if (email.asKnown().isPresent) 1 else 0) +
                (if (mobile.asKnown().isPresent) 1 else 0) +
                (if (name.asKnown().isPresent) 1 else 0) +
                (if (pan.asKnown().isPresent) 1 else 0) +
                (if (pincode.asKnown().isPresent) 1 else 0)

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Investor &&
                address == other.address &&
                casId == other.casId &&
                email == other.email &&
                mobile == other.mobile &&
                name == other.name &&
                pan == other.pan &&
                pincode == other.pincode &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(address, casId, email, mobile, name, pan, pincode, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Investor{address=$address, casId=$casId, email=$email, mobile=$mobile, name=$name, pan=$pan, pincode=$pincode, additionalProperties=$additionalProperties}"
    }

    class Meta
    private constructor(
        private val casType: JsonField<CasType>,
        private val generatedAt: JsonField<OffsetDateTime>,
        private val statementPeriod: JsonField<StatementPeriod>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("cas_type")
            @ExcludeMissing
            casType: JsonField<CasType> = JsonMissing.of(),
            @JsonProperty("generated_at")
            @ExcludeMissing
            generatedAt: JsonField<OffsetDateTime> = JsonMissing.of(),
            @JsonProperty("statement_period")
            @ExcludeMissing
            statementPeriod: JsonField<StatementPeriod> = JsonMissing.of(),
        ) : this(casType, generatedAt, statementPeriod, mutableMapOf())

        /**
         * Type of CAS detected and processed
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun casType(): Optional<CasType> = casType.getOptional("cas_type")

        /**
         * Timestamp when the response was generated
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun generatedAt(): Optional<OffsetDateTime> = generatedAt.getOptional("generated_at")

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun statementPeriod(): Optional<StatementPeriod> =
            statementPeriod.getOptional("statement_period")

        /**
         * Returns the raw JSON value of [casType].
         *
         * Unlike [casType], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("cas_type") @ExcludeMissing fun _casType(): JsonField<CasType> = casType

        /**
         * Returns the raw JSON value of [generatedAt].
         *
         * Unlike [generatedAt], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("generated_at")
        @ExcludeMissing
        fun _generatedAt(): JsonField<OffsetDateTime> = generatedAt

        /**
         * Returns the raw JSON value of [statementPeriod].
         *
         * Unlike [statementPeriod], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("statement_period")
        @ExcludeMissing
        fun _statementPeriod(): JsonField<StatementPeriod> = statementPeriod

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

            /** Returns a mutable builder for constructing an instance of [Meta]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Meta]. */
        class Builder internal constructor() {

            private var casType: JsonField<CasType> = JsonMissing.of()
            private var generatedAt: JsonField<OffsetDateTime> = JsonMissing.of()
            private var statementPeriod: JsonField<StatementPeriod> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(meta: Meta) = apply {
                casType = meta.casType
                generatedAt = meta.generatedAt
                statementPeriod = meta.statementPeriod
                additionalProperties = meta.additionalProperties.toMutableMap()
            }

            /** Type of CAS detected and processed */
            fun casType(casType: CasType) = casType(JsonField.of(casType))

            /**
             * Sets [Builder.casType] to an arbitrary JSON value.
             *
             * You should usually call [Builder.casType] with a well-typed [CasType] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun casType(casType: JsonField<CasType>) = apply { this.casType = casType }

            /** Timestamp when the response was generated */
            fun generatedAt(generatedAt: OffsetDateTime) = generatedAt(JsonField.of(generatedAt))

            /**
             * Sets [Builder.generatedAt] to an arbitrary JSON value.
             *
             * You should usually call [Builder.generatedAt] with a well-typed [OffsetDateTime]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun generatedAt(generatedAt: JsonField<OffsetDateTime>) = apply {
                this.generatedAt = generatedAt
            }

            fun statementPeriod(statementPeriod: StatementPeriod) =
                statementPeriod(JsonField.of(statementPeriod))

            /**
             * Sets [Builder.statementPeriod] to an arbitrary JSON value.
             *
             * You should usually call [Builder.statementPeriod] with a well-typed [StatementPeriod]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun statementPeriod(statementPeriod: JsonField<StatementPeriod>) = apply {
                this.statementPeriod = statementPeriod
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
             * Returns an immutable instance of [Meta].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Meta =
                Meta(casType, generatedAt, statementPeriod, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Meta = apply {
            if (validated) {
                return@apply
            }

            casType().ifPresent { it.validate() }
            generatedAt()
            statementPeriod().ifPresent { it.validate() }
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
            (casType.asKnown().getOrNull()?.validity() ?: 0) +
                (if (generatedAt.asKnown().isPresent) 1 else 0) +
                (statementPeriod.asKnown().getOrNull()?.validity() ?: 0)

        /** Type of CAS detected and processed */
        class CasType @JsonCreator private constructor(private val value: JsonField<String>) :
            Enum {

            /**
             * Returns this class instance's raw value.
             *
             * This is usually only useful if this instance was deserialized from data that doesn't
             * match any known member, and you want to know that value. For example, if the SDK is
             * on an older version than the API, then the API may respond with new members that the
             * SDK is unaware of.
             */
            @com.fasterxml.jackson.annotation.JsonValue fun _value(): JsonField<String> = value

            companion object {

                @JvmField val NSDL = of("NSDL")

                @JvmField val CDSL = of("CDSL")

                @JvmField val CAMS_KFINTECH = of("CAMS_KFINTECH")

                @JvmStatic fun of(value: String) = CasType(JsonField.of(value))
            }

            /** An enum containing [CasType]'s known values. */
            enum class Known {
                NSDL,
                CDSL,
                CAMS_KFINTECH,
            }

            /**
             * An enum containing [CasType]'s known values, as well as an [_UNKNOWN] member.
             *
             * An instance of [CasType] can contain an unknown value in a couple of cases:
             * - It was deserialized from data that doesn't match any known member. For example, if
             *   the SDK is on an older version than the API, then the API may respond with new
             *   members that the SDK is unaware of.
             * - It was constructed with an arbitrary value using the [of] method.
             */
            enum class Value {
                NSDL,
                CDSL,
                CAMS_KFINTECH,
                /**
                 * An enum member indicating that [CasType] was instantiated with an unknown value.
                 */
                _UNKNOWN,
            }

            /**
             * Returns an enum member corresponding to this class instance's value, or
             * [Value._UNKNOWN] if the class was instantiated with an unknown value.
             *
             * Use the [known] method instead if you're certain the value is always known or if you
             * want to throw for the unknown case.
             */
            fun value(): Value =
                when (this) {
                    NSDL -> Value.NSDL
                    CDSL -> Value.CDSL
                    CAMS_KFINTECH -> Value.CAMS_KFINTECH
                    else -> Value._UNKNOWN
                }

            /**
             * Returns an enum member corresponding to this class instance's value.
             *
             * Use the [value] method instead if you're uncertain the value is always known and
             * don't want to throw for the unknown case.
             *
             * @throws CasParserInvalidDataException if this class instance's value is a not a known
             *   member.
             */
            fun known(): Known =
                when (this) {
                    NSDL -> Known.NSDL
                    CDSL -> Known.CDSL
                    CAMS_KFINTECH -> Known.CAMS_KFINTECH
                    else -> throw CasParserInvalidDataException("Unknown CasType: $value")
                }

            /**
             * Returns this class instance's primitive wire representation.
             *
             * This differs from the [toString] method because that method is primarily for
             * debugging and generally doesn't throw.
             *
             * @throws CasParserInvalidDataException if this class instance's value does not have
             *   the expected primitive type.
             */
            fun asString(): String =
                _value().asString().orElseThrow {
                    CasParserInvalidDataException("Value is not a String")
                }

            private var validated: Boolean = false

            fun validate(): CasType = apply {
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

                return other is CasType && value == other.value
            }

            override fun hashCode() = value.hashCode()

            override fun toString() = value.toString()
        }

        class StatementPeriod
        private constructor(
            private val from: JsonField<LocalDate>,
            private val to: JsonField<LocalDate>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("from") @ExcludeMissing from: JsonField<LocalDate> = JsonMissing.of(),
                @JsonProperty("to") @ExcludeMissing to: JsonField<LocalDate> = JsonMissing.of(),
            ) : this(from, to, mutableMapOf())

            /**
             * Start date of the statement period
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun from(): Optional<LocalDate> = from.getOptional("from")

            /**
             * End date of the statement period
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun to(): Optional<LocalDate> = to.getOptional("to")

            /**
             * Returns the raw JSON value of [from].
             *
             * Unlike [from], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("from") @ExcludeMissing fun _from(): JsonField<LocalDate> = from

            /**
             * Returns the raw JSON value of [to].
             *
             * Unlike [to], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("to") @ExcludeMissing fun _to(): JsonField<LocalDate> = to

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

                /** Returns a mutable builder for constructing an instance of [StatementPeriod]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [StatementPeriod]. */
            class Builder internal constructor() {

                private var from: JsonField<LocalDate> = JsonMissing.of()
                private var to: JsonField<LocalDate> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(statementPeriod: StatementPeriod) = apply {
                    from = statementPeriod.from
                    to = statementPeriod.to
                    additionalProperties = statementPeriod.additionalProperties.toMutableMap()
                }

                /** Start date of the statement period */
                fun from(from: LocalDate) = from(JsonField.of(from))

                /**
                 * Sets [Builder.from] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.from] with a well-typed [LocalDate] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun from(from: JsonField<LocalDate>) = apply { this.from = from }

                /** End date of the statement period */
                fun to(to: LocalDate) = to(JsonField.of(to))

                /**
                 * Sets [Builder.to] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.to] with a well-typed [LocalDate] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun to(to: JsonField<LocalDate>) = apply { this.to = to }

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
                 * Returns an immutable instance of [StatementPeriod].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): StatementPeriod =
                    StatementPeriod(from, to, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): StatementPeriod = apply {
                if (validated) {
                    return@apply
                }

                from()
                to()
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
                (if (from.asKnown().isPresent) 1 else 0) + (if (to.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is StatementPeriod &&
                    from == other.from &&
                    to == other.to &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy { Objects.hash(from, to, additionalProperties) }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "StatementPeriod{from=$from, to=$to, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Meta &&
                casType == other.casType &&
                generatedAt == other.generatedAt &&
                statementPeriod == other.statementPeriod &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(casType, generatedAt, statementPeriod, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Meta{casType=$casType, generatedAt=$generatedAt, statementPeriod=$statementPeriod, additionalProperties=$additionalProperties}"
    }

    class MutualFund
    private constructor(
        private val additionalInfo: JsonField<AdditionalInfo>,
        private val amc: JsonField<String>,
        private val folioNumber: JsonField<String>,
        private val registrar: JsonField<String>,
        private val schemes: JsonField<List<Scheme>>,
        private val value: JsonField<Float>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("additional_info")
            @ExcludeMissing
            additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of(),
            @JsonProperty("amc") @ExcludeMissing amc: JsonField<String> = JsonMissing.of(),
            @JsonProperty("folio_number")
            @ExcludeMissing
            folioNumber: JsonField<String> = JsonMissing.of(),
            @JsonProperty("registrar")
            @ExcludeMissing
            registrar: JsonField<String> = JsonMissing.of(),
            @JsonProperty("schemes")
            @ExcludeMissing
            schemes: JsonField<List<Scheme>> = JsonMissing.of(),
            @JsonProperty("value") @ExcludeMissing value: JsonField<Float> = JsonMissing.of(),
        ) : this(additionalInfo, amc, folioNumber, registrar, schemes, value, mutableMapOf())

        /**
         * Additional folio information
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun additionalInfo(): Optional<AdditionalInfo> =
            additionalInfo.getOptional("additional_info")

        /**
         * Asset Management Company name
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun amc(): Optional<String> = amc.getOptional("amc")

        /**
         * Folio number
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun folioNumber(): Optional<String> = folioNumber.getOptional("folio_number")

        /**
         * Registrar and Transfer Agent name
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun registrar(): Optional<String> = registrar.getOptional("registrar")

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun schemes(): Optional<List<Scheme>> = schemes.getOptional("schemes")

        /**
         * Total value of the folio
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun value(): Optional<Float> = value.getOptional("value")

        /**
         * Returns the raw JSON value of [additionalInfo].
         *
         * Unlike [additionalInfo], this method doesn't throw if the JSON field has an unexpected
         * type.
         */
        @JsonProperty("additional_info")
        @ExcludeMissing
        fun _additionalInfo(): JsonField<AdditionalInfo> = additionalInfo

        /**
         * Returns the raw JSON value of [amc].
         *
         * Unlike [amc], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("amc") @ExcludeMissing fun _amc(): JsonField<String> = amc

        /**
         * Returns the raw JSON value of [folioNumber].
         *
         * Unlike [folioNumber], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("folio_number")
        @ExcludeMissing
        fun _folioNumber(): JsonField<String> = folioNumber

        /**
         * Returns the raw JSON value of [registrar].
         *
         * Unlike [registrar], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("registrar") @ExcludeMissing fun _registrar(): JsonField<String> = registrar

        /**
         * Returns the raw JSON value of [schemes].
         *
         * Unlike [schemes], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("schemes") @ExcludeMissing fun _schemes(): JsonField<List<Scheme>> = schemes

        /**
         * Returns the raw JSON value of [value].
         *
         * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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

            /** Returns a mutable builder for constructing an instance of [MutualFund]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [MutualFund]. */
        class Builder internal constructor() {

            private var additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of()
            private var amc: JsonField<String> = JsonMissing.of()
            private var folioNumber: JsonField<String> = JsonMissing.of()
            private var registrar: JsonField<String> = JsonMissing.of()
            private var schemes: JsonField<MutableList<Scheme>>? = null
            private var value: JsonField<Float> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(mutualFund: MutualFund) = apply {
                additionalInfo = mutualFund.additionalInfo
                amc = mutualFund.amc
                folioNumber = mutualFund.folioNumber
                registrar = mutualFund.registrar
                schemes = mutualFund.schemes.map { it.toMutableList() }
                value = mutualFund.value
                additionalProperties = mutualFund.additionalProperties.toMutableMap()
            }

            /** Additional folio information */
            fun additionalInfo(additionalInfo: AdditionalInfo) =
                additionalInfo(JsonField.of(additionalInfo))

            /**
             * Sets [Builder.additionalInfo] to an arbitrary JSON value.
             *
             * You should usually call [Builder.additionalInfo] with a well-typed [AdditionalInfo]
             * value instead. This method is primarily for setting the field to an undocumented or
             * not yet supported value.
             */
            fun additionalInfo(additionalInfo: JsonField<AdditionalInfo>) = apply {
                this.additionalInfo = additionalInfo
            }

            /** Asset Management Company name */
            fun amc(amc: String) = amc(JsonField.of(amc))

            /**
             * Sets [Builder.amc] to an arbitrary JSON value.
             *
             * You should usually call [Builder.amc] with a well-typed [String] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun amc(amc: JsonField<String>) = apply { this.amc = amc }

            /** Folio number */
            fun folioNumber(folioNumber: String) = folioNumber(JsonField.of(folioNumber))

            /**
             * Sets [Builder.folioNumber] to an arbitrary JSON value.
             *
             * You should usually call [Builder.folioNumber] with a well-typed [String] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun folioNumber(folioNumber: JsonField<String>) = apply {
                this.folioNumber = folioNumber
            }

            /** Registrar and Transfer Agent name */
            fun registrar(registrar: String) = registrar(JsonField.of(registrar))

            /**
             * Sets [Builder.registrar] to an arbitrary JSON value.
             *
             * You should usually call [Builder.registrar] with a well-typed [String] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun registrar(registrar: JsonField<String>) = apply { this.registrar = registrar }

            fun schemes(schemes: List<Scheme>) = schemes(JsonField.of(schemes))

            /**
             * Sets [Builder.schemes] to an arbitrary JSON value.
             *
             * You should usually call [Builder.schemes] with a well-typed `List<Scheme>` value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun schemes(schemes: JsonField<List<Scheme>>) = apply {
                this.schemes = schemes.map { it.toMutableList() }
            }

            /**
             * Adds a single [Scheme] to [schemes].
             *
             * @throws IllegalStateException if the field was previously set to a non-list.
             */
            fun addScheme(scheme: Scheme) = apply {
                schemes =
                    (schemes ?: JsonField.of(mutableListOf())).also {
                        checkKnown("schemes", it).add(scheme)
                    }
            }

            /** Total value of the folio */
            fun value(value: Float) = value(JsonField.of(value))

            /**
             * Sets [Builder.value] to an arbitrary JSON value.
             *
             * You should usually call [Builder.value] with a well-typed [Float] value instead. This
             * method is primarily for setting the field to an undocumented or not yet supported
             * value.
             */
            fun value(value: JsonField<Float>) = apply { this.value = value }

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
             * Returns an immutable instance of [MutualFund].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): MutualFund =
                MutualFund(
                    additionalInfo,
                    amc,
                    folioNumber,
                    registrar,
                    (schemes ?: JsonMissing.of()).map { it.toImmutable() },
                    value,
                    additionalProperties.toMutableMap(),
                )
        }

        private var validated: Boolean = false

        fun validate(): MutualFund = apply {
            if (validated) {
                return@apply
            }

            additionalInfo().ifPresent { it.validate() }
            amc()
            folioNumber()
            registrar()
            schemes().ifPresent { it.forEach { it.validate() } }
            value()
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
            (additionalInfo.asKnown().getOrNull()?.validity() ?: 0) +
                (if (amc.asKnown().isPresent) 1 else 0) +
                (if (folioNumber.asKnown().isPresent) 1 else 0) +
                (if (registrar.asKnown().isPresent) 1 else 0) +
                (schemes.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                (if (value.asKnown().isPresent) 1 else 0)

        /** Additional folio information */
        class AdditionalInfo
        private constructor(
            private val kyc: JsonField<String>,
            private val pan: JsonField<String>,
            private val pankyc: JsonField<String>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("kyc") @ExcludeMissing kyc: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pan") @ExcludeMissing pan: JsonField<String> = JsonMissing.of(),
                @JsonProperty("pankyc") @ExcludeMissing pankyc: JsonField<String> = JsonMissing.of(),
            ) : this(kyc, pan, pankyc, mutableMapOf())

            /**
             * KYC status of the folio
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun kyc(): Optional<String> = kyc.getOptional("kyc")

            /**
             * PAN associated with the folio
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun pan(): Optional<String> = pan.getOptional("pan")

            /**
             * PAN KYC status
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun pankyc(): Optional<String> = pankyc.getOptional("pankyc")

            /**
             * Returns the raw JSON value of [kyc].
             *
             * Unlike [kyc], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("kyc") @ExcludeMissing fun _kyc(): JsonField<String> = kyc

            /**
             * Returns the raw JSON value of [pan].
             *
             * Unlike [pan], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("pan") @ExcludeMissing fun _pan(): JsonField<String> = pan

            /**
             * Returns the raw JSON value of [pankyc].
             *
             * Unlike [pankyc], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("pankyc") @ExcludeMissing fun _pankyc(): JsonField<String> = pankyc

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

                private var kyc: JsonField<String> = JsonMissing.of()
                private var pan: JsonField<String> = JsonMissing.of()
                private var pankyc: JsonField<String> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(additionalInfo: AdditionalInfo) = apply {
                    kyc = additionalInfo.kyc
                    pan = additionalInfo.pan
                    pankyc = additionalInfo.pankyc
                    additionalProperties = additionalInfo.additionalProperties.toMutableMap()
                }

                /** KYC status of the folio */
                fun kyc(kyc: String) = kyc(JsonField.of(kyc))

                /**
                 * Sets [Builder.kyc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.kyc] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun kyc(kyc: JsonField<String>) = apply { this.kyc = kyc }

                /** PAN associated with the folio */
                fun pan(pan: String) = pan(JsonField.of(pan))

                /**
                 * Sets [Builder.pan] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pan] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun pan(pan: JsonField<String>) = apply { this.pan = pan }

                /** PAN KYC status */
                fun pankyc(pankyc: String) = pankyc(JsonField.of(pankyc))

                /**
                 * Sets [Builder.pankyc] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.pankyc] with a well-typed [String] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun pankyc(pankyc: JsonField<String>) = apply { this.pankyc = pankyc }

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
                 * Returns an immutable instance of [AdditionalInfo].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): AdditionalInfo =
                    AdditionalInfo(kyc, pan, pankyc, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): AdditionalInfo = apply {
                if (validated) {
                    return@apply
                }

                kyc()
                pan()
                pankyc()
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
                (if (kyc.asKnown().isPresent) 1 else 0) +
                    (if (pan.asKnown().isPresent) 1 else 0) +
                    (if (pankyc.asKnown().isPresent) 1 else 0)

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is AdditionalInfo &&
                    kyc == other.kyc &&
                    pan == other.pan &&
                    pankyc == other.pankyc &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(kyc, pan, pankyc, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "AdditionalInfo{kyc=$kyc, pan=$pan, pankyc=$pankyc, additionalProperties=$additionalProperties}"
        }

        class Scheme
        private constructor(
            private val additionalInfo: JsonField<AdditionalInfo>,
            private val cost: JsonField<Float>,
            private val gain: JsonField<Gain>,
            private val isin: JsonField<String>,
            private val name: JsonField<String>,
            private val nav: JsonField<Float>,
            private val nominees: JsonField<List<String>>,
            private val transactions: JsonField<List<Transaction>>,
            private val type: JsonField<Type>,
            private val units: JsonField<Float>,
            private val value: JsonField<Float>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("additional_info")
                @ExcludeMissing
                additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of(),
                @JsonProperty("cost") @ExcludeMissing cost: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("gain") @ExcludeMissing gain: JsonField<Gain> = JsonMissing.of(),
                @JsonProperty("isin") @ExcludeMissing isin: JsonField<String> = JsonMissing.of(),
                @JsonProperty("name") @ExcludeMissing name: JsonField<String> = JsonMissing.of(),
                @JsonProperty("nav") @ExcludeMissing nav: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("nominees")
                @ExcludeMissing
                nominees: JsonField<List<String>> = JsonMissing.of(),
                @JsonProperty("transactions")
                @ExcludeMissing
                transactions: JsonField<List<Transaction>> = JsonMissing.of(),
                @JsonProperty("type") @ExcludeMissing type: JsonField<Type> = JsonMissing.of(),
                @JsonProperty("units") @ExcludeMissing units: JsonField<Float> = JsonMissing.of(),
                @JsonProperty("value") @ExcludeMissing value: JsonField<Float> = JsonMissing.of(),
            ) : this(
                additionalInfo,
                cost,
                gain,
                isin,
                name,
                nav,
                nominees,
                transactions,
                type,
                units,
                value,
                mutableMapOf(),
            )

            /**
             * Additional information specific to the scheme
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun additionalInfo(): Optional<AdditionalInfo> =
                additionalInfo.getOptional("additional_info")

            /**
             * Cost of investment
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun cost(): Optional<Float> = cost.getOptional("cost")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun gain(): Optional<Gain> = gain.getOptional("gain")

            /**
             * ISIN code of the scheme
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun isin(): Optional<String> = isin.getOptional("isin")

            /**
             * Scheme name
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun name(): Optional<String> = name.getOptional("name")

            /**
             * Net Asset Value per unit
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun nav(): Optional<Float> = nav.getOptional("nav")

            /**
             * List of nominees
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun nominees(): Optional<List<String>> = nominees.getOptional("nominees")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun transactions(): Optional<List<Transaction>> =
                transactions.getOptional("transactions")

            /**
             * Type of mutual fund scheme
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun type(): Optional<Type> = type.getOptional("type")

            /**
             * Number of units held
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun units(): Optional<Float> = units.getOptional("units")

            /**
             * Current market value of the holding
             *
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun value(): Optional<Float> = value.getOptional("value")

            /**
             * Returns the raw JSON value of [additionalInfo].
             *
             * Unlike [additionalInfo], this method doesn't throw if the JSON field has an
             * unexpected type.
             */
            @JsonProperty("additional_info")
            @ExcludeMissing
            fun _additionalInfo(): JsonField<AdditionalInfo> = additionalInfo

            /**
             * Returns the raw JSON value of [cost].
             *
             * Unlike [cost], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("cost") @ExcludeMissing fun _cost(): JsonField<Float> = cost

            /**
             * Returns the raw JSON value of [gain].
             *
             * Unlike [gain], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("gain") @ExcludeMissing fun _gain(): JsonField<Gain> = gain

            /**
             * Returns the raw JSON value of [isin].
             *
             * Unlike [isin], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("isin") @ExcludeMissing fun _isin(): JsonField<String> = isin

            /**
             * Returns the raw JSON value of [name].
             *
             * Unlike [name], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("name") @ExcludeMissing fun _name(): JsonField<String> = name

            /**
             * Returns the raw JSON value of [nav].
             *
             * Unlike [nav], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("nav") @ExcludeMissing fun _nav(): JsonField<Float> = nav

            /**
             * Returns the raw JSON value of [nominees].
             *
             * Unlike [nominees], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("nominees")
            @ExcludeMissing
            fun _nominees(): JsonField<List<String>> = nominees

            /**
             * Returns the raw JSON value of [transactions].
             *
             * Unlike [transactions], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("transactions")
            @ExcludeMissing
            fun _transactions(): JsonField<List<Transaction>> = transactions

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

            /**
             * Returns the raw JSON value of [value].
             *
             * Unlike [value], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("value") @ExcludeMissing fun _value(): JsonField<Float> = value

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

                /** Returns a mutable builder for constructing an instance of [Scheme]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Scheme]. */
            class Builder internal constructor() {

                private var additionalInfo: JsonField<AdditionalInfo> = JsonMissing.of()
                private var cost: JsonField<Float> = JsonMissing.of()
                private var gain: JsonField<Gain> = JsonMissing.of()
                private var isin: JsonField<String> = JsonMissing.of()
                private var name: JsonField<String> = JsonMissing.of()
                private var nav: JsonField<Float> = JsonMissing.of()
                private var nominees: JsonField<MutableList<String>>? = null
                private var transactions: JsonField<MutableList<Transaction>>? = null
                private var type: JsonField<Type> = JsonMissing.of()
                private var units: JsonField<Float> = JsonMissing.of()
                private var value: JsonField<Float> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(scheme: Scheme) = apply {
                    additionalInfo = scheme.additionalInfo
                    cost = scheme.cost
                    gain = scheme.gain
                    isin = scheme.isin
                    name = scheme.name
                    nav = scheme.nav
                    nominees = scheme.nominees.map { it.toMutableList() }
                    transactions = scheme.transactions.map { it.toMutableList() }
                    type = scheme.type
                    units = scheme.units
                    value = scheme.value
                    additionalProperties = scheme.additionalProperties.toMutableMap()
                }

                /** Additional information specific to the scheme */
                fun additionalInfo(additionalInfo: AdditionalInfo) =
                    additionalInfo(JsonField.of(additionalInfo))

                /**
                 * Sets [Builder.additionalInfo] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.additionalInfo] with a well-typed
                 * [AdditionalInfo] value instead. This method is primarily for setting the field to
                 * an undocumented or not yet supported value.
                 */
                fun additionalInfo(additionalInfo: JsonField<AdditionalInfo>) = apply {
                    this.additionalInfo = additionalInfo
                }

                /** Cost of investment */
                fun cost(cost: Float) = cost(JsonField.of(cost))

                /**
                 * Sets [Builder.cost] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.cost] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun cost(cost: JsonField<Float>) = apply { this.cost = cost }

                fun gain(gain: Gain) = gain(JsonField.of(gain))

                /**
                 * Sets [Builder.gain] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.gain] with a well-typed [Gain] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun gain(gain: JsonField<Gain>) = apply { this.gain = gain }

                /** ISIN code of the scheme */
                fun isin(isin: String) = isin(JsonField.of(isin))

                /**
                 * Sets [Builder.isin] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.isin] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun isin(isin: JsonField<String>) = apply { this.isin = isin }

                /** Scheme name */
                fun name(name: String) = name(JsonField.of(name))

                /**
                 * Sets [Builder.name] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.name] with a well-typed [String] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun name(name: JsonField<String>) = apply { this.name = name }

                /** Net Asset Value per unit */
                fun nav(nav: Float) = nav(JsonField.of(nav))

                /**
                 * Sets [Builder.nav] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.nav] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun nav(nav: JsonField<Float>) = apply { this.nav = nav }

                /** List of nominees */
                fun nominees(nominees: List<String>) = nominees(JsonField.of(nominees))

                /**
                 * Sets [Builder.nominees] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.nominees] with a well-typed `List<String>` value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun nominees(nominees: JsonField<List<String>>) = apply {
                    this.nominees = nominees.map { it.toMutableList() }
                }

                /**
                 * Adds a single [String] to [nominees].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addNominee(nominee: String) = apply {
                    nominees =
                        (nominees ?: JsonField.of(mutableListOf())).also {
                            checkKnown("nominees", it).add(nominee)
                        }
                }

                fun transactions(transactions: List<Transaction>) =
                    transactions(JsonField.of(transactions))

                /**
                 * Sets [Builder.transactions] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.transactions] with a well-typed
                 * `List<Transaction>` value instead. This method is primarily for setting the field
                 * to an undocumented or not yet supported value.
                 */
                fun transactions(transactions: JsonField<List<Transaction>>) = apply {
                    this.transactions = transactions.map { it.toMutableList() }
                }

                /**
                 * Adds a single [Transaction] to [transactions].
                 *
                 * @throws IllegalStateException if the field was previously set to a non-list.
                 */
                fun addTransaction(transaction: Transaction) = apply {
                    transactions =
                        (transactions ?: JsonField.of(mutableListOf())).also {
                            checkKnown("transactions", it).add(transaction)
                        }
                }

                /** Type of mutual fund scheme */
                fun type(type: Type) = type(JsonField.of(type))

                /**
                 * Sets [Builder.type] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.type] with a well-typed [Type] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun type(type: JsonField<Type>) = apply { this.type = type }

                /** Number of units held */
                fun units(units: Float) = units(JsonField.of(units))

                /**
                 * Sets [Builder.units] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.units] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun units(units: JsonField<Float>) = apply { this.units = units }

                /** Current market value of the holding */
                fun value(value: Float) = value(JsonField.of(value))

                /**
                 * Sets [Builder.value] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.value] with a well-typed [Float] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun value(value: JsonField<Float>) = apply { this.value = value }

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
                 * Returns an immutable instance of [Scheme].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Scheme =
                    Scheme(
                        additionalInfo,
                        cost,
                        gain,
                        isin,
                        name,
                        nav,
                        (nominees ?: JsonMissing.of()).map { it.toImmutable() },
                        (transactions ?: JsonMissing.of()).map { it.toImmutable() },
                        type,
                        units,
                        value,
                        additionalProperties.toMutableMap(),
                    )
            }

            private var validated: Boolean = false

            fun validate(): Scheme = apply {
                if (validated) {
                    return@apply
                }

                additionalInfo().ifPresent { it.validate() }
                cost()
                gain().ifPresent { it.validate() }
                isin()
                name()
                nav()
                nominees()
                transactions().ifPresent { it.forEach { it.validate() } }
                type().ifPresent { it.validate() }
                units()
                value()
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
                (additionalInfo.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (cost.asKnown().isPresent) 1 else 0) +
                    (gain.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (isin.asKnown().isPresent) 1 else 0) +
                    (if (name.asKnown().isPresent) 1 else 0) +
                    (if (nav.asKnown().isPresent) 1 else 0) +
                    (nominees.asKnown().getOrNull()?.size ?: 0) +
                    (transactions.asKnown().getOrNull()?.sumOf { it.validity().toInt() } ?: 0) +
                    (type.asKnown().getOrNull()?.validity() ?: 0) +
                    (if (units.asKnown().isPresent) 1 else 0) +
                    (if (value.asKnown().isPresent) 1 else 0)

            /** Additional information specific to the scheme */
            class AdditionalInfo
            private constructor(
                private val advisor: JsonField<String>,
                private val amfi: JsonField<String>,
                private val closeUnits: JsonField<Float>,
                private val openUnits: JsonField<Float>,
                private val rtaCode: JsonField<String>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("advisor")
                    @ExcludeMissing
                    advisor: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("amfi")
                    @ExcludeMissing
                    amfi: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("close_units")
                    @ExcludeMissing
                    closeUnits: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("open_units")
                    @ExcludeMissing
                    openUnits: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("rta_code")
                    @ExcludeMissing
                    rtaCode: JsonField<String> = JsonMissing.of(),
                ) : this(advisor, amfi, closeUnits, openUnits, rtaCode, mutableMapOf())

                /**
                 * Financial advisor name (CAMS/KFintech)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun advisor(): Optional<String> = advisor.getOptional("advisor")

                /**
                 * AMFI code for the scheme (CAMS/KFintech)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun amfi(): Optional<String> = amfi.getOptional("amfi")

                /**
                 * Closing balance units (CAMS/KFintech)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun closeUnits(): Optional<Float> = closeUnits.getOptional("close_units")

                /**
                 * Opening balance units (CAMS/KFintech)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun openUnits(): Optional<Float> = openUnits.getOptional("open_units")

                /**
                 * RTA code for the scheme (CAMS/KFintech)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun rtaCode(): Optional<String> = rtaCode.getOptional("rta_code")

                /**
                 * Returns the raw JSON value of [advisor].
                 *
                 * Unlike [advisor], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("advisor") @ExcludeMissing fun _advisor(): JsonField<String> = advisor

                /**
                 * Returns the raw JSON value of [amfi].
                 *
                 * Unlike [amfi], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("amfi") @ExcludeMissing fun _amfi(): JsonField<String> = amfi

                /**
                 * Returns the raw JSON value of [closeUnits].
                 *
                 * Unlike [closeUnits], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("close_units")
                @ExcludeMissing
                fun _closeUnits(): JsonField<Float> = closeUnits

                /**
                 * Returns the raw JSON value of [openUnits].
                 *
                 * Unlike [openUnits], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("open_units")
                @ExcludeMissing
                fun _openUnits(): JsonField<Float> = openUnits

                /**
                 * Returns the raw JSON value of [rtaCode].
                 *
                 * Unlike [rtaCode], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("rta_code")
                @ExcludeMissing
                fun _rtaCode(): JsonField<String> = rtaCode

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
                     * Returns a mutable builder for constructing an instance of [AdditionalInfo].
                     */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [AdditionalInfo]. */
                class Builder internal constructor() {

                    private var advisor: JsonField<String> = JsonMissing.of()
                    private var amfi: JsonField<String> = JsonMissing.of()
                    private var closeUnits: JsonField<Float> = JsonMissing.of()
                    private var openUnits: JsonField<Float> = JsonMissing.of()
                    private var rtaCode: JsonField<String> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(additionalInfo: AdditionalInfo) = apply {
                        advisor = additionalInfo.advisor
                        amfi = additionalInfo.amfi
                        closeUnits = additionalInfo.closeUnits
                        openUnits = additionalInfo.openUnits
                        rtaCode = additionalInfo.rtaCode
                        additionalProperties = additionalInfo.additionalProperties.toMutableMap()
                    }

                    /** Financial advisor name (CAMS/KFintech) */
                    fun advisor(advisor: String) = advisor(JsonField.of(advisor))

                    /**
                     * Sets [Builder.advisor] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.advisor] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun advisor(advisor: JsonField<String>) = apply { this.advisor = advisor }

                    /** AMFI code for the scheme (CAMS/KFintech) */
                    fun amfi(amfi: String) = amfi(JsonField.of(amfi))

                    /**
                     * Sets [Builder.amfi] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.amfi] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun amfi(amfi: JsonField<String>) = apply { this.amfi = amfi }

                    /** Closing balance units (CAMS/KFintech) */
                    fun closeUnits(closeUnits: Float) = closeUnits(JsonField.of(closeUnits))

                    /**
                     * Sets [Builder.closeUnits] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.closeUnits] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun closeUnits(closeUnits: JsonField<Float>) = apply {
                        this.closeUnits = closeUnits
                    }

                    /** Opening balance units (CAMS/KFintech) */
                    fun openUnits(openUnits: Float) = openUnits(JsonField.of(openUnits))

                    /**
                     * Sets [Builder.openUnits] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.openUnits] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun openUnits(openUnits: JsonField<Float>) = apply {
                        this.openUnits = openUnits
                    }

                    /** RTA code for the scheme (CAMS/KFintech) */
                    fun rtaCode(rtaCode: String) = rtaCode(JsonField.of(rtaCode))

                    /**
                     * Sets [Builder.rtaCode] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.rtaCode] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun rtaCode(rtaCode: JsonField<String>) = apply { this.rtaCode = rtaCode }

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
                     * Returns an immutable instance of [AdditionalInfo].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): AdditionalInfo =
                        AdditionalInfo(
                            advisor,
                            amfi,
                            closeUnits,
                            openUnits,
                            rtaCode,
                            additionalProperties.toMutableMap(),
                        )
                }

                private var validated: Boolean = false

                fun validate(): AdditionalInfo = apply {
                    if (validated) {
                        return@apply
                    }

                    advisor()
                    amfi()
                    closeUnits()
                    openUnits()
                    rtaCode()
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
                    (if (advisor.asKnown().isPresent) 1 else 0) +
                        (if (amfi.asKnown().isPresent) 1 else 0) +
                        (if (closeUnits.asKnown().isPresent) 1 else 0) +
                        (if (openUnits.asKnown().isPresent) 1 else 0) +
                        (if (rtaCode.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is AdditionalInfo &&
                        advisor == other.advisor &&
                        amfi == other.amfi &&
                        closeUnits == other.closeUnits &&
                        openUnits == other.openUnits &&
                        rtaCode == other.rtaCode &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(
                        advisor,
                        amfi,
                        closeUnits,
                        openUnits,
                        rtaCode,
                        additionalProperties,
                    )
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "AdditionalInfo{advisor=$advisor, amfi=$amfi, closeUnits=$closeUnits, openUnits=$openUnits, rtaCode=$rtaCode, additionalProperties=$additionalProperties}"
            }

            class Gain
            private constructor(
                private val absolute: JsonField<Float>,
                private val percentage: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("absolute")
                    @ExcludeMissing
                    absolute: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("percentage")
                    @ExcludeMissing
                    percentage: JsonField<Float> = JsonMissing.of(),
                ) : this(absolute, percentage, mutableMapOf())

                /**
                 * Absolute gain or loss
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun absolute(): Optional<Float> = absolute.getOptional("absolute")

                /**
                 * Percentage gain or loss
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun percentage(): Optional<Float> = percentage.getOptional("percentage")

                /**
                 * Returns the raw JSON value of [absolute].
                 *
                 * Unlike [absolute], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("absolute")
                @ExcludeMissing
                fun _absolute(): JsonField<Float> = absolute

                /**
                 * Returns the raw JSON value of [percentage].
                 *
                 * Unlike [percentage], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("percentage")
                @ExcludeMissing
                fun _percentage(): JsonField<Float> = percentage

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

                    /** Returns a mutable builder for constructing an instance of [Gain]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Gain]. */
                class Builder internal constructor() {

                    private var absolute: JsonField<Float> = JsonMissing.of()
                    private var percentage: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(gain: Gain) = apply {
                        absolute = gain.absolute
                        percentage = gain.percentage
                        additionalProperties = gain.additionalProperties.toMutableMap()
                    }

                    /** Absolute gain or loss */
                    fun absolute(absolute: Float) = absolute(JsonField.of(absolute))

                    /**
                     * Sets [Builder.absolute] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.absolute] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun absolute(absolute: JsonField<Float>) = apply { this.absolute = absolute }

                    /** Percentage gain or loss */
                    fun percentage(percentage: Float) = percentage(JsonField.of(percentage))

                    /**
                     * Sets [Builder.percentage] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.percentage] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun percentage(percentage: JsonField<Float>) = apply {
                        this.percentage = percentage
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
                     * Returns an immutable instance of [Gain].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Gain =
                        Gain(absolute, percentage, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Gain = apply {
                    if (validated) {
                        return@apply
                    }

                    absolute()
                    percentage()
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
                    (if (absolute.asKnown().isPresent) 1 else 0) +
                        (if (percentage.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Gain &&
                        absolute == other.absolute &&
                        percentage == other.percentage &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(absolute, percentage, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Gain{absolute=$absolute, percentage=$percentage, additionalProperties=$additionalProperties}"
            }

            class Transaction
            private constructor(
                private val amount: JsonField<Float>,
                private val balance: JsonField<Float>,
                private val date: JsonField<LocalDate>,
                private val description: JsonField<String>,
                private val dividendRate: JsonField<Float>,
                private val nav: JsonField<Float>,
                private val type: JsonField<String>,
                private val units: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("amount")
                    @ExcludeMissing
                    amount: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("balance")
                    @ExcludeMissing
                    balance: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("date")
                    @ExcludeMissing
                    date: JsonField<LocalDate> = JsonMissing.of(),
                    @JsonProperty("description")
                    @ExcludeMissing
                    description: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("dividend_rate")
                    @ExcludeMissing
                    dividendRate: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("nav") @ExcludeMissing nav: JsonField<Float> = JsonMissing.of(),
                    @JsonProperty("type")
                    @ExcludeMissing
                    type: JsonField<String> = JsonMissing.of(),
                    @JsonProperty("units")
                    @ExcludeMissing
                    units: JsonField<Float> = JsonMissing.of(),
                ) : this(
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
                 * Transaction amount
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun amount(): Optional<Float> = amount.getOptional("amount")

                /**
                 * Balance units after transaction
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun balance(): Optional<Float> = balance.getOptional("balance")

                /**
                 * Transaction date
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun date(): Optional<LocalDate> = date.getOptional("date")

                /**
                 * Transaction description
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun description(): Optional<String> = description.getOptional("description")

                /**
                 * Dividend rate (for dividend transactions)
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun dividendRate(): Optional<Float> = dividendRate.getOptional("dividend_rate")

                /**
                 * NAV on transaction date
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun nav(): Optional<Float> = nav.getOptional("nav")

                /**
                 * Transaction type detected based on description. Possible values are
                 * PURCHASE,PURCHASE_SIP,REDEMPTION,SWITCH_IN,SWITCH_IN_MERGER,SWITCH_OUT,SWITCH_OUT_MERGER,DIVIDEND_PAYOUT,DIVIDEND_REINVESTMENT,SEGREGATION,STAMP_DUTY_TAX,TDS_TAX,STT_TAX,MISC.
                 * If dividend_rate is present, then possible values are dividend_rate is applicable
                 * only for DIVIDEND_PAYOUT and DIVIDEND_REINVESTMENT.
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun type(): Optional<String> = type.getOptional("type")

                /**
                 * Number of units involved
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun units(): Optional<Float> = units.getOptional("units")

                /**
                 * Returns the raw JSON value of [amount].
                 *
                 * Unlike [amount], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("amount") @ExcludeMissing fun _amount(): JsonField<Float> = amount

                /**
                 * Returns the raw JSON value of [balance].
                 *
                 * Unlike [balance], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("balance") @ExcludeMissing fun _balance(): JsonField<Float> = balance

                /**
                 * Returns the raw JSON value of [date].
                 *
                 * Unlike [date], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("date") @ExcludeMissing fun _date(): JsonField<LocalDate> = date

                /**
                 * Returns the raw JSON value of [description].
                 *
                 * Unlike [description], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("description")
                @ExcludeMissing
                fun _description(): JsonField<String> = description

                /**
                 * Returns the raw JSON value of [dividendRate].
                 *
                 * Unlike [dividendRate], this method doesn't throw if the JSON field has an
                 * unexpected type.
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
                 * Unlike [type], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("type") @ExcludeMissing fun _type(): JsonField<String> = type

                /**
                 * Returns the raw JSON value of [units].
                 *
                 * Unlike [units], this method doesn't throw if the JSON field has an unexpected
                 * type.
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

                    private var amount: JsonField<Float> = JsonMissing.of()
                    private var balance: JsonField<Float> = JsonMissing.of()
                    private var date: JsonField<LocalDate> = JsonMissing.of()
                    private var description: JsonField<String> = JsonMissing.of()
                    private var dividendRate: JsonField<Float> = JsonMissing.of()
                    private var nav: JsonField<Float> = JsonMissing.of()
                    private var type: JsonField<String> = JsonMissing.of()
                    private var units: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(transaction: Transaction) = apply {
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

                    /** Transaction amount */
                    fun amount(amount: Float) = amount(JsonField.of(amount))

                    /**
                     * Sets [Builder.amount] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.amount] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun amount(amount: JsonField<Float>) = apply { this.amount = amount }

                    /** Balance units after transaction */
                    fun balance(balance: Float) = balance(JsonField.of(balance))

                    /**
                     * Sets [Builder.balance] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.balance] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun balance(balance: JsonField<Float>) = apply { this.balance = balance }

                    /** Transaction date */
                    fun date(date: LocalDate) = date(JsonField.of(date))

                    /**
                     * Sets [Builder.date] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.date] with a well-typed [LocalDate] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun date(date: JsonField<LocalDate>) = apply { this.date = date }

                    /** Transaction description */
                    fun description(description: String) = description(JsonField.of(description))

                    /**
                     * Sets [Builder.description] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.description] with a well-typed [String]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun description(description: JsonField<String>) = apply {
                        this.description = description
                    }

                    /** Dividend rate (for dividend transactions) */
                    fun dividendRate(dividendRate: Float) = dividendRate(JsonField.of(dividendRate))

                    /**
                     * Sets [Builder.dividendRate] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.dividendRate] with a well-typed [Float]
                     * value instead. This method is primarily for setting the field to an
                     * undocumented or not yet supported value.
                     */
                    fun dividendRate(dividendRate: JsonField<Float>) = apply {
                        this.dividendRate = dividendRate
                    }

                    /** NAV on transaction date */
                    fun nav(nav: Float) = nav(JsonField.of(nav))

                    /**
                     * Sets [Builder.nav] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.nav] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun nav(nav: JsonField<Float>) = apply { this.nav = nav }

                    /**
                     * Transaction type detected based on description. Possible values are
                     * PURCHASE,PURCHASE_SIP,REDEMPTION,SWITCH_IN,SWITCH_IN_MERGER,SWITCH_OUT,SWITCH_OUT_MERGER,DIVIDEND_PAYOUT,DIVIDEND_REINVESTMENT,SEGREGATION,STAMP_DUTY_TAX,TDS_TAX,STT_TAX,MISC.
                     * If dividend_rate is present, then possible values are dividend_rate is
                     * applicable only for DIVIDEND_PAYOUT and DIVIDEND_REINVESTMENT.
                     */
                    fun type(type: String) = type(JsonField.of(type))

                    /**
                     * Sets [Builder.type] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.type] with a well-typed [String] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun type(type: JsonField<String>) = apply { this.type = type }

                    /** Number of units involved */
                    fun units(units: Float) = units(JsonField.of(units))

                    /**
                     * Sets [Builder.units] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.units] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun units(units: JsonField<Float>) = apply { this.units = units }

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
                     * Returns an immutable instance of [Transaction].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Transaction =
                        Transaction(
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

                    amount()
                    balance()
                    date()
                    description()
                    dividendRate()
                    nav()
                    type()
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
                 * Returns a score indicating how many valid values are contained in this object
                 * recursively.
                 *
                 * Used for best match union deserialization.
                 */
                @JvmSynthetic
                internal fun validity(): Int =
                    (if (amount.asKnown().isPresent) 1 else 0) +
                        (if (balance.asKnown().isPresent) 1 else 0) +
                        (if (date.asKnown().isPresent) 1 else 0) +
                        (if (description.asKnown().isPresent) 1 else 0) +
                        (if (dividendRate.asKnown().isPresent) 1 else 0) +
                        (if (nav.asKnown().isPresent) 1 else 0) +
                        (if (type.asKnown().isPresent) 1 else 0) +
                        (if (units.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Transaction &&
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
                    "Transaction{amount=$amount, balance=$balance, date=$date, description=$description, dividendRate=$dividendRate, nav=$nav, type=$type, units=$units, additionalProperties=$additionalProperties}"
            }

            /** Type of mutual fund scheme */
            class Type @JsonCreator private constructor(private val value: JsonField<String>) :
                Enum {

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

                    @JvmField val EQUITY = of("Equity")

                    @JvmField val DEBT = of("Debt")

                    @JvmField val HYBRID = of("Hybrid")

                    @JvmField val OTHER = of("Other")

                    @JvmStatic fun of(value: String) = Type(JsonField.of(value))
                }

                /** An enum containing [Type]'s known values. */
                enum class Known {
                    EQUITY,
                    DEBT,
                    HYBRID,
                    OTHER,
                }

                /**
                 * An enum containing [Type]'s known values, as well as an [_UNKNOWN] member.
                 *
                 * An instance of [Type] can contain an unknown value in a couple of cases:
                 * - It was deserialized from data that doesn't match any known member. For example,
                 *   if the SDK is on an older version than the API, then the API may respond with
                 *   new members that the SDK is unaware of.
                 * - It was constructed with an arbitrary value using the [of] method.
                 */
                enum class Value {
                    EQUITY,
                    DEBT,
                    HYBRID,
                    OTHER,
                    /**
                     * An enum member indicating that [Type] was instantiated with an unknown value.
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
                        EQUITY -> Value.EQUITY
                        DEBT -> Value.DEBT
                        HYBRID -> Value.HYBRID
                        OTHER -> Value.OTHER
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
                        EQUITY -> Known.EQUITY
                        DEBT -> Known.DEBT
                        HYBRID -> Known.HYBRID
                        OTHER -> Known.OTHER
                        else -> throw CasParserInvalidDataException("Unknown Type: $value")
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

                return other is Scheme &&
                    additionalInfo == other.additionalInfo &&
                    cost == other.cost &&
                    gain == other.gain &&
                    isin == other.isin &&
                    name == other.name &&
                    nav == other.nav &&
                    nominees == other.nominees &&
                    transactions == other.transactions &&
                    type == other.type &&
                    units == other.units &&
                    value == other.value &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(
                    additionalInfo,
                    cost,
                    gain,
                    isin,
                    name,
                    nav,
                    nominees,
                    transactions,
                    type,
                    units,
                    value,
                    additionalProperties,
                )
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Scheme{additionalInfo=$additionalInfo, cost=$cost, gain=$gain, isin=$isin, name=$name, nav=$nav, nominees=$nominees, transactions=$transactions, type=$type, units=$units, value=$value, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is MutualFund &&
                additionalInfo == other.additionalInfo &&
                amc == other.amc &&
                folioNumber == other.folioNumber &&
                registrar == other.registrar &&
                schemes == other.schemes &&
                value == other.value &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(
                additionalInfo,
                amc,
                folioNumber,
                registrar,
                schemes,
                value,
                additionalProperties,
            )
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "MutualFund{additionalInfo=$additionalInfo, amc=$amc, folioNumber=$folioNumber, registrar=$registrar, schemes=$schemes, value=$value, additionalProperties=$additionalProperties}"
    }

    class Summary
    private constructor(
        private val accounts: JsonField<Accounts>,
        private val totalValue: JsonField<Float>,
        private val additionalProperties: MutableMap<String, JsonValue>,
    ) {

        @JsonCreator
        private constructor(
            @JsonProperty("accounts")
            @ExcludeMissing
            accounts: JsonField<Accounts> = JsonMissing.of(),
            @JsonProperty("total_value")
            @ExcludeMissing
            totalValue: JsonField<Float> = JsonMissing.of(),
        ) : this(accounts, totalValue, mutableMapOf())

        /**
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun accounts(): Optional<Accounts> = accounts.getOptional("accounts")

        /**
         * Total portfolio value across all accounts
         *
         * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g. if
         *   the server responded with an unexpected value).
         */
        fun totalValue(): Optional<Float> = totalValue.getOptional("total_value")

        /**
         * Returns the raw JSON value of [accounts].
         *
         * Unlike [accounts], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("accounts") @ExcludeMissing fun _accounts(): JsonField<Accounts> = accounts

        /**
         * Returns the raw JSON value of [totalValue].
         *
         * Unlike [totalValue], this method doesn't throw if the JSON field has an unexpected type.
         */
        @JsonProperty("total_value")
        @ExcludeMissing
        fun _totalValue(): JsonField<Float> = totalValue

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

            /** Returns a mutable builder for constructing an instance of [Summary]. */
            @JvmStatic fun builder() = Builder()
        }

        /** A builder for [Summary]. */
        class Builder internal constructor() {

            private var accounts: JsonField<Accounts> = JsonMissing.of()
            private var totalValue: JsonField<Float> = JsonMissing.of()
            private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

            @JvmSynthetic
            internal fun from(summary: Summary) = apply {
                accounts = summary.accounts
                totalValue = summary.totalValue
                additionalProperties = summary.additionalProperties.toMutableMap()
            }

            fun accounts(accounts: Accounts) = accounts(JsonField.of(accounts))

            /**
             * Sets [Builder.accounts] to an arbitrary JSON value.
             *
             * You should usually call [Builder.accounts] with a well-typed [Accounts] value
             * instead. This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun accounts(accounts: JsonField<Accounts>) = apply { this.accounts = accounts }

            /** Total portfolio value across all accounts */
            fun totalValue(totalValue: Float) = totalValue(JsonField.of(totalValue))

            /**
             * Sets [Builder.totalValue] to an arbitrary JSON value.
             *
             * You should usually call [Builder.totalValue] with a well-typed [Float] value instead.
             * This method is primarily for setting the field to an undocumented or not yet
             * supported value.
             */
            fun totalValue(totalValue: JsonField<Float>) = apply { this.totalValue = totalValue }

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
             * Returns an immutable instance of [Summary].
             *
             * Further updates to this [Builder] will not mutate the returned instance.
             */
            fun build(): Summary =
                Summary(accounts, totalValue, additionalProperties.toMutableMap())
        }

        private var validated: Boolean = false

        fun validate(): Summary = apply {
            if (validated) {
                return@apply
            }

            accounts().ifPresent { it.validate() }
            totalValue()
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
            (accounts.asKnown().getOrNull()?.validity() ?: 0) +
                (if (totalValue.asKnown().isPresent) 1 else 0)

        class Accounts
        private constructor(
            private val demat: JsonField<Demat>,
            private val insurance: JsonField<Insurance>,
            private val mutualFunds: JsonField<MutualFunds>,
            private val additionalProperties: MutableMap<String, JsonValue>,
        ) {

            @JsonCreator
            private constructor(
                @JsonProperty("demat") @ExcludeMissing demat: JsonField<Demat> = JsonMissing.of(),
                @JsonProperty("insurance")
                @ExcludeMissing
                insurance: JsonField<Insurance> = JsonMissing.of(),
                @JsonProperty("mutual_funds")
                @ExcludeMissing
                mutualFunds: JsonField<MutualFunds> = JsonMissing.of(),
            ) : this(demat, insurance, mutualFunds, mutableMapOf())

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun demat(): Optional<Demat> = demat.getOptional("demat")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun insurance(): Optional<Insurance> = insurance.getOptional("insurance")

            /**
             * @throws CasParserInvalidDataException if the JSON field has an unexpected type (e.g.
             *   if the server responded with an unexpected value).
             */
            fun mutualFunds(): Optional<MutualFunds> = mutualFunds.getOptional("mutual_funds")

            /**
             * Returns the raw JSON value of [demat].
             *
             * Unlike [demat], this method doesn't throw if the JSON field has an unexpected type.
             */
            @JsonProperty("demat") @ExcludeMissing fun _demat(): JsonField<Demat> = demat

            /**
             * Returns the raw JSON value of [insurance].
             *
             * Unlike [insurance], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("insurance")
            @ExcludeMissing
            fun _insurance(): JsonField<Insurance> = insurance

            /**
             * Returns the raw JSON value of [mutualFunds].
             *
             * Unlike [mutualFunds], this method doesn't throw if the JSON field has an unexpected
             * type.
             */
            @JsonProperty("mutual_funds")
            @ExcludeMissing
            fun _mutualFunds(): JsonField<MutualFunds> = mutualFunds

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

                /** Returns a mutable builder for constructing an instance of [Accounts]. */
                @JvmStatic fun builder() = Builder()
            }

            /** A builder for [Accounts]. */
            class Builder internal constructor() {

                private var demat: JsonField<Demat> = JsonMissing.of()
                private var insurance: JsonField<Insurance> = JsonMissing.of()
                private var mutualFunds: JsonField<MutualFunds> = JsonMissing.of()
                private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                @JvmSynthetic
                internal fun from(accounts: Accounts) = apply {
                    demat = accounts.demat
                    insurance = accounts.insurance
                    mutualFunds = accounts.mutualFunds
                    additionalProperties = accounts.additionalProperties.toMutableMap()
                }

                fun demat(demat: Demat) = demat(JsonField.of(demat))

                /**
                 * Sets [Builder.demat] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.demat] with a well-typed [Demat] value instead.
                 * This method is primarily for setting the field to an undocumented or not yet
                 * supported value.
                 */
                fun demat(demat: JsonField<Demat>) = apply { this.demat = demat }

                fun insurance(insurance: Insurance) = insurance(JsonField.of(insurance))

                /**
                 * Sets [Builder.insurance] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.insurance] with a well-typed [Insurance] value
                 * instead. This method is primarily for setting the field to an undocumented or not
                 * yet supported value.
                 */
                fun insurance(insurance: JsonField<Insurance>) = apply {
                    this.insurance = insurance
                }

                fun mutualFunds(mutualFunds: MutualFunds) = mutualFunds(JsonField.of(mutualFunds))

                /**
                 * Sets [Builder.mutualFunds] to an arbitrary JSON value.
                 *
                 * You should usually call [Builder.mutualFunds] with a well-typed [MutualFunds]
                 * value instead. This method is primarily for setting the field to an undocumented
                 * or not yet supported value.
                 */
                fun mutualFunds(mutualFunds: JsonField<MutualFunds>) = apply {
                    this.mutualFunds = mutualFunds
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
                 * Returns an immutable instance of [Accounts].
                 *
                 * Further updates to this [Builder] will not mutate the returned instance.
                 */
                fun build(): Accounts =
                    Accounts(demat, insurance, mutualFunds, additionalProperties.toMutableMap())
            }

            private var validated: Boolean = false

            fun validate(): Accounts = apply {
                if (validated) {
                    return@apply
                }

                demat().ifPresent { it.validate() }
                insurance().ifPresent { it.validate() }
                mutualFunds().ifPresent { it.validate() }
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
                (demat.asKnown().getOrNull()?.validity() ?: 0) +
                    (insurance.asKnown().getOrNull()?.validity() ?: 0) +
                    (mutualFunds.asKnown().getOrNull()?.validity() ?: 0)

            class Demat
            private constructor(
                private val count: JsonField<Long>,
                private val totalValue: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("count")
                    @ExcludeMissing
                    count: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("total_value")
                    @ExcludeMissing
                    totalValue: JsonField<Float> = JsonMissing.of(),
                ) : this(count, totalValue, mutableMapOf())

                /**
                 * Number of demat accounts
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun count(): Optional<Long> = count.getOptional("count")

                /**
                 * Total value of demat accounts
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun totalValue(): Optional<Float> = totalValue.getOptional("total_value")

                /**
                 * Returns the raw JSON value of [count].
                 *
                 * Unlike [count], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

                /**
                 * Returns the raw JSON value of [totalValue].
                 *
                 * Unlike [totalValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("total_value")
                @ExcludeMissing
                fun _totalValue(): JsonField<Float> = totalValue

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

                    /** Returns a mutable builder for constructing an instance of [Demat]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Demat]. */
                class Builder internal constructor() {

                    private var count: JsonField<Long> = JsonMissing.of()
                    private var totalValue: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(demat: Demat) = apply {
                        count = demat.count
                        totalValue = demat.totalValue
                        additionalProperties = demat.additionalProperties.toMutableMap()
                    }

                    /** Number of demat accounts */
                    fun count(count: Long) = count(JsonField.of(count))

                    /**
                     * Sets [Builder.count] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.count] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun count(count: JsonField<Long>) = apply { this.count = count }

                    /** Total value of demat accounts */
                    fun totalValue(totalValue: Float) = totalValue(JsonField.of(totalValue))

                    /**
                     * Sets [Builder.totalValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.totalValue] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun totalValue(totalValue: JsonField<Float>) = apply {
                        this.totalValue = totalValue
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
                     * Returns an immutable instance of [Demat].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Demat =
                        Demat(count, totalValue, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Demat = apply {
                    if (validated) {
                        return@apply
                    }

                    count()
                    totalValue()
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
                    (if (count.asKnown().isPresent) 1 else 0) +
                        (if (totalValue.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Demat &&
                        count == other.count &&
                        totalValue == other.totalValue &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(count, totalValue, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Demat{count=$count, totalValue=$totalValue, additionalProperties=$additionalProperties}"
            }

            class Insurance
            private constructor(
                private val count: JsonField<Long>,
                private val totalValue: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("count")
                    @ExcludeMissing
                    count: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("total_value")
                    @ExcludeMissing
                    totalValue: JsonField<Float> = JsonMissing.of(),
                ) : this(count, totalValue, mutableMapOf())

                /**
                 * Number of insurance policies
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun count(): Optional<Long> = count.getOptional("count")

                /**
                 * Total value of insurance policies
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun totalValue(): Optional<Float> = totalValue.getOptional("total_value")

                /**
                 * Returns the raw JSON value of [count].
                 *
                 * Unlike [count], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

                /**
                 * Returns the raw JSON value of [totalValue].
                 *
                 * Unlike [totalValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("total_value")
                @ExcludeMissing
                fun _totalValue(): JsonField<Float> = totalValue

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

                    /** Returns a mutable builder for constructing an instance of [Insurance]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [Insurance]. */
                class Builder internal constructor() {

                    private var count: JsonField<Long> = JsonMissing.of()
                    private var totalValue: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(insurance: Insurance) = apply {
                        count = insurance.count
                        totalValue = insurance.totalValue
                        additionalProperties = insurance.additionalProperties.toMutableMap()
                    }

                    /** Number of insurance policies */
                    fun count(count: Long) = count(JsonField.of(count))

                    /**
                     * Sets [Builder.count] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.count] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun count(count: JsonField<Long>) = apply { this.count = count }

                    /** Total value of insurance policies */
                    fun totalValue(totalValue: Float) = totalValue(JsonField.of(totalValue))

                    /**
                     * Sets [Builder.totalValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.totalValue] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun totalValue(totalValue: JsonField<Float>) = apply {
                        this.totalValue = totalValue
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
                     * Returns an immutable instance of [Insurance].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): Insurance =
                        Insurance(count, totalValue, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): Insurance = apply {
                    if (validated) {
                        return@apply
                    }

                    count()
                    totalValue()
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
                    (if (count.asKnown().isPresent) 1 else 0) +
                        (if (totalValue.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is Insurance &&
                        count == other.count &&
                        totalValue == other.totalValue &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(count, totalValue, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "Insurance{count=$count, totalValue=$totalValue, additionalProperties=$additionalProperties}"
            }

            class MutualFunds
            private constructor(
                private val count: JsonField<Long>,
                private val totalValue: JsonField<Float>,
                private val additionalProperties: MutableMap<String, JsonValue>,
            ) {

                @JsonCreator
                private constructor(
                    @JsonProperty("count")
                    @ExcludeMissing
                    count: JsonField<Long> = JsonMissing.of(),
                    @JsonProperty("total_value")
                    @ExcludeMissing
                    totalValue: JsonField<Float> = JsonMissing.of(),
                ) : this(count, totalValue, mutableMapOf())

                /**
                 * Number of mutual fund folios
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun count(): Optional<Long> = count.getOptional("count")

                /**
                 * Total value of mutual funds
                 *
                 * @throws CasParserInvalidDataException if the JSON field has an unexpected type
                 *   (e.g. if the server responded with an unexpected value).
                 */
                fun totalValue(): Optional<Float> = totalValue.getOptional("total_value")

                /**
                 * Returns the raw JSON value of [count].
                 *
                 * Unlike [count], this method doesn't throw if the JSON field has an unexpected
                 * type.
                 */
                @JsonProperty("count") @ExcludeMissing fun _count(): JsonField<Long> = count

                /**
                 * Returns the raw JSON value of [totalValue].
                 *
                 * Unlike [totalValue], this method doesn't throw if the JSON field has an
                 * unexpected type.
                 */
                @JsonProperty("total_value")
                @ExcludeMissing
                fun _totalValue(): JsonField<Float> = totalValue

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

                    /** Returns a mutable builder for constructing an instance of [MutualFunds]. */
                    @JvmStatic fun builder() = Builder()
                }

                /** A builder for [MutualFunds]. */
                class Builder internal constructor() {

                    private var count: JsonField<Long> = JsonMissing.of()
                    private var totalValue: JsonField<Float> = JsonMissing.of()
                    private var additionalProperties: MutableMap<String, JsonValue> = mutableMapOf()

                    @JvmSynthetic
                    internal fun from(mutualFunds: MutualFunds) = apply {
                        count = mutualFunds.count
                        totalValue = mutualFunds.totalValue
                        additionalProperties = mutualFunds.additionalProperties.toMutableMap()
                    }

                    /** Number of mutual fund folios */
                    fun count(count: Long) = count(JsonField.of(count))

                    /**
                     * Sets [Builder.count] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.count] with a well-typed [Long] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun count(count: JsonField<Long>) = apply { this.count = count }

                    /** Total value of mutual funds */
                    fun totalValue(totalValue: Float) = totalValue(JsonField.of(totalValue))

                    /**
                     * Sets [Builder.totalValue] to an arbitrary JSON value.
                     *
                     * You should usually call [Builder.totalValue] with a well-typed [Float] value
                     * instead. This method is primarily for setting the field to an undocumented or
                     * not yet supported value.
                     */
                    fun totalValue(totalValue: JsonField<Float>) = apply {
                        this.totalValue = totalValue
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
                     * Returns an immutable instance of [MutualFunds].
                     *
                     * Further updates to this [Builder] will not mutate the returned instance.
                     */
                    fun build(): MutualFunds =
                        MutualFunds(count, totalValue, additionalProperties.toMutableMap())
                }

                private var validated: Boolean = false

                fun validate(): MutualFunds = apply {
                    if (validated) {
                        return@apply
                    }

                    count()
                    totalValue()
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
                    (if (count.asKnown().isPresent) 1 else 0) +
                        (if (totalValue.asKnown().isPresent) 1 else 0)

                override fun equals(other: Any?): Boolean {
                    if (this === other) {
                        return true
                    }

                    return other is MutualFunds &&
                        count == other.count &&
                        totalValue == other.totalValue &&
                        additionalProperties == other.additionalProperties
                }

                private val hashCode: Int by lazy {
                    Objects.hash(count, totalValue, additionalProperties)
                }

                override fun hashCode(): Int = hashCode

                override fun toString() =
                    "MutualFunds{count=$count, totalValue=$totalValue, additionalProperties=$additionalProperties}"
            }

            override fun equals(other: Any?): Boolean {
                if (this === other) {
                    return true
                }

                return other is Accounts &&
                    demat == other.demat &&
                    insurance == other.insurance &&
                    mutualFunds == other.mutualFunds &&
                    additionalProperties == other.additionalProperties
            }

            private val hashCode: Int by lazy {
                Objects.hash(demat, insurance, mutualFunds, additionalProperties)
            }

            override fun hashCode(): Int = hashCode

            override fun toString() =
                "Accounts{demat=$demat, insurance=$insurance, mutualFunds=$mutualFunds, additionalProperties=$additionalProperties}"
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) {
                return true
            }

            return other is Summary &&
                accounts == other.accounts &&
                totalValue == other.totalValue &&
                additionalProperties == other.additionalProperties
        }

        private val hashCode: Int by lazy {
            Objects.hash(accounts, totalValue, additionalProperties)
        }

        override fun hashCode(): Int = hashCode

        override fun toString() =
            "Summary{accounts=$accounts, totalValue=$totalValue, additionalProperties=$additionalProperties}"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is UnifiedResponse &&
            dematAccounts == other.dematAccounts &&
            insurance == other.insurance &&
            investor == other.investor &&
            meta == other.meta &&
            mutualFunds == other.mutualFunds &&
            summary == other.summary &&
            additionalProperties == other.additionalProperties
    }

    private val hashCode: Int by lazy {
        Objects.hash(
            dematAccounts,
            insurance,
            investor,
            meta,
            mutualFunds,
            summary,
            additionalProperties,
        )
    }

    override fun hashCode(): Int = hashCode

    override fun toString() =
        "UnifiedResponse{dematAccounts=$dematAccounts, insurance=$insurance, investor=$investor, meta=$meta, mutualFunds=$mutualFunds, summary=$summary, additionalProperties=$additionalProperties}"
}
