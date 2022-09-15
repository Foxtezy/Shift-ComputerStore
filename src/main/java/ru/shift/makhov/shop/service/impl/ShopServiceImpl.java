package ru.shift.makhov.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.component.WareMapper;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.repository.ShopRepository;
import ru.shift.makhov.shop.repository.model.ShopEntity;
import ru.shift.makhov.shop.service.ShopService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public WareDto addWare(WareDto wareDto) throws ResponseStatusException {
        if (shopRepository.existsById(wareDto.getSerialNumber()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This serial number already busy");
        ShopEntity response = shopRepository.save(wareMapper.mapToShopEntity(wareDto));
        return wareMapper.mapToWareDto(response);
    }

    @Override
    public WareDto findBySerialNumber(String serialNumber) throws ResponseStatusException {
        Optional<ShopEntity> response = shopRepository.findById(serialNumber);
        if (!response.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found ware");
        return wareMapper.mapToWareDto(response.get());
    }

    @Override
    public void deleteWare(String serialNumber) throws ResponseStatusException {
        if (!shopRepository.existsById(serialNumber))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Not found ware");
        shopRepository.deleteById(serialNumber);
    }

    @Override
    public List<WareDto> findByCategory(String category) throws ResponseStatusException {
        return shopRepository.getShopEntityByCategory(category).stream().
                map(wareMapper::mapToWareDto).collect(Collectors.toList());
    }
}
