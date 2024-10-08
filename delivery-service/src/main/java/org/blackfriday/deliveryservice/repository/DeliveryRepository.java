package org.blackfriday.deliveryservice.repository;

import org.blackfriday.deliveryservice.entity.Delivery;
import org.blackfriday.deliveryservice.enums.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findAllByOrderId(Long orderId);

    List<Delivery> findAllByStatus(DeliveryStatus deliveryStatus);
}
