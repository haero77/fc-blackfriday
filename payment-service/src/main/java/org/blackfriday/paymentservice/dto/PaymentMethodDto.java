package org.blackfriday.paymentservice.dto;

import lombok.Getter;
import org.blackfriday.paymentservice.enums.PaymentMethodType;

@Getter
public class PaymentMethodDto {

    private Long userId;
    private PaymentMethodType paymentMethodType;
    private String creditCardNumber;
}
