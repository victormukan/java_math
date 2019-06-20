package com.sofia.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="history")
public class HistoryRecord {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name="firstNumber")
    private double firstNumber;

    @Column(name="secondNumber")
    private double secondNumber;

    @Column(name="mathOperation")
    private String mathOperation;

    @Column(name="result")
    private double result;

    @Column(name="requestTime")
    private String requestTime;

    public HistoryRecord() {
    }

    public HistoryRecord(double firstNumber, double secondNumber, String mathOperation, double result, String requestTime) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.mathOperation = mathOperation;
        this.result = result;
        this.requestTime = requestTime;
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

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }
}
