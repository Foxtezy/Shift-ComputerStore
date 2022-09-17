package ru.shift.makhov.shop.service;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.model.WareDto;

import java.util.List;

@Service
public interface ShopService {
    WareDto addWare(WareDto wareDto) throws ResponseStatusException;

    WareDto editWare(WareDto wareDto) throws ResponseStatusException;

    void deleteWare(String serialNumber) throws ResponseStatusException;

    WareDto findBySerialNumber(String serialNumber) throws ResponseStatusException;

    List<WareDto> findByCategory(String category) throws ResponseStatusException;
}
