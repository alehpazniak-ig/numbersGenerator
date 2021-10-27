package com.example.numberGenerator.random;

import com.example.numberGenerator.domain.Operation;
import com.example.numberGenerator.enumeration.OperationName;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomOperationGenerator {

    public Operation generate() {

        double firstArg = Math.random();
        double secondArg = Math.random();

        Operation operation = new Operation();

        operation.setOperationName(generateOperationName());
        operation.setFirstArg(firstArg);
        operation.setSecondArg(secondArg);

        return operation;
    }

    public static OperationName generateOperationName() {
        OperationName[] values = OperationName.values();
        int length = values.length;
        int randomIndex = new Random().nextInt(length);
        return values[randomIndex];
    }
}
