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
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import ru.shift.makhov.shop.model.WareDto;
import ru.shift.makhov.shop.repository.ShopRepository;
import ru.shift.makhov.shop.repository.model.ShopEntity;
import ru.shift.makhov.shop.service.ShopService;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class AddWareTests {

    private final ShopService shopService;

    private WareDto wareDto;

    private ShopEntity shopEntity;

    @Autowired
    public AddWareTests(ShopService shopService) {
        this.shopService = shopService;
    }

    @BeforeEach
    public void setUp() {
        wareDto = new WareDto("1234", "cat",
                "man", 1.0, (long) 1, "add");
        shopEntity = new ShopEntity("1234", "cat",
                "man", 1.0, (long) 1, "add");
    }

    @MockBean
    private ShopRepository shopRepository;

    @Test
    public void addNewWare() {
        Mockito.when(shopRepository.existsById(wareDto.getSerialNumber())).thenReturn(false);
        Mockito.when(shopRepository.save(any())).thenReturn(shopEntity);
        Assertions.assertEquals(wareDto, shopService.addWare(wareDto));
    }

    @Test
    public void addExistWare() {
        Mockito.when(shopRepository.existsById(wareDto.getSerialNumber())).thenReturn(true);
        try {
            shopService.addWare(wareDto);
            Assertions.fail();
        } catch (ResponseStatusException e) {
            Assertions.assertEquals(new ResponseStatusException(HttpStatus.CONFLICT, "This serial number already busy").toString(), e.toString());
        }
    }

}
