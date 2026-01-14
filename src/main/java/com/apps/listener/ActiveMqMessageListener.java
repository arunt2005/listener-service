package com.apps.listener;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "messaging.broker", havingValue = "activemq")
public class ActiveMqMessageListener {

    @JmsListener(destination = "${messaging.queue}")
    public void onMessage(String message) {
        System.out.println("📩 ActiveMQ received message: " + message);
    }
}

