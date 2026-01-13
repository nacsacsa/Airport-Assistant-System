package com.example.Airport.Asistant.backend.service.impl;

import com.example.Airport.Asistant.backend.configuration.RabbitConfig;
import com.example.Airport.Asistant.backend.service.HistoryProducer;
import com.example.Airport.Asistant.backend.service.dto.HistoryDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryProducerImpl implements HistoryProducer {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Override
    public void sendHistory(HistoryDto historyDto) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.EXCHANGE,
                RabbitConfig.ROUTING_KEY,
                historyDto
        );
    }
}
