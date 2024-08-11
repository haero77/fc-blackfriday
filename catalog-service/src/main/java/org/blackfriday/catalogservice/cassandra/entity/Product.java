package org.blackfriday.catalogservice.cassandra.entity;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table
@Getter
public class Product {

    // auto increment가 아니기 때문에 직접 값을 넣어줘야한다.
    // SellerProduct.id를 넣어준다.
    @PrimaryKey
    private Long id;

    @Column
    private Long sellerId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Long price;

    @Column
    private Long stockCount;

    @Column
    private List<String> tags;

    @Builder
    private Product(
        final Long id, // id까지 생성자에 포함되어야함.
        final Long sellerId,
        final String name,
        final String description,
        final Long price,
        final Long stockCount,
        final List<String> tags
    ) {
        this.id = id;
        this.sellerId = sellerId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockCount = stockCount;
        this.tags = tags;
    }

    public void decreaseStockCount(final Long decreaseCount) {
        final long decreasedCount = this.stockCount - decreaseCount;

        if (decreasedCount < 0) {
            throw new IllegalStateException();
        }

        this.stockCount = decreaseCount;
    }
}
