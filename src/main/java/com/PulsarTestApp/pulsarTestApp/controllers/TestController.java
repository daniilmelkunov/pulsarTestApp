package com.PulsarTestApp.pulsarTestApp.controllers;

import com.PulsarTestApp.pulsarTestApp.MessageTest;
import com.PulsarTestApp.pulsarTestApp.services.ProducerService;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class testController {

    @Autowired
    private ProducerService producerService;

    @RequestMapping(value = {"test"}, method = RequestMethod.POST)
    public void test(@RequestBody MessageTest messageTest) throws PulsarClientException {
        producerService.sendMessage(messageTest);
    }
}
