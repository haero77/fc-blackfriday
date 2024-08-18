package org.blackfriday.orderservice.dto;

import lombok.Getter;

@Getter
public class FinishOrderDto {

    private Long orderId;
    private Long paymentMethodId;
    private Long addressId;

    public FinishOrderDto() {
    }
}
