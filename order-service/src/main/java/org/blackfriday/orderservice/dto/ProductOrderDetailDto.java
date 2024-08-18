package org.blackfriday.orderservice.dto;

import lombok.Builder;
import org.blackfriday.orderservice.enums.OrderStatus;

@Builder
public class ProductOrderDetailDto {

    private final Long id;
    private final Long userId;
    private final Long productId;
    private final Long count;
    private final OrderStatus orderStatus;
    private final Long paymentId;
    private final Long deliveryId;

    @Builder
    private ProductOrderDetailDto(
            final Long id,
            final Long userId,
            final Long productId,
            final Long count,
            final OrderStatus orderStatus,
            final Long paymentId,
            final Long deliveryId
    ) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.orderStatus = orderStatus;
        this.paymentId = paymentId;
        this.deliveryId = deliveryId;
    }
}
