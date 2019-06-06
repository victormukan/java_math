package com.sofia.dao;

import com.sofia.model.MathOperation;

public class MathOperationDAO {
    private static final int PROCENT_DIVIDER = 100;

    public static double addNumbers(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() + mathOperation.getSecondNumber();
    }

    public static double divideNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() / mathOperation.getSecondNumber();
    }

    public static double multiplyNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() * mathOperation.getSecondNumber();
    }

    public static double distractNumber(MathOperation mathOperation) {
        return  mathOperation.getFirstNumber() - mathOperation.getSecondNumber();
    }

    public static double getPercentOfNumber(MathOperation mathOperation){
        return mathOperation.getFirstNumber() * (mathOperation.getSecondNumber() / PROCENT_DIVIDER);
    }

}
