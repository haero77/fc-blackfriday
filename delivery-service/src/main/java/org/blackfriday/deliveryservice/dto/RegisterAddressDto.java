package org.blackfriday.deliveryservice.dto;

import lombok.Getter;

@Getter
public class RegisterAddressDto {

    private Long userId;
    private String address;
    private String alias;

    public RegisterAddressDto() {
    }
}
