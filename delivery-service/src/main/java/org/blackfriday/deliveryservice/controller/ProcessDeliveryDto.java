package org.blackfriday.deliveryservice.controller;

import lombok.Getter;

@Getter
public class ProcessDeliveryDto {

    private Long orderId;
    private String productName;
    private Long productCount;
    private String address;

    public ProcessDeliveryDto() {
    }
}
