package ru.shift.makhov.shop.component;

import org.springframework.stereotype.Component;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.repository.model.ShopEntity;

@Component
public class WareMapper {

    public ShopEntity mapToShopEntity(WareDto wareDto) {
        return new ShopEntity(wareDto.getSerialNumber(), wareDto.getCategory(),
                wareDto.getManufacturer(), wareDto.getPrice(),
                wareDto.getAmount(), wareDto.getAdditionalInfo());
    }

    public WareDto mapToWareDto(ShopEntity shopEntity) {
        return new WareDto(shopEntity.getSerialNumber(), shopEntity.getCategory(),
                shopEntity.getManufacturer(), shopEntity.getPrice(),
                shopEntity.getAmount(), shopEntity.getAdditionalInfo());
    }

}
