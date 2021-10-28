package com.example.numberGenerator.schedule;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class RandomOperationSenderTest {

    @MockBean
    RestTemplate mockRestTemplate;

    @Autowired
    RandomOperationSender randomOperationSender;

    @Test
    void sendRandomOperation() {

    }
}