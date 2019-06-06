package com.sofia.bussinessobj;

import com.sofia.model.MathOperation;

import static com.sofia.dao.MathOperationDAO.*;

public class MathOperationBO {

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
}
