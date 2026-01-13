package com.example.Airport.Asistant.backend.service;

import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

public interface HistoryProducer {
    void sendHistory(HistoryDto historyDto);
}
