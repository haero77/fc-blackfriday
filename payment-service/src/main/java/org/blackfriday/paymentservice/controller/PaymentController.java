package org.blackfriday.paymentservice.controller;

import jakarta.persistence.GeneratedValue;
import org.blackfriday.paymentservice.dto.PaymentMethodDto;
import org.blackfriday.paymentservice.dto.ProcessPaymentDto;
import org.blackfriday.paymentservice.entity.Payment;
import org.blackfriday.paymentservice.entity.PaymentMethod;
import org.blackfriday.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/payment/methods")
    public PaymentMethod registerPaymentMethod(
            @RequestBody final PaymentMethodDto dto
    ) {
        final PaymentMethod paymentMethod = paymentService.registerPaymentMethod(
                dto.getUserId(),
                dto.getPaymentMethodType(),
                dto.getCreditCardNumber()
        );

        return paymentMethod;
    }

    @PostMapping("/payment/process-payment")
    public Payment processPayment(
            @RequestBody final ProcessPaymentDto dto
    ) throws Exception {
        final Payment payment = paymentService.processPayment(
                dto.getUserId(),
                dto.getOrderId(),
                dto.getAmountKRW(),
                dto.getPaymentMethodId()
        );

        return payment;
    }

    @GetMapping("/payment/users/{userId}/first-method")
    public PaymentMethod getPaymentMethod(@PathVariable final Long userId) {
        final PaymentMethod paymentMethod = paymentService.getPaymentMethodByUser(userId);
        return paymentMethod;
    }

    @GetMapping("/payment/payments/{paymentId}")
    public Payment getPayment(@PathVariable final Long paymentId) {
        return paymentService.getPayment(paymentId);
    }
}
