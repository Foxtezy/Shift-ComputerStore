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
    @Column(name = "serial_number", nullable = false)
    private Long serialNumber;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "manufacturer", nullable = false)
    private String manufacturer;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "amount", nullable = false)
    private Long amount;

    @Column(name = "additional_information")
    private String additionalInfo;
}
