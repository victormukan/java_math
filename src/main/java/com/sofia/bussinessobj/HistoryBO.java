package com.sofia.bussinessobj;

import com.sofia.model.HistoryRecord;
import com.sofia.model.MathOperation;
import com.sofia.util.HistoryDateParser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HistoryBO {
    private List<HistoryRecord> requestsHistory = new ArrayList<>();

    public void addRecord(MathOperation operation, Double result) {
        requestsHistory.add(new HistoryRecord(operation, result));
    }

    public List<HistoryRecord> getHistory() {
        return requestsHistory;
    }

    public List<HistoryRecord> getHistoryByDate(String limit) {
        return requestsHistory.stream()
                .filter(i -> i.getRequestTime().isAfter(HistoryDateParser.getMinSatisfyingDate(limit)))
                .collect(Collectors.toList());
    }
}
