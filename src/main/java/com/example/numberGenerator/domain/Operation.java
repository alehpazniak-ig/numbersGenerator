package com.example.numberGenerator.domain;

import com.example.numberGenerator.enumeration.OperationName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Operation {

    private OperationName operationName;
    private double argFirst;
    private double argSecond;
    private double result;
}
