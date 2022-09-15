package ru.shift.makhov.shop.repository.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Shop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopEntity {

    @Id
    @Column(name = "SERIAL_NUMBER", nullable = false)
    private String serialNumber;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "MANUFACTURER", nullable = false)
    private String manufacturer;

    @Column(name = "PRICE", nullable = false)
    private Double price;

    @Column(name = "AMOUNT", nullable = false)
    private Long amount;

    @Column(name = "ADDITIONAL_INFORMATION")
    private String additionalInfo;
}
