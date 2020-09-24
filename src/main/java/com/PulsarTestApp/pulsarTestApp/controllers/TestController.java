package com.PulsarTestApp.pulsarTestApp.controllers;

import com.PulsarTestApp.pulsarTestApp.services.ProducerService;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class testController {

    @GetMapping(value = "/test")
    public String test(){
        return "test";
    }
}
