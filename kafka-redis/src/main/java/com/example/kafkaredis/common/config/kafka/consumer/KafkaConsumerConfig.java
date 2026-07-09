package com.example.kafkaredis.common.config.kafka.consumer;

import com.example.kafkaredis.common.model.kafka.event.PaymentCompletedEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    // 카프카 주소
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStringServers;

    // 컨슘한 정보를 기준으로 당일 가장 많이 판매된 상품의 랭킹을 구하는 작업
    @Bean
    public ConsumerFactory<String, PaymentCompletedEvent> productRankingConsumerFactory() {

        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStringServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "product-ranking-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");

        JsonDeserializer<PaymentCompletedEvent> deserializer = new JsonDeserializer<>(PaymentCompletedEvent.class);

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PaymentCompletedEvent> productRankingKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, PaymentCompletedEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(productRankingConsumerFactory());
        return factory;
    }
}
