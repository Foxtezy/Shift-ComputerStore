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
    @Operation(summary = "Post ware", tags = "Shop")
    @ApiResponse(responseCode = "201", description = "The ware is saved")
    @ApiResponse(responseCode = "409", description = "This serial number is already taken", content = @Content)
    public ResponseEntity<WareDto> postWare(WareDto wareDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(shopService.addWare(wareDto));
    }

    @Operation(summary = "Delete ware by serial number", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Deleted ware", content = @Content)
    @ApiResponse(responseCode = "404", description = "Ware not found", content = @Content)
    @DeleteMapping
    public ResponseEntity<String> deleteWare(String serialNumber){
        shopService.deleteWare(serialNumber);
        return ResponseEntity.ok("Deleted successfully");
    }

    @Operation(summary = "Get ware by serial number", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Found ware")
    @ApiResponse(responseCode = "404", description = "Ware not found", content = @Content)
    @GetMapping("/find_ware/serial_number/{serialNumber}")
    public ResponseEntity<WareDto> getWareBySerialNumber(@PathVariable String serialNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(shopService.findBySerialNumber(serialNumber));
    }

    @Operation(summary = "Get wares by category", tags = "Shop")
    @ApiResponse(responseCode = "200", description = "Found wares")
    @GetMapping("/find_ware/category/{category}")
    public ResponseEntity<List<WareDto>> getWaresByCategory(@PathVariable String category){
        return ResponseEntity.status(HttpStatus.OK).body(shopService.findByCategory(category));
    }

}
