// File generated from our OpenAPI spec by Stainless.

package com.cas_parser.api.errors

import com.cas_parser.api.core.JsonValue
import com.cas_parser.api.core.http.Headers

abstract class CasParserServiceException
protected constructor(message: String, cause: Throwable? = null) :
    CasParserException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
