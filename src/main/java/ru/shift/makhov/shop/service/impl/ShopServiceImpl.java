package ru.shift.makhov.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.shift.makhov.shop.component.WareMapper;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.repository.ShopRepository;
import ru.shift.makhov.shop.repository.model.ShopEntity;
import ru.shift.makhov.shop.service.ShopService;

@Service
public class ShopServiceImpl implements ShopService {

    private final ShopRepository shopRepository;

    private final WareMapper wareMapper;

    @Autowired
    public ShopServiceImpl(ShopRepository shopRepository, WareMapper wareMapper) {
        this.shopRepository = shopRepository;
        this.wareMapper = wareMapper;
    }

    @Override
    public ResponseEntity<WareDto> addWare(WareDto wareDto) {
        ShopEntity response = shopRepository.save(wareMapper.mapToShopEntity(wareDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(wareMapper.mapToWareDto(response));
    }

    @Override // TODO: 14.09.2022
    public ResponseEntity<WareDto> findBySerialNumber(Long serialNumber){
        ShopEntity response = shopRepository.findById(serialNumber).get();
        return ResponseEntity.ok(wareMapper.mapToWareDto(response));
    }
}
