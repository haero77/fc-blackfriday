package org.blackfriday.deliveryservice.repository;

import org.blackfriday.deliveryservice.entity.UserAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAddressRepository extends JpaRepository<UserAddress, Long> {

    List<UserAddress> findAllByUserId(Long userId);
}
