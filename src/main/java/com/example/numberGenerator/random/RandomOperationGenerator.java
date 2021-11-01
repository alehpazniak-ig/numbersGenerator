package com.example.numberGenerator.random;

import com.example.numberGenerator.domain.Operation;
import com.example.numberGenerator.enumeration.OperationName;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.SplittableRandom;

@Component
public class RandomOperationGenerator {

    public Operation generate() {

        double firstArg = Math.random();
        double secondArg = Math.random();

        Operation operation = new Operation();

        operation.setOperationName(generateOperationName());
        operation.setArgFirst(firstArg);
        operation.setArgSecond(secondArg);

        return operation;
    }

    public static OperationName generateOperationName() {
        SplittableRandom random = new SplittableRandom();
        boolean probablyFalse = random.nextInt(25) == 0;
        boolean whoKnows = random.nextInt(1, 101) == 25;
        int probability = 25;
        OperationName[] values = OperationName.values();
        int length = values.length;
        int randomIndex = new Random().nextInt(length);
        return values[randomIndex];
    }
}
