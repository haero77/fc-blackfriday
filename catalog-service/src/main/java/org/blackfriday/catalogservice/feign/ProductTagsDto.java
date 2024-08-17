package org.blackfriday.catalogservice.feign;

import org.blackfriday.catalogservice.dto.RegisterProductDto;

import java.nio.file.FileAlreadyExistsException;
import java.util.List;

public class ProductTagsDto {

    private final List<String> tags;
    private final Long productId;

    public ProductTagsDto(final List<String> tags, final Long productId) {
        this.tags = tags;
        this.productId = productId;
    }
}
