package ru.shift.makhov.shop.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<WareDto> postWare(WareDto wareDto){
        return shopService.addWare(wareDto);
    }

    @GetMapping("/{serialNumber}")
    public ResponseEntity<WareDto> getWareBySerialNumber(@PathVariable Long serialNumber){
        return shopService.findBySerialNumber(serialNumber);
    }

}
