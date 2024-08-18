package org.blackfriday.orderservice.dto;

import lombok.Builder;
import lombok.Getter;
import org.blackfriday.orderservice.repository.ProductOrderRepository;

import java.util.Map;

@Getter
public class StartOrderResponseDto {

    private final Long orderId;

    private final Map<String, Object> paymentMethod;

    private final Map<String, Object> address;

    @Builder
    private StartOrderResponseDto(
            final Long orderId,
            final Map<String, Object> paymentMethod,
            final Map<String, Object> address
    ) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.address = address;
    }
}
