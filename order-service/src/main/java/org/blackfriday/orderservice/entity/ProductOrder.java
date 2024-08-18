package org.blackfriday.orderservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.blackfriday.orderservice.enums.OrderStatus;

@Entity
@Getter
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_order_id")
    private Long id;

    private Long userId;
    private Long productId; // 단일 상품에 대해서만 주문 가능하다고 가정.
    private Long count;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    private Long paymentId;
    private Long deliveryId;

    protected ProductOrder() {
    }

    @Builder
    private ProductOrder(final Long userId, final Long productId, final Long count, final OrderStatus orderStatus, final Long paymentId, final Long deliveryId) {
        this.userId = userId;
        this.productId = productId;
        this.count = count;
        this.orderStatus = orderStatus;
        this.paymentId = paymentId;
        this.deliveryId = deliveryId;
    }
}
