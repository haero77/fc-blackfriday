package org.blackfriday.deliveryservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.blackfriday.deliveryservice.enums.DeliveryStatus;
import org.hibernate.event.internal.ProxyVisitor;

@Entity
@Table(indexes = {@Index(name = "idx_orderId", columnList = "orderId")})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "delivery_id")
    private Long id;

    private Long orderId;

    @Enumerated(value = EnumType.STRING)
    private DeliveryStatus deliveryStatus;

    private String productName;

    private Long productCount; // 비정규화

    private String address;

    private Long referenceCode; // 외부 연동 시

    @Builder
    private Delivery(
            final Long orderId,
            final DeliveryStatus deliveryStatus,
            final String productName,
            final Long productCount,
            final String address,
            final Long referenceCode
    ) {
        this.orderId = orderId;
        this.deliveryStatus = deliveryStatus;
        this.productName = productName;
        this.productCount = productCount;
        this.address = address;
        this.referenceCode = referenceCode;
    }
}
