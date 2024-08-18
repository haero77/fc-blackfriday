package org.blackfriday.deliveryservice.controller;

import lombok.RequiredArgsConstructor;
import org.blackfriday.deliveryservice.dto.ProcessDeliveryDto;
import org.blackfriday.deliveryservice.dto.RegisterAddressDto;
import org.blackfriday.deliveryservice.entity.Delivery;
import org.blackfriday.deliveryservice.entity.UserAddress;
import org.blackfriday.deliveryservice.service.DeliveryService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @PostMapping("/delivery/addresses")
    public UserAddress registerAddress(@RequestBody RegisterAddressDto dto) {
        return deliveryService.addUserAddress(dto.getUserId(), dto.getAddress(), dto.getAlias());
    }

    @PostMapping("/delivery/process-delivery")
    public Delivery processDelivery(@RequestBody ProcessDeliveryDto dto) {
        return deliveryService.processDelivery(
                dto.getOrderId(),
                dto.getProductName(),
                dto.getProductCount(),
                dto.getAddress()
        );
    }

    @GetMapping("/delivery/deliveries/{deliveryId}")
    public Delivery getDelivery(@PathVariable Long deliveryId) {
        return deliveryService.getDelivery(deliveryId);
    }

    @GetMapping("/delivery/addresses/{addressId}")
    public UserAddress getAddress(@PathVariable Long addressId) {
        return deliveryService.getAddress(addressId);
    }

    @GetMapping("/delivery/users/{userId}/first-address")
    public UserAddress getUserAddress(@PathVariable Long userId) {
        return deliveryService.getUserAddress(userId);
    }
}
