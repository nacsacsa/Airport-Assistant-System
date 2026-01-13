package com.example.Airport.Asistant.backend.service;

import com.example.Airport.Asistant.backend.service.dto.HistoryDto;

public interface HistoryConsumer {
    void receiveHistory(HistoryDto historyDto);
}
