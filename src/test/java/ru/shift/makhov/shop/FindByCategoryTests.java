package ru.shift.makhov.shop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.repository.ShopRepository;
import ru.shift.makhov.shop.repository.model.ShopEntity;
import ru.shift.makhov.shop.service.ShopService;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class FindByCategoryTests {

    private final ShopService shopService;

    private final String category = "cat";

    private List<WareDto> wareDtoList;

    private List<ShopEntity> shopEntityList;

    @Autowired
    public FindByCategoryTests(ShopService shopService) {
        this.shopService = shopService;
    }

    @BeforeEach
    public void setUp() {
        wareDtoList = new ArrayList<>();
        wareDtoList.add(new WareDto("1234", "cat",
                "man", 1.0, (long) 1, "add"));
        shopEntityList = new ArrayList<>();
        shopEntityList.add(new ShopEntity("1234", "cat",
                "man", 1.0, (long) 1, "add"));
    }

    @MockBean
    private ShopRepository shopRepository;

    @Test
    public void findByValidCategory() {
        Mockito.when(shopRepository.getShopEntityByCategory(category)).thenReturn(shopEntityList);
        Assertions.assertEquals(wareDtoList, shopService.findByCategory(category));
    }

    @Test
    public void findByInvalidCategory() {
        Mockito.when(shopRepository.getShopEntityByCategory(category)).thenReturn(new ArrayList<>());
        Assertions.assertEquals(new ArrayList<>(), shopService.findByCategory(category));
    }
}
