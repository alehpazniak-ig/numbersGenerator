package com.example.numberGenerator.random;

import com.example.numberGenerator.domain.Operation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class RandomOperationGeneratorTest {

    @Autowired
    RandomOperationGenerator randomOperationGenerator;

    @Test
    void shouldGenerate() {
        Operation operation = randomOperationGenerator.generate();

        assertNotNull(operation);
        assertNotNull(operation.getOperationName());
        assertNotNull(operation.getArgFirst());
        assertNotNull(operation.getArgSecond());
    }
}