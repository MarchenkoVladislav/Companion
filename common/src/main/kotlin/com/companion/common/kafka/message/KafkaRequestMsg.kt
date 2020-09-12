package com.companion.common.kafka.message

import java.util.*

/**
 * @author shvatov
 */
@Suppress("unchecked_cast")
data class KafkaRequestMsg(
    val uuid: UUID,
    val source: String,
    val destination: String,
    private val parameters: MutableMap<String, Any?>
) {
    fun <T> getParameter(key: String) = parameters[key] as? T

    fun putParameter(key: String, value: Any?) {
        parameters[key] = value
    }
}