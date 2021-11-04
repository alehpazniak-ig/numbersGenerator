package com.example.numberGenerator.random;

import com.example.numberGenerator.enumeration.OperationName;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Component
@Getter
@Setter
public class RandomOperationNameGenerator {

    @Value("${app.operationgenerator.operation.rate.DIVIDE}")
    private Integer DivideRate;
    @Value("${app.operationgenerator.operation.rate.SUBTRACT}")
    private Integer SubtractRate;
    @Value("${app.operationgenerator.operation.rate.ADDITION}")
    private Integer AdditionRate;
    @Value("${app.operationgenerator.operation.rate.MULTIPLY}")
    private Integer MultiplyRate;

    @PostConstruct
    public void validateRate() {
        if (DivideRate + SubtractRate + AdditionRate + MultiplyRate != 100) {
            throw new IllegalStateException("Sum of all rates must be 100%");
        }
    }

    private static final Random RANDOM = new Random();

    public OperationName getOperationName() {
        int randomNum = RANDOM.nextInt(100);
        if (randomNum <= DivideRate) {
            return OperationName.DIVIDE;
        } else if (randomNum <= DivideRate + SubtractRate) {
            return OperationName.SUBTRACT;
        } else if (randomNum <= (DivideRate + SubtractRate + AdditionRate)) {
            return OperationName.ADDITION;
        } else {
            return OperationName.MULTIPLY;
        }
    }

}
