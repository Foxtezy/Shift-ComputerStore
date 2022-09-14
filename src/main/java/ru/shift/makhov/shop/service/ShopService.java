package ru.shift.makhov.shop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.model.WareDto;

public interface ShopService {
    WareDto addWare(WareDto wareDto) throws ResponseStatusException;

    WareDto findBySerialNumber(Long serialNumber) throws ResponseStatusException;
}
