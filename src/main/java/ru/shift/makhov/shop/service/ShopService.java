package ru.shift.makhov.shop.service;

import org.springframework.http.ResponseEntity;
import ru.shift.makhov.shop.model.WareDto;

public interface ShopService {
    ResponseEntity<WareDto> addWare(WareDto wareDto);

    ResponseEntity<WareDto> findBySerialNumber(Long serialNumber);
}
