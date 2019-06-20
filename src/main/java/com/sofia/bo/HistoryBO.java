package com.sofia.bo;

import com.google.gson.Gson;
import com.sofia.entity.HistoryRecord;
import com.sofia.model.MathOperation;
import com.sofia.repository.HistoryRecordRepository;
import com.sofia.util.date.Converter;
import com.sofia.util.date.HistoryDateParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryBO {


    private HistoryRecordRepository historyRepository;

    @Autowired
    public HistoryBO(HistoryRecordRepository historyRepository) {
        this.historyRepository = historyRepository;
    }


    private Gson converter = Converter.getConverter();


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


}
