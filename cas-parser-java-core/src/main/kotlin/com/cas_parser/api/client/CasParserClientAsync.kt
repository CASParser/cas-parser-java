// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.client

import com.cas_parser.api.core.ClientOptions
import com.cas_parser.api.services.async.AccessTokenServiceAsync
import com.cas_parser.api.services.async.CamsKfintechServiceAsync
import com.cas_parser.api.services.async.CdslServiceAsync
import com.cas_parser.api.services.async.ContractNoteServiceAsync
import com.cas_parser.api.services.async.CreditServiceAsync
import com.cas_parser.api.services.async.InboxServiceAsync
import com.cas_parser.api.services.async.KfintechServiceAsync
import com.cas_parser.api.services.async.LogServiceAsync
import com.cas_parser.api.services.async.NsdlServiceAsync
import com.cas_parser.api.services.async.SmartServiceAsync
import com.cas_parser.api.services.async.VerifyTokenServiceAsync
import java.util.function.Consumer

/**
 * A client for interacting with the Cas Parser REST API asynchronously. You can also switch to
 * synchronous execution via the [sync] method.
 *
 * This client performs best when you create a single instance and reuse it for all interactions
 * with the REST API. This is because each client holds its own connection pool and thread pools.
 * Reusing connections and threads reduces latency and saves memory. The client also handles rate
 * limiting per client. This means that creating and using multiple instances at the same time will
 * not respect rate limits.
 *
 * The threads and connections that are held will be released automatically if they remain idle. But
 * if you are writing an application that needs to aggressively release unused resources, then you
 * may call [close].
 */
interface CasParserClientAsync {

    /**
     * Returns a version of this client that uses synchronous execution.
     *
     * The returned client shares its resources, like its connection pool and thread pools, with
     * this client.
     */
    fun sync(): CasParserClient

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CasParserClientAsync

    fun credits(): CreditServiceAsync

    fun logs(): LogServiceAsync

    fun accessToken(): AccessTokenServiceAsync

    fun verifyToken(): VerifyTokenServiceAsync

    fun camsKfintech(): CamsKfintechServiceAsync

    fun cdsl(): CdslServiceAsync

    fun contractNote(): ContractNoteServiceAsync

    fun inbox(): InboxServiceAsync

    fun kfintech(): KfintechServiceAsync

    fun nsdl(): NsdlServiceAsync

    fun smart(): SmartServiceAsync

    /**
     * Closes this client, relinquishing any underlying resources.
     *
     * This is purposefully not inherited from [AutoCloseable] because the client is long-lived and
     * usually should not be synchronously closed via try-with-resources.
     *
     * It's also usually not necessary to call this method at all. the default HTTP client
     * automatically releases threads and connections if they remain idle, but if you are writing an
     * application that needs to aggressively release unused resources, then you may call this
     * method.
     */
    fun close()

    /**
     * A view of [CasParserClientAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CasParserClientAsync.WithRawResponse

        fun credits(): CreditServiceAsync.WithRawResponse

        fun logs(): LogServiceAsync.WithRawResponse

        fun accessToken(): AccessTokenServiceAsync.WithRawResponse

        fun verifyToken(): VerifyTokenServiceAsync.WithRawResponse

        fun camsKfintech(): CamsKfintechServiceAsync.WithRawResponse

        fun cdsl(): CdslServiceAsync.WithRawResponse

        fun contractNote(): ContractNoteServiceAsync.WithRawResponse

        fun inbox(): InboxServiceAsync.WithRawResponse

        fun kfintech(): KfintechServiceAsync.WithRawResponse

        fun nsdl(): NsdlServiceAsync.WithRawResponse

        fun smart(): SmartServiceAsync.WithRawResponse
    }
}
