package com.example.numberGenerator.random;

import com.example.numberGenerator.domain.Operation;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class RandomOperationGenerator {

    @Value("${app.operationgenerator.operation.generate.lowLimit}")
    private Double lowLimit;
    @Value("${app.operationgenerator.operation.generate.upperLimit}")
    private Double upperLimit;

    @Autowired
    private RandomOperationNameGenerator randomOperationNameGenerator;

    public Operation generate() {

        double argFirst = Math.random() * (upperLimit - lowLimit) + lowLimit;
        double argSecond = Math.random() * (upperLimit - lowLimit) + lowLimit;

        Operation operation = new Operation();

        operation.setOperationName(randomOperationNameGenerator.getOperationName());
        operation.setArgFirst(argFirst);
        operation.setArgSecond(argSecond);
        return operation;
    }
}
