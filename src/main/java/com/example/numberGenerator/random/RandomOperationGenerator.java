package com.example.numberGenerator.random;

import com.example.numberGenerator.domain.Operation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RandomOperationGenerator {

    private Double lowLimit = 1.0;
    private Double upperLimit = 50.0;

    @Autowired
    private RandomOperationNameGenerator randomOperationNameGenerator;

    public Operation generate() {

        double firstArg = Math.random() * (upperLimit - lowLimit) + lowLimit;
        double secondArg = Math.random() * (upperLimit - lowLimit) + lowLimit;

        Operation operation = new Operation();

        operation.setOperationName(randomOperationNameGenerator.getOperationName());
        operation.setArgFirst(firstArg);
        operation.setArgSecond(secondArg);
        return operation;
    }
}
