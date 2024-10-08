package org.blackfriday.orderservice.feign;

import org.blackfriday.orderservice.dto.ProcessPaymentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(name = "feignClient", url = "http://payment-service:8080")
public interface PaymentClient {

    @GetMapping("/payment/users/{userId}/first-method")
    Map<String, Object> getPaymentMethod(@PathVariable Long userId);

    @PostMapping("/payment/process-payment")
    Map<String, Object> processPayment(@RequestBody ProcessPaymentDto dto);

    @GetMapping("/payment/payments/{paymentId}")
    Map<String, Object> getPayment(@PathVariable Long paymentId);
}
