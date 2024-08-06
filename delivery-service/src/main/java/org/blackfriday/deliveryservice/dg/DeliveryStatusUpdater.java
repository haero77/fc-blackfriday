package org.blackfriday.deliveryservice.dg;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.blackfriday.deliveryservice.entity.Delivery;
import org.blackfriday.deliveryservice.enums.DeliveryStatus;
import org.blackfriday.deliveryservice.repository.DeliveryRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DeliveryStatusUpdater {

    private final DeliveryRepository deliveryRepository;

    @Scheduled(fixedDelay = 10_000L)
    public void updateDeliveryStatus() {
        log.info("------------ delivery status update ------------");

        final List<Delivery> inDeliveryList = deliveryRepository.findAllByStatus(DeliveryStatus.IN_DELIVERY);
        inDeliveryList.forEach(delivery -> {
            delivery.updateToCompletedStatus();
            deliveryRepository.save(delivery);
        });

        final List<Delivery> requetedList = deliveryRepository.findAllByStatus(DeliveryStatus.REQUESTED);
        requetedList.forEach(delivery -> {
            delivery.updateToInDeliveryStatus();
            deliveryRepository.save(delivery);
        });
    }
}
