package com.companion.common.kafka.message

import org.springframework.http.HttpStatus
import java.util.*

/**
 * @author shvatov
 */
data class KafkaResponseMsg<R>(
    val uuid: UUID,
    val status: KafkaResponseMsgStatus,
    val destination: String,
    val result: R?
) {
    enum class KafkaResponseMsgStatus(val httpStatus: HttpStatus) {
        SUCCESS(HttpStatus.OK),
        ERROR(HttpStatus.INTERNAL_SERVER_ERROR),
        FORBIDDEN(HttpStatus.FORBIDDEN)
    }
}