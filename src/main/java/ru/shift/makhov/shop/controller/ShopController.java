package ru.shift.makhov.shop.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.service.ShopService;

@RestController
@RequestMapping("shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    @Operation(summary = "Post ware", tags = "Shop")
    @ApiResponse(responseCode = "201", description = "The ware is saved")
    @ApiResponse(responseCode = "409", description = "This serial number is already taken")
    public ResponseEntity<WareDto> postWare(WareDto wareDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.addWare(wareDto));
    }

    @Operation(summary = "Get ware by serial number", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Found the ware")
    @ApiResponse(responseCode = "404", description = "Ware not found")
    @GetMapping("/{serialNumber}")
    public ResponseEntity<WareDto> getWareBySerialNumber(@PathVariable Long serialNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.findBySerialNumber(serialNumber));
    }

}
