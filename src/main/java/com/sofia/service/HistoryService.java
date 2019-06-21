package com.sofia.service;

import com.sofia.entity.HistoryRecord;
import com.sofia.dto.MathOperation;
import com.sofia.repository.HistoryRecordRepository;
import com.sofia.util.date.HistoryDateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    @Autowired
    private HistoryRecordRepository historyRepository;

    public HistoryRecord addRecord(MathOperation operation, Double result) {
        return historyRepository.save(new HistoryRecord(
                operation.getFirstNumber(),
                operation.getSecondNumber(),
                operation.getOperationType().name(),
                result
                )
        );
    }

    public List<HistoryRecord> getHistory() {
        return historyRepository.findAll();
    }

    public HistoryRecord getHistoryById(int id) {
        return historyRepository.findById(id).orElse(null);
    }

    public List<HistoryRecord> getHistoryByDate(String limit) {
        return historyRepository.findAll().stream()
                .filter(i -> i.getRequestTime().isAfter(HistoryDateParser.getMinSatisfyingDate(limit)))
                .collect(Collectors.toList());
    }

    public long getHistorySize() {
        return historyRepository.count();
    }

}
