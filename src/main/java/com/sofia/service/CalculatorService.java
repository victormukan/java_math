package com.sofia.service;

import com.sofia.dto.MathOperation;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final int PROCENT_DIVIDER = 100;

    public Double doOperation(MathOperation mathOperation) {
        Double result = null;
        switch (mathOperation.getOperationType()) {
            case ADD:
                result = addNumbers(mathOperation);
                break;
            case DEVIDE:
                result = divideNumber(mathOperation);
                break;
            case MULTIPLY:
                result = multiplyNumber(mathOperation);
                break;
            case DISTRACT:
                result = distractNumber(mathOperation);
                break;
            case PROCENT:
                result = getPercentOfNumber(mathOperation);
                break;
        }
        return result;
    }

    public double addNumbers(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() + mathOperation.getSecondNumber();
    }

    public double divideNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() / mathOperation.getSecondNumber();
    }

    public double multiplyNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() * mathOperation.getSecondNumber();
    }

    public double distractNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() - mathOperation.getSecondNumber();
    }

    public double getPercentOfNumber(MathOperation mathOperation){
        return mathOperation.getFirstNumber() * (mathOperation.getSecondNumber() / PROCENT_DIVIDER);
    }
}
