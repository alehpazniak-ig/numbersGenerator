package com.example.numberGenerator.random;

import com.example.numberGenerator.enumeration.OperationName;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OperationRangeTest {

    @Autowired
    private OperationRange operationRange;

    @Test
    void test() {

        assertEquals(10, operationRange.getAdditionRate());
        assertEquals(20, operationRange.getMultiplyRate());
        assertEquals(30, operationRange.getSubtractRate());
        assertEquals(40, operationRange.getDivideRate());
    }

    @Test
    void rangeNumber100PercentsDivTest() {

        var operationRange = new OperationRange();
        operationRange.setDivideRate(100);
        operationRange.setAdditionRate(0);
        operationRange.setMultiplyRate(0);
        operationRange.setSubtractRate(0);

        for (int i = 0; i < 1000; i++) {
            assertSame(operationRange.getOperationName(), OperationName.DIVIDE);
        }
    }

    @Test
    void rangeNumber100PercentsAddTest() {

        var operationRange = new OperationRange();
        operationRange.setDivideRate(0);
        operationRange.setAdditionRate(100);
        operationRange.setMultiplyRate(0);
        operationRange.setSubtractRate(0);

        for (int i = 0; i < 100; i++) {
            assertSame(operationRange.getOperationName(), OperationName.ADDITION);
        }
    }

    @Test
    void rangeNumber100PercentsMulTest() {

        var operationRange = new OperationRange();
        operationRange.setDivideRate(0);
        operationRange.setAdditionRate(0);
        operationRange.setMultiplyRate(100);
        operationRange.setSubtractRate(0);

        for (int i = 0; i < 100; i++) {
            assertSame(operationRange.getOperationName(), OperationName.MULTIPLY);
        }
    }

    @Test
    void rangeNumber100PercentsSubTest() {
        var operationRange = new OperationRange();
        operationRange.setDivideRate(0);
        operationRange.setAdditionRate(0);
        operationRange.setMultiplyRate(0);
        operationRange.setSubtractRate(100);

        for (int i = 0; i < 100; i++) {
            assertSame(operationRange.getOperationName(), OperationName.SUBTRACT);
        }
    }

    @Test
    void validateRateException() {
        operationRange.setAdditionRate(25);
        operationRange.setSubtractRate(25);
        operationRange.setMultiplyRate(25);
        operationRange.setDivideRate(20);

        Exception exception = assertThrows(IllegalStateException.class, operationRange::validateRate);
        assertTrue(exception.getMessage().startsWith("Sum of all rates must be 100%"));
    }

    @Test
    void validateRate() {
        operationRange.setAdditionRate(25);
        operationRange.setSubtractRate(25);
        operationRange.setMultiplyRate(25);
        operationRange.setDivideRate(25);

        operationRange.validateRate();
    }

    @Test
    void getOperationName() {

        int probabilityAddition = 10;
        int probabilitySubtract = 20;
        int probabilityMultiply = 30;
        int probabilityDivide = 40;

        operationRange.setAdditionRate(probabilityAddition);
        operationRange.setSubtractRate(probabilitySubtract);
        operationRange.setMultiplyRate(probabilityMultiply);
        operationRange.setDivideRate(probabilityDivide);

        int countDiv = 0;
        int countAdd = 0;
        int countSub = 0;
        int countMul = 0;

        int numberOfSamples = 1000;

        for (int i = 0; i < numberOfSamples; i++) {
            OperationName operationName = operationRange.getOperationName();
            switch (operationName) {
                case ADDITION:
                    ++countAdd;
                    break;
                case DIVIDE:
                    ++countDiv;
                    break;
                case SUBTRACT:
                    ++countSub;
                    break;
                case MULTIPLY:
                    ++countMul;
                    break;
            }
        }
        int percentProbabilityAddition = countAdd * 100 / 1000;
        int percentProbabilityDivide = countDiv * 100 / 1000;
        int percentProbabilitySubtract = countSub * 100 / 1000;
        int percentProbabilityMultiply = countMul * 100 / 1000;

        assertThat(percentProbabilityAddition).isCloseTo(probabilityAddition, Offset.offset(5));
        assertThat(percentProbabilityDivide).isCloseTo(probabilityDivide, Offset.offset(5));
        assertThat(percentProbabilitySubtract).isCloseTo(probabilitySubtract, Offset.offset(5));
        assertThat(percentProbabilityMultiply).isCloseTo(probabilityMultiply, Offset.offset(5));
    }
}