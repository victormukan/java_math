package com.sofia.bussinessobj;

import com.sofia.model.HistoryRecord;
import com.sofia.model.MathOperation;

import java.util.ArrayList;
import java.util.List;

public class HistoryBO {
    private static List<HistoryRecord> requestsHistory = new ArrayList<>();

    public static void addRecord(MathOperation operation, Double result) {
        requestsHistory.add(new HistoryRecord(operation, result));
    }

    public static List<HistoryRecord> getHistory() {
        return requestsHistory;
    }
}
