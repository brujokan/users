package com.soma.bookstore.users.infrastructure.messaging.producer

import com.fasterxml.jackson.databind.ObjectMapper
import com.soma.bookstore.users.domain.mapper.Mapper
import com.soma.bookstore.users.domain.messaging.UserProducer
import com.soma.bookstore.users.domain.model.User
import com.soma.bookstore.users.infrastructure.messaging.model.UserMessage
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class UserProducerImpl(
    private val kafkaTemplate: KafkaTemplate<String, Any>,
    @Value("\${kafka.topic.create}")
    private val topic: String,
    private val messageMapper: Mapper<UserMessage, User>,
    private val objectMapper: ObjectMapper
): UserProducer {

    val logger: Logger = LoggerFactory.getLogger("Logger")


    override fun send(user: User) {
        val message: String = objectMapper.writeValueAsString(
            messageMapper.map(user)
        )
        kafkaTemplate.send(topic, message)
        logger.debug(message.toString())
    }
}