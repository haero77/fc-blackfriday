package org.blackfriday.catalogservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class RegisterProductDto {

    private Long sellerId;
    private String name;
    private String description;
    private Long price;
    private Long stockCount;
    private List<String> tags;

}
