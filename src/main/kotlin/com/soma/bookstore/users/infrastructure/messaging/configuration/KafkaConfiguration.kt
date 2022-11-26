package com.soma.bookstore.users.infrastructure.messaging.configuration

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class KafkaConfiguration(
    @Value("\${kafka.topic.create}")
    private val topicCreate: String,
    @Value("\${kafka.topic.delete}")
    private val topicDelete: String
) {
    @Bean
    fun topicCreate(): NewTopic {
        return TopicBuilder
            .name(topicCreate)
            .partitions(1)
            .replicas(1)
            .build()
    }

    @Bean
    fun topicDelete(): NewTopic {
        return TopicBuilder
            .name(topicDelete)
            .partitions(1)
            .replicas(1)
            .build()
    }
}