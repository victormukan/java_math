package com.sofia.service;

import com.sofia.dto.MathOperation;
import org.springframework.stereotype.Service;

import static org.apache.cxf.common.jaxb.JAXBUtils.LOG;

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

    private double addNumbers(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() + mathOperation.getSecondNumber();
    }

    private double divideNumber(MathOperation mathOperation) throws ArithmeticException{
        double result = Double.parseDouble(null);
        try {
            result = mathOperation.getFirstNumber() / mathOperation.getSecondNumber();
        } catch (ArithmeticException e) {
            LOG.info("YOU CANT DIVIDE IN THIS CALCULATOR!!!!!!");
            LOG.info("IT WILL BE INFINITY ANYWAY. JUST DON`T TRY TO DO THIS ONE MORE TOME");
        }
        return result;
    }

    private double multiplyNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() * mathOperation.getSecondNumber();
    }

    private double distractNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() - mathOperation.getSecondNumber();
    }

    private double getPercentOfNumber(MathOperation mathOperation){
        return mathOperation.getFirstNumber() * (mathOperation.getSecondNumber() / PROCENT_DIVIDER);
    }
}
