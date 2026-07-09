package com.example.kafkaredis.common.config.kafka.produce;


import com.example.kafkaredis.common.model.kafka.event.PaymentCompletedEvent;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaProduceConfig {

    // Spring Boot에 카프카 클러스터 주소 연결
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootStrapServers;

    // ProduceFactory
    // Spring Boot에서 발생한 이벤트를 Kafka에 저장시키는 역할
    @Bean
    public ProducerFactory<String, PaymentCompletedEvent> eventProducerFactory() {

        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    // KafkaTemplate
    // Spring boot와 Kafka가 소통 할 때 사용하는 객체
    @Bean
    public KafkaTemplate<String, PaymentCompletedEvent> paymentCompletedEventKafkaTemplate() {
        return new KafkaTemplate<>(eventProducerFactory());
    }
}
