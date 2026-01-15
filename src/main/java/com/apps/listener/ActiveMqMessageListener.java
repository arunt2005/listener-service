package com.apps.listener;

import com.apps.dto.OrderMessage;
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

    @JmsListener(destination = "order-queue")
    public void onMessage(OrderMessage order) {
        // The JSON is already converted back to an OrderRequest object here
        System.out.println("Received order: " + order.getProduct() + " x" + order.getQuantity());
    }
}

