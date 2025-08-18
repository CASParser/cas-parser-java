package com.cas_parser.api.errors

open class CasParserException
@JvmOverloads
constructor(message: String? = null, cause: Throwable? = null) : RuntimeException(message, cause)
