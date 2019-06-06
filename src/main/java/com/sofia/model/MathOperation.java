package com.sofia.model;

public class MathOperation {
    private double firstNumber;
    private double secondNumber;
    private OperationType operationType;

    public MathOperation() {
    }

    public MathOperation(double firstNumber, double secondNumber, OperationType operationType) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operationType = operationType;
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

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
