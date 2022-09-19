package ru.shift.makhov.shop.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("shop")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping
    @Operation(summary = "Add ware", tags = "Shop")
    @ApiResponse(responseCode = "201", description = "The ware is saved")
    @ApiResponse(responseCode = "409", description = "This serial number is already taken", content = @Content)
    public ResponseEntity<WareDto> addWare(@RequestBody WareDto wareDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.addWare(wareDto));
    }

    @PutMapping
    @Operation(summary = "Edit ware", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "The ware is edited")
    @ApiResponse(responseCode = "404", description = "Ware not found", content = @Content)
    public ResponseEntity<WareDto> editWare(@RequestBody WareDto wareDto) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.editWare(wareDto));
    }

    @DeleteMapping("/delete_ware/{serialNumber}")
    @Operation(summary = "Delete ware by serial number", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Deleted ware", content = @Content)
    @ApiResponse(responseCode = "404", description = "Ware not found", content = @Content)
    public void deleteWare(@PathVariable String serialNumber) {
        shopService.deleteWare(serialNumber);
    }

    @GetMapping("/find_ware/serial_number/{serialNumber}")
    @Operation(summary = "Get ware by serial number", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Found ware")
    @ApiResponse(responseCode = "404", description = "Ware not found", content = @Content)
    public ResponseEntity<WareDto> getWareBySerialNumber(@PathVariable String serialNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.findBySerialNumber(serialNumber));
    }

    @GetMapping("/find_ware/category/{category}")
    @Operation(summary = "Get wares by category", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Found wares")
    public ResponseEntity<List<WareDto>> getWaresByCategory(@PathVariable String category) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.findByCategory(category));
    }

}
