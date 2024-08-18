package org.blackfriday.orderservice.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ProcessDeliveryDto {

    private final Long orderId;
    private final String productName;
    private final Long productCount;
    private final String address;

    @Builder
    private ProcessDeliveryDto(
            final Long orderId,
            final String productName,
            final Long productCount,
            final String address
    ) {
        this.orderId = orderId;
        this.productName = productName;
        this.productCount = productCount;
        this.address = address;
    }
}
