package com.example.numberGenerator.domain;

import com.example.numberGenerator.enumeration.OperationName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Operation {

    private double firstArg;
    private double secondArg;
    private OperationName operationName;

    @Override
    public String toString() {
        return "Operation{" +
                "firstArg=" + firstArg +
                ", secondArg=" + secondArg +
                ", operationName=" + operationName +
                '}';
    }
}
