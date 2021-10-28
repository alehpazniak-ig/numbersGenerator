package com.example.numberGenerator.schedule;

import com.example.numberGenerator.domain.Operation;
import com.example.numberGenerator.random.RandomOperationGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RandomOperationSender {

    private static final String SQL_CALCULATOR_URL = "http://localhost:8080/api/calculator";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RandomOperationGenerator generator;

    @Scheduled(fixedRate = 2000)
    public void sendRandomOperation() {
        String operationURL = "";

        Operation operation = generator.generate();
        switch (operation.getOperationName()) {
            case ADD:
                operationURL = "/addition";
                break;
            case SUB:
                operationURL = "/subtract";
                break;
            case MUL:
                operationURL = "/multiply";
                break;
            case DIV:

                operationURL = "/divide";
                break;
        }

        String requstURL = SQL_CALCULATOR_URL + operationURL + "/{firstArg}/{secondArg}";
        System.out.println("sending request to " + requstURL + "with operation " + operation.getOperationName());
        var result = restTemplate.getForObject(requstURL, Operation.class,
                operation.getFirstArg(), operation.getSecondArg());
        System.out.println("result: DONE");
    }
}
