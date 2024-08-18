package org.blackfriday.orderservice.dto;

public class ProcessPaymentDto {

    private final Long userId;
    private final Long orderId;
    private final Long amountKRW;
    private final Long paymentMethodId;

    public ProcessPaymentDto(final Long userId, final Long orderId, final Long amountKRW, final Long paymentMethodId) {
        this.userId = userId;
        this.orderId = orderId;
        this.amountKRW = amountKRW;
        this.paymentMethodId = paymentMethodId;
    }
}
