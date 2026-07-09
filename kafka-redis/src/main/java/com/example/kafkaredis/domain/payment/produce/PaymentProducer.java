package com.example.kafkaredis.domain.payment.produce;

import com.example.kafkaredis.common.model.kafka.event.PaymentCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.example.kafkaredis.common.model.kafka.topic.KafkaTopic.TOPIC_PAYMENT_COMPLETED;

@Service
@RequiredArgsConstructor
public class PaymentProducer {

    // 카프카에 메시지를 보내주는 역할
    private final KafkaTemplate<String, PaymentCompletedEvent> paymentCompletedEventKafkaTemplate;

    public void send(PaymentCompletedEvent event) {
        paymentCompletedEventKafkaTemplate.send(TOPIC_PAYMENT_COMPLETED, event);
    }

}