package org.blackfriday.deliveryservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(indexes = {@Index(name = "idx_userId", columnList = "userId")})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_address_id")
    private Long id;

    private Long userId;
    private String address;
    private String alias; // 별칭

    @Builder
    private UserAddress(final Long userId, final String address, final String alias) {
        this.userId = userId;
        this.address = address;
        this.alias = alias;
    }
}
