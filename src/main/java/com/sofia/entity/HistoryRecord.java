package com.sofia.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="history")
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name="firstNumber")
    private double firstNumber;

    @Column(name="secondNumber")
    private double secondNumber;

    @Column(name="mathOperation")
    private String mathOperation;

    @Column(name="result")
    private double result;

    @CreationTimestamp
    @Column(name="requestTime")
    private LocalDateTime requestTime;

    public HistoryRecord() {
    }

    public HistoryRecord(double firstNumber, double secondNumber, String mathOperation, double result) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.mathOperation = mathOperation;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public void setFirstNumber(double firstNumber) {
        this.firstNumber = firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setSecondNumber(double secondNumber) {
        this.secondNumber = secondNumber;
    }

    public String getMathOperation() {
        return mathOperation;
    }

    public void setMathOperation(String mathOperation) {
        this.mathOperation = mathOperation;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }
}
