package org.blackfriday.catalogservice.service;

import lombok.RequiredArgsConstructor;
import org.blackfriday.catalogservice.cassandra.entity.Product;
import org.blackfriday.catalogservice.cassandra.repository.ProductRepository;
import org.blackfriday.catalogservice.mysql.entity.SellerProduct;
import org.blackfriday.catalogservice.mysql.entity.SellerProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CatalogService {

    private final SellerProductRepository sellerProductRepository;
    private final ProductRepository productRepository;

    public Product registerProduct(
        final Long sellerId,
        final String name,
        final String description,
        final Long price,
        final Long stockCount,
        final List<String> tags
    ) {
        final SellerProduct sellerProduct = new SellerProduct(sellerId);
        sellerProductRepository.save(sellerProduct);

        final Product product = Product.builder()
            .id(sellerProduct.getId())
            .sellerId(sellerId)
            .name(name)
            .description(description)
            .price(price)
            .stockCount(stockCount)
            .tags(tags)
            .build();
        return productRepository.save(product);
    }

    public void deleteProductById(final Long productId) {
        productRepository.deleteById(productId);
        sellerProductRepository.deleteById(productId);
    }

    public List<Product> getProductsBySellerId(final Long sellerId) {
        final List<SellerProduct> sellerProducts = sellerProductRepository.findBySellerId(sellerId);

        final List<Product> products = new ArrayList<>();

        for (SellerProduct sellerProduct : sellerProducts) {
            final Optional<Product> productOptional = productRepository.findById(sellerProduct.getId());
            productOptional.ifPresent(products::add);
        }

        return products;
    }

    public Product getProductsById(final Long productId) {
        return productRepository.findById(productId).orElseThrow();
    }

    public Product decreaseStockCount(
        final Long productId,
        final Long decreaseCount
    ) {
        final Product product = productRepository.findById(productId).orElseThrow();
        product.decreaseStockCount(decreaseCount);
        productRepository.save(product);

        return product;
    }
}
