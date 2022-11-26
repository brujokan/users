package com.soma.bookstore.users.infrastructure.messaging.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.messaging.UserIdProducer
import com.soma.bookstore.users.infrastructure.messaging.model.UserIdMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UserIdProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${kafka.topic.delete}")
    private val topic: String,
    private val messageMapper: Mapper<UserIdMessage, Long>,
    private val objectMapper: ObjectMapper
): UserIdProducer {

    val logger: Logger = LoggerFactory.getLogger("Logger")

    override fun send(id: Long) {
        val message: String = objectMapper.writeValueAsString(
            messageMapper.map(id)
        )
        kafkaTemplate.send(topic, message)
        logger.debug(message.toString())
    }
}