package org.blackfriday.paymentservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.blackfriday.paymentservice.enums.PaymentMethodType;

@Entity
@Table(indexes = {@Index(name = "idx_userId", columnList = "userId")})
@Getter
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id")
    public Long id;

    private Long userId;

    @Enumerated(value = EnumType.STRING)
    private PaymentMethodType paymentMethodType;

    private String creditCardNumber;

    protected PaymentMethod() {
    }

    public PaymentMethod(
            final Long userId,
            final PaymentMethodType paymentMethodType,
            final String creditCardNumber
    ) {
        this.userId = userId;
        this.paymentMethodType = paymentMethodType;
        this.creditCardNumber = creditCardNumber;
    }

    public boolean matchesPaymentMethodType(final PaymentMethodType paymentMethodType) {
        return this.paymentMethodType == paymentMethodType;
    }
}
