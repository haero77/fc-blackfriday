package org.blackfriday.catalogservice.mysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SellerProduct {

    /**
     * Product의 id는 SellerProduct의 id를 쓰고 있다.
     * Product 생성시 부하가 걸릴 경우, MySQL의 auto_increment를 사용하지 않고,
     * 직접 랜덤값(예: uuid) 등을 사용함으로써 부하를 줄일 수 있다.
     */
    // MySQL의
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long sellerId;

    public SellerProduct(final Long sellerId) {
        this.sellerId = sellerId;
    }
}
