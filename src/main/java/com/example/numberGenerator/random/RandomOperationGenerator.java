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

    @Autowired
    private OperationRange rangeNumber;

    public Operation generate() {

        double firstArg = Math.random();
        double secondArg = Math.random();

        Operation operation = new Operation();

        operation.setOperationName(rangeNumber.getOperationName());
        operation.setArgFirst(firstArg);
        operation.setArgSecond(secondArg);

        return operation;
    }
}
