package com.PulsarTestApp.pulsarTestApp.services;

import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

@Service
public interface ConsumerService {
    void buildConsumer(String service_url, String topic_name) throws PulsarClientException;
}
