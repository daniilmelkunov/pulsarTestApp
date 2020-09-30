package com.PulsarTestApp.pulsarTestApp.services;

import com.PulsarTestApp.pulsarTestApp.MessageTest;
import org.apache.pulsar.client.api.*;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

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
        producer.send("Test message1".getBytes());
        producer.send("Test message2".getBytes());
        producer.send("Test message3".getBytes());
        producer.send("Test message4".getBytes());
        producer.send("Test message5".getBytes());
        producer.send("Test message6".getBytes());
        producer.send("Test message7".getBytes());
        producer.send("Test message8".getBytes());
        producer.send("Test message9".getBytes());
        producer.send("Test message".getBytes());
        producer.send("Test message234".getBytes());
        producer.send("Test message3123".getBytes());
        producer.send("Test message4234".getBytes());
        producer.send("Test message23423".getBytes());
        producer.send("Test message324234".getBytes());
        producer.send("Test message234".getBytes());
        producer.send("23423".getBytes());
        producer.send("234234".getBytes());
        producer.send("wrwerwer".getBytes());
        producer.send("wrw2322gggerwer".getBytes());
        producer.send("wwerwerwerwerwerrw2322gggwrwwerweerwer".getBytes());
        producer.send("hrthrhfhfgh".getBytes());
        producer.send("5u56uujytjtyi67t6j".getBytes());
    }

    @Override
    public void sendMessage(MessageTest messageTest) throws PulsarClientException {
        String message = messageTest.username + ": "+ messageTest.message;
        producer.send(message.getBytes());
    }


}
