package com.example.numberGenerator.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomOperationGeneratorTest {

    RandomOperationGenerator randomOperationGenerator;

    @BeforeEach
    void setup(){
        randomOperationGenerator = new RandomOperationGenerator();
    }

    @Test
    void shouldGenerate() {
        var operation = randomOperationGenerator.generate();

        assertNotNull(operation);
        assertNotNull(operation.getOperationName());
        assertNotNull(operation.getFirstArg());
        assertNotNull(operation.getSecondArg());
    }
}