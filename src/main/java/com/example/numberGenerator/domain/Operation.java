package com.example.numberGenerator.domain;

import com.example.numberGenerator.enumeration.OperationName;

public class Operation {

    private double firstArg;
    private double secondArg;
    private OperationName operationName;

    public double getFirstArg() {
        return firstArg;
    }

    public void setFirstArg(double firstArg) {
        this.firstArg = firstArg;
    }

    public double getSecondArg() {
        return secondArg;
    }

    public void setSecondArg(double secondArg) {
        this.secondArg = secondArg;
    }

    public OperationName getOperationName() {
        return operationName;
    }

    public void setOperationName(OperationName operationName) {
        this.operationName = operationName;
    }
}
