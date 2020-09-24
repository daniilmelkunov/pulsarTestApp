package com.PulsarTestApp.pulsarTestApp.services;

import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private PulsarClient client;
    private Consumer consumer;

    @Override
    public void buildConsumer(String service_url, String topic_name) throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl(service_url)
                .build();

        consumer = client.newConsumer()
                .topic(topic_name)
                .subscriptionName("my-subscription")
                .subscribe();

        while (true) {
            Message msg = consumer.receive();

            try {
                var data = new String(msg.getData());
                System.out.printf("Message received: %s", data);
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        }
    }
}
