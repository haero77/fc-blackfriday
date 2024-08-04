package org.blackfriday.paymentservice.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.blackfriday.paymentservice.enums.PaymentMethodType;
import org.blackfriday.paymentservice.enums.PaymentStatus;


@Entity
@Table(indexes = {@Index(name = "idx_userId", columnList = "userId")})
@Getter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long id;

    public Long userId;

    @Column(unique = true)
    public Long orderId; // 한 주문에 Payment는 한 개만 생성되어야함.

    public Long amountKRW;

    public PaymentMethodType paymentMethodType;

    public String paymentData; // ex: credit card 번호. 다른 테이블로 빼는게 낫긴하다.

    @Enumerated(value = EnumType.STRING)
    public PaymentStatus paymentStatus;

    @Column(unique = true)
    public Long referenceCode; // 외부시스템 매핑

    protected Payment() {
    }

    @Builder
    public Payment(
            final Long userId,
            final Long orderId,
            final Long amountKRW,
            final PaymentMethodType paymentMethodType,
            final String paymentData,
            final PaymentStatus paymentStatus,
            final Long referenceCode
    ) {
        this.userId = userId;
        this.orderId = orderId;
        this.amountKRW = amountKRW;
        this.paymentMethodType = paymentMethodType;
        this.paymentData = paymentData;
        this.paymentStatus = paymentStatus;
        this.referenceCode = referenceCode;
    }
}
