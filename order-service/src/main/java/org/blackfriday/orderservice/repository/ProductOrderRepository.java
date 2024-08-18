package org.blackfriday.orderservice.repository;

import org.apache.logging.log4j.util.Unbox;
import org.blackfriday.orderservice.entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    List<ProductOrder> findByUserId(Long userId);
}
