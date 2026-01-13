package com.example.Airport.Asistant.backend.service.impl;

import com.example.Airport.Asistant.backend.configuration.RabbitConfig;
import com.example.Airport.Asistant.backend.service.HistoryConsumer;
import com.example.Airport.Asistant.backend.service.HistoryService;
import com.example.Airport.Asistant.backend.service.dto.HistoryDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoryConsumerImpl implements HistoryConsumer {
    @Autowired
    private HistoryService historyService;
    @Override
    @RabbitListener(queues = RabbitConfig.QUEUE)
    public void receiveHistory(HistoryDto historyDto) {
        historyService.save(historyDto);
    }
}
