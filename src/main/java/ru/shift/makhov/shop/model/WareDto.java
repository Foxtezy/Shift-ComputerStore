package ru.shift.makhov.shop.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WareDto {

    private Long serialNumber;

    private String type;

    private String manufacturer;

    private Double price;

    private Long amount;

    private String additionalInfo;

}
