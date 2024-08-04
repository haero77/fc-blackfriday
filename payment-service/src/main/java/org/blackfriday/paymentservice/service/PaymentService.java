package org.blackfriday.paymentservice.service;

import lombok.RequiredArgsConstructor;
import org.apache.el.util.ReflectionUtil;
import org.blackfriday.paymentservice.entity.Payment;
import org.blackfriday.paymentservice.entity.PaymentMethod;
import org.blackfriday.paymentservice.enums.PaymentMethodType;
import org.blackfriday.paymentservice.enums.PaymentStatus;
import org.blackfriday.paymentservice.pg.CreditCardPaymentAdapter;
import org.blackfriday.paymentservice.repository.PaymentMethodRepository;
import org.blackfriday.paymentservice.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final CreditCardPaymentAdapter creditCardPaymentAdapter;

    public PaymentMethod registerPaymentMethod(
            final Long userId,
            final PaymentMethodType paymentMethodType,
            final String creditCardNumber
    ) {
        final PaymentMethod paymentMethod = new PaymentMethod(userId, paymentMethodType, creditCardNumber);
        return paymentMethodRepository.save(paymentMethod);
    }

    public Payment processPayment(
            final Long userId,
            final Long orderId,
            final Long amountKRW,
            final Long paymentMethodId
    ) throws Exception {
        final PaymentMethod paymentMethod = paymentMethodRepository.findById(paymentMethodId).orElseThrow();

        if (!paymentMethod.matchesPaymentMethodType(PaymentMethodType.CREDIT_CARD)) {
            throw new Exception("Unsupported payment method type");
        }

        final Long referenceCode = creditCardPaymentAdapter.processCreditPayment(amountKRW, paymentMethod.getCreditCardNumber());

        final Payment payment = Payment.builder()
                .userId(userId)
                .orderId(orderId)
                .amountKRW(amountKRW)
                .paymentMethodType(paymentMethod.getPaymentMethodType())
                .paymentData(paymentMethod.getCreditCardNumber())
                .paymentStatus(PaymentStatus.COMPLETED)
                .referenceCode(referenceCode)
                .build();

        return paymentRepository.save(payment);
    }

    public PaymentMethod getPaymentMethodByUser(final Long userId) {
        return paymentMethodRepository.findByUserId(userId).stream()
                .findFirst()
                .orElseThrow();
    }

    public Payment getPayment(final Long paymentId) {
        return paymentRepository.findById(paymentId).orElseThrow();
    }
}
