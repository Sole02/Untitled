package com.example.kafka.common.config;

import com.example.kafka.domain.simple.model.kafka.SimpleEvent;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    // 1) Producer 설정 (String, String)
    @Bean
    public ProducerFactory<String, String> stringProducerFactory() {
        Map<String, Object> props = new HashMap<>();

        // Kafka 서버 위치
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        // key, value를 문자열로 직렬화
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    // 2) Producer가 사용할 KafkaTemplate
    @Bean
    public KafkaTemplate<String, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    // 3) Consumer 설정 (String, String)
    @Bean
    public ConsumerFactory<String, String> stringConsumerFactory() {
        Map<String, Object> props = new HashMap<>();

        // Kafka 서버 위치
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

        // 이 Consumer가 속할 그룹 아이디
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "simple-group");

        // key, value를 문자열로 역직렬화
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

        // 처음 시작할 때, 토픽 맨 앞(earliest)부터 읽도록 설정
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        return new DefaultKafkaConsumerFactory<>(props);
    }

    // 4) @KafkaListener가 사용할 ListenerContainerFactory
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> stringKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        // 3) 에서 만든 consumer 등록
        factory.setConsumerFactory(stringConsumerFactory());

        return factory;
    }
    // Producer 설정 (String, SimpleEvent) - JSON 직렬화
    @Bean
    public ProducerFactory<String, SimpleEvent> eventProducerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(props);
    }

    @Bean
    public KafkaTemplate<String, SimpleEvent> eventKafkaTemplate() {
        return new KafkaTemplate<>(eventProducerFactory());
    }

    // Consumer 설정 (String, SimpleEvent) - JSON 역직렬화
    @Bean
    public ConsumerFactory<String, SimpleEvent> eventConsumerFactory() {
        Map<String, Object> props = new HashMap<>();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "simple-event-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        // SimpleEvent 타입을 역직렬화하기 위한 JsonDeserializer 생성
        JsonDeserializer<SimpleEvent> deserializer = new JsonDeserializer<>(SimpleEvent.class);

        // 역직렬화를 허용할 패키지 지정 (보안 및 타입 안전성)
        deserializer.addTrustedPackages("com.example.kafka.domain.simple.model.kafka");

        return new DefaultKafkaConsumerFactory<>(
                props,
                new StringDeserializer(),
                deserializer
        );
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, SimpleEvent> eventKafkaListenerContainerFactory() {

        ConcurrentKafkaListenerContainerFactory<String, SimpleEvent> factory = new ConcurrentKafkaListenerContainerFactory<>();

        factory.setConsumerFactory(eventConsumerFactory());
        return factory;
    }
}
