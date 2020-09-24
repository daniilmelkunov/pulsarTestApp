package com.PulsarTestApp.pulsarTestApp.services;

import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Service;

@Service
public class ProducerServiceImpl implements ProducerService {



    private PulsarClient client;
    private Producer<byte[]> producer;

    @Override
    public void buildProducer(String service_url, String topic_name) throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl(service_url)
                .build();

        producer = client.newProducer()
                .topic(topic_name)
                .create();
    }

    @Override
    public void sendTestMessage() throws PulsarClientException {
        producer.send("Test message".getBytes());
    }


}
