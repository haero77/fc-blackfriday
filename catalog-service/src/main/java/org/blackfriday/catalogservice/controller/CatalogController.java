package org.blackfriday.catalogservice.controller;

import lombok.RequiredArgsConstructor;
import org.blackfriday.catalogservice.cassandra.entity.Product;
import org.blackfriday.catalogservice.dto.DecreaseStockCountDto;
import org.blackfriday.catalogservice.dto.RegisterProductDto;
import org.blackfriday.catalogservice.service.CatalogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @PostMapping("/catalog/products")
    public Product registerProduct(@RequestBody RegisterProductDto dto) {
        return catalogService.registerProduct(
            dto.getSellerId(),
            dto.getName(),
            dto.getDescription(),
            dto.getPrice(),
            dto.getStockCount(),
            dto.getTags()
        );
    }

    @GetMapping("/catalog/products/{productId}")
    public Product getProduct(@PathVariable Long productId) {
        return catalogService.getProductsById(productId);
    }

    @DeleteMapping("/catalog/products/{productId}")
    public void deleteProduct(@PathVariable Long productId) {
        catalogService.deleteProductById(productId);
    }

    @GetMapping("/catalog/sellers/{sellerId}/products")
    public List<Product> getProductsBySellerId(@PathVariable final Long sellerId) {
        return catalogService.getProductsBySellerId(sellerId);
    }

    @PostMapping("/catalog/products/{productId}/decreaseStockCount")
    public Product decreaseStockCount(
            @PathVariable final Long productId,
            @RequestBody final DecreaseStockCountDto dto
    ) {
        return catalogService.decreaseStockCount(productId, dto.getDecreaseCount());
    }
}
