package com.PulsarTestApp.pulsarTestApp.services;

import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    private PulsarClient client;
    private Consumer consumer;

    @Override
    public void buildConsumer(String service_url, String topic_name, String subscriptionName) throws PulsarClientException {
        client = PulsarClient.builder()
                .serviceUrl(service_url)
                .build();

        consumer = client.newConsumer()
                .topic(topic_name)
                .subscriptionName(subscriptionName)
                .subscriptionType(SubscriptionType.Shared)
                .subscribe();

        Runnable task = () -> {
            try {
                checkMessages(subscriptionName);
            } catch (PulsarClientException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(task);
        thread.start();
    }

    private void checkMessages(String subName) throws PulsarClientException {
        while (true) {
            Message msg = consumer.receive();

            try {
                var data = new String(msg.getData());
                System.out.println(subName+ "|| Message : " + data);
                consumer.acknowledge(msg);
            } catch (Exception e) {
                consumer.negativeAcknowledge(msg);
            }
        }
    }
}
