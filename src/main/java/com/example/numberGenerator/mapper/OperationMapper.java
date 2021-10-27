package com.example.numberGenerator.mapper;

import com.example.numberGenerator.domain.Operation;
import com.example.numberGenerator.enumeration.OperationName;

public class OperationMapper {
    public static Operation map(double firstArg, double secondArg, OperationName operationName) {
        Operation operation = new Operation();
        operation.setOperationName(operationName);
        operation.setFirstArg(firstArg);
        operation.setSecondArg(secondArg);

        return operation;
    }
}
