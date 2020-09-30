package com.PulsarTestApp.pulsarTestApp.services;

import com.PulsarTestApp.pulsarTestApp.MessageTest;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

@Service
public interface ProducerService {
    void buildProducer(String service_url, String topic_name) throws PulsarClientException;
    void sendTestMessage() throws PulsarClientException;
    void sendMessage(MessageTest messageTest) throws PulsarClientException;
}
