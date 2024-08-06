package org.blackfriday.deliveryservice.service;

import lombok.RequiredArgsConstructor;
import org.blackfriday.deliveryservice.dg.DeliveryAdapter;
import org.blackfriday.deliveryservice.entity.Delivery;
import org.blackfriday.deliveryservice.entity.UserAddress;
import org.blackfriday.deliveryservice.enums.DeliveryStatus;
import org.blackfriday.deliveryservice.repository.DeliveryRepository;
import org.blackfriday.deliveryservice.repository.UserAddressRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final UserAddressRepository userAddressRepository;
    private final DeliveryAdapter deliveryAdapter;

    public UserAddress addUserAddress(
            final String userId,
            final String address,
            final String alias
    ) {
        final UserAddress userAddress = UserAddress.builder()
                .userId(userId)
                .address(address)
                .alias(alias)
                .build();
        return userAddressRepository.save(userAddress);
    }

    public Delivery processDelivery(
            final Long orderId,
            final String productName,
            final Long productCount,
            final String address
    ) {
        final Long referenceCode = deliveryAdapter.processDelivery(productName, productCount, address);

        final Delivery delivery = Delivery.builder()
                .orderId(orderId)
                .deliveryStatus(DeliveryStatus.REQUESTED)
                .productName(productName)
                .productCount(productCount)
                .address(address)
                .referenceCode(referenceCode)
                .build();
        return deliveryRepository.save(delivery);
    }

    public Delivery getDelivery(final Long deliveryId) {
        return deliveryRepository.findById(deliveryId).orElseThrow();
    }

    public UserAddress getAddress(final Long addressId) {
        return userAddressRepository.findById(addressId).orElseThrow();
    }

    public UserAddress getUserAddress(final Long userId) {
        return userAddressRepository.findAllByUserId(userId).stream()
                .findFirst()
                .orElseThrow();
    }
}
