package org.blackfriday.paymentservice.pg;

import org.springframework.stereotype.Service;

@Service
public class EasyCreditCardPaymentAdapter implements CreditCardPaymentAdapter {

    @Override
    public Long processCreditPayment(final Long amountKRW, final String creditCardNumber) {
        // actual process with external system
        return Math.round(Math.random() * 1000_0000);
    }
}
