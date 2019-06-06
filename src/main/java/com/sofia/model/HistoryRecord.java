package com.sofia.model;

import java.time.LocalDateTime;

public class HistoryRecord {
    private MathOperation mathOperation;
    private Double result;
    private LocalDateTime requestTime;

    public HistoryRecord(MathOperation mathOperation, Double result) {
        this.mathOperation = mathOperation;
        this.result = result;
        requestTime = LocalDateTime.now();
    }

    public MathOperation getMathOperation() {
        return mathOperation;
    }

    public void setMathOperation(MathOperation mathOperation) {
        this.mathOperation = mathOperation;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }
}
