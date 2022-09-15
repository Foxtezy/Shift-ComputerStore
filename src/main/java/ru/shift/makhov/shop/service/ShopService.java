package ru.shift.makhov.shop.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.model.WareDto;

import java.util.List;

public interface ShopService {
    WareDto addWare(WareDto wareDto) throws ResponseStatusException;

    WareDto findBySerialNumber(String serialNumber) throws ResponseStatusException;

    void deleteWare(String serialNumber) throws ResponseStatusException;

    List<WareDto> findByCategory(String category) throws ResponseStatusException;
}
