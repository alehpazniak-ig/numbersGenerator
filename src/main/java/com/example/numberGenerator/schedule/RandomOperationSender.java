package com.example.numberGenerator.schedule;

import com.example.numberGenerator.domain.Operation;
import com.example.numberGenerator.enumeration.OperationName;
import com.example.numberGenerator.random.RandomOperationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomOperationSender {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RandomOperationGenerator generator;

    @Scheduled(fixedRate = 2000)
    public void sendRandomOperation() {

        OperationName op = RandomOperationGenerator.generateOperationName();
        Operation operation = new Operation();
        String SQL_CALCULATOR = "http://localhost:8080/api/calculator";
        switch (op) {
            case ADD:
                restTemplate.postForObject(
                        SQL_CALCULATOR + "/addition/{firstArg}/{secondArg}",
                        operation,
                        Operation.class,
                        generator.generate().getFirstArg(), generator.generate().getSecondArg());
                break;
            case SUB:
                restTemplate.postForObject(
                        SQL_CALCULATOR + "/subtract/{firstArg}/{secondArg}",
                        operation,
                        Operation.class,
                        generator.generate().getFirstArg(), generator.generate().getSecondArg());
                break;
            case MUl:
                restTemplate.postForObject(
                        SQL_CALCULATOR + "/multiply/{firstArg}/{secondArg}",
                        operation,
                        Operation.class,
                        generator.generate().getFirstArg(), generator.generate().getSecondArg());
                break;
            case DIV:
                restTemplate.postForObject(
                        SQL_CALCULATOR + "/divide/{firstArg}/{secondArg}",
                        operation,
                        Operation.class,
                        generator.generate().getFirstArg(), generator.generate().getSecondArg());
                break;
        }
    }
}
