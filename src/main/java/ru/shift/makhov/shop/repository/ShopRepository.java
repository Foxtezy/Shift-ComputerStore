package ru.shift.makhov.shop.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shift.makhov.shop.repository.model.ShopEntity;
@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Long> {

}
