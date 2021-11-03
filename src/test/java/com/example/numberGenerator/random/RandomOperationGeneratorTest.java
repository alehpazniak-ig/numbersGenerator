package com.example.numberGenerator.random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class RandomOperationGeneratorTest {

    @Autowired
    RandomOperationGenerator randomOperationGenerator;

    @BeforeEach
    void setup() {
        randomOperationGenerator = new RandomOperationGenerator();
    }

    @Test
    void shouldGenerate() {
        var operation = randomOperationGenerator.generate();

        assertNotNull(operation);
        assertNotNull(operation.getOperationName());
        assertNotNull(operation.getArgFirst());
        assertNotNull(operation.getArgSecond());
    }

}