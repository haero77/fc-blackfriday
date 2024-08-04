package org.blackfriday.paymentservice.pg;

public interface CreditCardPaymentAdapter {

    /**
     * @return referenceCode of Payment
     */
    Long processCreditPayment(Long amountKRW, String creditCardNumber);
}
