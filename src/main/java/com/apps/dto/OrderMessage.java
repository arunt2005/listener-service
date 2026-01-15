package com.apps.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OrderMessage {

    private String orderId;
    private String product;
    private int quantity;


}
