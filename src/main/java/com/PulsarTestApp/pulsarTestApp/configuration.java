package com.PulsarTestApp.pulsarTestApp;

import com.PulsarTestApp.pulsarTestApp.services.ConsumerService;
import com.PulsarTestApp.pulsarTestApp.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component("VeraConfiguration")
public class configuration {

    @Autowired
    private ProducerService producerService;

    @Autowired
    private ConsumerService consumerService;

    private static final String SERVICE__URL = "pulsar://localhost:6650";
    private static final String TOPIC__NAME = "test-topic534345345";

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws Exception {
        producerService.buildProducer(SERVICE__URL, TOPIC__NAME);
        consumerService.buildConsumer(SERVICE__URL, TOPIC__NAME, "sub1");
        consumerService.buildConsumer(SERVICE__URL, TOPIC__NAME, "sub2");
        consumerService.buildConsumer(SERVICE__URL, TOPIC__NAME, "sub3");
    }

}
