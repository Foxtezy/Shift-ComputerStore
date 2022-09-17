package ru.shift.makhov.shop.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@Data
@AllArgsConstructor
public class WareDto {

    @NotNull
    @Schema(example = "M6TPM20612003453", required = true)
    private String serialNumber;

    @NotNull
    @Schema(example = "Laptop", required = true)
    private String category;

    @NotNull
    @Schema(example = "Huawei", required = true)
    private String manufacturer;

    @Positive
    @Schema(example = "49999", required = true)
    private Double price;

    @PositiveOrZero
    @Schema(example = "1", required = true)
    private Long amount;

    @NotNull
    @Schema(example = "14 inch", required = true)
    private String additionalInfo;

}
