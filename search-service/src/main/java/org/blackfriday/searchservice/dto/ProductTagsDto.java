package org.blackfriday.searchservice.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ProductTagsDto {

    private Long productId;
    private List<String> tags;

    public ProductTagsDto() {
    }
}
